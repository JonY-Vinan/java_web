package com.projecto.java.dao;

import com.projecto.java.entidad.Cliente;
import com.projecto.java.exepcion.AccesoDatosException;

public class DaoClienteSQLite extends DaoClienteJdbc implements DaoCliente {

	private static final String SQL_SELECT = ("SELECT * FROM Clientes");
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE idUsuario = ?";
	private static final String SQL_SELECT_NOMBRE = SQL_SELECT + " WHERE nombre = ?";
	private static final String SQL_INSERT = "INSERT INTO Clientes (login, email, nombre, status, privilege, tipoUsuario, password, telefono,fechaAlta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE Clientes SET login = ?, email = ?, nombre = ?, status = ?, privilege = ?, tipoUsuario = ?, password = ?, telefono = ?, fechaAlta = ? WHERE idUsuario = ?";
	private static final String SQL_DELETE = "DELETE FROM Clientes WHERE idUsuario = ?";

	public DaoClienteSQLite(String url, String user, String pass) {
		super(url, user, pass);
	}

	@Override
	public Iterable<Cliente> obtenerTodos() {
		return ejecutarConsulta(SQL_SELECT, pst -> datosSentencia(pst));

	}

	@Override
	public Cliente obtenerPorId(Long id) {
		return ejecutarConsultaUno(SQL_SELECT_ID, pst -> datosSentencia(pst, id));
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		ejecutarCambio(SQL_INSERT, pst -> clienteAFila(cliente, pst));
		return cliente;
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		ejecutarCambio(SQL_UPDATE, pst -> clienteAFila(cliente, pst));
		return cliente;
	}

	@Override
	public void borrar(Long id) {
		ejecutarCambio(SQL_DELETE,pst -> clienteAFila(new Cliente(id, null, null, null, null, null, null, null, 0, null), pst));
	}

	@Override
	public Iterable<Cliente> obtenerPorNombreParcial(String nombre) {
		return (Iterable<Cliente>) ejecutarConsulta(SQL_SELECT_NOMBRE,
				pst -> datosSentencia(pst, "%" + nombre + "%"));
	}

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de SQLite", e);
		}
	}
}
