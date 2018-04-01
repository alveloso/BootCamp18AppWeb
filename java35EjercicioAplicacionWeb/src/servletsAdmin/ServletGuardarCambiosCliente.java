package servletsAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;

@WebServlet("/admin/ServletGuardarCambiosCliente")
public class ServletGuardarCambiosCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		String calle = request.getParameter("campoCalle");
		String numeracion = request.getParameter("campoNumeracion");
		String codigoPostal = request.getParameter("campoCodigoPostal");
		String poblacion = request.getParameter("campoPoblacion");
		String telefono = request.getParameter("campoTelefono");
		String email = request.getParameter("campoEmail");
		String particularEmpresa = request.getParameter("campoParticularEmpresa");
		String id = request.getParameter("campoId");
		
		//Ahora deberiamos validar los datos
		
		Cliente cliente = new Cliente(nombre, calle, numeracion, codigoPostal, poblacion, telefono, email, particularEmpresa);
		cliente.setId(Integer.parseInt(id));
		
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		clientesDAO.guardarCambiosCliente(cliente);
		
		request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
	}

}
