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
import model.Post;

/**
 * Servlet implementation class PostRequest
 */
@WebServlet("/PostRequest")
public class PostRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();		
		Post post=(Post) session.getAttribute("currentpost");
		String decide=request.getParameter("decide");
		ListPostDao postDao=new ListPostDao();
		
		if(decide.equals("accept")) {
			post.setStatus(1);	
		}else
		{
			post.setStatus(0);
		}
		try {
			postDao.updatePost(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("currentpost", null);
		
		List<Post> list;
		try {
			list = postDao.loadeRequestPost();
			request.setAttribute("listrequest", list);
			request.getRequestDispatcher("managerUser/requestPost.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			ListPostDao postDao=new ListPostDao();
			List<Post> list =postDao.loadeRequestPost();
			request.setAttribute("listrequest", list);
			request.getRequestDispatcher("managerUser/requestPost.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		
		
	}

}
