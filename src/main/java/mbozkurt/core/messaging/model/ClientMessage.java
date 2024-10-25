package mbozkurt.core.messaging.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientMessage implements Message{

	private final String code;
	private final MessageType type;
	private final String text;
	
}
