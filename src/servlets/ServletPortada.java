package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.JuegoDAO;
import modelo.Juego;

/**
 * Servlet implementation class ServletPortada
 */
@WebServlet("/ServletPortada")
public class ServletPortada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		JuegoDAO dao = contenedor.getBean(JuegoDAO.class);
		
		int comienzo = 0;
		int cuantos = 10;
		
		if(request.getParameter("comienzo")!=null) {
			comienzo = Integer.parseInt(request.getParameter("comienzo"));
		}
		
		int anterior = comienzo -10;
		int siguiente = comienzo+10;
		int total = dao.obtenerTotalJuego();

		List<Juego> juegos = dao.obtenerJuegos(comienzo, cuantos);
		request.setAttribute("juegos", juegos);
		request.setAttribute("anterior", anterior);
		request.setAttribute("siguiente", siguiente);
		request.setAttribute("total", total);

		

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoProductos.jsp");
		rd.forward(request, response);
	}

}