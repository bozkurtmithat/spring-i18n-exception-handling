package mbozkurt.core.messaging.component;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mbozkurt.core.messaging.entity.MessageEntity;
import mbozkurt.core.messaging.repository.MessageRepository;

@Slf4j
@Component
public class CoreMessageSource implements ApplicationContextAware {
    
    private static ApplicationContext context;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void setApplicationContext(ApplicationContext ctx) {
        context = ctx;
    }
	
    /**
    * This method is for accessing API with programatically.
    */
    public static CoreMessageSource getInstance() {
    	return context.getBean(CoreMessageSource.class);
    }
    
    public String getMessage(String code) {
	return getMessage(code, LocaleContextHolder.getLocale().toString());
    }
	
	public String getMessage(String code, Object...objects) {
		String template = getMessage(code, LocaleContextHolder.getLocale().toString());
		return MessageFormat.format(template, objects);
	}

	/**
	 * Veritabanından hata koduna ve yerel dile göre mesajı alır. Bu mesaj cache'den
	 * gelir, yoksa veritabanından çekilir.
	 * 
	 * @param code   Hata kodu
	 * @param locale İstekteki dil
	 * @return Yerelleştirilmiş hata mesajı
	 */
	@Cacheable(value = "messages", key = "#code + '_' + #locale")
	public String getMessage(String code, String locale) {
		MessageEntity messageEntity = messageRepository.findByCodeAndLocale(code, locale);
		return (messageEntity == null) ? "Unknown error code: " + code : messageEntity.getMessage();
	}

	@Cacheable(value = "allMessageByLocale")
	public List<MessageEntity> getMessagesByLocale(String locale) {
		return messageRepository.findByLocale(locale);
	}

	@Cacheable(value = "allMessages")
	public List<MessageEntity> getAllErrorMessages() {
		return messageRepository.findAll();
	}

	@CacheEvict(value = "allMessages", allEntries = true)
	public void evictAllCacheValues() {
		log.info("evicting all error messages");
	}

}
