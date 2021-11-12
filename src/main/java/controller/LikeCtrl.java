package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDao;
import model.User;

/**
 * Servlet implementation class LikeCtrl
 */
@WebServlet("/LikeCtrl")
public class LikeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idcmt=Integer.parseInt(request.getParameter("cmtid"));
		PrintWriter out=response.getWriter();
		CommentDao cmtDao=new CommentDao();
		try {
			int count=cmtDao.countlike(idcmt);
			out.print(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html;charset=UTF-8");
		int idcmt=Integer.parseInt(request.getParameter("cmtid"));
		String action= request.getParameter("current_status");
		String time= java.time.LocalDateTime.now().toString();
		PrintWriter out=response.getWriter();
		CommentDao cmtDao=new CommentDao();
		HttpSession session= request.getSession();
		User user=(User) session.getAttribute("currentuser");
		if(user!=null) {
			if(action.equals("Thích")) {
				try {
				cmtDao.likecmt(user.getIduser(), idcmt, time);				
				out.print("Bỏ thích");
				} catch (Exception e) {
				e.getStackTrace();
				// TODO: handle exception
				}
			}
			else {
				try {
					cmtDao.unlikecmt(user.getIduser(), idcmt);
					out.print("Thích");
					} catch (Exception e) {
					e.getStackTrace();
					// TODO: handle exception
					}
			}
		}else {
			out.print("login");
		}
		
		
		
	}

}
