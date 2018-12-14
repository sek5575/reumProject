package com.kosmo.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Ch15PrintStreamTest {

	public static void main(String[] args) {
//		OutPutStream os = new OutPutStream(); XXXX
		byte[] sarr = {65, 66, 67, 68, 69};
		ByteArrayInputStream bais = new ByteArrayInputStream(sarr);
		
		String dest = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\cp.txt";
		
		try {
			FileOutputStream fos = new FileOutputStream(dest);
			PrintStream out = new PrintStream(fos);
			
			int res = 0;
			while((res = bais.read()) != -1) {
				System.out.println(res);
				out.println(res);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//		String name = "kim";
//		int age = 10;
//		System.out.printf("my name is %s, age is %d", name, age);   //4바이트
//		System.out.println("my name is " + name + ", age is " + age);  //16바이트 사용
//		System.out.printf("%s", 10);
		
//		try {
//			InputStreamReader isr = new InputStreamReader(System.in);
//			System.out.println(isr.read());  //6  1byte  숫자
//		} catch (IOException e) {			 //54 2byte ascii코드값
//			e.printStackTrace();
//		}
		
		System.out.println("입력:");
		Scanner s = new Scanner(System.in);
//		String scStr = s.nextLine();
		int scStr = s.nextInt();
		System.out.println("rn:"+scStr);
		
		System.err.println("ddddddd");
		
		
		System.out.println("=====done====");
		
//		out.println(4);
		

	}

}
