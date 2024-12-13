package com.projecto.java.app;

import com.projecto.java.biblioteca.Util;
import com.projecto.java.dao.DaoCliente;
import com.projecto.java.dao.DaoReserva;
import com.projecto.java.entidad.Cliente;
import com.projecto.java.entidad.Reserva;
import com.projecto.java.fatoria.GestionFactoria;

public class Aplicacion {

	private static final int SALIR = 0;

	private static final DaoCliente DAO_Cliente = GestionFactoria.getDaoCliente();
	private static final DaoReserva DAO_Reserva = GestionFactoria.getDaoReserva();

	// private static final boolean SIN_ID = false;
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
			case 6 -> buscarUsuarioNombre();
			case 7 -> crearNuevaReserva();
			case 8 -> listadoReservas();
			case 0 -> System.out.println("Gracias por usar nuestra aplicacion");

			default -> throw new IllegalArgumentException("Unexpected value: " + opc);
			}

		} while (opc != SALIR);

	}

	private static void listadoReservas() {
		var reserva = DAO_Reserva.obtenerTodos();
		mostrarLista(reserva);
	}

	private static Reserva crearNuevaReserva() {
		var reserva = nuevaReserva();
		DAO_Reserva.insertar(reserva);
		return reserva;
	}

	private static void CrearNuevoUsuario() {
		var client = nuevoUsuario();
		DAO_Cliente.insertar(client);
	}

	private static void listaUsuarios() {
		var clientes = DAO_Cliente.obtenerTodos();
		mostrarLista(clientes);
	}

	private static void buscarUsuariosPorId() {
		Long id = (long) Util.leerInt("Dime el id");
		var cliente = DAO_Cliente.obtenerPorId(id);
		mostrarLineaProducto(cliente);
	}

	private static void buscarUsuarioNombre() {
		var nombre = Util.leerCadena("Dime el nombre");
		var cliente = DAO_Cliente.obtenerPorNombreParcial(nombre);
		mostrarLista(cliente);
	}

	private static Object modificarCliente() {
		var id = Util.leerInt("Dime el id a modificar");
		var cliente = DAO_Cliente.obtenerPorId((long) id);
		System.out.println(cliente.toString());
		cliente.setDatos(cliente.getIdUsuario());
		DAO_Cliente.modificar(cliente);
		return cliente;
	}

	private static void borrarUsuarioPorId() {
		var id = Util.leerInt("Dime el id a borrar");
		var cl = DAO_Cliente.obtenerPorId((long) id);
		System.out.println(cl.toString());
		DAO_Cliente.borrar(cl.getIdUsuario());
	}

	@SuppressWarnings("unused")
	private static <T> void mostrarLista(Iterable<T> lista) {
		lista.forEach(p -> mostrarLineaProducto(p));
	}

	private static <T> void mostrarLineaProducto(T p) {
		System.out.println(p.toString());
	}

	private static int menu() {
		int respuesta = Util.leerInt("""
				** M E N U **
				01.-Nuevo cliente
				02.-Listar cliente
				03.-Buscar cliente por id
				04.-Borrar cliente por id
				05.-Modificar cliente
				06.-Buscar por nombre
				07.-Nueva reserva
				08.-Lists reserva
				09.-Buscar reserva por nombre
				10.-Busvar reserva por apellido
				11.-Modificar reserva
				12.-Eliminar reverva
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

	public static Reserva nuevaReserva() {
		var reserva = new Reserva();
		reserva.setDatos();
		return reserva;
	}
}
