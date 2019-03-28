package flitros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FiltroLoginB implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		//El admin esta identificado si:
		//En la sesion esta el parametro 'admin' con el valor ok
		
		if (request.getSession().getAttribute("admin") != null
				&& request.getSession().getAttribute("admin").equals("ok")) {
			arg2.doFilter(arg0, arg1); //continua con la respuesta
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp"); //le mandamos a que se loguee
			
			rd.forward(arg0, arg1);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

