package mbozkurt.core.messaging.model;

public interface InfoMessage extends Message {

	@Override
	default MessageType getType() {
		return MessageType.INFO;
	}
}
