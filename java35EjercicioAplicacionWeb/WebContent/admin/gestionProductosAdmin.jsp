<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area gestión productos</title>
</head>
<body>

	<c:if test="${sessionScope.admin == null}">
		<jsp:forward page="login.jsp"></jsp:forward>
	</c:if>

	<h1>Area de productos</h1>
	
	<div><a href="registrarProductoAdmin.jsp">REGISTRAR PRODUCTO</a><br/></div>
	
	<c:forEach items="${productos}" var="producto">
		<div style="margin: 8px">
		
			<!-- Tienen que ser los nombres de las variables dentro de la clase -->
		
			Nombre: ${producto.nombre}<br/>
			Dispositivos: ${producto.dispositivos}<br/>
			Género: ${producto.genero}</br>
			Fecha de salida: ${producto.fechaSalida}</br>
			Precio: ${producto.precio}</br>
			Formato: ${producto.formato}</br>
			Numero de jugadores: ${producto.numeroJugadores}</br>
			Compañía: ${producto.compania}</br>
			Idioma: ${producto.idioma}</br>
			Editor: ${producto.editor}</br>
 			Imagen: <img alt="Imagen" src="${producto.rutaImagen}" height="200">
			<a href="ServletBorrarProducto?id=${producto.id}">BORRAR</a><br/>
			<a href="ServletEditarProducto?id=${producto.id}">EDITAR</a><br/>
		</div>
	</c:forEach>

</body>
</html>