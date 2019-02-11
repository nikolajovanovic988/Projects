package practise;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = "/delete-data.do")
public class P_Delete extends HttpServlet{
	
	private P_Service service = new P_Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String name = request.getParameter("name");
		String num = request.getParameter("num");
		P_Data data = new P_Data();
		data.setName(name);
		data.setNum(num);
		service.deleteData(data);
		response.sendRedirect("/p.do");
	}
	
}
