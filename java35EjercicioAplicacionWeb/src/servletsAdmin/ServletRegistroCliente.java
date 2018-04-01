package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import daosImpl.ClientesDAOImpl;

@WebServlet("/admin/ServletRegistroCliente")
public class ServletRegistroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Se ejecuta el post del ServletRegistroCliente");
		
		//Vamos a recoger lo del formulario
		String nombre = request.getParameter("campoNombre");
		String calle = request.getParameter("campoCalle");
		String numeracion = request.getParameter("campoNumeracion");
		String codigoPostal = request.getParameter("campoCodigoPostal");
		String poblacion = request.getParameter("campoPoblacion");
		String telefono = request.getParameter("campoTelefono");
		String email = request.getParameter("campoEmail");
		String particularEmpresa = request.getParameter("campoParticularEmpresa");
		
		//parte de validacion de datos
		Cliente nuevoCliente = new Cliente(nombre, calle, numeracion, codigoPostal,poblacion, telefono,email, particularEmpresa);
		
		//Ahora le damos el nuevo anuncio a un dao para que lo registre
		System.out.println("Vamos a registrar:" + nuevoCliente.toString());
		
		ClientesDAOImpl clientesDAO = new ClientesDAOImpl();
		clientesDAO.registrarCliente(nuevoCliente);
		
		/*
		 * Desde un servlet no deberia mostrarle nada al usuario
		 * Para eso tenemos las jsp que son las encargadas de realizar
		 * lo que se denomina la vista de la aplicacion
		 */
		
		//Aqui se reparten las tareas
		//Aqui le ddecimos al servidor que hemos acabado pero
		//queremos seguir con la ejecucion de otro jsp
		//Asi digo al server que siga la ejecucion en la siguiente jsp
		request.getRequestDispatcher("registroClienteOK.jsp").forward(request, response);
		
	}

}
