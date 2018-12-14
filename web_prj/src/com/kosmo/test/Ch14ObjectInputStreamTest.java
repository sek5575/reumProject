package com.kosmo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ch14ObjectInputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String source = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\object.txt";
						 		
//		File sfile = new File(source);
//		File dfile = new File(dest);
//		FileInputStream fis = FileInputStream(source);
//		FileOutputStream fis = FileOutputStream(sfile);
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
//			fos = new FileOutputStream(source);
//			oos = new ObjectOutputStream(fos);
//			
//			ArrayList<String> list = new ArrayList<String>();
//			list.add("aaa");
//			list.add("bbb");
//			list.add("ccc");
//			
//			MemberVO vo = new MemberVO();
//			vo.setMid("se1");
//			vo.setMpw("9999");
//			
//			oos.writeObject(list);
//			oos.writeObject(vo);
////			
			//=--------------------------------------
			fis = new FileInputStream(source);
			ois = new ObjectInputStream(fis);			
			
			try {
				ArrayList<String> res = (ArrayList<String>) ois.readObject();
				MemberVO res2 = (MemberVO)ois.readObject();
				System.out.println(res.size());
				System.out.println(res2.getMpw());
				System.out.println(res2.getMname());
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			System.out.println("==========Output done=========");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(ois != null)
				try {
					fis.close();
					ois.close();
					if(oos != null) oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		

	}

}
