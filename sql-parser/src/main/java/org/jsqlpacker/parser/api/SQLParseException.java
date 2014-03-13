package org.jsqlpacker.parser.api;

public class SQLParseException extends Exception {

	private static final long serialVersionUID = 1L;

	public SQLParseException() {
		super();
	}

	public SQLParseException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SQLParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public SQLParseException(String message) {
		super(message);
	}

	public SQLParseException(Throwable cause) {
		super(cause);
	}
}
