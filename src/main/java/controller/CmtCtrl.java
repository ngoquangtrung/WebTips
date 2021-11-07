package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDao;
import model.Comment;
import model.User;

/**
 * Servlet implementation class CmtCtrl
 */
@WebServlet("/CmtCtrl")
public class CmtCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CmtCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		User user=(User) session.getAttribute("currentuser");
		CommentDao cmtDao=new CommentDao();
		try {
			List<Comment> listcmt=cmtDao.listCmtofUser(user);
			request.setAttribute("listcmt", listcmt);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			PrintWriter out=response.getWriter();
		try {
			
			String content=request.getParameter("contentcmt");
			User user= (User) session.getAttribute("currentuser");
			if(user!=null) {
				
			int iduser=user.getIduser();
			int idpost=Integer.parseInt(request.getParameter("idpost"));
			LocalDateTime currenttime= LocalDateTime.now();
		     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		     String time= formatter.format(currenttime);
		     Comment cmt;
		     
		     if(request.getParameter("idrep")!=null) {
		    	 Integer idrep = Integer.parseInt(request.getParameter("idrep"));
		    	 cmt=new Comment(iduser,idpost,content,time,2,user.getName(),idrep,0);
		     }else {
		    	 cmt=new Comment(iduser,idpost,content,time,2,user.getName(),null,0);
		     }
		     
		     CommentDao cmtDao =new CommentDao();
		     cmtDao.addComment(cmt);
		     out.print("loginned");
			}else {
				out.print("login");
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		
		
	}

}
