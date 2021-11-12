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
 * Servlet implementation class detailPostctrl
 */
@WebServlet("/detailPostctrl")
public class detailPostctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailPostctrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
			int id_post=Integer.parseInt(request.getParameter("id_currentpost"));
			Post post=new ListPostDao().loadPostWithID(id_post);
			List<PostPart> list= new PartDao().loadPart(post);
			
			HttpSession session=request.getSession(true);
			
			//session.setAttribute("currentpost", post);
			request.setAttribute("currentpost", post);
			session.setAttribute("listpart", list);
			request.setAttribute("idpost", id_post);
			request.getRequestDispatcher("screen/detailPost.jsp").forward(request, response);
			
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
