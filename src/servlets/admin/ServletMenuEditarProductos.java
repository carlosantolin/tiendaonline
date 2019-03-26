package servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Juego;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.JuegoDAO;

/**
 * Servlet implementation class ServletMenuEditarProductos
 */
@WebServlet("/admin/ServletMenuEditarProductos")
public class ServletMenuEditarProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		JuegoDAO dao = contenedor.getBean(JuegoDAO.class);

		List<Juego> juegos = dao.obtenerJuegos();
		
		Juego juego = new Juego();
		
		int id = Integer.parseInt(request.getParameter("campoId"));
		
		for(Juego j : juegos){
			if(id == j.getId()){
				juego = j;				
			}
		}
		
		request.setAttribute("juego", juego);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/menuEditarProductos.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
