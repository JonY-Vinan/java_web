package com.projecto.java.negocio;

import java.util.logging.Logger;

import com.projecto.java.dao.DaoReserva;
import com.projecto.java.entidad.Reserva;
import com.projecto.java.fatoria.GestionFactoria;

public class ReservaNegocioImpl implements ReservaNegocio {

	private static final Logger LOG = Logger.getLogger(ReservaNegocioImpl.class.getName());
	private static final DaoReserva daoReserva = GestionFactoria.getDaoReserva();

	@Override
	public Iterable<Reserva> verReservas() {
		return daoReserva.obtenerTodos();
	}

	@Override
	public Reserva buscarReservaPorId(Long id) {
		LOG.info("Se ha pedido un producto por el id: " + id);
		return daoReserva.obtenerPorId(id);
	}

	@Override
	public Iterable<Reserva> buscarReservasPorNombre(String nombre) {
		LOG.info("BUSQUEDA: " + nombre);
		return daoReserva.obtenerPorNombreParcial(nombre);
	}

	@Override
	public Iterable<Reserva> buscarReservasPorApellido(String apellido) {
		return daoReserva.obtenerPorApellidoParcial(apellido);
	}

}
