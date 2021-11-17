package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDao;
import dao.LogMessage;
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
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		User user = (User) session.getAttribute("currentuser");
		if(user==null) {response.sendRedirect("login.jsp"); return;}
		CommentDao cmtDao=new CommentDao();
		out.println(user.getIduser());
		try {
			List<Comment> listcmt=cmtDao.listCmtofUser(user);
			List<Integer> listIdcmt=new ArrayList<Integer>();
			for (Comment comment : listcmt) {
				listIdcmt.add(comment.getIdcmt());
				
			}
			/*if(listcmt!=null) {
				
			out.println("do dai "+listcmt.size());
			for (Integer comment : listIdcmt) {
				out.println("id  "+comment);
				
			}
			}else {
				out.print("rong");
			}*/
			
			request.setAttribute("listid", listIdcmt);
			request.setAttribute("listcmt", listcmt);
			request.getRequestDispatcher("screen/listComment.jsp").forward(request, response);
			
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
		
		//them mot binh luan
			HttpSession session=request.getSession();
			PrintWriter out=response.getWriter();
		try {
			
			String content=request.getParameter("contentcmt");
			User user= (User) session.getAttribute("currentuser");
			if(user!=null) {
				
			int iduser=user.getIduser();
			int idpost=Integer.parseInt(request.getParameter("idpost"));
			//LocalDateTime currenttime= LocalDateTime.now();
		     //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		     //String time= formatter.format(currenttime);
		     String time= java.time.LocalDateTime.now().toString();
		     Comment cmt;
		     
		     if(request.getParameter("idrep")!=null) {
		    	 Integer idrep = Integer.parseInt(request.getParameter("idrep"));
		    	 cmt=new Comment(iduser,idpost,content,time,2,user.getName(),idrep,0);
		     }else {
		    	 cmt=new Comment(iduser,idpost,content,time,2,user.getName(),null,0);
		     }
		     
		     CommentDao cmtDao =new CommentDao();
		     
		     if(cmtDao.addComment(cmt)) {
		    	 out.print("loginned");
		     }
		     else {
		    	 out.print("failed");
		     }
		    
		     
			}else {
				out.print("login");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();			
			User user=(User) session.getAttribute("currentuser");
			LogMessage message=new LogMessage();
			String log="error add comment ";
			String time= java.time.LocalDateTime.now().toString();
			try {
				message.clientLogMessage(user.getIduser(),log , time);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}

}
