package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProductosDAO;
import daosImpl.ProductosDAOImpl;


@WebServlet("/admin/ServletBorrarProducto")
public class ServletBorrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("Borrar producto de id: " + id);
		
		ProductosDAO productosDAO = new ProductosDAOImpl();
		
		productosDAO.borrarProducto(id);
		
		request.getRequestDispatcher("ServletListadoProductos").forward(request, response);
	}

}
