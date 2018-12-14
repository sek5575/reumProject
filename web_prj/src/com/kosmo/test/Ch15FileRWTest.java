package com.kosmo.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ch15FileRWTest {

	public static void main(String[] args) {
		String source = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\aaa.txt";
		String dest = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\cp.txt";
		
		
		//Reader r = new Reader();  //abstract class new xxxxx
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
//			char[] carr = {'j', 'a', 'v', 'a'};
//			CharArrayReader car = 
			
			int res = 0;
			fr = new FileReader(source);
			fw = new FileWriter(dest, true);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			String line = null;
			while((line = br.readLine()) != null) {
			System.out.println(line);
			bw.write(line);
			}
			bw.flush();
			
			
//			
//			while((res = br.read()) != -1) {
////				System.out.println((char)res);
//				bw.write(res);
//			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("====done====");

		
	}

}
