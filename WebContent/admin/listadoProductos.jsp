<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="../w3.css"> 
<meta charset="UTF-8">
<title>Listado de productos</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Listado de productos de la tienda</div>
	
	<div>
		<c:if test="${anterior >= 0}">
	<a href="ServletListadoProductos?comienzo=${anterior}&campoBusqueda=${campoBusqueda}">anterior</a> &nbsp;&nbsp;&nbsp;&nbsp;
	</c:if>
	<c:if test="${siguiente < total}">
	<a href="ServletListadoProductos?comienzo=${siguiente}&campoBusqueda=${campoBusqueda}">siguiente</a> 
	</c:if>
	</div>
	
	<div>
		<form action="ServletListadoProductos">
			buscar: <input type="text" name ="campoBusqueda"/>
			<input type="submit" value="BUSCAR"/>
		</form>
	</div>
	
	<div>
		total de jugadores: ${total}
	</div>

	<table class="w3-table-all w3-small ">
	<tr class="w3-red">
  				<th>Nombre</th>
  				<th>Desarrollador</th>
  				<th>Genero</th>
  				<th>Duracion</th>
  				<th>Fecha</th>
  				<th>Precio</th>
  				<th>Stock</th>
  				<th>Id</th>
  				<th>Imagen</th>
  				<th>Borrar</th>
  				<th>Editar</th>
			</tr> 
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
	
	<jsp:include page="/carritoCompra.jsp" />

</body>
</html>