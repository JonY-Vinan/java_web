package com.web.reserva.presentacion;

import java.io.IOException;
import java.io.PrintWriter;

import com.projecto.java.entidad.Reserva;
import com.projecto.java.fatoria.GestionFactoria;
import com.projecto.java.negocio.ReservaNegocio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");

		
		ReservaNegocio negocio = GestionFactoria.getReservaNegocio();

		String incrustacion = "";

		if (sId == null) {
			Iterable<Reserva> productos;

			if (nombre == null) {
				productos = negocio.verReservas();
			} else {
				productos = negocio.buscarReservasPorNombre(nombre);
			}

			incrustacion += "<ul>\n";

			for (var p : productos) {
				incrustacion += "<li>" + p.getNombre() + "</li>\n";
			}

			incrustacion += "</ul>\n";
		} else {
			var producto = negocio.buscarReservaPorId(Long.parseLong(sId));

			incrustacion += "<dl>\n";

			incrustacion += "<dt>Nombre</dt><dd>" + producto.getNombre() + "</dd>\n";
			incrustacion += "<dt>Email</dt><dd>" + producto.getEmail() + "</dd>\n";
			incrustacion += "<dt>Telefono</dt><dd>" + producto.getTelefono() + "</dd>\n";

			incrustacion += "</dl>\n";
		}

		out.printf("""
				<!DOCTYPE html>
				<html>
				<head>
					<title>Productos</title>
				</head>
				<body>
					%s
				</body>
				</html>
				""", incrustacion);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private static final long serialVersionUID = -7264352929414320945L;

}
