package com.projecto.java.fatoria;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.projecto.java.dao.DaoCliente;
import com.projecto.java.dao.DaoReserva;
import com.projecto.java.exepcion.GestionFactoriaException;

public class GestionFactoria {
	private static DaoCliente daoCliente = null;
	private static DaoReserva daoReserva = null;

	static {
		try {
			Properties props = new Properties();
			props.load(GestionFactoria.class.getClassLoader().getResourceAsStream("configuracion.properties"));
			
			var daoClienteClase = props.getProperty("dao.cliente.implementacion");
			var daoReservaClase = props.getProperty("dao.reserva.implementacion");
			
			var url = props.getProperty("dao.url");
			var user = props.getProperty("dao.user");
			var pass = props.getProperty("dao.pass");

			daoCliente = (DaoCliente) Class.forName(daoClienteClase)
					.getConstructor(String.class, String.class, String.class).newInstance(url, user, pass);
			daoReserva = (DaoReserva) Class.forName(daoReservaClase)
					.getConstructor(String.class, String.class, String.class).newInstance(url, user, pass);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException | IOException e) {
			throw new GestionFactoriaException("No se ha podido inicializar la fábrica", e);
		}
	}

	public static DaoCliente getDaoCliente() {
		return daoCliente;
	}

	public static DaoReserva getDaoReserva() {
		return daoReserva;
	}
}
