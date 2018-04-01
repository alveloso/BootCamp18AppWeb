package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daosImpl.ProductosDAOImpl;
import modelo.Producto;

@WebServlet("/admin/ServletRegistroProducto")
public class ServletRegistroProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Se ejecuta el post del ServletRegistroProducto");
		
		//Vamos a recoger lo del formulario
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
		//parte de validacion de datos
		Producto nuevoProducto = new Producto(nombre, dispositivos, genero, fechaSalida, precio, formato, numeroJugadores, compania, idioma, editor);
		
		//Ahora le damos el nuevo anuncio a un dao para que lo registre
		System.out.println("Vamos a registrar:" + nuevoProducto.toString());
		
		ProductosDAOImpl productosDAO = new ProductosDAOImpl();
		productosDAO.registrarProducto(nuevoProducto);
		
		/*
		 * Desde un servlet no deberia mostrarle nada al usuario
		 * Para eso tenemos las jsp que son las encargadas de realizar
		 * lo que se denomina la vista de la aplicacion
		 */
		
		//Aqui se reparten las tareas
		//Aqui le ddecimos al servidor que hemos acabado pero
		//queremos seguir con la ejecucion de otro jsp
		//Asi digo al server que siga la ejecucion en la siguiente jsp
		request.getRequestDispatcher("registroProductoOK.jsp").forward(request, response);
		
	}

}
