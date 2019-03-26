<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de productos</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Listado de productos de la tienda</div>

	<table>
		<c:forEach items="${juegos}" var="juego">
		<form action="ServletBorradoProductos" method="post">
			<tr>
				<td>${juego.nombre}</td>
				<td>${juego.desarollador}</td>
				<td>${juego.genero}</td>
				<td>${juego.duracion}</td>
				<td>${juego.fecha}</td>
				<td>${juego.precio}</td>
				<td>${juego.stock}</td>
				<td>${juego.id}</td>
				<td><img width="50" height="50" 
				src="/47tiendaonline/images/${juego.nombre}.png"></td>
			<td><input type="hidden" value="${juego.id}" name="campoId"><input type="submit" onclick="return confirm('estas seguro?')" value="Borrar"/></td>
				<td><input type="hidden" value="${juego.id}" name="campoId"><input type="submit" formaction="ServletMenuEditarProductos" value="Editar"/></td>
				
			</tr>
			</form>
		</c:forEach>
	</table>

</body>
</html>