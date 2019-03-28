package servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.CategoriaDAO;
import modelo.Categoria;

/**
 * Servlet implementation class ServletPrepararRegistrarProducto
 */
@WebServlet("/admin/ServletPrepararRegistrarProducto")
public class ServletPrepararRegistrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		CategoriaDAO dao = contenedor.getBean(CategoriaDAO.class);
		
		List<Categoria> categorias = dao.obtenerCategorias();
	}

}
