package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDao;
import dao.ListPostDao;
import dao.PartDao;
import model.Comment;
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
			HttpSession session=request.getSession();
			int idpost=Integer.parseInt(request.getParameter("idpost"));
			Post post=new ListPostDao().loadPostWithID(idpost);
			List<PostPart> list= new PartDao().loadPart(post);
			session.setAttribute("viewpost", post);
			session.setAttribute("listpart", list);
			
			List<Comment> listcmt =new CommentDao().listComment(post);
			List<Comment> listRep =new CommentDao().listRepcmt(post);
			
			
			session.setAttribute("listcmt", listcmt);
			session.setAttribute("listrep", listRep);
			
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
