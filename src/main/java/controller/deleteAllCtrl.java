package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Post;

/**
 * Servlet implementation class deleteAllCtrl
 */
@WebServlet("/deleteAllCtrl")
public class deleteAllCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteAllCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		List<Post> list= (List<Post>) session.getAttribute("listuser");
		
		for(Post p:list) {
			int id=p.getId_post();			
			PrintWriter out=response.getWriter();
			out.print( "id "+ id);
			out.println(request.getParameter("check_box_"+id));
			//out.println(request.getParameter("check_box_"+id));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		List<Post> list= (List<Post>) session.getAttribute("listuser");
		
		for(Post p:list) {
			int id=p.getId_post();			
			PrintWriter out=response.getWriter();
			out.print( "id "+ id);
			out.println(request.getParameter("check_box_"+id));
			//out.println(request.getParameter("check_box_"+id));
		}
	}

}
