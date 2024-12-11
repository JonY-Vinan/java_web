package com.projecto.java.dao;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.projecto.java.entidad.*;

public class DaoClienteArrayList implements DaoCliente {

	ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public DaoClienteArrayList() {

	}

	public DaoClienteArrayList(String url, String user, String pass) {
		this();
	}

	@Override
	public Iterable<Cliente> obtenerTodos() {
		return clientes;
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getIdUsuario().equals(id)) {
				return clientes.get(i);
			}
		}
		return null;
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}

	@Override
	public Cliente modificar(Cliente cliente) {

		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getIdUsuario().equals(cliente.getIdUsuario())) {
				cliente.setDatos(clientes.get(i).getIdUsuario());
				clientes.set(i, cliente);
				return cliente;
			}
		}
		return null;

	}

	@Override
	public void borrar(Long id) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getIdUsuario().equals(id)) {
				clientes.remove(i);
			}
		}
	}

	@Override
	public Iterable<Cliente> obtenerPorNombreParcial(String nombre) {
		return clientes.stream().filter(p -> p.getNombre().contains(nombre)).collect(Collectors.toList());
	}

}
