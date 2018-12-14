package com.kosmo.test;

import java.io.File;


public class Ch14FileTest {
	
	public static void recall(File[] far) {
		File[] farr = far;
		for(int i =0; i < farr.length; i++) {
			if(farr[i].isDirectory()) {
				System.out.println("<dir>" + farr[i].getName());
				farr = farr[i].listFiles();
				recall(farr);
			}else {
				System.out.println(farr[i].length() + "\t" + farr[i].getName());
			}
		}
//		System.out.println("=========done========");
	}
	
	
	public void showList(String path) {
		File f = new File(path);
		File[] farr = f.listFiles();
		
		for(int i=0; i<farr.length; i++) {
			File getiFile = farr[i];
			if(getiFile.isDirectory()) {
				System.out.println("<DIR>" + getiFile.getName());
				showList(path + "\\" + getiFile.getName());
			}else {
				System.out.println("\t" + getiFile.length() + "\t" + getiFile.getName());
			}
		}
		
	}

	public static void main(String[] args) {
//		String source = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\aaa.txt";
//		File f = new File(source);
//		System.out.println(f.getPath());
//		System.out.println(f.getAbsolutePath());
//		System.out.println(f.getName());
//		System.out.println(f.getParent());
//		System.out.println(f.isFile());
//		System.out.println(f.isDirectory());
		
		String path = "C:\\jp\\workspace_java\\java_prj\\src";
		File f = new File(path);
		File[] farr = f.listFiles();
		
		
		Ch14FileTest t = new Ch14FileTest();
		t.showList(path);
//		t.recall(farr);
		
		
//		for(int i =0; i < farr.length; i++) {
//			if(farr[i].isDirectory()) {
//				System.out.println("<DIR>\t" + farr[i].getName());
//				
//			}else {
//				System.out.println(farr[i].length() + "\t" + farr[i].getName());
//			}
//			System.out.println("=========done========");
//		}
//		
	
		
		
	}

}
