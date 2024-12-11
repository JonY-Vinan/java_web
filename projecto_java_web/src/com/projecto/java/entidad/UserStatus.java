package com.projecto.java.entidad;

public enum UserStatus {
	/**
	 * El usuario está activado.
	 */
	ENABLED,
	/**
	 * El usuario está desactivado.
	 */
	DISABLED;

	private final int value = 0; // Constructor Estado(int value) { this.value = value; }

	public static UserStatus fromInt(int value) {
		for (UserStatus estado : UserStatus.values()) {
			if (estado.getValue() == value) {
				return estado;
			}
		}
		throw new IllegalArgumentException("Valor desconocido: " + value);
	}

	public int getValue() {
		return value;
	}
}