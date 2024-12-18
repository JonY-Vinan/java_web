package com.web.reserva.controlador.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.projecto.java.fatoria.GestionFactoria;

@WebServlet("/admin/reserva")
public class RerevaAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sId = request.getParameter("id");

		if (sId != null) {
			Long id = Long.parseLong(sId);
			var reservas = GestionFactoria.getReservaNegocio().buscarReservaPorId(id);
			request.setAttribute("reserva", reservas);

		}

		request.getRequestDispatcher("/WEB-INF/vistas/admin/reserva.jsp").forward(request, response);

	}

}
