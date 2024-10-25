package mbozkurt.core.messaging.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mbozkurt.core.messaging.component.CoreMessageSource;
import mbozkurt.core.messaging.entity.MessageEntity;

@Service
public class KodluBilgilerService {

	@Autowired
	private CoreMessageSource messageSource;

	/**
	 * Belirli bir locale'a ait tüm mesajları getirir.
	 *
	 * @param localeName Yerel dil (ör. en_US, tr_TR)
	 * @return Yerel dile ait tüm hata mesajları
	 */
	public List<MessageEntity> getMessagesForLocale(String locale) {
		return messageSource.getMessagesByLocale(locale);
	}
	
}
