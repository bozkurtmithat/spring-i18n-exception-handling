package mbozkurt.core.messaging.model;

public interface ErrorMessage extends Message {

	@Override
	default MessageType getType() {
		return MessageType.ERROR;
	}
}
