package webapp.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService loginService = new LoginService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		
		
		request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		if (loginService.checkIfExist(name, pass)) {
			request.getSession().setAttribute("name", name);
			response.sendRedirect("/home.do");
		} else {
			request.setAttribute("errorMassage", "Incorect user name or password");
			request.getRequestDispatcher("/WEB-INF/login/login.jsp").forward(request, response);
		}
	}
	
}