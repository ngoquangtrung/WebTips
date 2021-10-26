package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListPostDao;
import model.Post;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/PostController")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session= request.getSession();
		PrintWriter out = response.getWriter();
		try {
			//User user= (User) session.getAttribute("curentuser");
			//HttpSession session=request.getSession(true);
			//session.setAttribute("currentuser", user);
			String type=request.getParameter("category");
			String search= request.getParameter("search");
			if(type!=null) {
				if(type.equals("broadgame")) {
					List<Post> listpost=new ListPostDao().loadCategory(1);
					session.setAttribute("listpost", listpost);
					session.setAttribute("type", "Broad game");
					response.sendRedirect("category.jsp");
					if(listpost==null) {
						out.print("<p>Không có bài viết để hiển thị</p>");
					}
					
				}else if(type.equals("dangian")) {
					List<Post> listpost=new ListPostDao().loadCategory(3);
					if(listpost==null) {
						out.print("<p>Không có bài viết để hiển thị</p>");
					}
					
					session.setAttribute("listpost", listpost);
					session.setAttribute("type", "Dân gian");
					response.sendRedirect("category.jsp");
					
				}
				else if(type.equals("vandong")) {
					List<Post> listpost=new ListPostDao().loadCategory(2);
					session.setAttribute("listpost", listpost);
					session.setAttribute("type", "Vận động");
					response.sendRedirect("category.jsp");
					if(listpost==null) {
						out.print("<p>Không có bài viết để hiển thị</p>");
					}
				}
			
			}else if(search==null){
				List<Post> list=new ListPostDao().loadPostItem(5,5);
				List<Post> listest=new ListPostDao().loadPostItem(2,3);
				Post latestpost= new ListPostDao().loadLatest();
				session.setAttribute("postest", latestpost);
				session.setAttribute("latestpost", listest);
				session.setAttribute("postlist", list);
				response.sendRedirect("index.jsp");
				
			}else if(search!=null||!search.equals("")){
				List<Post> list=new ListPostDao().searchPost(search);
				session.setAttribute("listpost", list);
				session.setAttribute("type", "search for: "+search);
				response.sendRedirect("category.jsp");
				if(list==null) {
					out.print("<p>Không có bài viết để hiển thị</p>");
				}
			}
			
		} catch (Exception ex) {
			
			Logger.getLogger(PostController.class.getName()).log(Level.SEVERE,null,ex);
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
