<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>
Tu carrito de la compra.
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
  				
			</tr> 
		<c:forEach items="${sessionScope.carrito}" var="carro">
		<form action="" method="post">
		 	
			<tr>
				<td>${carro.nombre}</td>
				<td>${carro.desarollador}</td>
				<td>${carro.genero}</td>
				<td>${carro.duracion}</td>
				<td>${carro.fecha}</td>
				<td>${carro.precio}</td>
				<td>${carro.stock}</td>
				<td><img width="50" height="50" 
				src="/47tiendaonline/images/${juego.nombre}.png"></td>
			<td><input type="hidden" value="${juego.id}" name="campoId"><input type="submit" onclick="return confirm('estas seguro?')" value="Borrar"/></td>
				
			</tr>
			</form>
		</c:forEach>
	</table>
	
		
	