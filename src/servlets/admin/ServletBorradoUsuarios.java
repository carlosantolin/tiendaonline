package servlets.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.UsuariosDAO;

/**
 * Servlet implementation class ServletBorradoUsuarios
 */
@WebServlet("/admin/ServletBorradoUsuarios")
public class ServletBorradoUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		UsuariosDAO dao = contenedor.getBean(UsuariosDAO.class);
		
		int id = Integer.parseInt(request.getParameter("campoId"));
		
		dao.borrarUsuario(id);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/ServletListadoUsuarios");
		rd.forward(request, response);
	}

}
