<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrar Categoria</title>
</head>
<body>

<jsp:include page="menu.jsp" />
	<div>Introduce los datos del nuevo servicio</div>
	<form action="ServletRegistroCategorias" method="post">
		nombre:<input type="text" name="campoNombre"/><br/>
		descripcion:<input type="text" name="campoDescripcion"/><br/>


		<input type="submit" value="Registrarme"/>
	</form>
</body>
</html>