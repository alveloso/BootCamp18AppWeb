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

@WebServlet("/admin/ServletGuardarCambiosProducto")
public class ServletGuardarCambiosProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		String dispositivos = request.getParameter("campoDispositivos");
		String genero = request.getParameter("campoGenero");
		String fechaSalida = request.getParameter("campoFechaSalida");
		double precio = Integer.parseInt(request.getParameter("campoPrecio"));
		String formato = request.getParameter("campoFormato");
		String numeroJugadores = request.getParameter("campoNumeroJugadores");
		String compania = request.getParameter("campoCompania");
		String idioma = request.getParameter("campoIdioma");
		String editor = request.getParameter("campoEditor");
		String id = request.getParameter("campoId");
		
		//Ahora deberiamos validar los datos
		
		Producto producto = new Producto(nombre, dispositivos, genero, fechaSalida, precio, formato, numeroJugadores, compania, idioma, editor);
		producto.setId(Integer.parseInt(id));
		
		ProductosDAO productosDAO = new ProductosDAOImpl();
		productosDAO.guardarCambiosProducto(producto);
		
		request.getRequestDispatcher("ServletListadoProductos").forward(request, response);
	}

}
