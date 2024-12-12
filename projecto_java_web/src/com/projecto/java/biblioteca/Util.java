package com.projecto.java.biblioteca;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;


public class Util {

	public static String leerCadena() {
		String cadena = "";
		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(entrada);
		try {
			cadena = teclado.readLine();
		} catch (IOException er) {
			System.out.println("error al introducir datos");
			System.exit(0);
		}
		return cadena;
	}

	public static String leerCadena(String mensaje) {
		String cadena = "";
		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(entrada);
		System.out.println(mensaje);
		try {
			cadena = teclado.readLine();
		} catch (IOException er) {
			System.out.println("error al introducir datos");
			System.exit(0);
		}
		return cadena;
	}

	public static char respCharList(String s) {
		char c;
		boolean error;
		do {
			error = false;
			/* System.out.println("Introduce respuesta: "); */
			c = leerChar();
			s = s.toUpperCase();
			c = Character.toUpperCase(c);
			if (-1 == s.indexOf(c)) {
				System.out.println("Error, opcion no valida");
				error = true;
			}
		} while (error);
		return c;
	}

	public static char leerChar() {
		char c;
		String cadena;
		boolean error;
		do {
			error = false;
			cadena = leerCadena();
			if (1 != cadena.length()) {
				System.out.println("Error, introduce un solo caracter: ");
				error = true;
			}
		} while (error);
		c = cadena.charAt(0);
		return c;
	}

	public static int leerInt() {
		int num = 0;
		boolean error;
		do {
			error = false;
			try {
				num = Integer.parseInt(leerCadena());
			} catch (NumberFormatException e) {
				System.out.println("Error, introduce un n�mero: ");
				error = true;
			}
		} while (error);
		return num;
	}

	public static int leerInt(String mensaje) {
		int num = 0;
		boolean error;
		System.out.println(mensaje);
		do {
			error = false;
			try {
				num = Integer.parseInt(leerCadena());
			} catch (NumberFormatException e) {
				System.out.println("Error, introduce un n�mero: ");
				error = true;
			}
		} while (error);
		return num;
	}

	public static float leerFloat() {
		float num = 0;
		boolean error;
		do {
			error = false;
			try {
				num = Float.parseFloat(leerCadena());
			} catch (NumberFormatException e) {
				System.out.println("Error, introduce un n�mero: ");
				error = true;
			}
		} while (error);
		return num;
	}

	public static float leerFloat(String mensaje) {
		float num = 0;
		boolean error;
		System.out.println(mensaje);
		do {
			error = false;
			try {
				num = Float.parseFloat(leerCadena());
			} catch (NumberFormatException e) {
				System.out.println("Error, introduce un n�mero: ");
				error = true;
			}
		} while (error);
		return num;
	}

	public static int leerInt(int n, int m) {
		int num = 0;
		boolean error;
		do {
			error = false;
			try {
				num = Integer.parseInt(leerCadena());
			} catch (NumberFormatException e) {
				System.out.println("Error, introduce un n�mero: ");
				error = true;
				num = n;
			}
			if (num < n || num > m) {
				System.out.println("Error, numero fuera de rango\nIntroduce otro n�mero: ");
				error = true;
			}
		} while (error);
		return num;
	}

	public static int leerInt(int n, int m, String mensaje) {
		int num = 0;
		boolean error;
		do {
			System.out.println(mensaje);
			error = false;
			try {
				num = Integer.parseInt(leerCadena());
			} catch (NumberFormatException e) {
				System.out.println("Error ,no es un numero");
				error = true;
				num = n;
			}
			if (num < n || num > m) {
				System.out.println("Error, numero fuera de rango");
				error = true;
			}
		} while (error);
		return num;
	}

	public static float leerFloat(float n, float m, String mensaje) {
		float num = 0;
		boolean error;
		do {
			System.out.println(mensaje);
			error = false;
			try {
				num = Float.parseFloat(leerCadena());

			} catch (NumberFormatException e) {
				System.out.println("Error, no es un numero");
				error = true;
				num = n;
			}
			if (num < n || num > m) {
				System.out.println("Error, numero fuera de rango");
				error = true;
			}
		} while (error);
		return num;
	}

	// Método para leer objetos desde un archivo F
	public static <T> List<T> leerObjetos(File archivo, Class<T> tipo) throws IOException {
		List<T> objetos = new ArrayList<>();
		if (!archivo.exists()) {
			return objetos;
			// Retornar lista vacía si el archivo no existe
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
			while (true) {
				try {
					Object obj = ois.readObject();
					if (tipo.isInstance(obj)) {
						objetos.add(tipo.cast(obj));
					}
				} catch (EOFException e) {
					break; // Fin del archivo alcanzado
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return objetos;
	}

	// Método para guardar un objeto en un archivo
	public static void guardarObjeto(File archivo, Object obj) throws IOException {
		int numero = Util.calculoFichero(archivo) + 1;
		if (archivo.exists()) {
			try {
				FileOutputStream fos = new FileOutputStream(archivo, true);
				MyObjectOutputStream moos = new MyObjectOutputStream(fos);

				moos.writeObject(obj);
				moos.close();
				fos.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error en el fichero");
			} catch (IOException e1) {
				System.out.println("Error entrada/salida");
			}
		} else {
			try {
				FileOutputStream fos = new FileOutputStream(archivo);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(obj);
				oos.close();
				fos.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error en el fichero");
			} catch (IOException e1) {
				System.out.println("Error entrada/salida");
			}

		}
		System.out.println("Numero asignado: " + numero);

	}

	private static int calculoFichero(File archivo) {
		int cont = 0;

		if (archivo.exists()) {
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			try {
				fis = new FileInputStream(archivo);
				ois = new ObjectInputStream(fis);

				Object aux = ois.readObject();

				while (aux != null) {
					cont++;
					aux = ois.readObject();
				}

			} catch (EOFException e1) {
				// System.out.println("Has terminado de leer, "+cont+" objetos");

			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				ois.close();
				fis.close();
			} catch (IOException e) {

				System.out.println("Error al cerrar los flujos. ");
			}
		}
		return cont;
	}

	public static boolean primo(int a) {
		boolean x = true;
		if (a < 1) {
			x = false;
		}
		for (int c = 2; c < a; c++) {
			if (a % c == 0) {
				x = false;
				break;
			}
		}
		return x;
	}

	public static boolean esmultiplo(int a, int b) {
		boolean x = false;
		if (b % a == 0) {
			x = true;
		}
		return x;

	}

	public static char[] getabcspanishu() {
		char abc[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', '�', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		return abc;
	}

	public static char[] getabcspanishl() {
		char abc[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', '�', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		return abc;
	}

	public static LocalDate leerFecha(String mensaje) {
		String fechaAux;
		LocalDate date = null;
		boolean error;
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(mensaje);
		do {
			error = false;

			fechaAux = Util.leerCadena();
			try {
				date = LocalDate.parse(fechaAux, formateador);
			} catch (DateTimeParseException e) {
				error = true;
				System.out.println("Error, introduce fecha con formato dd-mm-aaaa: ");
			}
		} while (error);
		return date;
	}

	public static LocalTime leerHora(String mensaje) {
		String horaAux;
		LocalTime time = null;
		boolean error;
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm");
		System.out.println(mensaje);
		do {
			error = false;
			horaAux = Util.leerCadena();
			try {
				time = LocalTime.parse(horaAux, formateador);
			} catch (DateTimeParseException e) {
				error = true;
				System.out.println("Error, introduce la hora con formato HH:mm: ");
			}
		} while (error);
		return time;
	}

}
