package mbozkurt.core.messaging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mbozkurt.core.messaging.model.ErrorMessage;

@Getter
@AllArgsConstructor
public enum SystemErrorMessage implements ErrorMessage {

	COMMON_EXCEPTION("SYS_ERR_1001"),
	UNAUTHORIZED_USER("SYS_ERR_1002");
	
	private String code;
}
