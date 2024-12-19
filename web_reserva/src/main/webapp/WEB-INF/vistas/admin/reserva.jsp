<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<form action="admin/reserva" method="post" class="needs-validation" novalidate>
    <div class="row mb-3">
        <label for="id" class="col-sm-2 col-form-label">Id</label>
        <div class="col-sm-10">
            <input type="number" readonly class="form-control" id="id" name="id" value="${reserva.id}">
        </div>
    </div>
    <div class="row mb-3">
        <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
        <div class="col-sm-10">
            <input type="text" class="form-control ${producto.errores.nombre != null ? 'is-invalid': '' }" id="nombre" name="nombre" value="${reserva.nombre}" required>
            <div class="invalid-feedback">El nombre no se puede dejar vacío</div>
        </div>
    </div>
    <div class="row mb-3">
        <label for="apellido" class="col-sm-2 col-form-label">Apellido</label>
        <div class="col-sm-10">
            <input type="text" class="form-control ${producto.errores.apellido != null ? 'is-invalid': '' }" id="apellido" name="apellido" value="${reserva.apellido}" required>
            <div class="invalid-feedback">El apellido no se puede dejar vacío</div>
        </div>
    </div>
    <div class="row mb-3">
        <label for="email" class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-10">
            <input type="email" class="form-control ${producto.errores.email != null ? 'is-invalid': '' }" id="email" name="email" value="${reserva.email}" required>
            <div class="invalid-feedback">El email no se puede dejar vacío y debe ser válido</div>
        </div>
    </div>
    <div class="row mb-3">
        <label for="telefono" class="col-sm-2 col-form-label">Telefono</label>
        <div class="col-sm-10">
            <input type="tel" class="form-control ${producto.errores.telefono != null ? 'is-invalid': '' }" id="telefono" name="telefono" value="${reserva.telefono}" required pattern="[0-9]{9}">
            <div class="invalid-feedback">El teléfono no se puede dejar vacío y debe tener 9 dígitos</div>
        </div>
    </div>
    <div class="row mb-3">
        <label for="fechaReserva" class="col-sm-2 col-form-label">Fecha de reserva</label>
        <div class="col-sm-10">
            <input type="date" min="${hoy}" class="form-control ${producto.errores.fechaReserva != null ? 'is-invalid': '' }" id="fechaReserva" name="fechaReserva" value="${reserva.fechaReserva}" required>
            <div class="invalid-feedback">La fecha de reserva no se puede dejar vacía</div>
        </div>
    </div>
    <div class="row mb-3">
        <label for="hora" class="col-sm-2 col-form-label">Hora</label>
        <div class="col-sm-10">
            <input type="time" class="form-control ${producto.errores.hora != null ? 'is-invalid': '' }" id="hora" name="hora" value="${reserva.hora}" required>
            <div class="invalid-feedback">La hora no se puede dejar vacía</div>
        </div>
    </div>
    <div class="row mb-3">
        <label for="numeroPersonas" class="col-sm-2 col-form-label">Numero de personas</label>
        <div class="col-sm-10">
            <input type="number" class="form-control ${producto.errores.numeroPersonas != null ? 'is-invalid': '' }" id="numeroPersonas" name="numeroPersonas" value="${reserva.numeroPersonas}" required min="1">
            <div class="invalid-feedback">El número de personas no se puede dejar vacío y debe ser al menos 1</div>
        </div>
    </div>
    <div class="row mb-3">
        <label for="estado" class="col-sm-2 col-form-label">Estado</label>
        <div class="col-sm-10">
            <select class="form-control ${producto.errores.estado != null ? 'is-invalid': '' }" id="estado" name="estado" required>
                <option value="">Seleccione...</option>
                <option value="PENDIENTE" ${reserva.estado == 'PENDIENTE' ? 'selected' : ''}>Pendiente</option>
                <option value="CONFIRMADA" ${reserva.estado == 'CONFIRMADA' ? 'selected' : ''}>Confirmada</option>
                <option value="CANCELADA" ${reserva.estado == 'CANCELADA' ? 'selected' : ''}>Cancelada</option>
                <option value="EN_ESPERA" ${reserva.estado == 'EN_ESPERA' ? 'selected' : ''}>En Espera</option>
                <option value="COMPLETADA" ${reserva.estado == 'COMPLETADA' ? 'selected' : ''}>Completada</option>
                <option value="NO_PRESENTADO" ${reserva.estado == 'NO_PRESENTADO' ? 'selected' : ''}>No Presentado</option>
            </select>
            <div class="invalid-feedback">El estado no se puede dejar vacío</div>
        </div>
    </div>

    <button type="submit" class="btn btn-primary">Guardar</button>
</form>

<script src="js/validacion.js"></script>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
