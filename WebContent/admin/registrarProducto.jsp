<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar productos</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Introduce los datos del nuevo juego</div>
	<form action="ServletRegistroProductos" method="post" 
	 enctype="multipart/form-data">
		nombre:<input type="text" name="campoNombre"/><br/>
		
		desarollador:<input type="text" name="campoDesarollador"/><br/>
		duracion:<input type="text" name="campoDuracion"/><br/>
	fecha de salida:<input type="text" name="campoFecha"/><br/>
	
	Genero:
	<select name="campoDescripcion">
			<c:forEach items="${categorias}" var="categoria">
				<option value="${categoria.id}">${categoria.nombre}</option>
			</c:forEach>
	</select><br/>
	
		stock:<input type="number" name="campoStock"/><br/>
		precio:<input type="number" name="campoPrecio"/><br/>
				
		imagen:<input type="file" name="campoImagen"/><br/>
		
		<input type="submit" value="Registrarme"/>
	</form>

</body>
</html>