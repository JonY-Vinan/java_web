package com.projecto.java.app;

import com.projecto.java.biblioteca.Util;
import com.projecto.java.dao.DaoCliente;
import com.projecto.java.entidad.Cliente;
import com.projecto.java.fatoria.GestionFactoria;

public class Aplicacion {

	private static final int SALIR = 0;

	private static final DaoCliente DAO = GestionFactoria.getDaoCliente();

	//private static final boolean SIN_ID = false;
	public static void main(String[] args) {
		var opc = 0;

		do {

			opc = menu();
			switch (opc) {
			case 1 -> CrearNuevoUsuario();
			case 2 -> listaUsuarios();
			case 3 -> buscarUsuariosPorId();
			case 4 -> borrarUsuarioPorId();
			case 5 -> modificarCliente();
			case 0 -> System.out.println("Gracias por usar nuestra aplicacion");

			default -> throw new IllegalArgumentException("Unexpected value: " + opc);
			}

		} while (opc != SALIR);

	}

	private static Object modificarCliente() {
		var id = Util.leerInt("Dime el id a modificar");
		var cliente = DAO.obtenerPorId((long) id);
		DAO.modificar(cliente);
		return cliente;
	}

	private static void borrarUsuarioPorId() {
		var id = Util.leerInt("Dime el id a borrar");
		DAO.borrar((long) id);
	}

	private static void buscarUsuariosPorId() {
		Long id = (long) Util.leerInt("Dime el id");
		var cliente = DAO.obtenerPorId(id);
		mostrarFichaProducto(cliente);
	}

	private static void mostrarFichaProducto(Cliente cliente) {
		System.out.println(cliente.toString());

	}

	private static void listaUsuarios() {
		var clientes = DAO.obtenerTodos();
		mostrarListaClientes(clientes);
	}

	private static void mostrarListaClientes(Iterable<Cliente> clientes) {
		clientes.forEach(p -> mostrarLineaProducto(p));
	}

	private static void mostrarLineaProducto(Cliente p) {
		System.out.println(p.toString());
	}

	private static void CrearNuevoUsuario() {
		var client = nuevoUsuario();
		DAO.insertar(client);
	}

	private static int menu() {
		int respuesta = Util.leerInt("""
				** M E N U **
				1.-Nuevo cliente
				2.-Listar cliente
				3.-Buscar cliente por id
				4.-Borrar cliente por id
				5.-Modificar cliente
				0.-SALIR
				elige una opcion:
				""");
		return respuesta;
	}

	public static Cliente nuevoUsuario() {
		var cliente = new Cliente();
		cliente.setDatos();
		return cliente;
	}
}
