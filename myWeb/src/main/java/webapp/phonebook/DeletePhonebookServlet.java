package webapp.phonebook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/delete-phonebook.do")
public class DeletePhonebookServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PhonebookService phonebookService = new PhonebookService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		phonebookService.deletePhonebook(name, number);
		request.getRequestDispatcher("/WEB-INF/view/list-phonebook.jsp").forward(request, response);
	}
}
