package com.projecto.java.entidad;

import java.time.LocalDate;
import java.util.Objects;

import com.projecto.java.biblioteca.Util;

public class Reserva {
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	private LocalDate fechaReserva;
	private String hora;
	private int numeroPersonas;
	private EstadoReserva estado;

	public Reserva() {
		super();
	}

	public Reserva(Long id, String nombre, String apellido, String email, int telefono, LocalDate fechaReserva,
			String hora, int numeroPersonas, EstadoReserva estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaReserva = fechaReserva;
		this.hora = hora;
		this.numeroPersonas = numeroPersonas;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public EstadoReserva getEstado() {
		return estado;
	}

	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(apellido, email, estado, fechaReserva, hora, id, nombre, numeroPersonas, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(email, other.email) && estado == other.estado
				&& Objects.equals(fechaReserva, other.fechaReserva) && Objects.equals(hora, other.hora)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& numeroPersonas == other.numeroPersonas && telefono == other.telefono;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", fechaReserva=" + fechaReserva + ", hora=" + hora + ", numeroPersonas="
				+ numeroPersonas + ", estado=" + estado + "]";
	}

	// Método setDatos
	public void setDatos() {
		nombre = Util.leerCadena("Nombre: ");
		apellido = Util.leerCadena("Apellido: ");
		email = Util.leerCadena("Email: ");
		telefono = Util.leerInt("Telefono: ");
		fechaReserva = Util.leerFecha("Fecha para hacer reserva");
		hora = Util.leerCadena("hora de reserva");
		numeroPersonas = Util.leerInt("Cuantas personas");
		estado = EstadoReserva.PENDIENTE;

	}
}
