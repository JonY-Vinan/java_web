package com.projecto.java.negocio;

import com.projecto.java.entidad.Reserva;

public interface AdminNegocio {
  
	Reserva altaReserva(Reserva reserva);
	Reserva modificarReserva(Reserva reserva);
	void borrarReserva(Long id);
}
