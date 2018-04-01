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

@WebServlet("/admin/ServletEditarCliente")
public class ServletEditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//este id lo cogemos de la interrogacion que pusimos en gestionAnuncios
		int id = Integer.parseInt(request.getParameter("id"));
		
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		Cliente clienteAeditar = clientesDAO.obtenerClientePorId(id);
		System.out.println("Cliente a editar: " + clienteAeditar.toString());
		//Una vez tengo el anuncio tengo que llevarlo a un jsp a un formulario
		request.setAttribute("clienteAeditar", clienteAeditar);
		request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
	}

}
