package servlets.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Juego;
import modelo.Servicio;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.JuegoDAO;
import daos.ServicioDAO;

/**
 * Servlet implementation class ServletRegistroServicios
 */
@WebServlet("/admin/ServletRegistroServicios")
public class ServletRegistroServicios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		ServicioDAO dao = contenedor.getBean(ServicioDAO.class);
		
		Servicio servicio = new Servicio(request.getParameter("campoNombre"),
				request.getParameter("campoDescripcion"));
		
		
		dao.registrarServicio(servicio);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/listadoServicios.jsp");
		rd.forward(request, response);
	}

}
