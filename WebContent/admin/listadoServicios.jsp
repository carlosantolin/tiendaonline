<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Servicios</title>
</head>
<body>

<jsp:include page="menu.jsp" />
	<div>Listado de servicios de la tienda</div>

	<table>
		<c:forEach items="${servicios}" var="servicio">
			<tr>
				<td>${servicio.nombre}</td>
				<td>${servicio.descripcion}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>