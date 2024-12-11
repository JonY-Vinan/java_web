package com.projecto.java.entidad;

public enum UserPrivilege {
	/**
	 * El usuario es un usuario corriente.
	 */
	USER,
	/**
	 * El usuario es un administrador.
	 */
	ADMIN;

	private final int value = 0; // Constructor Estado(int value) { this.value = value; }

	public static UserPrivilege fromInt(int value) {
		for (UserPrivilege estado : UserPrivilege.values()) {
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
