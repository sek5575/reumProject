package com.kosmo.test;

import java.util.ArrayList;
import java.util.HashMap;

public class MethodCallTest {
//javac MethodCallTest.java
//		MethodCallTest.class
//java MethodCallTest 5 8 hello
	
	// 오버로딩 : over loading 
	// -> 하나의 클래스 안에서 N개의 메서드관계 : 오버로딩   하나의클래스  리턴타입도 상관없다.
	//    이름이 같고, 매개변수의 타입이 다른 것.   -------> 이름 같고 괄호 안이 다르고!!!
	
//	public static void main(int a ) {
//		System.out.println("ddd"+args);
//	}
//	public static void main(int a, int b) {      // 두개는 오버로딩 관계이다.
//		System.out.println("ddd"+args);
//	}
	
//	public static void main(double a, int b) {
//		System.out.println("ddd"+args);
//	}
//	public static void main(int a) {      // 두개는 오버로딩 관계이다.
//		System.out.println("ddd"+args);
//	}
		
	public static void main(String[] args) {
//		System.out.println("시작");
//		MethodCallTest.print("111");
//		int sum = 0;
//		for(int i=0; i<arr.length; i++) {
//			sum += Integer.parseInt(arr[i]);
//		}
//		System.out.println(sum);
		
		
		// 1. static static
		// 2. 클래스이름.메서드명
		// 3. 메서드명 (여기 클래스이름.) 을 불러온다.
		MethodCommon mc = new MethodCommon();
		MethodCommon mc2 = new MethodCommon(1000, "japan");
		double q = mc.add(5.76, 7.25);
		System.out.println(q);
		
		
		int[] val = new int[] {11, 22, 33};
		int res = mc.getItem(val);
		System.out.println(res);
		
		
		HashMap map = new HashMap();
		map.put("key_name", "아무개");
		map.put("key_age", 25);
		String res3 = mc.getItembyMap(map);
		System.out.println(res3);
		
//		System.out.println(mrr.get(0));
		
//		String a;
//		System.out.println(a + true);
//		System.out.println(MethodCommon.add(4.0, 5.0)); //메서드에 static을 제거했을 경우에 에러가 난다.
		
				
		String[] sarr = new String[] {"aa", "bb", "cc"};
		ArrayList reslist = mc.convertArrayToList(sarr);
		for(int i=0; i<reslist.size(); i++) {
			System.out.println(reslist.get(i));
		}
		
		
		int[] numarr = new int[] {1,2,3,4,5};
//		int res5 = mc.nextIndex(numarr, 4);
//		System.out.println(res5);
		
		
		mc.getPoint();
		mc.getNation();
		System.out.println(mc.getPoint1());
		System.out.println(mc.getNation1());
		
		Object o1 = mc.getPP();
		Object o2 = mc.getPP();    //object로 선언하면 문제가 생긴다 형변환!!
		int o3 = (int)mc.getPP();
		int o4 = (int)mc.getPP();
		
		mc.setConvertPoint(5);
		mc.setConvertNation("japan");
		
		
		
		System.out.println("**************************");
		//****************test***************************
		int[] qwer = new int[] {10,20,30,40,50};
		System.out.println(mc.changeNum(qwer));
		
		
		System.out.println("**************************");
//		ArrayList arrayt1 = new ArrayList();
//		HashMap test = new HashMap();	
//		for(int i=0; i<4; i++) {      
//			arrayt1.add(test.put("name", "은규"+i));
//			arrayt1.add(test.put("age", 10+i));
//			System.out.println(arrayt1.get(i));
//		}
//		
//		for(int i=0; i<arrayt1.size(); i++) {
//			System.out.println(arrayt1.get(i));
//		}
		System.out.println("**************************");
		
		String[] yoy = new String[] {"abc", "def", "ghi"};
		ArrayList bbc = mc.convertList(yoy);
		for(int i=0; i<bbc.size(); i++) {
			System.out.println(bbc.get(i));
		}
		System.out.println(mc.convertList(yoy));
		
		System.out.println(mc.next(qwer, 4));
		
		
		String id = "song";
		int pw = 1234;
		System.out.println(mc.logIn(id, pw));
		
		String id1 = "key_id";
		System.out.println(mc.getValueByMap(id1));
		
		
		
		
		
		
	
		
	}

}
