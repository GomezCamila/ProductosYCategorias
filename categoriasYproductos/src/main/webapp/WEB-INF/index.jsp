<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formateo fechas (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Formulario form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<div class="container mt-5">
		<h1 class="text-center display-2">Bienvenido a Productos y Categorías</h1>

		<div class="row justify-content-center mt-4">
			<div class="col-4 col-md-3">
				<a class="btn btn-success btn-block" href="/categories/new">Nueva Categoria</a>
				<a class="btn btn-success btn-block" href="/products/new">Nuevo Producto</a>
			</div>
		</div>

		<div class="row  mt-5">
			<div class="col-md-6">
				<h2>Todos los productos</h2>
				<ul class="list-group mt-3">
					<c:forEach items="${productos}" var="producto">
						<li class="list-group-item"><a href="products/${producto.id}">
								<c:out value="${producto.name}"></c:out>
						</a></li>
					</c:forEach>
				</ul>
			</div>
			
	</body>
</html>