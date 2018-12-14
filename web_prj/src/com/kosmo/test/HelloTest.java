package com.kosmo.test; //package 저장된 폴더
//2018 07 26 18:20
//자바 첫날 :

/**
 * 이건 첫날 만든 doc파일이다 <p>
 * 
 * 음..... 그렇군<p>
 * 음..... 그렇군<p>
 * 음..... 그렇군<p>
 * 음..... 그렇군<p>
 * 
 * @author User
 *
 */
public class HelloTest {
	static int allnum = 1000;   //변수만 밖에 둘수 있지만 메서드는 쓸수없다.

	//표준들여쓰기 단축키 : ctrl + i
	//구역 드래그 tap    반대로  shift + tap

	//메서드이름 : main
	//메서드 -> 제한없이 메서드를 생성가능
	//public __0__ main(_1__ __2_)
	//(  ) : 파라미터
	//파라미터, 매개변수, 인자   
	//0.리턴타입 int string void(리턴이없다=줄값이 없다) 
	//1.파라미터 타입
	//2.파라미터명 = 변수명(사용자 리네임) 
	
	/**
	 * 
	 * 이건 내가 처음 만든 main이다.<p>
	 * 1일차<p>
	 * 2일차<p>
	 * 3일차<p>
	 * @param args  는 그냥 우리가 아는 그 메인이 맞다.
	 */
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allnum);
		System.out.println("dddd"+5);

		//호출한다.
		//add 메서드를 호출한다.
		//res : add 메서드를 호출한 결과값
		int res = add(2,4);
		System.out.println(res);
		
		
		//******************************
		//메모리에 올리는 방법
		//1. static  --> static라고 선언하자마자 메모리에 올라간다.
		//2. new
		//******************************
		HelloTest aaa = new HelloTest(); //Hello 클래스의 모든것을 메모리에 올림.
		System.out.println(aaa); 
		System.out.println(aaa.allnum); 
		int res22 = aaa.add(55, 10);
		System.out.println(res22);
		//aaa.add(1, 4)
	}
	// 메서드 기본 모양
	//_접근제어자_  ______  _리턴타입_ _메서드명_(파라미터타입 파라미터명, 파라미터타입 파라미터명){

	//}


	/**
	 * 해당함수는 두개의 파라미터를 받아서 더해주는 메소드이다.<p>
	 * @param a는 숫자다
	 * @param b는 숫자다
	 * @return  두수의 합을 준다
	 */
	public static int add(int a, int b) {
		System.out.println("_____" + allnum);
		return a + b;
	}

}
