package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListPostDao;
import dao.PartDao;
import model.Post;
import model.PostPart;

/**
 * Servlet implementation class testservlet
 */
@WebServlet("/testservlet")
public class testservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String title="test title 2";
		String src="src image";
		String summary="test summary";
		int category=2;
		String time= java.time.LocalDateTime.now().toString();
		Post post=new Post(1,title,src,summary,"",2,1,category,time );
		
		ListPostDao postdao=new ListPostDao();
		PartDao partdao= new PartDao();
		try {
			postdao.addPost(post);
			Post postlatest=postdao.loadLatest();
			
			PostPart postpart =new PostPart(1,postlatest.getId_post(),"src image part","title part  2 ", "content part");
			
			partdao.addPart(postlatest, postpart);
			
			out.println("post id: "+postlatest.getId_post());
			out.println("post id in post part: "+postpart.getId_post());
			
			
		} catch (Exception e) {
			e.printStackTrace();
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
