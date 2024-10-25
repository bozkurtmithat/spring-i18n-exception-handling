package mbozkurt.core.messaging.model;

public interface WarningMessage extends Message {

	@Override
	default MessageType getType() {
		return MessageType.WARNING;
	}
}
