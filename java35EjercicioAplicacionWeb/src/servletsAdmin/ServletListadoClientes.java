package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;

@WebServlet("/admin/ServletListadoClientes")
public class ServletListadoClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Creo un objeto clientes
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		
		//Obtengo los clientes
		request.setAttribute("clientes", clientesDAO.obtenerClientes());
		
		//Redirijo al jsp donde voy a sacar los clientes
		request.getRequestDispatcher("gestionClientesAdmin.jsp").forward(request, response);
	}

}
