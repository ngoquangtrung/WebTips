package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ListPostDao;
import dao.LogMessage;
import dao.PartDao;
import model.Post;
import model.PostPart;
import model.User;

/**
 * Servlet implementation class AddPostCtrl
 */
@MultipartConfig
@WebServlet("/AddPostCtrl")
public class AddPostCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SAVE_DIRECTORY = "images";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try {
			HttpSession session=request.getSession();
			User user=(User) session.getAttribute("currentuser");
			int numberpart=Integer.parseInt(request.getSession().getAttribute("countPart").toString());
			
			String appPath = request.getServletContext().getRealPath("");
		     appPath = appPath.replace('\\', '/');
		     
		     String fullSavePath = null;
		        if (appPath.endsWith("/")) {
		            fullSavePath = appPath + SAVE_DIRECTORY;
		        } else {
		            fullSavePath = appPath + "/" + SAVE_DIRECTORY;
		        }
		     
		        File fileSaveDir = new File(fullSavePath);
		        if (!fileSaveDir.exists()) {
		            fileSaveDir.mkdir();
		        }
		        
		        int category= Integer.parseInt(request.getParameter("category"));
				String title= request.getParameter("txt_posttitle");
				
				String summary=request.getParameter("txt_summary");
		        Part part=request.getPart("img_thumbnail");
		        String namefile= part.getSubmittedFileName();
		        String file_path= fullSavePath +File.separator + namefile;
		        part.write(file_path);
		        String src= "/GameRule/"+SAVE_DIRECTORY+"\\"+namefile;
		        
		        LocalDateTime currenttime= LocalDateTime.now();
		        
		        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        String time= formatter.format(currenttime);
		        
		        
		        
		        //String time= java.time.LocalDateTime.now().toString();
		       
		        
		        
		        Post post=new Post(1,title,src,summary,"",2,user.getIduser(),category,time);
		        Logger.getLogger(PostController.class.getName()).log(Level.SEVERE,null,"title"+post.getTitle() );
		        ListPostDao postdao =new ListPostDao();
		        PartDao partdao=new PartDao();
		        postdao.addPost(post);
		        Post postlatest=postdao.loadLatest();
		        int id_post= postlatest.getId_post();
		        for(int i=1;i<=numberpart;i++) {
		        	String titlepart=request.getParameter("txt_parttitle"+i);
		        	String contentpart=request.getParameter("txt_partcontent"+i);
		        	Part file=request.getPart("file"+i);
		        	String file_name=file.getSubmittedFileName();
		        	if(file_name!="") {
		        		String filepath=fullSavePath +File.separator + file_name;
		        		try {
		        			file.write(filepath);
		        		}catch(Exception e){
		        			out.println("file name: "+file_name);
		        		}
			        	
			        	String src_image="/GameRule/"+SAVE_DIRECTORY+"\\"+file_name;
			        	PostPart post_part =new PostPart(1,id_post,src_image,titlepart, contentpart);
			        	partdao.addPart(postlatest, post_part);
		        	}else {
		        		PostPart post_part =new PostPart(1,id_post,null,titlepart, contentpart);
			        	partdao.addPart(postlatest, post_part);
		        	}    
		        }
		        if(user.getPermission()==0) {
		        	response.sendRedirect("user.jsp");
		        }else {
		        	response.sendRedirect("adminuser.jsp");
		        }
		        
		        
			
		} catch (Exception e) {
			e.printStackTrace();
			HttpSession session=request.getSession();
			User user=(User) session.getAttribute("currentuser");
			LogMessage message=new LogMessage();
			String log="error add post ";
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
