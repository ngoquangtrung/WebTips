package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListPostDao;
import dao.PartDao;
import model.Post;
import model.PostPart;

/**
 * Servlet implementation class contentPostCtrl
 */
@WebServlet("/contentPostCtrl")
public class contentPostCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contentPostCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idpost=Integer.parseInt(request.getParameter("idpost"));
			String title=(String) request.getParameter("title");
			Post post=new ListPostDao().loadPostWithID(idpost);
			List<PostPart> list= new PartDao().loadPart(post);
			request.setAttribute("currentpost", post);
			request.setAttribute("listpart", list);
			request.getRequestDispatcher("postContent.jsp").forward(request, response);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
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
