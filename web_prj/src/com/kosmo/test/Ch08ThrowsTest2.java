package com.kosmo.test;

public class Ch08ThrowsTest2 {

	public static void main(String[] args) {//throws Exception {
		System.out.println(1);
		try {
			myPrint();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(2);	
		}finally {
			System.out.println(3);
		}
		System.out.println(4);
		
		
	}
	
	public static void myPrint() throws ArithmeticException, Exception {   //순서가 작은것부터 큰거로
		System.out.println("myPrint111");
		try {
			int res = 10/0;
		}catch(ArithmeticException aa) {
			System.out.println("연산에러..");
		}
		System.out.println("myPrint222");
		throw new Exception();   //새로운 excetion을 강제로 만들어 내고 위로 던져라
	}
	
	

}
