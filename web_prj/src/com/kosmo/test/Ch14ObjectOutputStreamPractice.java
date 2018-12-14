package com.kosmo.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ch14ObjectOutputStreamPractice {

	public static void main(String[] args) {
		String source = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\bbb.txt";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(source);
			oos = new ObjectOutputStream(fos);
			
			
			ArrayList<String> list = new ArrayList<String>();
			list.add("qwer");
			list.add("zzzxcd");
			
			MemberVO vo = new MemberVO();
			vo.setMname("sek");
			
			oos.writeObject(list);
			oos.writeObject(vo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
