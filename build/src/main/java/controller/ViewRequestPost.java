package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListPostDao;
import dao.PartDao;
import model.Post;
import model.PostPart;

/**
 * Servlet implementation class ViewRequestPost
 */
@WebServlet("/ViewRequestPost")
public class ViewRequestPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRequestPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
			int idpost=Integer.parseInt(request.getParameter("idpost"));
			HttpSession session= request.getSession();
			ListPostDao postDao=new ListPostDao();
			Post post=postDao.loadPostWithID(idpost);
			session.setAttribute("currentpost", post);
			List<PostPart> listPart=new PartDao().loadPart(post);
			request.setAttribute("listpart", listPart);
			request.getRequestDispatcher("managerUser/acceptPost.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idpost=Integer.parseInt(request.getParameter("idpost"));
		
		ListPostDao postDao=new ListPostDao();
		
		try {
			Post post=postDao.loadPostWithID(idpost);
			request.setAttribute("currentpost", post);
			request.getRequestDispatcher("managerUser/acceptPost.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
