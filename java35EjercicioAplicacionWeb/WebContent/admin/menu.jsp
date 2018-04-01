<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:if test="${sessionScope.admin == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<c:if test="${sessionScope.admin != null}">
	<ul>
		<li><a href="ServletListadoClientes">Clientes</a>&nbsp;&nbsp;</li>
		<li><a href="ServletListadoProductos">Productos</a>&nbsp;&nbsp;</li>
		<li><a href="ServletLogOutAdmin">Salir</a></li>
	</ul>
</c:if>