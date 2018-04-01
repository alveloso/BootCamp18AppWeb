package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProductosDAO;
import daosImpl.ProductosDAOImpl;

@WebServlet("/admin/ServletListadoProductos")
public class ServletListadoProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creo un objeto clientes
				ProductosDAO productosDAO = new ProductosDAOImpl();
				
				//Obtengo los clientes
				request.setAttribute("productos", productosDAO.obtenerProductos());
				
				//Redirijo al jsp donde voy a sacar los clientes
				request.getRequestDispatcher("gestionProductosAdmin.jsp").forward(request, response);
	}

}
