package com.projecto.java.exepcion;

public class GestionFactoriaException extends RuntimeException {
	private static final long serialVersionUID = 1589961905020063644L;

	public GestionFactoriaException() {
		super();
	}

	public GestionFactoriaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GestionFactoriaException(String message, Throwable cause) {
		super(message, cause);
	}

	public GestionFactoriaException(String message) {
		super(message);
	}

	public GestionFactoriaException(Throwable cause) {
		super(cause);
	}
}
