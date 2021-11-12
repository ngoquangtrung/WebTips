package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDao;
import model.Comment;
import model.User;

/**
 * Servlet implementation class DeleteCmt
 */
@WebServlet("/DeleteCmt")
public class DeleteCmt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCmt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<Integer> listdelete= (List) request.getAttribute("idList[]");
		String[] list = request.getParameterValues("idList[]");
		CommentDao cmtDao=new CommentDao();
		if(list!=null) {
			for(int i=0;i<list.length;i++) {
				try {
					int id=Integer.parseInt(list[i]);
					cmtDao.deleteComment(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("currentuser");
		try {
			List<Comment> listcmt=cmtDao.listCmtofUser(user);
			List<Integer> listIdcmt=new ArrayList<Integer>();
			for (Comment comment : listcmt) {
				listIdcmt.add(comment.getIdcmt());
				
			}
			
			request.setAttribute("listid", listIdcmt);
			request.setAttribute("listcmt", listcmt);
			request.getRequestDispatcher("screen/listComment.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
