package mbozkurt.core.messaging.model;

import lombok.Getter;
import mbozkurt.core.messaging.component.UyapMessageSource;

public class MessageException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private final ClientMessage clientMessage;
	
	public <E extends Enum<E> & Message>MessageException(E message) {
		String text = UyapMessageSource.getInstance().getMessage(message.getCode());
		clientMessage = new ClientMessage(message.getCode(), message.getType(), text);
	}
	
	public <E extends Enum<E> & Message>MessageException(E message, Object[] params) {
		String text = UyapMessageSource.getInstance().getMessage(message.getCode(), params);
		clientMessage = new ClientMessage(message.getCode(), message.getType(), text);
	}
	
	public <E extends Enum<E> & Message>MessageException(Exception causedBy, E message) {
		super(causedBy);
		String text = UyapMessageSource.getInstance().getMessage(message.getCode());
		clientMessage = new ClientMessage(message.getCode(), message.getType(), text);
	}
	
	public <E extends Enum<E> & Message>MessageException(Exception causedBy, E message, Object[] params) {
		super(causedBy);
		String text = UyapMessageSource.getInstance().getMessage(message.getCode(), params);
		clientMessage = new ClientMessage(message.getCode(), message.getType(),text);
	}

	@Override
	public String toString() {
		return getClass().getName() +" " + clientMessage.getCode() + ": " + clientMessage.getText();
	}
}
