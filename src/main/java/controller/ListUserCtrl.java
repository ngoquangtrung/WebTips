package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class ListUserCtrl
 */
@WebServlet("/ListUserCtrl")
public class ListUserCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUserCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDao userDao=new UserDao();
			PrintWriter out=response.getWriter();
			int status=Integer.parseInt(request.getParameter("status"));
				List<User> list=userDao.selectUserStatus(status);
				request.setAttribute("alluser", list);
				
				
				
				request.getRequestDispatcher("managerUser/listuser.jsp").forward(request, response);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDao userDao=new UserDao();
			PrintWriter out=response.getWriter();
			int status=Integer.parseInt(request.getParameter("status"));
			int update=1;
			if(status==1) {
				update=0;
			}
			
			
			int userid=Integer.parseInt(request.getParameter("iduser"));
			
			
				userDao.deleteUser(userid,update);
				
				List<User> list=userDao.selectUserStatus(status);
				request.setAttribute("alluser", list);
				
				//out.print("da xoa");
				
				request.getRequestDispatcher("managerUser/listuser.jsp").forward(request, response);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
