package org.com.restaurante.fabrica;

public class GestionFabricaException extends RuntimeException {
	private static final long serialVersionUID = 1589961905020063644L;

	public GestionFabricaException() {
		super();
	}

	public GestionFabricaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GestionFabricaException(String message, Throwable cause) {
		super(message, cause);
	}

	public GestionFabricaException(String message) {
		super(message);
	}

	public GestionFabricaException(Throwable cause) {
		super(cause);
	}
}
