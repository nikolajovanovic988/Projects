package webapp.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/home.do")
public class HomeServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String name = (String) request.getSession().getAttribute("name");
		String todosNum = "5";
		String phonebookNum = "4";
		request.setAttribute("name", name);
		request.setAttribute("todosNum", todosNum);
		request.setAttribute("phonebookNum", phonebookNum);
		
		request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}
}
