package com.kosmo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ch14ObjectInputStreamPractice {

	public static void main(String[] args) {
		String source = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\bbb.txt";
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(source);
			ois = new ObjectInputStream(fis);
			ArrayList<String> res = (ArrayList<String>) ois.readObject();
			MemberVO vo = (MemberVO) ois.readObject();
			
			System.out.println(res.size());
			System.out.println(vo.getMname());
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}finally {
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
