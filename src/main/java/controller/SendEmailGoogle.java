package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.HashText;
import model.RandomPassword;
import model.User;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Servlet implementation class SendEmailGoogle
 */
@WebServlet("/SendEmailGoogle")
public class SendEmailGoogle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailGoogle() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static void sendHTML(String to, String subject, String emailBody) throws AddressException, MessagingException {
    	
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage mailMessage;
     
        // Step1: setup Mail Server
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
     
        // Step2: get Mail Session
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(getMailSession);
     
        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); //Thay  địa chỉ người nhận
     
        // có thể chọn CC, BCC
//        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("cc@gmail.com")); //Địa chỉ cc gmail
     
     
        mailMessage.setSubject(subject);
        
        mailMessage.setContent(emailBody, "text/html");
        try {
        	// Step3: Send mail
            Transport transport = getMailSession.getTransport("smtp");            
            // Thay your_gmail thành gmail của bạn, thay your_password thành mật khẩu gmail của bạn
            transport.connect("smtp.gmail.com", "noxplaygpv@gmail.com", "Gpv12345678"); 
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            transport.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
        
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
		String email=request.getParameter("email");
		UserDao userDao=new UserDao();
		try {
			User user=userDao.existUser(email);
			if(user==null) {
				request.setAttribute("usererror", "Không có tài khoản này");
				
				request.getRequestDispatcher("forgotPassWord.jsp").forward(request, response);
				return;
			}else {
				
				String newpass= new RandomPassword().randomAlphaNumeric(8);
								
				String emailBody = "<h5>Recovery your account </h5>\r\n"
		        		+ "    <p>Your new pass word.please change password after first login</p>\r\n"
		        		+ "    <p style=\"color:red\"><strong>"+newpass+"</strong></p>\r\n"
		        		+ "    <a href=\"http://localhost:8080/GameRule/login.jsp\" class=\"\">Login</a>";
				
				String hashpass=new HashText().getMD5(newpass);
				user.setPass(hashpass);
				userDao.updateUser(user);	
				sendHTML(email,"GameRules",emailBody);
				response.sendRedirect("login.jsp");
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
