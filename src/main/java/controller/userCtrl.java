package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.HashText;
import model.User;

/**
 * Servlet implementation class userCtrl
 */
@WebServlet("/userCtrl")
public class userCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("screen/infoUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String name=request.getParameter("nameuser");
		String pass=request.getParameter("password");
		String repass=request.getParameter("repassword");
		String birthday=request.getParameter("birthday");
		int gender=Integer.parseInt(request.getParameter("genderuser"));
		
		String hashpass=new HashText().getMD5(pass);
		
		if(pass.equals(repass)) {
			UserDao userDao=new UserDao();
			User user=(User) session.getAttribute("currentuser");
			
			user.setName(name);
			user.setGender(gender);
			user.setPass(hashpass);
			user.setBirthday(birthday);
			
			try {
				userDao.updateUser(user);
				session.setAttribute("currentuser", user);				
				response.sendRedirect("user.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			request.setAttribute("passerror","Mật khẩu không khớp");
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
		
	}

}
