package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Working;
import service.impl.WookingServcieImpl;

/**
 * Servlet implementation class AddWorking
 */
@WebServlet("/AddWorking")
public class AddWorking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWorking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		WookingServcieImpl wookser = new WookingServcieImpl();
		Working working = new Working();
		
		
		
		working.setTitle(request.getParameter("title"));
		working.setContent(request.getParameter("content"));
		working.setType(Integer.parseInt(request.getParameter("type")));
		int reuslt = wookser.addWoofing(working);
		PrintWriter out = response.getWriter();
		out.print(reuslt);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
