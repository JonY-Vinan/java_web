package org.com.restaurante.negocio;

import org.com.restaurante.accesoadatosException.NegocioException;
import org.com.restaurante.entidades.Reserva;

public interface AnonimoNegocio {

	default Reserva detalleProducto(Long id) {
		throw new NegocioException("NO IMPLEMENTADO");
	}
}
