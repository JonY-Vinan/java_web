package com.projecto.java.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Consumer;

import com.projecto.java.entidad.Cliente;
import com.projecto.java.entidad.TipoUsuario;
import com.projecto.java.entidad.UserPrivilege;
import com.projecto.java.entidad.UserStatus;
import com.projecto.java.exepcion.AccesoDatosException;

public abstract class DaoClienteJdbc extends DaoJdbc implements DaoCliente {

	protected DaoClienteJdbc(String url, String user, String pass) {
		super(url, user, pass);
	}

	protected static Cliente filaACliente(ResultSet rs) throws SQLException {

		var idUsuario = rs.getLong("idUsuario");
		var login = rs.getString("login");
		var email = rs.getString("email");
		var nombre = rs.getString("nombre");
		var statusStr = rs.getString("status");
		var status = statusStr != null ? UserStatus.valueOf(statusStr) : null;
		var privilegeStr = rs.getString("privilege");
		var privilege = privilegeStr != null ? UserPrivilege.valueOf(privilegeStr) : null;
		var tipoUsuarioStr = rs.getString("tipoUsuario");
		var tipoUsuario = tipoUsuarioStr != null ? TipoUsuario.valueOf(tipoUsuarioStr) : null;
		var password = rs.getString("password");
		var telefono = rs.getInt("telefono");
		var sFecha = rs.getString("fechaAlta");
		LocalDate fechaAlta = sFecha != null ? LocalDate.parse(sFecha) : null;

		Cliente cliente;
		cliente = new Cliente(idUsuario, login, email, nombre, status, privilege, tipoUsuario, password, telefono,
				fechaAlta);
		return cliente;
	}

	protected static void clienteAFila(Cliente cliente, PreparedStatement pst) {
		try {

			if (cliente.getNombre() != null) {
				pst.setString(1, cliente.getLogin());
				pst.setString(2, cliente.getEmail());
				pst.setString(3, cliente.getNombre());
				pst.setString(4, cliente.getStatus().name());
				pst.setString(5, cliente.getPrivilege().name());
				pst.setString(6, cliente.getTipoUsuario().name());
				pst.setString(7, cliente.getPassword());
				pst.setInt(8, cliente.getTelefono());
				pst.setString(9, cliente.getFechaAlta().toString());
			}
			if (cliente.getNombre() != null && cliente.getIdUsuario() != null) {
				pst.setLong(10, cliente.getIdUsuario());
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han asociado bien los datos a la consulta", e);
		}
	}

	protected Iterable<Cliente> ejecutarConsulta(String sql, Consumer<PreparedStatement> codigo) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(sql);) {

			codigo.accept(pst);

			try (ResultSet rs = pst.executeQuery()) {
				Cliente cliente = null;

				var clientes = new ArrayList<Cliente>();

				while (rs.next()) {
					cliente = filaACliente(rs);
					clientes.add(cliente);
				}

				return clientes;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta", e);
		}
	}

	protected Cliente ejecutarConsultaUno(String sql, Consumer<PreparedStatement> codigo) {
		var i = ejecutarConsulta(sql, codigo).iterator();
		return i.hasNext() ? i.next() : null;
	}

	private static Date cambiarADate(LocalDate fechaAlta) {
		Date date = Date.valueOf(fechaAlta);
		return date;
	}

}
