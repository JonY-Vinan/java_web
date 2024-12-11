package com.projecto.java.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.function.Supplier;

import com.projecto.java.entidad.Cliente;
import com.projecto.java.exepcion.AccesoDatosException;



public class DaoClienteFicheroObjetos extends DaoClienteArrayList implements DaoCliente {

	private String rutaFichero;

	@SuppressWarnings("unchecked")
	public DaoClienteFicheroObjetos(String rutaFichero) {
		this.rutaFichero = rutaFichero;

		if (!new File(rutaFichero).exists()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero))) {
				oos.writeObject(new ArrayList<Cliente>());
			} catch (IOException e) {
				throw new AccesoDatosException("No se ha podido escribir en el fichero de objetos", e);
			}
		} else {
			// Si el fichero ya existe, leer los clientes existentes
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero))) {
				super.clientes = (ArrayList<Cliente>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				throw new AccesoDatosException("No se ha podido leer el fichero de objetos", e);
			}
		}
	}

	public DaoClienteFicheroObjetos(String url, String user, String pass) {
		this(url);
	}

	@Override
	public Iterable<Cliente> obtenerTodos() {
		return lectura(() -> super.obtenerTodos());
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		return lectura(() -> super.obtenerPorId(id));
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		return lecturaEscritura(() -> super.insertar(cliente));
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		return lecturaEscritura(() -> super.modificar(cliente));
	}

	@Override
	public void borrar(Long id) {
		lecturaEscritura(() -> {
			super.borrar(id);
			return null;
		});
	}

	@Override
	public Iterable<Cliente> obtenerPorNombreParcial(String nombre) {
		return lectura(() -> super.obtenerPorNombreParcial(nombre));
	}

	@SuppressWarnings("unchecked")
	private <R> R lectura(Supplier<R> proveedor) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero))) {
			super.clientes = (ArrayList<Cliente>) ois.readObject();
			return proveedor.get();
		} catch (ClassNotFoundException | IOException e) {
			throw new AccesoDatosException("No se ha podido realizar la operación de lectura", e);
		}
	}

	private <R> R lecturaEscritura(Supplier<R> proveedor) {
		var respuesta = lectura(proveedor);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero))) {
			oos.writeObject(super.clientes);
			return respuesta;
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido realizar la operación de escritura", e);
		}
	}
}
