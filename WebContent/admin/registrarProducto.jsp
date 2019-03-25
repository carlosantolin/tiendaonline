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
	<form action="ServletRegistroProductos" method="post">
		nombre:<input type="text" name="campoNombre"/><br/>
		desarollador:<input type="text" name="campoDesarollador"/><br/>
		duracion:<input type="text" name="campoDuracion"/><br/>
	fecha de salida:<input type="text" name="campoFecha"/><br/>
	descripcion:<input type="text" name="campoDescripcion"/><br/>
		stock:<input type="number" name="campoStock"/><br/>
		precio:<input type="number" name="campoPrecio"/><br/>
				
		
		
		<input type="submit" value="Registrarme"/>
	</form>

</body>
</html>