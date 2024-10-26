package mbozkurt.core.messaging.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static mbozkurt.core.messaging.SystemErrorMessage.UNAUTHORIZED_USER;

import mbozkurt.core.messaging.SystemErrorMessage;
import mbozkurt.core.messaging.entity.MessageEntity;
import mbozkurt.core.messaging.model.MessageException;
import mbozkurt.core.messaging.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	MessageService messageService;
	
	/**
     * Belirtilen locale için veritabanından tüm mesajları döner.
     *
     * @param localeName Yerel dil (ör. en_US, tr_TR)
     * @return Yerel dile ait tüm hata mesajları
     */
    @GetMapping("/test/messages")
    public List<MessageEntity> getMessages(@RequestParam String localeName) {
        return messageService.getMessagesForLocale(localeName);
    }
    
    @GetMapping("/test/messages/fixed")
    public List<MessageEntity> testFixedMessages() {
        throw new MessageException(SystemErrorMessage.COMMON_EXCEPTION);
    }
    
    @GetMapping("/test/messages/param")
    public List<MessageEntity> testParametricMessages() {
        try {
        	throw new MessageException(new IOException("My sweety cause by"),
        			UNAUTHORIZED_USER,
        			new Object[] {"Mithat"});
        }catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
}
