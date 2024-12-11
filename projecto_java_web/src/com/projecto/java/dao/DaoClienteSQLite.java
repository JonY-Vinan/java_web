package com.projecto.java.dao;

import com.projecto.java.entidad.Cliente;

public class DaoClienteSQLite extends DaoClienteArrayList implements DaoCliente {

	@Override
	public Iterable<Cliente> obtenerTodos() {
		// TODO Auto-generated method stub
		return super.obtenerTodos();
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return super.obtenerPorId(id);
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		return super.insertar(cliente);
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		// TODO Auto-generated method stub
		return super.modificar(cliente);
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		super.borrar(id);
	}

	@Override
	public Iterable<Cliente> obtenerPorNombreParcial(String nombre) {
		// TODO Auto-generated method stub
		return super.obtenerPorNombreParcial(nombre);
	}

	
}
