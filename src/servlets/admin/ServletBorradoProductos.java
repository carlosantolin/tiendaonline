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

import daos.JuegoDAO;
import daos.UsuariosDAO;

/**
 * Servlet implementation class ServletBorradoProductos
 */
@WebServlet("/admin/ServletBorradoProductos")
public class ServletBorradoProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		JuegoDAO dao = contenedor.getBean(JuegoDAO.class);
		
		int id = Integer.parseInt(request.getParameter("campoId"));
		
		dao.borrarJuego(id);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/ServletListadoProductos");
		rd.forward(request, response);
	}

}
