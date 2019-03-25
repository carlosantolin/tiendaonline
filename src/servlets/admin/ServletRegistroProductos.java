package servlets.admin;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modelo.Juego;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.JuegoDAO;
import daos.UsuariosDAO;

/**
 * Servlet implementation class ServletRegistroProductos
 */
@MultipartConfig
@WebServlet("/admin/ServletRegistroProductos")
public class ServletRegistroProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		JuegoDAO dao = contenedor.getBean(JuegoDAO.class);
		
		
	      

	       Part filePart = request.getPart("campoImagen");
	       InputStream imageInputStream = filePart.getInputStream();
	       //read imageInputStream
	       filePart.write("/home/carlos/data/"+request.getParameter("campoNombre"));
	       //can also write the photo to local storage

	       
		
		//adaptar
		
		Juego nuevo = new Juego(request.getParameter("campoNombre"),
				request.getParameter("campoDesarollador"),
				request.getParameter("campoFecha"),
				request.getParameter("campoGenero"),
				request.getParameter("campoDuracion"),
				Double.parseDouble(request.getParameter("campoPrecio")),
				Integer.parseInt(request.getParameter("campoStock")));
		
		
		dao.registrarJuego(nuevo);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/listadoProductos.jsp");
		rd.forward(request, response);
	
	}

}
