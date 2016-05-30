package com.ikyer.master.api.exceptions;

public class CoreRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private ErrorCode errorCode;
	
	public CoreRuntimeException(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public CoreRuntimeException(ErrorCode errorCode, Throwable arg0) {
		super(arg0);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode.getName();
	}

}
