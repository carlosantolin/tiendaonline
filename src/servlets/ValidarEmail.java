package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.UsuariosDAO;

/**
 * Servlet implementation class ValidarEmail
 */
@WebServlet("/ValidarEmail")
public class ValidarEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		UsuariosDAO dao = contenedor.getBean(UsuariosDAO.class);
		
//		response.setContentType("text/plain"); 
//	    response.setCharacterEncoding("UTF-8");
	    
	    
	    String email = request.getParameter("email");
	    
	    String resultado = Integer.toString(dao.obtenerIdUsuarioPorEmail(email));

		response.getWriter().write(resultado); 
	}

}
