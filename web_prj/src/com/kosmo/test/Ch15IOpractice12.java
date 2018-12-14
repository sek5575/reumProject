package com.kosmo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ch15IOpractice12 {

	public static void main(String[] args) {
		
		//InputStream is = new InputStream();
		String name = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\aaa.txt";
		FileInputStream fis =null;
		
		try {
			fis = new FileInputStream(name);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			while(true) {
				int res = fis.read();
				System.out.println((char)res);
				if(res == -1) {
					break;
				}
			}
			System.out.println("------done-----");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
