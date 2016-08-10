package io.egen.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8035464182912182458L;
	
	public MovieNotFoundException(String msg) {
		super(msg);
	}
	
	public MovieNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
