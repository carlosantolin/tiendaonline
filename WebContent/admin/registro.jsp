<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>

	<jsp:include page="menu.jsp"/>
	<div>Introduce los datos del nuevo usuario:</div>
	<form action="ServletRegistroUsuario" name="formulario" method="post"><br/>
		nombre:<input type="text" name="campoNombre"/><br/>
		email:<input type="email" name="campoEmail" onkeyup="validarEmail();"/><br/>
		contraseña:<input type="password" name="campoPass"/><br/>
		<input type="submit" value="Registrarme"/>
	
	</form>

</body>
<script type="text/javascript" src="../jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function validarEmail(){
	var param = {email: $("input[name=campoEmail]").val()};
          
	$.ajax({
	     url:"../ValidarEmail", 
	     data : param,
	     success:function(resultado){
	         if(resultado == "-1"){
	        	 return;
	         }
	         alert("El email introducido ya existe. Por favor, introduce otro o inicia sesión.");
	     },
	     error:function( jqXHR, textStatus, errorThrown){
	         alert(textStatus);
	         alert(errorThrown);

	     },
	});
	
}
</script>
</html>