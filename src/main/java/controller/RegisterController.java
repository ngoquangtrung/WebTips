package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.HashText;
import model.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String repass=request.getParameter("repass");
		String date=request.getParameter("birthday");
		String gender=request.getParameter("gender");
		PrintWriter out = response.getWriter();
		//User uer=new User();
		UserDao userDao=new UserDao();
		out.println(email);
		boolean invalid = false;
		try {
			User userexist= userDao.existUser(email);
			if(!repass.equals(pass)) {
				request.setAttribute("passerror","Mật khẩu không khớp");
				invalid=true;
			}
			if(userexist!=null) {
				request.setAttribute("emailerror", "Email đã tồn tại");
				invalid=true;
			}
			
			if(invalid) {
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			else
			{
				int intgender;
				String time= java.time.LocalDateTime.now().toString();
				if(gender.equals("male")) {
					intgender=1;
				}else if(gender.equals("female")) {
					intgender=0;
				}else intgender=3;
				String hashpass=new HashText().getMD5(pass);			
				User user =new User(1,name,email,hashpass,intgender,date,time,0,1);
				userDao.addUser(user);
				out.println("success");
				response.sendRedirect("login.jsp");
			}
			//request.getRequestDispatcher("register.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
