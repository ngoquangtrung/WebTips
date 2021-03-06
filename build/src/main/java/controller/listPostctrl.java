package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListPostDao;
import model.Post;
import model.User;

/**
 * Servlet implementation class listPostctrl
 */
@WebServlet("/listPostctrl")
public class listPostctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listPostctrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession(true);
		session.setAttribute("countPart", 1);
		User user = (User) session.getAttribute("currentuser");
		
		try {
			List<Post> list = new ListPostDao().loadPostofStatus(user, 1);
			//session.setAttribute("listuser", list);
			List<Integer> listid=new ArrayList<Integer>();
			for (Post post : list) {
				listid.add(post.getId_post());
			}
			request.setAttribute("listpost", list);
			request.setAttribute("listid", listid);
			request.getRequestDispatcher("screen/listPost.jsp").forward(request, response);
			
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
