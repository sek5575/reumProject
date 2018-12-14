package com.kosmo.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ch15IOpractice111 {

	public static void main(String[] args) {
		String name = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\aaa.txt";
		String dest = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\bbb.txt";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;  //다형성
		BufferedOutputStream bos = null;
		
		
		try {
			fis = new FileInputStream(name);
			fos = new FileOutputStream(dest);
			bis = new BufferedInputStream(fis);  //다형성
			bos = new BufferedOutputStream(fos);

			int res = 0;
			try {
				while((res = bis.read()) != -1) {
					System.out.print((char)res);			
					bos.write(res);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //버퍼를 비우다.
			
			
//			while(true) {    //풀어서 쓴거
//				int res = fis.read();
//				System.out.println((char)res);
//				if(res == -1)
//					break;
//			}
			
					
//			while(true) {
//				try {
//					int res = fis.read();
//					System.out.println((char)res);
//					fos.write(res);
//					if(res == -1)
//						break;
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			System.out.println("-----done------");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
