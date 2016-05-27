package com.ikyer.master.api.exceptions;

public class CoreException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private ErrorCode errorCode;

	public CoreException(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public CoreException(ErrorCode errorCode, Throwable arg0) {
		super(arg0);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode.getName();
	}

}
