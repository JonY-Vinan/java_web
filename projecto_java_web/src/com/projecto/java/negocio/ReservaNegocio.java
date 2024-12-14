package com.projecto.java.negocio;

import com.projecto.java.entidad.Reserva;

public interface ReservaNegocio {
  
	Iterable<Reserva> verReservas();
	Reserva buscarReservaPorId(Long id);
	Iterable<Reserva> buscarReservasPorNombre(String nombre);
	Iterable<Reserva> buscarReservasPorApellido(String apellido);
	
}
