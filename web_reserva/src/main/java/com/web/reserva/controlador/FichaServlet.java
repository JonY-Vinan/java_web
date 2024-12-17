package com.web.reserva.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.projecto.java.fatoria.GestionFactoria;

@WebServlet("/ficha")
public class FichaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String sId = request.getParameter("id");

		Long id = Long.parseLong(sId);
		
		var reserva = GestionFactoria.getReservaNegocio().buscarReservaPorId(id);

		request.setAttribute("reserva", reserva);

		request.getRequestDispatcher("/WEB-INF/vistas/ficha.jsp").forward(request, response);

	}

}
