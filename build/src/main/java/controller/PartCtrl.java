package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PartCtrl
 */
@WebServlet("/PartCtrl")
public class PartCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int numberPart=Integer.parseInt(request.getParameter("numberPart"));
		PrintWriter out= response.getWriter();
		request.getSession().setAttribute("countPart", numberPart);
		try {
			out.println("<div class=\"part border-top\">\r\n"
					+ "	        	<div><label class=\"font-weight-bold\">Part title</label>\r\n"
					+ "	        	<textarea rows=\"2\" cols=\"40\" class=\"editcontent\" name=\"txt_parttitle"+numberPart+"\"></textarea>\r\n"
					+ "	        	 </div>\r\n"
					+ "	        	 <div><label class=\"font-weight-bold\">Part image</label>\r\n"
					+ "	        	<input type=\"file\" name=\"file"+numberPart+"\" placeholder=\"image\">\r\n"
					+ "	        	 </div>\r\n"
					+ "	        	<div><label class=\"font-weight-bold\">Part content</label>\r\n"
					+ "	        	<textarea rows=\"5\" cols=\"40\" class=\"editcontent\" name=\"txt_partcontent"+numberPart+"\"></textarea>\r\n"
					+ "	        	</div>\r\n"
					+ "        	</div>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
