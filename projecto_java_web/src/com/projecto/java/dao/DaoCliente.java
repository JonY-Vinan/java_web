package com.projecto.java.dao;

import com.projecto.java.entidad.Cliente;

public interface DaoCliente extends Dao<Cliente> {

	Iterable<Cliente> obtenerPorNombreParcial(String nombre);
	//Iterable<Cliente> obtenerPorPrecio(BigDecimal minimo, BigDecimal maximo);
	
}
