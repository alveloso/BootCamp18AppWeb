<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area gestión clientes</title>
</head>
<body>

	<c:if test="${sessionScope.admin == null}">
		<jsp:forward page="login.jsp"></jsp:forward>
	</c:if>

	<h1>Area de clientes</h1>
	
	<div><a href="registrarClienteAdmin.jsp">REGISTRAR CLIENTE</a><br/></div>
	
	<c:forEach items="${clientes}" var="cliente">
		<div style="margin: 8px">
		
			<!-- Tienen que ser los nombres de las variables dentro de la clase -->
		
			Nombre: ${cliente.nombre}<br/>
			Calle: ${cliente.calle}<br/>
			Numeración: ${cliente.numeracion}</br>
			Código postal: ${cliente.codigoPostal}</br>
			Poblacion: ${cliente.poblacion}</br>
			Telefono: ${cliente.telefono}</br>
			Particular/Empresa: ${cliente.particularEmpresa}</br>
			
			<a href="ServletBorrarCliente?id=${cliente.id}">BORRAR</a><br/>
			<a href="ServletEditarCliente?id=${cliente.id}">EDITAR</a><br/>
		</div>
	</c:forEach>

</body>
</html>