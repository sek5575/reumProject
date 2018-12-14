package com.biz.shop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.biz.common.MyBatisFactory;
import com.biz.common.MyFileRenamePolicy;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

@WebServlet("/shop_insert") 	
public class ShopInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDirectory = "C:/uploads";
		int maxPostSize = 1024 * 1024 * 10; //10M
		String encoding = "UTF-8";
//		FileRenamePolicy policy = new DefaultFileRenamePolicy();



//		//--------------------------------------------
//		// * c:/uploads 폴더에 파일카피 input/output Stream
//		// * 중복파일 rename
//		//--------------------------------------------
//		MultipartRequest mrequest = new MultipartRequest(request,saveDirectory,maxPostSize,encoding,policy);
//		
//		//--------------------------------------------
//		// * shop_info 관련 파라미터
//		//--------------------------------------------
//		String sname = mrequest.getParameter("sname");
//		String placename = mrequest.getParameter("placename");
//		String lat = mrequest.getParameter("lat");
//		String lng = mrequest.getParameter("lng");
//		String sinfo = mrequest.getParameter("sinfo");
//		
//	
//		//--------------------------------------------
//		// * shop_pic : cos.jar MultipartRequest를 이용한  멀티 파일업로드 처리
//		// * <input type=pname1> <input type=pname2> name 여러개로 여러파일 올릴 경우   
//		//--------------------------------------------
//		ArrayList<ShopPicVO> pvolist  = new ArrayList<ShopPicVO>();
//		Enumeration formNames = mrequest.getFileNames();
//		while(formNames.hasMoreElements()) {
//			String inputTagNames = (String)formNames.nextElement();
//			//원본파일명
//			String origPnames = mrequest.getOriginalFileName(inputTagNames);
//			
//			if(origPnames != null) {
//				ShopPicVO pvo  = new ShopPicVO();
//				//중복 시 리네임된 시스템 파일명
//				String sysPnames = mrequest.getFilesystemName(inputTagNames);
//				//파일크기
//				//File pfiles = mrequest.getFile(inputTagNames); 
//				//long attachFileSizes = pfiles.length();		
//				
//				pvo.setPname(origPnames);
//				pvo.setSysname(sysPnames);
//				pvo.setPpath(saveDirectory); 
//				if(pvolist.size() == 0) {
//					pvo.setPyn("y");
//				} else {
//					pvo.setPyn("n");
//				}
//				pvolist.add(pvo);
//			}
//		}


		/* ---------------------------------------------------------------
		 * shop_pic : cos.jar MultipartParser를 이용한  멀티 파일업로드 드래그 처리
		 * <input type="file" name="files[]" multiple>  name 1개로 여러 파일 올릴 경우
		 * ---------------------------------------------------------------
		 */
		MyFileRenamePolicy pol = new MyFileRenamePolicy();
		MultipartParser parser = new MultipartParser(request, 1024 * 1024 * 10, false, false, "UTF-8"); 
		Part part=null;
		HashMap<String, Object> smap = new HashMap<String, Object>();
		ArrayList<ShopPicVO> pvolist  = new ArrayList<ShopPicVO>();
		while ((part = parser.readNextPart()) != null) {
			String inputName = part.getName();
			if (part.isParam()) {
				ParamPart paramPart = (ParamPart)part;      //VOname
				String value = paramPart.getStringValue();  //VOvalue
				//System.out.println("inputName:" + inputName + "; value:" + value);
				smap.put(inputName, value);
			} else if (part.isFile()) {
				ShopPicVO pvo = new ShopPicVO();
				
				FilePart filePart = (FilePart)part;
				//내가 정의한 파일 리네임 폴리시 사용....셋팅
				filePart.setRenamePolicy(pol);
				
				String fileName = filePart.getFileName();
				
				//파일업로드
				if (fileName != null) {
					long fileSize = filePart.writeTo(new File(saveDirectory));   //writeTo 하는 동시에 여기서 업로드. 리네임도 같이 진행된다.
//					filePart.getFileName();  	//리네임
//					filePart.getFilePath();		//원본명
					
					//원본파일명
					//pvo.setPname(filePart.getFilePath());
					pvo.setPname(fileName);
					//파일 리네임명
					pvo.setSysname(filePart.getFileName());  //리네임된 파일로 간다.
					System.out.println(filePart.getFileName());
					//파일경로				
					pvo.setPpath(saveDirectory);
					if(pvolist.size() == 0) {
						pvo.setPyn("y");
					} else {
						pvo.setPyn("n");
					}
					//파일크기
					//pvo.setFileSize(fileSize);
					
					pvolist.add(pvo);
					
				} else {
					System.out.println("error");
				}
			}
		} 

         
		//--------------------------------------------
		// * DB Connection 
		//   트랙잭션 관리 : conn.setAutoCommit(false)
		//--------------------------------------------
		SqlSession conn = MyBatisFactory.getFactory().openSession();
		
		
		//--------------------------------------------
		// 1. CURRVAL+1 SSEQ 가져오기
		//--------------------------------------------
		ShopDAO dao = new ShopDAO();	
		int next_sseq = dao.selectNextSseq(conn);
		
		if(next_sseq > 0) {
			try {
				//--------------------------------------------
				// 2. DB저장작업
				//    SHOP_INFO 테이블 정보 입력 : 1번 입력
				//--------------------------------------------
//				ShopVO svo = new ShopVO();
//				svo.setSseq(next_sseq);
//				svo.setSname(sname);
//				svo.setSinfo(sinfo);
//				svo.setLat(lat);
//				svo.setLng(lng);
//				svo.setPlacename(placename);
				
				HttpSession session = request.getSession();
				String sess_id = session.getAttribute("SESS_ID").toString();
				
				Gson gson = new Gson();
				JsonElement jsonElement = gson.toJsonTree(smap);
				ShopVO svo = gson.fromJson(jsonElement, ShopVO.class);
				svo.setSseq(next_sseq);
				svo.setRegid(sess_id);
				int infoInsertRes = dao.insertShopInfo(svo, conn);
				
				//--------------------------------------------
				// 3. DB저장작업
				//    SHOP_PIC 테이블 정보 입력 : pvolist.size()번 입력
				//--------------------------------------------
				if(infoInsertRes > 0) {
					int shopPicInsertRes = 0;
					for(int i=0; i<pvolist.size(); i++) {
						pvolist.get(i).setSseq(next_sseq);
						shopPicInsertRes = dao.insertShopPic(pvolist.get(i), conn);
					}
				} 
				//conn에 의한 모든 트랜잭션이 정상적으로 처리된 경우에만 commit
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
			}finally {
				conn.close();
			}
		}  //end of if(next_sseq > 0)
		
		
		
		//--------------------------------------------
		// * DB close
		//--------------------------------------------

		response.sendRedirect("index.jsp");
		
		
		
//		//-----------------------------------------------		
//		// * shop_pic : cos.jar 를 이용한 단일 파일 업로드 처리 
//		//-----------------------------------------------
//		String origPname = mrequest.getOriginalFileName("pname");
//		//3.File 객체를 이용한 파일명 
//		File pfile = mrequest.getFile("pname");
//		String filePname  = pfile.getName(); 	
//				
//		//중복 시 리네임된 파일명
//		String sysPname = mrequest.getFilesystemName("pname");
//		
//		//파일크기
//		long attachFileSize = pfile.length();		
//		
//		String attachFileContentType = mrequest.getContentType("pname");
//		
//		//파일 확장자 처리
//		String attachFileExt = "jpg";
//		if(origPname.lastIndexOf(".") != -1) {
//			attachFileExt = origPname.substring(origPname.lastIndexOf(".")+1);
//		}
//		if(!attachFileExt.toUpperCase().equals("JPG") &&
//				!attachFileExt.toUpperCase().equals("PNG") &&
//				!attachFileExt.toUpperCase().equals("GIF")
//		) {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('이미지 첨부만 가능')</script>");
//			//response.sendRedirect("shop_form.jsp");
//		}


/* ---------------------------------------------------------------
 *  apache : common-io.jar common-upload.jar 사용한 경우
 * <input type="file" name="files[]" multiple>
 * ---------------------------------------------------------------
 */
//		ArrayList<ShopPicVO> pvolist = new ArrayList<ShopPicVO>();
//		ShopPicVO pvo = new ShopPicVO();
//		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//		if (isMultipart) {
//			FileItemFactory factory = new DiskFileItemFactory();
//			ServletFileUpload upload = new ServletFileUpload(factory);
//			try {
//				List items = upload.parseRequest(request);
//				Iterator<FileItem> iterator = items.iterator();
//				while (iterator.hasNext()) {
//					FileItem item = iterator.next();
//					if (!item.isFormField()) {
//						String fieldName = item.getFieldName();
//						String value = item.getName();		//파일명
//						long sizeInBytes = item.getSize();	//파일크기
//						
//						System.out.println(fieldName + "---" + value);
//						pvo.setPname(value);
//					
//						//String root = getServletContext().getRealPath("/");
//						//File path = new File("c:/uploads");
//						//if (!path.exists()) {
//						//	boolean status = path.mkdirs();
//						//}
//
//						File uploadedFile = new File(saveDirectory + "/" + value);
//						//System.out.println(uploadedFile.getAbsolutePath());
//						item.write(uploadedFile);
//					}
//					System.out.println("pvo.getPname():" + pvo.getPname());
//					pvolist.add(pvo);
//				}
//			} catch (FileUploadException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

	}

}
