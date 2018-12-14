package com.kosmo.test;
//인스턴스 : 메모리에 올라가서 주소를 갖는 것
//인스턴스화 : 주소를 만든다(new)

public class Ch02Var {
	//클래스 안에는 변수 , 메서드 들이 올 수 있다.
	
	//전역변수는 초기화하지 않으면 기본 값으로 초기화된다.
	static int point;  // static변수  = 클래스 변수      이태리어
	int point2;        // 인스턴스 변수 
	static final int NOT_EDIT_NUM1 = 500; //메서드 안에서는 static을 사용하지 못한다. 
	
	public static void main(String[] args) {
		//static 변수는 메모리에 자동으로 올라감으로 그냥사용
		System.out.println(point);

		//일반변수에 new해서 메모리에 올려놓고 사용
		Ch02Var v = new Ch02Var();     //변수에는 숫자 못쓴다
		System.out.println(v.point2);
		System.out.println(v.point);  //out도 변수....
		
		
		//변수를 선언
		//지역변수 반드시 초기화 해야한다!!(최초로 값을 넣는것)
		int a; 
		a = 4;  //초기화
		int b = 10;  // 선언과 동시에 선언
		b = 7; // 값을 재 할당
		
		//기본(primitve)타입: 8개타입 (boolean, char, byte, short, int ,long, float, double) *******암기
		//참조(reference)타입 : 주소값(4byte)
		
		boolean bool = false; //기본값 true
		char c = 'c';
		byte bt = 127; // 2^7 -1
				
		short s = 32767; // 2^16-1
		int i = 2147483647;  //정수
		long l = 520000;
		
		float f = 3.0f; //리터럴 f,d
		float u = (float)4.0;
		double d = 5.0;  // 소수점
		
		String aa = "hello";
		//String aa2 = new String("hello");  //위와 같은 문법이다
		
		System.out.println(aa);
		
		System.out.println(a);

		
		//상수 : final이 붙은 변수
		final int NOT_EDIT_NUM = 500;    //자바에서 대문자를 넣었다 -> 상수를 썻다.
		System.out.println(NOT_EDIT_NUM);
		
		//NOT_EDIT_NUM = 2000;  에러: 상수는 값을 초기화 한 후 재할당 못한다. 
		
		String str1 = null;
		String str2 = "";
		//char ic1 = '';  에러다 ************
		char ic2 = ' ';
		char ic3 = '\u0000';  //' '의 유니코드
		System.out.println(ic3);
		String str3 = "A";
		//String에 어떠한 연산을 해도 String
		
		int h = 100;
		int z = 50;
		System.out.println(str3 + h + z);
		System.out.println(str3 + (h + z));
		
		//int보다 작은 크기의 타입들을 더하면 결과는 int
		char calph = 'A';  //아스키코드 값 65
		System.out.println(calph+1);
		System.out.println((char)(calph + 1));  // 캐스팅 : 형변환 (바꾸고 싶은 타입) 
		// 1은 int형 4바이트 , calph는 char형  2바이트      큰 타입에서 작은타입으로 바꾸고 싶을때 char 2바이트/ int 4바이트
		// 기본타입 8개 중 boolean을 제외한 나머지는 서로 캐스팅이 가능하다.
		
		boolean bl = true;

		//참조타입 <--> 기본타입 하고는 절대 캐스팅 불가!!!
		String numstr = "11";
		//System.out.println((int)numstr);  -> 안된다.
		
		Boolean bw;
		//Boolean.parseBoolean("true");
		Character cw;
		Byte btw;
		Short sw;
		//Short.parseShort("14");
		Integer it;
		Long lw;
		float fw;
		Double dw;
		double dp = Double.parseDouble("3.4");
		
		
		//***** Wrapper 참조타입 <--> 기본타입  클래스 사용 *******//
		int pint = Integer.parseInt(numstr);
		System.out.println(pint+5);	
		
		String ssn1 = "9201708 - 1234567";
		
		int ssn2 = 920101;
		int ssn3 = 1234567;
		
		
		byte q = 10;
		byte e = 20;
		//byte k = 10 + 20; int형 + int형이 byte형에 담기지못한다. *********문제
		byte k = (byte)(q + e); 
		System.out.println(k);
		
		int num1 = 100000;
		int num2 = 200000;
		long nres = (long)num1 * num2;
		//(long)(num1 * num2)  num1, num2가 int형에서 계산했기 때문에 long으로 형변환을 하더라도 -값이 나온다.
		System.out.println(nres);
		
		
		double divers = (double)10/8;   //******* 문제
		System.out.println(divers);
		
		// float nn1 = 3.14  -> 에러   3.14는 double형이다. ***********
		final int MAX = 3;  // int MAX = 3  무늬만 상수이다. int형  ***********
		// MAX = 10;
		
		int tot = 80;  
		String totres = (tot==90) ? "같다":"다르다";     //decode(sal,90,'같다','다르다')  --> 데이터베이스
		System.out.println(totres);
		int score = 80;
		char ress = (score>90) ? 'A':(score>80) ? 'b':'c';  //삼항 연사자는 무한으로 증식할 수 있다.
		
		
		
	}
	

}
