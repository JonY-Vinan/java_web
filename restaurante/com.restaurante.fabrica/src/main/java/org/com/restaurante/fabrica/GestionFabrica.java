package org.com.restaurante.fabrica;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.com.restaurante.accesoadatos.ReservaDao;

public class GestionFabrica {
	private static ReservaDao daoReserva = null;

	static {
		try {
			Properties props = new Properties();
			props.load(GestionFabrica.class.getClassLoader().getResourceAsStream("restaurante.properties"));

			// var daoClienteClase = props.getProperty("dao.cliente.implementacion");
			var daoReservaClase = props.getProperty("dao.reserva.implementacion");

			var url = props.getProperty("dao.url");
			var user = props.getProperty("dao.user");
			var pass = props.getProperty("dao.pass");

			// daoCliente = (DaoCliente) Class.forName(daoClienteClase)
			// .getConstructor(String.class, String.class, String.class).newInstance(url,
			// user, pass);
			daoReserva = (ReservaDao) Class.forName(daoReservaClase)
					.getConstructor(String.class, String.class, String.class).newInstance(url, user, pass);

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException | IOException e) {
			throw new GestionFabricaException("No se ha podido inicializar la fábrica", e);
		}
	}

	public static ReservaDao getDaoReserva() {
		return daoReserva;
	}

}
