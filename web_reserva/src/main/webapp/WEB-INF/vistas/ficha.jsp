<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<div class="card mb-3">
	<div class="row g-0">
		<div class="col-md-4">
			<img src="https://picsum.photos/600/800" class="img-fluid rounded-start" alt="...">
		</div>
		<div class="col-md-8">
			<div class="card-body">
				<h5 class="card-title">${reserva.nombre}</h5>
				<p class="card-text">${reserva.apellido}</p>
				<p class="card-text">
					<small class="text-body-secondary">${reserva.fechaReserva}</small>
				</p>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
