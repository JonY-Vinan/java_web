package com.projecto.java.entidad;

public enum TipoUsuario {
	/**
	 * El usuario es un empleado.
	 */
	EMPLEADO,
	/**
	 * El usuario es un cliente
	 */
	CLIENTE;

	private final int value = 0; // Constructor Estado(int value) { this.value = value; }

	public static TipoUsuario fromInt(int value) {
		for (TipoUsuario estado : TipoUsuario.values()) {
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
