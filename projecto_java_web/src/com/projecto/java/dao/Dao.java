package com.projecto.java.dao;

public interface  Dao<T> {

	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	T insertar(T objeto);
	T modificar(T objeto);
	void borrar(Long id);
	
}
