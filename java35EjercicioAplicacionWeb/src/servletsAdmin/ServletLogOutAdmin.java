package servletsAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogOutAdmin
 */
@WebServlet("/admin/ServletLogOutAdmin")
public class ServletLogOutAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Invalido la sesion
		request.getSession().invalidate();
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		//Si quisiera invalidad una session determinada
		//request.getSession().removeAttribute("admin");
	}

}
