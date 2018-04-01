package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AdministradorDAO;
import daosImpl.AdministradorDAOImpl;

//Se pone /admin porque el archivo que está accediendo al servlet se
//encuentra en la carpeta admin, por tema de rutas
@WebServlet("/admin/ServletIdentificacionAdmin")
public class ServletIdentificacionAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Cogemos los parametros que hemos recibido del formulario del login
		String usuario = request.getParameter("userField");
		String contrasenia = request.getParameter("passField");
		
		//Creo un objeto temporal para almacenar el resultado de buscar al admin
		AdministradorDAO administradorDAO = new AdministradorDAOImpl();
		
		//Si encuentro admin creo variable de sesion "admin" y redirijo al index
		if(administradorDAO.identificarAdmin(usuario, contrasenia)){
			request.getSession().setAttribute("admin", "ok");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			//sino redirijo al index
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
