package webapp.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.phonebook.PhonebookService;
import webapp.todos.TodoService;

@WebServlet(urlPatterns = "/home.do")
public class HomeServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TodoService todoService = new TodoService();
	private PhonebookService phonebookService = new PhonebookService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String name = (String) request.getSession().getAttribute("name");
		String todosNum = Integer.toString(todoService.getTodoNum());
		String phonebookNum = Integer.toString(phonebookService.getPhonebookNum());
		request.setAttribute("name", name);
		request.setAttribute("todosNum", todosNum);
		request.setAttribute("phonebookNum", phonebookNum);
		
		request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}
}
