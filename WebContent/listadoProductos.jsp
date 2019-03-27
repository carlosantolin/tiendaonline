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
	
	<div>
		<c:if test="${anterior >= 0}">
	<a href="ServletPortada?comienzo=${anterior}">anterior</a> &nbsp;&nbsp;&nbsp;&nbsp;
	</c:if>
	<c:if test="${siguiente < total}">
	<a href="ServletPortada?comienzo=${siguiente}">siguiente</a> 
	</c:if>
	</div>

	<table>
		<c:forEach items="${juegos}" var="juego">

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
							
			</tr>

		</c:forEach>
	</table>

</body>
</html>