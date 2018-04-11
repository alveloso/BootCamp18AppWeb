<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de producto</title>
</head>
<body>

	<c:if test="${sessionScope.admin == null}">
		<jsp:forward page="login.jsp"></jsp:forward>
	</c:if>
	
	<div style="color: red">${mensaje}</div>

	<a href="index.jsp">Volver al inicio</a>
	
	<div>Introduce los datos del juego</div>
	
	<!-- Las vistas cuanto más sencillas mejor-->
	<form action="ServletRegistroProducto" method="post" enctype="multipart/form-data">
		Nombre: <input type="text" name="campoNombre" id="campoNombre"><br/>
		Dispositivos: <input type="text" name="campoDispositivos" id="campoDispositivos"><br/>
		Genero: <input type="text" name="campoGenero" id="campoNumeracion"><br/>
		Fecha de salida: <input type="text" name="campoFechaSalida" id="campoFechaSalida"><br/>
		Precio: <input type="text" name="campoPrecio" id="campoPrecio"><br/>
		Formato: <input type="text" name="campoFormato" id="campoFormato"><br/>
		Numero de jugadores: <input type="text" name="campoNumeroJugadores" id="campoNumeroJugadores"><br/>
		Compañia: <input type="text" name="campoCompania" id="campoCompania"><br/>
		Idioma: <input type="text" name="campoIdioma" id="campoIdioma"><br/>
		Editor: <input type="text" name="campoEditor" id="campoEditor"><br/>
		Imágen: <input type="file" name="campoImagen"><br/>	
		<input type="submit" value="REGISTRAR">
	</form>
	
</body>
</html>