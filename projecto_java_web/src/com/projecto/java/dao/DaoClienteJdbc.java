package com.projecto.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.projecto.java.entidad.Cliente;

public abstract class DaoClienteJdbc extends DaoJdbc implements DaoCliente {

	protected DaoClienteJdbc(String url, String user, String pass) {
		super(url, user, pass);
	}

	protected static Cliente filaACliente(ResultSet rs) {
		Cliente cliente = new Cliente();
		cliente.setDatos();
		return cliente;
	}
	
	protected static void clienteAFila(Cliente cliente, PreparedStatement pst) {
		
	}

}
