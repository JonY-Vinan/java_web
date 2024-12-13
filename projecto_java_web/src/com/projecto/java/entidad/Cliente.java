package com.projecto.java.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.projecto.java.biblioteca.Util;

public class Cliente extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6545654277525712658L;
	private int telefono;
	private LocalDate fechaAlta;

	public Cliente() {

	}

	public Cliente(Long idUsuario, String login, String email, String nombre, UserStatus status,
			UserPrivilege privilege, TipoUsuario tipoUsuario, String password, int telefono, LocalDate fechaAlta) {
		super(idUsuario, login, email, nombre, status, privilege, tipoUsuario, password);
		this.telefono = telefono;
		this.fechaAlta = fechaAlta;
	}

	public Cliente(int telefono, LocalDate fechaAlta) {
		super();
		this.telefono = telefono;
		this.fechaAlta = fechaAlta;
	}


	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaAlta, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(fechaAlta, other.fechaAlta) && telefono == other.telefono;
	}

	@Override
	public String toString() {

		return super.toString() + " Telefono=" + telefono + " Fecha alta " + fechaAlta;
	}

	public void setDatos(Long id) {
		super.setDatos(id);
		telefono = Util.leerInt("telefono: ");
		fechaAlta = Util.leerFecha("fecha alta: ");
	}

	public void setDatos() {
		super.setDatos();
		telefono = Util.leerInt("telefono: ");
		fechaAlta = Util.leerFecha("fecha alta: ");
	}

}
