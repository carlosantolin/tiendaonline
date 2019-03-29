<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
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
  				
			</tr> 
		<c:forEach items="${sessionScope.carrito}" var="juego">
		<form action="" method="post">
		 	
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
				
			</tr>
			</form>
		</c:forEach>
	</table>
	
		
	