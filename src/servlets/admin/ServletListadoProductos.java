package servlets.admin;

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

@WebServlet("/admin/ServletListadoProductos")
public class ServletListadoProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		JuegoDAO dao = contenedor.getBean(JuegoDAO.class);
		
		
		String busqueda = request.getParameter("campoBusqueda");
		if(busqueda == null) {
			busqueda = "";
		}
		System.out.println("Buscando juego por nombre: " + busqueda);
		
		int comienzo = 0;
		int cuantos = 10;
		
		if(request.getParameter("comienzo")!=null) {
			comienzo = Integer.parseInt(request.getParameter("comienzo"));
		}
		
		int anterior = comienzo -10;
		int siguiente = comienzo+10;
		int total = dao.obtenerTotalJuego(busqueda);

		List<Juego> juegos = dao.obtenerJuegos(busqueda, comienzo, cuantos);
		request.setAttribute("juegos", juegos);
		request.setAttribute("anterior", anterior);
		request.setAttribute("siguiente", siguiente);
		request.setAttribute("total", total);
		request.setAttribute("campoBusqueda", busqueda);

		

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/listadoProductos.jsp");
		rd.forward(request, response);
	}

}
