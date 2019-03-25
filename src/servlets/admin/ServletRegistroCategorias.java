package servlets.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;
import modelo.Servicio;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.CategoriaDAO;
import daos.ServicioDAO;

/**
 * Servlet implementation class ServletRegistroCategoria
 */
@WebServlet("/admin/ServletRegistroCategorias")
public class ServletRegistroCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		CategoriaDAO dao = contenedor.getBean(CategoriaDAO.class);
		
		Categoria servicio = new Categoria(request.getParameter("campoNombre"),
				request.getParameter("campoDescripcion"));
		
		
		dao.registrarCategoria(servicio);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/listadoCategorias.jsp");
		rd.forward(request, response);
	}

}
