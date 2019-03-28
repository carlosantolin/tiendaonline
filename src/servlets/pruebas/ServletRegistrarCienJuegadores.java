package servlets.pruebas;

import java.io.IOException;

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
 * Servlet implementation class ServletRegistrarCienJuegadores
 */
@WebServlet("/ServletRegistrarCienJuegadores")
public class ServletRegistrarCienJuegadores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Registramos 100 usuarios para poder hacer pruebas sin datos reales
	WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
	JuegoDAO dao = contenedor.getBean(JuegoDAO.class);
	
	for (int i = 0; i < 100; i++) {
		Juego u = new Juego("smash"+i, "nintendo", "2018", 1, "infinita", 68, 50);
		dao.registrarJuego(u);
	}
	
	System.out.println("100 JUEGOS registrados");
	}
	
	
}

