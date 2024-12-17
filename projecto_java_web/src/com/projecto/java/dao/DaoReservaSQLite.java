package com.projecto.java.dao;

import com.projecto.java.entidad.Reserva;
import com.projecto.java.exepcion.AccesoDatosException;

public class DaoReservaSQLite extends DaoReservaJdbc implements DaoReserva {

	private static final String SQL_SELECT = ("SELECT * FROM Reservas");
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_SELECT_NOMBRE = SQL_SELECT + " WHERE nombre LIKE ?";
	private static final String SQL_SELECT_APELLIDO = SQL_SELECT + " WHERE apellido LIKE ?";
	private static final String SQL_INSERT = "INSERT INTO Reservas (nombre, apellido, email, telefono, fechaReserva, hora, numeroPersonas, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE Reservas SET nombre = ?, apellido = ?, email = ?, telefono = ?, fechaReserva = ?, hora = ?, numeroPersonas = ?, estado = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM Reservas WHERE id = ?";

	public DaoReservaSQLite(String url, String user, String pass) {
		super(url, user, pass);
	}

	@Override
	public Iterable<Reserva> obtenerTodos() {
		return ejecutarConsulta(SQL_SELECT, pst -> datosSentencia(pst));

	}

	@Override
	public Reserva obtenerPorId(Long id) {
		return ejecutarConsultaUno(SQL_SELECT_ID, pst -> datosSentencia(pst, id));
	}

	@Override
	public Reserva insertar(Reserva cliente) {
		ejecutarCambio(SQL_INSERT, pst -> clienteAFila(cliente, pst));
		return cliente;
	}

	@Override
	public Reserva modificar(Reserva cliente) {
		ejecutarCambio(SQL_UPDATE, pst -> clienteAFila(cliente, pst));
		return cliente;
	}

	@Override
	public void borrar(Long id) {
		ejecutarCambio(SQL_DELETE, pst -> clienteAFila(new Reserva(id, null, null, null, 0, null, null, 0, null), pst));
	}

	@Override
	public Iterable<Reserva> obtenerPorNombreParcial(String nombre) {
		return ejecutarConsulta(SQL_SELECT_NOMBRE, pst -> datosSentencia(pst, "%" + nombre + "%"));
	}

	@Override
	public Iterable<Reserva> obtenerPorApellidoParcial(String apellido) {
		return ejecutarConsulta(SQL_SELECT_APELLIDO, pst -> datosSentencia(pst, "%" + apellido + "%"));
	}

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de SQLite", e);
		}
	}

}
