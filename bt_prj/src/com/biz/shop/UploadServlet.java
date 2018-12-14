package com.biz.shop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;

/**
 * Servlet implementation class UploadServlet
 */

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
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
		
		/* ---------------------------------------------------------------
         * 멀티파일업로드 
         * <input type="file" name="files[]" multiple>  name 1개로 여러 파일 올릴 경우
         * ---------------------------------------------------------------
         */
		 //MultipartParser parser = new MultipartParser(request, 1024 * 1024 * 10);
		 MultipartParser parser = new MultipartParser(request, 1024 * 1024 * 10, false, false, "UTF-8"); 
		 
         Part _part;
         //String resp = "<br>uploaded files.<br>";
         int i = 1;
        
         while ((_part = parser.readNextPart()) != null) {
             if (_part.isFile()) {
                 FilePart fPart = (FilePart) _part;  
                 String name = fPart.getFileName();
                 if (name != null) {
                     long fileSize = fPart.writeTo(new File("c:/uploads"));
                     System.out.println(fPart.getFilePath() + "," + fileSize );
                 } else {
                     System.out.println("error");
                 }
             }
         }// end while 
         
         //System.out.println(resp);
         
         
        /* ---------------------------------------------------------------
         * 멀티파일업로드 
         * <input type=file> name이 각각 존재할 경우
         * ---------------------------------------------------------------
         */
//        String saveDirectory = "C:/uploads";
// 		int maxPostSize = 1024 * 1024 * 10; //10M
// 		String encoding = "UTF-8";
// 		FileRenamePolicy policy = new DefaultFileRenamePolicy();
//
// 		//1. 파일카피 input/output Stream
// 		//2. 중복파일 rename
// 		MultipartRequest mrequest = new MultipartRequest(request,saveDirectory,maxPostSize,encoding,policy);
//
// 		Enumeration formNames = mrequest.getFileNames();
// 		while(formNames.hasMoreElements()) {
// 			String inputTagNames = (String)formNames.nextElement();
// 			//원본파일명
// 			String origPnames = mrequest.getOriginalFileName(inputTagNames);
// 			System.out.println(origPnames);
// 		}
//
// 		System.out.println("-------done---------------");
         
         
         
         //주말에 해보자.
     /* ---------------------------------------------------------------
      *  apache : common-io.jar commons-fileupload 사용한 경우
      * <input type="file" name="files[]" multiple>
      * ---------------------------------------------------------------
      */
//		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//		if (isMultipart) {
//			FileItemFactory factory = new DiskFileItemFactory();
//			ServletFileUpload upload = new ServletFileUpload(factory);
//			try {
//				List items = upload.parseRequest(request);
//				Iterator iterator = items.iterator();
//				while (iterator.hasNext()) {
//					FileItem item = (FileItem) iterator.next();
//
//					if (!item.isFormField()) {
//						String fieldName = item.getFieldName();
//						String fileName = item.getName();
//						
//						System.out.println(fileName + "---");
//						
////						//String root = getServletContext().getRealPath("/");
////						File path = new File("c:/uploads");
////						if (!path.exists()) {
////							boolean status = path.mkdirs();
////						}
////
////						File uploadedFile = new File(path + "/" + fileName);
////						System.out.println(uploadedFile.getAbsolutePath());
////						item.write(uploadedFile);
//					}
//				}
//			} catch (FileUploadException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		
		

		

	}

}
