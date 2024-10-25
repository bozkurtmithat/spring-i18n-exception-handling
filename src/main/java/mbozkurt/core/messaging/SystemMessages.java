package mbozkurt.core.messaging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mbozkurt.core.messaging.model.Message;
import mbozkurt.core.messaging.model.MessageType;

@Getter
@AllArgsConstructor
public enum SystemMessages implements Message {

	// ERRORS
	COMMON_EXCEPTION("SYS_ERR_10001", MessageType.ERROR),
	UNAUTHORIZED_USER("SYS_ERR_10002", MessageType.ERROR),

	// WARNINGS
	CONTINUE_OPERATION_WITH_WARNING("SYS_WARN_10001", MessageType.WARNING),

	// INFOS
	OPERATION_SUCCESS("SYS_INFO_10001", MessageType.INFO);

	private String code;
	private MessageType type;

}
