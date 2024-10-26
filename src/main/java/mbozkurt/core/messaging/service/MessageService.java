package mbozkurt.core.messaging.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mbozkurt.core.messaging.component.CoreMessageSource;
import mbozkurt.core.messaging.entity.MessageEntity;

@Service
public class MessageService {

	@Autowired
	private CoreMessageSource messageSource;

	/**
	 * Gets all mesaage belongs to a specific locale 
	 *
	 * @param localeName (ör. en_US, tr_TR)
	 * @return All messages of locale
	 */
	public List<MessageEntity> getMessagesForLocale(String locale) {
		return messageSource.getMessagesByLocale(locale);
	}
	
}
