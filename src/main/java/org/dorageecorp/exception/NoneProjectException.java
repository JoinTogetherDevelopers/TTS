package org.dorageecorp.exception;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class NoneProjectException extends RuntimeException {
	private String message;
	
	public NoneProjectException(String message) {
		this.message = message;
	}
}
