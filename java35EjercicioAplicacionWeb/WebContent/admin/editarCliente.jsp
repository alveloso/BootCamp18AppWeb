<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar clientes</title>
</head>
<body>

	<c:if test="${sessionScope.admin == null}">
		<jsp:forward page="login.jsp"></jsp:forward>
	</c:if>

	<jsp:include page="menu.jsp"></jsp:include>

	<form action="ServletGuardarCambiosCliente" method="post">
		Nombre: <input type="text" name="campoNombre" value="${clienteAeditar.nombre}"><br/>
		Calle: <input type="text" name="campoCalle" value="${clienteAeditar.calle}"><br/>
		Numeración: <input type="text" name="campoNumeracion" value="${clienteAeditar.numeracion}"><br/>
		Código postal: <input type="text" name="campoCodigoPostal" value="${clienteAeditar.codigoPostal}"><br/>
		Población: <input type="text" name="campoPoblacion" value="${clienteAeditar.poblacion}"><br/>
		Teléfono: <input type="text" name="campoTelefono" value="${clienteAeditar.telefono}"><br/>
		Email: <input type="text" name="campoEmail" value="${clienteAeditar.email}"><br/>
		Particular/Empresa: <input type="text" name="campoParticularEmpresa" value="${clienteAeditar.particularEmpresa}"><br/>
		
		<input type="hidden" name="campoId" value="${ clienteAeditar.id }">
		<input type="submit" value="GUARDAR CAMBIOS">
	</form>
	
</body>
</html>