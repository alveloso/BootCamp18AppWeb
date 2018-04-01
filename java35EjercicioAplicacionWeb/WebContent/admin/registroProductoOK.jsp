<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmacion</title>
</head>
<body>

	<c:if test="${sessionScope.admin == null}">
		<jsp:forward page="login.jsp"></jsp:forward>
	</c:if>

	<h1>Producto registrado correctamente</h1>
	<a href="ServletListadoProductos">Ir al listado de productos</a>
</body>
</html>