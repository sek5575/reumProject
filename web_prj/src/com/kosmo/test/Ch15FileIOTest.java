package com.kosmo.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//get....path()
//상대경로 : 현재 파일 위치를 기준으로 경로를 정의
//
///etc/src/
//c:\fils\
//com.kosmo.user
//C:\workspac\prj\src\
//com
//  kosmo      ..
//     bb.txt
//C:\workspac\prj\src\com\kosmo\
//     Hello.java
//     user    .
//       Test.java
//       aa.txt
//       
//class Hello{
//	String path = "./user/aa.txt";
//}
//class Test{
//	main(){
//		String path = "./aa.txt";
//		String path = "../aa.txt";   상대경로
//	}
//}
//     
//절대경로 : 파일 디렉토리를 기준으로 경로를 정의

public class Ch15FileIOTest {

	public static void main(String[] args) {
//		InputStream
		String source = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\aaa.txt";
		String dest = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\cp.txt";
//		String name = "aaa.txt";
		
		File sfile = new File(source);
		File dfile = new File(dest);
		
		
		FileInputStream fis =null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {      							  //try catch 에서도 {}은 지역변수로 인식한다.
			fis = new FileInputStream(sfile);  //예외 발생시킴
			fos = new FileOutputStream(dfile);
			bis = new BufferedInputStream(fis);  //다형성
			bos = new BufferedOutputStream(fos);
//			
//			dis = new DataInputStream(fis);
//			dos = new DataOutputStream(fos);
//			int num = 0;
//			while(dis.available() > 0 ) {
//				num = dis.readInt();
//				System.out.println(num + 10);
//				dos.writeInt(num);
//			}
			
			int res = 0;
			while((res = bis.read()) != -1) {
				System.out.println((char)res);			
				bos.write(res);
			}
			bos.flush();  //버퍼를 비우다.
			
//			while(true) {    //풀어서 쓴거
//				int res = fis.read();
//				System.out.println((char)res);
//				if(res == -1)
//					break;
//			}
			
			
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
//				dis.close();
//				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("---done----");
		

	}

}
