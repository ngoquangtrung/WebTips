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
import model.User;

/**
 * Servlet implementation class CheckCookie
 */
@WebServlet("/CheckCookie")
public class CheckCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();	
		Cookie[] cookies =request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				PrintWriter out=response.getWriter();
				out.print("name: "+cookie.getName()+" value: "+cookie.getValue());
				if(cookie.getName().equalsIgnoreCase("remember")) {				
					
					String email=cookie.getValue();
					UserDao userDao=new UserDao();
					User user;
					try {
						user = userDao.existUser(email);
						session.setAttribute("currentuser",user);
					} catch (Exception e) {
						e.printStackTrace();
					}
					response.sendRedirect("user.jsp");
					return;
				}
			}
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("login.jsp");
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
