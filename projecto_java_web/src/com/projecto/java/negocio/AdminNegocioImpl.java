package com.projecto.java.negocio;

import com.projecto.java.dao.DaoReserva;
import com.projecto.java.entidad.Reserva;
import com.projecto.java.exepcion.NegocioException;
import com.projecto.java.fatoria.GestionFactoria;

public class AdminNegocioImpl implements AdminNegocio {

	private static final DaoReserva DAO_RESERVA = GestionFactoria.getDaoReserva();

	@Override
	public Reserva altaReserva(Reserva reserva) {
		if (reserva.isCorrecto()) {
			return DAO_RESERVA.insertar(reserva);

		} else {
			throw new NegocioException("El producto no es válido");
		}
	}

	@Override
	public Reserva modificarReserva(Reserva reserva) {
		if (reserva.isCorrecto()) {
			return DAO_RESERVA.modificar(reserva);
		} else {
			throw new NegocioException("El producto no es válido");
		}
	}

	@Override
	public void borrarReserva(Long id) {
		DAO_RESERVA.borrar(id);
	}

}
