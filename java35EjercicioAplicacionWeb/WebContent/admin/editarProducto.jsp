<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar producto</title>
</head>
<body>

	<c:if test="${sessionScope.admin == null}">
		<jsp:forward page="login.jsp"></jsp:forward>
	</c:if>

	<jsp:include page="menu.jsp"></jsp:include>

	<form action="ServletGuardarCambiosProducto" method="post">
		Nombre: <input type="text" name="campoNombre" value="${productoAeditar.nombre}"><br/>
		Dispositivos: <input type="text" name="campoDispositivos" value="${productoAeditar.dispositivos}"><br/>
		Género: <input type="text" name="campoGenero" value="${productoAeditar.genero}"><br/>
		Fecha de salida: <input type="text" name="campoFechaSalida" value="${productoAeditar.fechaSalida}"><br/>
		Precio: <input type="text" name="campoPrecio" value="${productoAeditar.precio}"><br/>
		Formato: <input type="text" name="campoFormato" value="${productoAeditar.formato}"><br/>
		Numero de jugadores: <input type="text" name="campoNumeroJugadores" value="${productoAeditar.numeroJugadores}"><br/>
		Compañia: <input type="text" name="campoCompania" value="${productoAeditar.compania}"><br/>
		Idioma: <input type="text" name="campoIdioma" value="${productoAeditar.idioma}"><br/>
		Editor: <input type="text" name="campoEditor" value="${prouctoAeditar.editor}"><br/>
		
		<input type="hidden" name="campoId" value="${ productoAeditar.id }">
		<input type="submit" value="GUARDAR CAMBIOS">
	</form>
	
</body>
</html>