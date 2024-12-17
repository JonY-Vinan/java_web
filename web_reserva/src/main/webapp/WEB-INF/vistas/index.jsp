<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row row-cols-1 row-cols-md-3 row-cols-lg-4 g-4">
	<c:forEach items="${reservas}" var="r">
		<div class="col">
			<div class="card h-100">
				<img src="https://picsum.photos/400/300?${r.id}"
					class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">${r.nombre}</h5>
					<p class="card-text">${r.apellido}</p>
					<p class="card-text">
						<a class="btn btn-primary stretched-link" href="ficha?id=${r.id}">Ver
							ficha</a>
					</p>
				</div>
				<div class="card-footer">
					<small class="text-body-secondary">${r.fechaReserva}</small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<%--
<ul>
	<c:forEach items="${productos}" var="p">
		<li>${p.nombre}: ${p.precio} -> ${p.fechaCaducidad}</li>
	</c:forEach>
</ul>
 --%>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>