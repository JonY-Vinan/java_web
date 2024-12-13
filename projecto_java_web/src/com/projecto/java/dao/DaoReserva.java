package com.projecto.java.dao;

import com.projecto.java.entidad.Reserva;

public interface DaoReserva extends Dao<Reserva> {

	Iterable<Reserva> obtenerPorNombreParcial(String nombre);

	Iterable<Reserva> obtenerPorApellidoParcial(String apellido);

}
