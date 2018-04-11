package servletsAdmin;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
		String expresionRegularNombre = "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄]{3,20}";
		Pattern patternNombre = Pattern.compile(expresionRegularNombre);
		Matcher matcherNombre = patternNombre.matcher(nombre);//DDevuelve true si todo esta bien
		
		String expresionRegularCalle = "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄\\s]{6,50}";//CAdena con espacios, minimo 6 maximo 50
		Pattern patternCalle = Pattern.compile(expresionRegularCalle);
		Matcher matcherCalle = patternCalle.matcher(calle);//DDevuelve true si todo esta bien
		
		String expresionRegularNumero = "[1-9]{1,4}";//Numeros solamente y como mucho 4
		Pattern patternNumero = Pattern.compile(expresionRegularNumero);
		Matcher matcherNumero = patternNumero.matcher(numeracion);//DDevuelve true si todo esta bien
		
		String expresionRegularPostal = "^\\d{5,5}$";//Numeros y 5 digitos
		Pattern patternPostal = Pattern.compile(expresionRegularPostal);
		Matcher matcherPostal = patternPostal.matcher(codigoPostal);//DDevuelve true si todo esta bien
		
		String expresionRegularCiudad = "Zamora";//Numeros y 5 digitos
		Pattern patternCiudad = Pattern.compile(expresionRegularCiudad);
		Matcher matcherCiudad = patternCiudad.matcher(poblacion);//DDevuelve true si todo esta bien
		
		String expresionRegularTelefono = "^(6)([0-9]{8})$";//Que empiece por 6 y 9 digitos
		Pattern patternTelefono = Pattern.compile(expresionRegularTelefono);
		Matcher matcherTelefono = patternTelefono.matcher(telefono);//DDevuelve true si todo esta bien
		
		String expresionRegularParticularEmpresa = "(Particular)|(Empresa)";//Que sea Particular o Empresa
		Pattern patternParticularEmpresa = Pattern.compile(expresionRegularParticularEmpresa);
		Matcher matcherParticularEmpresa = patternParticularEmpresa.matcher(particularEmpresa);//DDevuelve true si todo esta bien
		
		String expresionRegularEmail = "[a-z]{1,10}(@)[a-z]{1,10}((.com)|(.es))";//String + @ + String + .com o .es
		Pattern patternEmail = Pattern.compile(expresionRegularEmail);
		Matcher matcherEmail = patternEmail.matcher(email);//DDevuelve true si todo esta bien
		
		
		if(matcherNombre.matches()){
			System.out.println("Nombre ok");
		}else{
			System.out.println("Nombre no valido");
			//request.setAttribute("mensaje", "Titulo no valido");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			return;
		}
		
		if(matcherNumero.matches()){
			System.out.println("Numeracion ok");
		}else{
			System.out.println("NumeraciÛn no valida");
			//request.setAttribute("mensaje", "Titulo no valido");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			return;
		}
		
		if(matcherCalle.matches()){
			System.out.println("Calle ok");
		}else{
			System.out.println("Calle no valida");
			//request.setAttribute("mensaje", "Titulo no valido");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			return;
		}
		
		if(matcherPostal.matches()){
			System.out.println("Codigo postal ok");
		}else{
			System.out.println("Codigo postal no valido");
			//request.setAttribute("mensaje", "Titulo no valido");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			return;
		}
		
		if(matcherCiudad.matches()){
			System.out.println("Ciudad ok");
		}else{
			System.out.println("Ciudad no valida");
			//request.setAttribute("mensaje", "Titulo no valido");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			return;
		}
		
		if(matcherTelefono.matches()){
			System.out.println("Telefono ok");
		}else{
			System.out.println("telefono no valido");
			//request.setAttribute("mensaje", "Titulo no valido");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			return;
		}
		
		if(matcherParticularEmpresa.matches()){
			System.out.println("PartEmpresa ok");
		}else{
			System.out.println("PartEmpresa no valido");
			//request.setAttribute("mensaje", "Titulo no valido");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			return;
		}
		
		if(matcherEmail.matches()){
			System.out.println("Email ok");
		}else{
			System.out.println("email no valido");
			//request.setAttribute("mensaje", "Titulo no valido");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			return;
		}
		
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
