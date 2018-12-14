package com.kosmo.test;

//예외처리란 : 코드를 끝까지 수행하기 위해서 발생된 예외를 처리해 주는 것
//try{}    XXXXX
//try{} catch{}
//try{} catch{} finally{}
//try{}         finally{} : 의미 없음

public class Ch08ExceptionTest {

	public static void main(String[] args) {
		int[] arr = new int[2];
		
		try {
			int res = 10/0;
		//catch{} exception은 작은 타입 --> 큰타입으로 적어라	 
		}catch(ArithmeticException aa){
			System.out.println("산술적 예외 발생 잡았다..");
		}catch(Exception aa) {
			System.out.println("혹시나...해서");
		}
		
		try {
			//ArrayIndexOutOfBoundsException 에러가 아니어도 try에 묶여도 상관없다.
			System.out.println("1");
			System.out.println(arr[4]);   //예외를 잡히는 순간 뒤에 코드는 생략된다.
			System.out.println("********");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("catch: 예외");
			System.out.println("메세지:" + e.getMessage());
			System.out.println("원인:" + e.getCause());
			System.out.println("클래스:" + e.getClass());
			e.printStackTrace();
		}finally {
			//예외 발생 여부와 관계없이 해당 블럭은 실행
			System.out.println("무조건 실행");
		}
		
		System.out.println("2");
		//하나의 메서드에서 try{} catch{} 여러번 사용 가능하다.
		try {
			System.out.println(arr[6]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("catch: 예외22");
			//하나의 try{}catch{} 안에서 또 다른 try{}catch{} 중첩 가능하다.
			try {
				System.out.println(arr[7]);
			}catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("catch: 예외33");
			}
			
		}
		System.out.println("3");
		
	}

}
