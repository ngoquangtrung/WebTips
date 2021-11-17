package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ListPostDao;
import dao.PartDao;
import model.Post;
import model.PostPart;
import model.User;

/**
 * Servlet implementation class UpdatePostCtrl
 */
@MultipartConfig
@WebServlet("/UpdatePostCtrl")
public class UpdatePostCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SAVE_DIRECTORY = "images";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePostCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		try {
			HttpSession session = request.getSession(true);
			User user=(User) session.getAttribute("currentuser");
			Post post = (Post) session.getAttribute("currentpost");
			//List<Post> list = (List<Post>) session.getAttribute("listIddelete[]");
			String[] list = request.getParameterValues("listIddelete[]");
			
			PrintWriter out = response.getWriter();
			if (action == null||action.equals("")) {
				/*for (Post p : list) {
					int id = p.getId_post();
					//out.print("id " + id);
					String value = request.getParameter("check_box_" + id);
					if (value != null) {
						out.print(p.getTitle());
						p.setStatus(0);
						ListPostDao lpdao = new ListPostDao();
						lpdao.updatePost(p);
					}
					//response.sendRedirect("user.jsp");
				}*/
				//response.sendRedirect("user.jsp");
				ListPostDao lpdao = new ListPostDao();
				for(int i=0;i<list.length;i++) {
					int iddelete=Integer.parseInt(list[i]);
					lpdao.deletePost(iddelete);
				}
				
				
			} else if (action.equals("delete")) {
				/*post.setStatus(0);
				ListPostDao lpdao = new ListPostDao();
				lpdao.updatePost(post);
				session.setAttribute("currentpost", null);
				if(user.getPermission()==0) {
					response.sendRedirect("user.jsp");
				}else {
					response.sendRedirect("adminuser.jsp");
				}*/
				
				int idpost=Integer.parseInt(request.getParameter("idpost"));
				ListPostDao lpdao = new ListPostDao();
				lpdao.deletePost(idpost);
				
			}
			/*if(user.getPermission()==0) {
				response.sendRedirect("user.jsp");
			}else {
				response.sendRedirect("adminuser.jsp");
			}*/
			

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
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
			HttpSession session = request.getSession(true);
			Post post = (Post) session.getAttribute("currentpost");
			List<PostPart> list = (List<PostPart>) session.getAttribute("listpart");
			int idpost = post.getId_post();
			int statuspost = post.getStatus();
			int iduser = post.getId_user();
			String time = post.getTime();
			String src = post.getSrc();
			String titlepost = request.getParameter("titlepost");
			int category = Integer.parseInt(request.getParameter("category"));
			String summary = request.getParameter("summary");
			Part part = request.getPart("img_thumbnail");
			String namefile = part.getSubmittedFileName();
			if (namefile != "") {
				String file_path = fullSavePath + File.separator + namefile;
				part.write(file_path);
				src = "/GameRule/" + SAVE_DIRECTORY + "\\" + namefile;
			}
			Post changepost = new Post(idpost, titlepost, src, summary, null, statuspost, iduser, category, time);

			ListPostDao lpdao = new ListPostDao();
			lpdao.updatePost(changepost);

			PartDao pdao = new PartDao();
			for (PostPart element : list) {
				int id = element.getId_part();
				int id_post = element.getId_part();
				String titlepart = request.getParameter("title_" + id);
				String contentpart = request.getParameter("content_" + id);
				String srcpart = element.getSrc_image();
				Part imagepart = request.getPart("img_" + id);
				String nameimg = imagepart.getSubmittedFileName();
				if (nameimg != "") {
					String img_path = fullSavePath + File.separator + namefile;
					imagepart.write(img_path);
				}

				PostPart update = new PostPart(id, id_post, srcpart, titlepart, contentpart);
				pdao.updatePart(update);
				out.println(update.getId_part() + " " + update.getTitle() + " " + update.getContent());
			}
			response.sendRedirect("user.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
