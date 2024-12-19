<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<form action="admin/reserva" method="post">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" readonly class="form-control" id="id" name="id"
				value="${reserva.id}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nombre" name="nombre"
				value="${reserva.nombre}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="apellido" class="col-sm-2 col-form-label">Apellido</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="apellido" name="apellido"
				value="${reserva.apellido}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="email" class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="email" name="email"
				value="${reserva.email}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="telefono" class="col-sm-2 col-form-label">Telefono</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" id="telefono"
				name="telefono" value="${reserva.telefono}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="fechaReserva" class="col-sm-2 col-form-label">Fecha
			de reserva</label>
		<div class="col-sm-10">
			<input type="date" class="form-control" id="fechaReserva"
				name="fechaReserva" value="${reserva.fechaReserva}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="hora" class="col-sm-2 col-form-label">Hora</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="hora" name="hora"
				value="${reserva.hora}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="numeroPersonas" class="col-sm-2 col-form-label">Numero
			de personas</label>
		<div class="col-sm-10">
			<input type="number" class="form-control" id="numeroPersonas"
				name="numeroPersonas" value="${reserva.numeroPersonas}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="estado" class="col-sm-2 col-form-label">Estado</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="estado" name="estado"
				value="${reserva.estado}">
		</div>
	</div>

	<button type="submit" class="btn btn-primary">Guardar</button>
</form>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>