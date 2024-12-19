package com.web.reserva.controlador.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Logger;

import com.projecto.java.entidad.EstadoReserva;
import com.projecto.java.entidad.Reserva;
import com.projecto.java.fatoria.GestionFactoria;

@WebServlet("/admin/reserva")
public class ReservaAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(ReservaAdminServlet.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sId = request.getParameter("id");

		if (sId != null) {
			Long id = Long.parseLong(sId);
			var reservas = GestionFactoria.getReservaNegocio().buscarReservaPorId(id);
			request.setAttribute("reserva", reservas);

		}
		request.setAttribute("hoy", LocalDate.now());
		request.getRequestDispatcher("/WEB-INF/vistas/admin/reserva.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recibir datos de petición

		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String sTelefono = request.getParameter("telefono");
		int telefono = Integer.parseInt(sTelefono);
		String sFecha = request.getParameter("fechaReserva");
		String sHora = request.getParameter("hora");
		String sNumeroPersonas = request.getParameter("numeroPersonas");
		int numeroPersonas = Integer.parseInt(sNumeroPersonas);
		String sEstado = request.getParameter("estado");
		EstadoReserva estado = EstadoReserva.valueOf(sEstado);
		// Convertir los datos

		Long id = sId.isBlank() ? null : Long.parseLong(sId);
		LocalDate fechaReserva = sFecha.isBlank() ? null : LocalDate.parse(sFecha);

		// Empaquetarlos en objetos

		var reserva = new Reserva(id, nombre, apellido, email, telefono, fechaReserva, sHora, numeroPersonas, estado);
		// Ejecutar la lógica de negocio
		if (!reserva.isCorrecto()) {
			LOG.info(reserva.toString());

			request.setAttribute("reserva", reserva);

			request.getRequestDispatcher("/WEB-INF/vistas/admin/reserva.jsp").forward(request, response);

			return;
		}
		var negocio = GestionFactoria.getAdminNegocio();

		if (reserva.getId() == null) {
			negocio.altaReserva(reserva);
		} else {
			negocio.modificarReserva(reserva);
		}

		// Empaquetar datos para la pantalla
		// Mostrar la siguiente pantalla

		response.sendRedirect(request.getContextPath() + "/admin/index");
	}
}
