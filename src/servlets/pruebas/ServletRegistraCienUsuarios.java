package servlets.pruebas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.UsuariosDAO;
import modelo.Usuario;

/**
 * Servlet implementation class ServletRegistraCienUsuarios
 */
@WebServlet("/ServletRegistraCienUsuarios")
public class ServletRegistraCienUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Registramos 100 usuarios para poder hacer pruebas sin datos reales
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		UsuariosDAO dao = contenedor.getBean(UsuariosDAO.class);
		
		for (int i = 0; i < 100; i++) {
			Usuario u = new Usuario("Carlos"+i, "carlosantolinlucas@gmail.com"+i, "1234");
			dao.registrarUsuario(u);
		}
		
		System.out.println("100 usuarios registrados");
		
	}

}
