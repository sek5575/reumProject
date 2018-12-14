package com.kosmo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ch14ObjectOutputStreamTest {

	public static void main(String[] args) {
		String source = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\object.txt";
	
		FileOutputStream fos = null;    //원본파일
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(source);
			oos = new ObjectOutputStream(fos);
			ArrayList<String> list = new ArrayList<String>();
			list.add("aaa");
			list.add("bbb");
			list.add("ccc");
			
			Ch99JDBCImpl t = new Ch99JDBCImpl();
//			ArrayList<EmpVO> list = new ArrayList<EmpVO>();	
			
			MemberVO vo = new MemberVO();
			vo.setMid("se1");
			vo.setMpw("9999");
			vo.setMname("힘들어");
			
			oos.writeObject(list);
			oos.writeObject(vo);
			
			System.out.println("==========Input done=========");

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
