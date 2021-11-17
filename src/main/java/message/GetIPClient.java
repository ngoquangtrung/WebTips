package message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetIPClient {
			public String ip(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
				String[] HEADERS_TO_TRY = {
			            "X-Forwarded-For",
			            "Proxy-Client-IP",
			            "WL-Proxy-Client-IP",
			            "HTTP_X_FORWARDED_FOR",
			            "HTTP_X_FORWARDED",
			            "HTTP_X_CLUSTER_CLIENT_IP",
			            "HTTP_CLIENT_IP",
			            "HTTP_FORWARDED_FOR",
			            "HTTP_FORWARDED",
			            "HTTP_VIA",
			            "REMOTE_ADDR" };
				for (String header : HEADERS_TO_TRY) {
			        String ip = request.getHeader(header);
			        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
			        	 
			        	 return ip;
			        }
			    }
				String ipAddress = request.getRemoteAddr();  
			    return ipAddress;		
			} ;
}
