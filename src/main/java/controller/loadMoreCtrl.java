package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.ListPostDao;
import model.Post;

/**
 * Servlet implementation class loadMoreCtrl
 */
@WebServlet("/loadMoreCtrl")
public class loadMoreCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadMoreCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int index=Integer.parseInt(request.getParameter("index"));
		PrintWriter out= response.getWriter();
		try {
			List<Post> list= new ListPostDao().loadPostItem(index);
			for (Post post : list) {
				out.print("<div id=\""+post.getId_post()+"\" class=\"row post-item\" onlcik=\" \" >\r\n"
						+ "	    <div class=\"col-md-3\">\r\n"
						+ "	    	<img alt=\"\" src=\""+post.getSrc()+"\" class=\"img-fluid\">\r\n"
						+ "    	</div>\r\n"
						+ "    	<div class=\"col-md-9\">\r\n"
						+ "		<h3>"+post.getTitle()+"</h3>\r\n"
						+ "		<p>"+post.getSummary()+"</p>\r\n"
						+ "    	</div>\r\n"
						+ "    </div>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
