package com.web.reserva.controlador.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.projecto.java.fatoria.GestionFactoria;

@WebServlet("/admin/reserva/borrar")
public class BorrarReservaAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sId = request.getParameter("id");

		Long id = Long.parseLong(sId);
		GestionFactoria.getAdminNegocio().borrarReserva(id);
		

		response.sendRedirect(request.getContextPath() + "/admin/index");

	}

}
