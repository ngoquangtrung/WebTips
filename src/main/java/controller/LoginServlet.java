package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.HashText;
import model.Post;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String remember=request.getParameter("remember");
		UserDao userDao=new UserDao();
		try {	String hashpass=new HashText().getMD5(pass);
				User user=userDao.checkUser(email, hashpass);		
				if(user==null) {
					request.setAttribute("loginerror", "Thông tin sai, vui lòng kiểm tra lại");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else {
					int status =user.getStatus();
					if(status==0) {
						request.setAttribute("usererror", "Tài khoản đã bị khóa");
						request.getRequestDispatcher("login.jsp").forward(request, response);
						return;
					}
					
					
					HttpSession session= request.getSession();
					
					//test hinh dai dien khi khong co
					
					session.setAttribute("currentuser", user);
					//int permission=user.getPermission();
					if (remember != null) {
						Cookie cookie=new Cookie("remember",user.getEmail());
						cookie.setMaxAge(60*60*24*7);
						response.addCookie(cookie);
					}else {
						Cookie cookie=new Cookie("remember",user.getEmail());
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
					Post viewpost=(Post) session.getAttribute("viewpost");
					if(viewpost==null) {
						response.sendRedirect("main");
					}else {
						response.sendRedirect("contentPostCtrl?idpost="+viewpost.getId_post()+"&title="+viewpost.getTitle());
					}
					/*if(permission==0) {
						response.sendRedirect("user.jsp");
					}
					else {
						response.sendRedirect("adminuser.jsp");
					}*/
										
				}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print("Can't connect to Database");
			return;
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
