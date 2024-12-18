<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
<table class="table table-bordered table-hover table-striped">
	<caption>Reservas</caption>
	
	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Estado</th>
			<th>Fecha de reserva</th>
			<th>OPCIONES</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${reserva}" var="p">
		<tr>
			<th>${p.id}</th>
			<td>${p.nombre}</td>
			<td>${p.estado}</td>
			<td>${p.fechaReserva}</td>
			<td>
				<a href="reserva?id=${p.id}" class="btn btn-primary btn-sm">Editar</a>
				<a href="reserva?id=${p.id}" class="btn btn-danger btn-sm">Borrar</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
	
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
				<a href="#" class="btn btn-primary btn-sm">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>