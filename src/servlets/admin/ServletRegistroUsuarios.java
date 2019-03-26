package servlets.admin;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modelo.Usuario;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.UsuariosDAO;

/**
 * Servlet implementation class ServletRegistroUsuarios
 */
@MultipartConfig
@WebServlet("/admin/ServletRegistroUsuarios")
public class ServletRegistroUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		String email = request.getParameter("campoEmail");
		String pass = request.getParameter("campoPass");
		Usuario nuevo = new Usuario(nombre, email, pass);
		System.out.println("Voy a registrar: " + nuevo);
		System.out.println("Vamos a ver si somos capaces de recuperar una bean del contenedor de Spring");
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		UsuariosDAO dao = contenedor.getBean(UsuariosDAO.class);
		int id = dao.registrarUsuario(nuevo);
		
		Part filePart = request.getPart("campoImagen");
	       //InputStream imageInputStream = filePart.getInputStream();
	       //read imageInputStream
		String sid = Integer.toString(id);
		System.out.println(sid);
	       filePart.write("/home/carlos/images/"
	       +sid+".png");
	       //can also write the photo to local storage
		
		// Si todo ha ido bien, continúo la petición a registroOK.jsp
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/index.jsp");
		rd.forward(request, response);
	}

}
