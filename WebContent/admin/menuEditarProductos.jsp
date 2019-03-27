<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="w3.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Producto</title>
</head>
<body>

<form action="ServletEditarProductos" method="post" enctype="multipart/form-data">
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
				src="/47tiendaonline/images/${juego.nombre}.png"></td></tr>
				
				<tr>
				<td>nombre:<input type="text" value="${juego.nombre}" name="campoNombre"/></td>
		<td>desarollador:<input type="text" value="${juego.desarollador}" name="campoDesarollador"/></td>
		<td>duracion:<input type="text" value="${juego.duracion}" name="campoDuracion"/></td>
	<td>fecha de salida:<input type="text" value="${juego.fecha}" name="campoFecha"/></td>
	<td>genero:<input type="text" value="${juego.genero}" name="campoGenero"/></td>
		<td>stock:<input type="number" value="${juego.stock}" name="campoStock"/></td>
		<td>precio:<input type="number" value="${juego.precio}" name="campoPrecio"/></td>
				
		<td>imagen:<input type="file" name="campoImagen"/></td>
		
		<td><input type="submit" value="Editame"/></td>
				</tr>
</table>
</form>
</body>
</html>