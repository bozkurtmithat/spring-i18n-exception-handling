package mbozkurt.core.messaging.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mbozkurt.core.messaging.entity.MessageEntity;
import mbozkurt.core.messaging.entity.MessageId;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, MessageId> {
    
	 // Hata koduna ve yerel dile göre mesajı bul
    MessageEntity findByCodeAndLocale(String code, String locale);
    
 // Belirli bir locale_name'e ait tüm mesajları getirir
    List<MessageEntity> findByLocale(String locale);
}

