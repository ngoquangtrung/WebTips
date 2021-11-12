package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.HashText;
import model.Post;
import model.User;
import stackjava.GooglePojo;
import stackjava.GoogleUtils;

/**
 * Servlet implementation class LoginGoogleServlet
 */
@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginGoogleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
	    if (code == null || code.isEmpty()) {
	      RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
	      dis.forward(request, response);
	    } else {
	      String accessToken = GoogleUtils.getToken(code);
	      GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
	      
	      
	      HttpSession session= request.getSession();
	      UserDao userDao=new UserDao();
	      try {
			User user=userDao.existUser(googlePojo.getEmail());
			if(user==null) {
				String time= java.time.LocalDateTime.now().toString();
				String hashpass=new HashText().getMD5(googlePojo.getId());
				String email=googlePojo.getEmail();
				user=new User(1,"Google User",email,hashpass,3,"",time,0,1,null);
				userDao.addUser(user);
			}
			session.setAttribute("currentuser", user);
			/*int permission=user.getPermission();
			if(permission==0) {
				response.sendRedirect("user.jsp");
			}else {
				response.sendRedirect("adminuser.jsp");
			}*/
			Post viewpost=(Post) session.getAttribute("viewpost");
			if(viewpost==null) {
				response.sendRedirect("main");
			}else {
				response.sendRedirect("contentPostCtrl?idpost="+viewpost.getId_post()+"&title="+viewpost.getTitle());
			}
			
			
			
			//response.sendRedirect("user.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
