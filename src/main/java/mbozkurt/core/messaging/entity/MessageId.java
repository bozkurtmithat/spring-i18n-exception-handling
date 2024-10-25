package mbozkurt.core.messaging.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class MessageId implements Serializable {
	
    private static final long serialVersionUID = 1L;
	private String code;
    private String locale;

}

