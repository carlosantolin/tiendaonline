<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="w3.css"> 
<meta charset="UTF-8">
<title>Listado de usuarios</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Listado de usuarios registrados de la tienda</div>
	
	<div>
		<c:if test="${anterior >= 0}">
	<a href="ServletListadoUsuarios?comienzo=${anterior}">anterior</a> &nbsp;&nbsp;&nbsp;&nbsp;
	</c:if>
	<c:if test="${siguiente < total}">
	<a href="ServletListadoUsuarios?comienzo=${siguiente}">siguiente</a> 
	</c:if>
	</div>

	<table class="w3-table-all w3-small">
	<tr class="w3-red">
  				<th>Nombre</th>
  				<th>e-mail</th>
  				<th>contraseña</th>
  				

			</tr>
		<c:forEach items="${usuarios}" var="usuario">
		<form action="ServletBorradoUsuarios" method="post">
		
		
			<tr>
				<td>${usuario.nombre}</td>
				<td>${usuario.email}</td>
				<td>${usuario.pass}</td>
				<td>${usuario.id}</td>
				<td><img width="50" height="50" 
				src="/47tiendaonline/images/${usuario.id}.png"></td>
				<td><input type="hidden"  value="${usuario.id}" name="campoId"><input type="submit" onclick="return confirm('estas seguro?')" value="Borrar"/></td>
				<td><input type="submit" formaction="ServletEditarUsuarios" value="Editar"/></td>
				
			</tr>
			</form>
		</c:forEach>
	</table>


</body>
</html>