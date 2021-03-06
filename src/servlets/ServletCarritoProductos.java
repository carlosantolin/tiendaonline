package servlets;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ServletCarritoProductos
 */
@WebServlet("/ServletCarritoProductos")
public class ServletCarritoProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("carrito") == null){
			request.getSession().setAttribute("carrito", new ArrayList<Juego>());
		}
		
		List<Juego> juegos = (List<Juego>) request.getSession().getAttribute("carrito");
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		JuegoDAO dao = contenedor.getBean(JuegoDAO.class);
		
		int total = dao.obtenerTotalJuego();
		
		List<Juego> todos = dao.obtenerJuegos("", 0, total);
		
		for(Juego j : todos) {
			if(j.getId() == Integer.parseInt(request.getParameter("campoId"))) {
				juegos.add(j);
			}
		}
		
		request.getSession().setAttribute("carrito", juegos);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ServletPortada");
		rd.forward(request, response);
		
	}

}
