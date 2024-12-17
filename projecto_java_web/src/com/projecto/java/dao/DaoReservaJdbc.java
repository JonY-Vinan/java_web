package com.projecto.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Consumer;

import com.projecto.java.entidad.EstadoReserva;
import com.projecto.java.entidad.Reserva;
import com.projecto.java.exepcion.AccesoDatosException;

public abstract class DaoReservaJdbc extends DaoJdbc implements DaoReserva {

	protected DaoReservaJdbc(String url, String user, String pass) {
		super(url, user, pass);
	}

	protected static Reserva filaACliente(ResultSet rs) throws SQLException {

		var id = rs.getLong("id");
		var nombre = rs.getString("nombre");
		var apellido = rs.getString("apellido");
		var email = rs.getString("email");
		var telefono = rs.getInt("telefono");
		var sFecha = rs.getString("fechaReserva");
		LocalDate fechaReserva = sFecha != null ? LocalDate.parse(sFecha) : null;
		var hora = rs.getString("hora");
		var numeroPersonas = rs.getInt("numeroPersonas");
		var estadoStr = rs.getString("estado");
		var estado = estadoStr != null ? EstadoReserva.valueOf(estadoStr) : null;

		Reserva reserva = new Reserva(id, nombre, apellido, email, telefono, fechaReserva, hora, numeroPersonas,
				estado);

		return reserva;
	}

	protected static void clienteAFila(Reserva reserva, PreparedStatement pst) {
		try {

			if (reserva.getNombre() != null) {
				pst.setString(1, reserva.getNombre());
				pst.setString(2, reserva.getApellido());
				pst.setString(3, reserva.getEmail());
				pst.setInt(4, reserva.getTelefono());
				pst.setString(5, reserva.getFechaReserva().toString());
				pst.setString(6, reserva.getHora());
				pst.setInt(7, reserva.getNumeroPersonas());
				pst.setString(8, reserva.getEstado().name());

			}
			if (reserva.getNombre() != null && reserva.getId() != null) {
				pst.setLong(10, reserva.getId());
			}

			if (reserva.getNombre() == null && reserva.getId() != null) {
				pst.setLong(1, reserva.getId());
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han asociado bien los datos a la consulta", e);
		}
	}

	protected Iterable<Reserva> ejecutarConsulta(String sql, Consumer<PreparedStatement> codigo) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(sql);) {

			codigo.accept(pst);

			try (ResultSet rs = pst.executeQuery()) {
				Reserva reserva = null;

				var reservas = new ArrayList<Reserva>();

				while (rs.next()) {
					reserva = filaACliente(rs);
					reservas.add(reserva);
				}

				return reservas;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error en la consulta", e);
		}
	}

	protected Reserva ejecutarConsultaUno(String sql, Consumer<PreparedStatement> codigo) {
		var i = ejecutarConsulta(sql, codigo).iterator();
		return i.hasNext() ? i.next() : null;
	}

}
