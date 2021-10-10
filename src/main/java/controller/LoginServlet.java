package controller;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import context.DBContext;
import dao.ListPostDao;
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
		UserDao userDao=new UserDao();
		try {	String hashpass=new HashText().getMD5(pass);
				User user=userDao.checkUser(email, hashpass);
				if(user==null) {
					request.setAttribute("loginerror", "Thông tin sai, vui lòng kiểm tra lại");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else {
					HttpSession session= request.getSession();
					session.setAttribute("currentuser", user);
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
