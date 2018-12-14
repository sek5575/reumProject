package com.kosmo.test;

import java.io.IOException;

public class Ch9Lang {

	public static void main(String[] args) {
		String sss = "  abcDF990402-  929592-990381";
		sss.length();
		sss.charAt(7);
		sss.substring(0, 5);
		sss.indexOf("-");
		System.out.println(sss.length());
		System.out.println(sss.charAt(3));  //3번째 출력
		System.out.println(sss.substring(0, 6));  //0 ~ 6까지 출력
		System.out.println(sss.concat("000"));  //글자 붙이기
		System.out.println(sss.indexOf("-"));   //최초로 저 글자가 찾아내는 위치
		System.out.println(sss.lastIndexOf("-"));   //마지막으로 찾아내는 위치
		System.out.println(sss.replaceAll("-", "**"));   // 글자를 바꾸는거     -->공백제거도 가능하다.
		String[] aa = sss.split("-");   //배열을 주고 배열 위치만큼 -로 뽑아내는것.
		System.out.println(aa[1]);
		System.out.println(sss.toLowerCase());  // 소문자화로 시켜라
		System.out.println(sss.toUpperCase());  // 대문자화
		System.out.println(sss.trim());  //앞뒤 공백만 제거   -->중간공백 제거 불가.
		
		
		System.out.println("outout");
		System.err.println("rrrrrrrrrrr");
		
		
		try {    //try 타이핑 라인    에러가 날 소지가 있는 부분을 확인차  ==> 즉 다른 코드를 끝까지 실행해보고 싶어
			int aaa = System.in.read();
			System.out.println(aaa);
		} catch (IOException e) {  
			System.out.println("에러가 났어요..");
			e.printStackTrace();
		}
		
		
		Ch9Lang lang = new Ch9Lang();
		String str1 = "abc";
		String str2 = "abc";    //둘다 같은 주소를 가지고 있다.
		String str3 = new String("abc");
		String str4 = new String("abc");   //new를 새롭게 만들기때문에 다른주소에 같은값이 있다.   즉, 값은 똑같이 출력이 되지만 메모리를 관리하는 방법이 다르다
		
		if(str1.equals(str2)) {  //값을 비교하려면 equals로 비교해야한다.   !str1.equals(str2)  ==> 같지 않으면
			System.out.println("같다");
		}
		else {
			System.out.println("다르다");
		}
		
		
		if(str1 == str2) {   //주소가 같다    ==  ->주소 비교이다.
			System.out.println("같다");
		}
		else {
			System.out.println("다르다");
		}
		
		if(str3 == str4) {   //주소가 다르다
			System.out.println("같다");
		}
		else {
			System.out.println("다르다");
		}
		
		int a = 10;
		String astr = a+"";
		System.out.println(astr + 3);
		
		String cname = lang.getClass().toString();
		System.out.println(cname);
		
		
		StringBuffer sb = new StringBuffer("abc");
		for(int i=0; i<10; i++) {
			sb.append(i);
		}
		System.out.println(sb);
		
		String res = sb.toString();
		System.out.println(res);    
		
		System.out.println(); //out static이라서 이태리체로 되어있다. 클래스이름으로도 바로 쓸수있다.
		
		
		
		
		

	}

}
