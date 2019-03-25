package servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Servicio;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.ServicioDAO;

/**
 * Servlet implementation class ServletListadoServicios
 */
@WebServlet("/admin/ServletListadoServicios")
public class ServletListadoServicios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		ServicioDAO dao = contenedor.getBean(ServicioDAO.class);

		List<Servicio> servicios = dao.obtenerServicios();
		request.setAttribute("servicios", servicios);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/listadoServicios.jsp");
		rd.forward(request, response);
	}

}
