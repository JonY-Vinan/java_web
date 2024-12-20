package org.com.restaurante.negocio;

import org.com.restaurante.accesoadatos.ReservaDao;
import org.com.restaurante.fabrica.GestionFabrica;

public class AnonimoNegocioImpl implements AnonimoNegocio{

	ReservaDao reservaDao = GestionFabrica.getDaoReserva();
}
