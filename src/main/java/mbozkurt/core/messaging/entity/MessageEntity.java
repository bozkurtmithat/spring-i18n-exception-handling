package mbozkurt.core.messaging.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;


/*
 
CREATE TABLE T_GNL_MESSAGES (
    CODE VARCHAR2(100) NOT NULL,
    LOCALE_NAME VARCHAR2(10) NOT NULL,
    MESSAGE VARCHAR2(500) NOT NULL,
    PRIMARY KEY (CODE, LOCALE_NAME)
);

INSERT INTO T_GNL_MESSAGES (CODE, LOCALE_NAME, MESSAGE) VALUES ('SYS_ERR_1001', 'en_US', 'Operation failed. Please contact with system administrator');
INSERT INTO T_GNL_MESSAGES (CODE, LOCALE_NAME, MESSAGE) VALUES ('SYS_ERR_1001', 'tr_TR', 'Gerçekleştirdiğiniz işlemde hata oluştu. Lütfen sistem yöneticisi ile irtaibata geçiniz.');
INSERT INTO T_GNL_MESSAGES (CODE, LOCALE_NAME, MESSAGE) VALUES ('SYS_ERR_1002', 'en_US', 'You({0}) have not permission to execute this operation');
INSERT INTO T_GNL_MESSAGES (CODE, LOCALE_NAME, MESSAGE) VALUES ('SYS_ERR_1002', 'tr_TR', 'Siz({0} bu işlemi yapmaya yetkiniz bulunmamaktadır.');

 */
@Data
@Entity(name = "T_GNL_MESSAGES")
@IdClass(MessageId.class) 
public class MessageEntity {

    @Id
	private String code;

    @Id
    @Column(name = "LOCALE_NAME")
    private String locale;
    
    private String message;
}
