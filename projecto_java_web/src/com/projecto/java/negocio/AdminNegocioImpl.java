package com.projecto.java.negocio;

import java.util.logging.Logger;

import com.projecto.java.dao.DaoReserva;
import com.projecto.java.entidad.Reserva;
import com.projecto.java.fatoria.GestionFactoria;

public class AdminNegocioImpl implements AdminNegocio {

	private static final Logger LOG = Logger.getLogger(AdminNegocioImpl.class.getName());
	private static final DaoReserva DAO_RESERVA = GestionFactoria.getDaoReserva();

	@Override
	public Reserva altaReserva(Reserva reserva) {
		return DAO_RESERVA.insertar(reserva);
	}

	@Override
	public Reserva modificarReserva(Reserva reserva) {
		return DAO_RESERVA.modificar(reserva);
	}

	@Override
	public void borrarReserva(Long id) {
		DAO_RESERVA.borrar(id);
	}

}
