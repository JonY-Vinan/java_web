package com.projecto.java.exepcion;

public class AccesoDatosException extends RuntimeException {
	private static final long serialVersionUID = 5283729038545121491L;

	public AccesoDatosException() {

	}

	public AccesoDatosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccesoDatosException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccesoDatosException(String message) {
		super(message);
	}

	public AccesoDatosException(Throwable cause) {
		super(cause);
	}

}
