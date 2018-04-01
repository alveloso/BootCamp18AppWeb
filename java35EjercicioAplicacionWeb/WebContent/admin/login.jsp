<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceso a la aplicacion</title>
</head>
<body>

	<div class="title">
		<h1>Acceso administracion</h1>
	</div>
	
	<div class="body">
		<form action="ServletIdentificacionAdmin" method="post">
			<div class="formSection">
				<label>Usuario</label>
				<input type="text" name="userField" id="userField"/><br/>
			</div>
			
			<div class="formSection">
				<label>Contraseña</label>
				<input type="text" name="passField" id="passField"/><br/>
			</div>
			
			<div class="formSection">
				<input type="submit" value="ENTRAR">
			</div>
		</form>
	</div>
	

</body>
</html>