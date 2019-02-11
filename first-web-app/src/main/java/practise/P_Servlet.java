package practise;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpHandler;

@WebServlet (urlPatterns = "/p.do")
public class P_Servlet extends HttpServlet{
	
	
	private P_Service service = new P_Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setAttribute("data", service.getData());
		request.getRequestDispatcher("/WEB-INF/views/p.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String num = request.getParameter("num");
		service.addNewPhonebook(name, num);
		
		request.setAttribute("data", service.getData());
		response.sendRedirect("/p.do");
	}

	
}
