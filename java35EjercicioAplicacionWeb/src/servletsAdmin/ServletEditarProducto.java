package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Producto;
import daos.ProductosDAO;
import daosImpl.ProductosDAOImpl;

@WebServlet("/admin/ServletEditarProducto")
public class ServletEditarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//este id lo cogemos de la interrogacion que pusimos en gestionAnuncios
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProductosDAO productosDAO = new ProductosDAOImpl();
		Producto productoAeditar = productosDAO.obtenerProductoPorId(id);
		System.out.println("Producto a editar: " + productoAeditar.toString());
		//Una vez tengo el anuncio tengo que llevarlo a un jsp a un formulario
		request.setAttribute("productoAeditar", productoAeditar);
		request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
	}

}
