<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar cliente</title>
</head>
<body>

	<c:if test="${sessionScope.admin == null}">
		<jsp:forward page="login.jsp"></jsp:forward>
	</c:if>

	<div>Introduce los datos de usuario</div>
	
	<!-- Las vistas cuanto más sencillas mejor-->
	<form action="ServletRegistroCliente" method="post">
		Nombre: <input type="text" name="campoNombre" id="campoNombre"><br/>
		Calle: <input type="text" name="campoCalle" id="campoCalle"><br/>
		Numeración: <input type="text" name="campoNumeracion" id="campoNumeracion"><br/>
		Código postal: <input type="text" name="campoCodigoPostal" id="campoCodigoPostal"><br/>
		Población: <input type="text" name="campoPoblacion" id="campoPoblacion"><br/>
		Teléfono: <input type="text" name="campoTelefono" id="campoTelefono"><br/>
		Email: <input type="text" name="campoEmail" id="campoEmail"><br/>
		Particular/Empresa: <input type="text" name="campoParticularEmpresa" id="campoParticularEmpresa"><br/>
		<input type="submit" value="REGISTRAR">
	</form>

</body>
</html>