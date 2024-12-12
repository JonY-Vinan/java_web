package com.projecto.java.entidad;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Objects;

import com.projecto.java.biblioteca.Util;


/**
 * Clase que define los atributos y los métodos de la entidad "Usuario".
 *
 * @author prueba
 */

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Id del usuario. Es la clave primaria de la tabla "usuario".
	 */
	private Long idUsuario;
	/**
	 * Login del usuario.
	 */
	private String login;
	/**
	 * Email del usuario.
	 */
	private String email;
	/**
	 * Nombre completo del usuario.
	 */
	private String nombre;
	/**
	 * Estado del usuario, que puede ser ENABLED o DISABLED.
	 */
	private UserStatus status;
	/**
	 * Privilegio del usuario, que puede ser ADMIN o USER.
	 */
	private UserPrivilege privilege;
	/**
	 * Tipo de usuario, que puede ser BIBLIOTECARIO, PROFESOR o ALUMNO.
	 */

	private TipoUsuario tipoUsuario;
	/**
	 * Contraseña del usuario.
	 */
	private String password;

	/**
	 * Constructor vacio de Usuario
	 */
	public Usuario() {
		super();
	}

	public Usuario(Long idUsuario, String login, String email, String nombre, UserStatus status,
			UserPrivilege privilege, TipoUsuario tipoUsuario, String password) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.email = email;
		this.nombre = nombre;
		this.status = status;
		this.privilege = privilege;
		this.tipoUsuario = tipoUsuario;
		this.password = password;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public UserPrivilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(UserPrivilege privilege) {
		this.privilege = privilege;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, idUsuario, login, nombre, password, privilege, status, tipoUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(idUsuario, other.idUsuario)
				&& Objects.equals(login, other.login) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && privilege == other.privilege && status == other.status
				&& tipoUsuario == other.tipoUsuario;
	}

	/**
	 * Método que devuelve un String con los atributos del usuario.
	 *
	 * @return un String con los atributos de la entidad.
	 */
	@Override
	public String toString() {
		return "Usuario: " + " ID: " + idUsuario + " login: " + login + " email: " + email + " Name: " + nombre
				+ " estado: " + status + " privilegio: " + privilege + " tipo: " + tipoUsuario + " contraseña: "
				+ password;

	}

	public void setDatos(Long idUsuario) {

		if (idUsuario == null) {
			idUsuario = (long) Util.leerInt("Id: ");
		} else {
			this.idUsuario = idUsuario;
		}

		login = Util.leerCadena("login: ");
		email = Util.leerCadena("email: ");
		nombre = Util.leerCadena("nombre: ");
		status = UserStatus.ENABLED;
		privilege = UserPrivilege.USER;
		tipoUsuario = TipoUsuario.CLIENTE;
		password = Util.leerCadena("contraseña: ");
	}

	public void setDatos() {
		//idUsuario = (long) Util.leerInt("Id: ");
		login = Util.leerCadena("login: ");
		email = Util.leerCadena("email: ");
		nombre = Util.leerCadena("nombre: ");
		status = UserStatus.ENABLED;
		privilege = UserPrivilege.USER;
		tipoUsuario = TipoUsuario.CLIENTE;
		password = Util.leerCadena("contraseña: ");
	}

}