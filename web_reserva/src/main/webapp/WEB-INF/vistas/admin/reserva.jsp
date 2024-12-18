<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<form>
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
		<label for="estado" class="col-sm-2 col-form-label">Estado</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="estado" name="estado"
				value="${reserva.estado}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="fecha" class="col-sm-2 col-form-label">Fecha de
			reservada</label>
		<div class="col-sm-10">
			<input type="date" class="form-control" id="fechaReserva"
				name="fechaReserva" value="${reserva.fechaReserva}">
		</div>
	</div>

	<button type="submit" class="btn btn-primary">Guardar</button>
</form>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>