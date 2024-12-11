package com.projecto.java.biblioteca;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {
	// Sobrescribimos el método que crea la cabecera
	protected void writeStreamHeader() throws IOException {// No hacer nada.
	}// Constructores

	public MyObjectOutputStream() throws IOException {
		super();
	}

	public MyObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
}
