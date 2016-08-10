package io.egen.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class IDNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7086815618349851839L;
	
	public IDNotFoundException(String msg) {
		super(msg);
	}
	
	public IDNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
