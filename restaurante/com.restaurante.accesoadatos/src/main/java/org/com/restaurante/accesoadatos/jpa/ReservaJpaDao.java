package org.com.restaurante.accesoadatos.jpa;

import org.com.restaurante.accesoadatos.JpaDao;
import org.com.restaurante.accesoadatos.ReservaDao;
import org.com.restaurante.entidades.Reserva;

public class ReservaJpaDao extends JpaDao implements ReservaDao {

	public ReservaJpaDao(String nousado1, String nousado2, String nousado3) {
		super(nousado1, nousado2, nousado3);
	}

	@Override
	public Iterable<Reserva> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva insertar(Reserva objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva modificar(Reserva objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		
	}


}
