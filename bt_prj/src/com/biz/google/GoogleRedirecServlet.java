package com.biz.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoogleSigninServlet
 */
@WebServlet("/google_redirect")
public class GoogleRedirecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	277301311172-mb5l5nou6l6krsjvbsar0g8ttr59kpg5.apps.googleusercontent.com
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			GET 전송일 경우 인코딩
//			String redirect_uri = "http%3A%2F%2Flocalhost%3A8088%2Fgoogle_redirect";
//			String scope="https%3A%20%2F%2Fwww.googleapis.com%2Fauth%2Fcalendar.readonly";
		
//			POST 전송일 경우
			String googleURL = "https://accounts.google.com/o/oauth2/v2/auth?";
			String redirect_uri = "http://localhost:8088/google_redirect";
			String access_type="offline";
			String client_id = "277301311172-mb5l5nou6l6krsjvbsar0g8ttr59kpg5.apps.googleusercontent.com";
			String scope= "https://www.googleapis.com/auth/calendar.readonly";
			String response_type="code";

//			String urlString = "http://";
//			URL url = new URL(urlString); 
			
	        Map<String,Object> map = new HashMap<>();       
	        map.put("redirect_uri", redirect_uri);
	        map.put("access_type", access_type);
	        map.put("scope", scope);
	        map.put("include_granted_scopes", true);
	        map.put("response_type", response_type);	
	        map.put("client_id", client_id);
	        
	        //map에서 데이터를 꺼내 k=v&k2=m& 문장 생성
	        StringBuffer buffer = new StringBuffer();
	        for (Map.Entry<String,Object> keyval : map.entrySet()) {
	            if (buffer.length() != 0) buffer.append('&');
//	            buffer.append(URLEncoder.encode(keyval.getKey(), "UTF-8"));
	            buffer.append(keyval.getKey());
	            buffer.append('=');
//	            buffer.append(URLEncoder.encode(String.valueOf(keyval.getValue()), "UTF-8"));
	            buffer.append(String.valueOf(keyval.getValue()));
	            System.out.println(buffer);
	        }
	        // String urlString = https://accounts.google.com/o/oauth2/v2/auth&~~~~~~&~~~~~~~~~위의 작업과 같다       
	        
//			StringBuffer --> String  tostring()
//			String --> byte[]   getBytes
			byte[] postDataBytes = buffer.toString().getBytes();
			
//			for(int i = 0; i<postDataBytes.length; i++){
//				System.out.println(postDataBytes[i]);
//
//			}
		
		
//	        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
				
	        URL url = new URL(googleURL);
//	        System.out.println(url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();           
			connection.setDoOutput(true); 
			connection.setInstanceFollowRedirects(false); 
			connection.setRequestMethod("POST"); 
			
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
			connection.setRequestProperty("charset", "utf-8");
			connection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
			connection.connect();
			
			connection.getOutputStream().write(postDataBytes);  //http body에 write == post전송
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line = "";
	        if( (line = in.readLine()) != null) {
	        	System.out.print(line);
	        }
	        

	        //code <동의서>
	        //apiket
	        //securitykey
	        //client_id
	        //--> access_token
			
	}

}
