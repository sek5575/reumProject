package com.kosmo.test;

import com.kosmo.other.Ch07Other;
import com.kosmo.other.Ch07Parent;  
// import해서 상속을 해도 그래도 부모가 가능하다.
public class Ch07Child extends Ch07Parent {  
	      static int num = 99;     //변수를 상속받아서 재할당했다 => 아니다 그냥 우연히 똑같이 선언된 변수이다  **************
	public       int cpoint = 1000;
//	public static int ppoint = 5000;
	
//	public void parentPrint() {
//		System.out.println("ppppp");   // 이렇게 코드를 가져오지만 Ch07Child new해서 메모리에 올려야한다.
//	}                                  // 상속시키면 이 클래스안에 변수와 메서드를 가져온다.
	
	//overriding : 오버라이딩  ==> 반드시 상속관계이어야 한다  ***************  --> 없으면 아무관계도 아니다.
	//메서드의 선언부는 같고 바디를 변경  or [그래도 똑같이 사용한 것]
	//접근제어자는 같거나 커야한다 (부모보다) 
	//예외는 같거나 적다(부모보다) 
	@Override    //static을 붙이면 override을 쓰면 에러가 난다.
	public void parentPrint() {    // ==> static을 부모와 자손에 둘다 써버리면 부모에 이미 메모리에 올라왔기 때문에 똑같은 메소드가 겹쳐버린다. 문법오류는 아니다.
		System.out.println("결과는");
		System.out.println("p5");
	}
	// 접근제어자가 조상이 private면 오버라이딩이 되지 않는다. private는 자기 클래스에서만 사용되기 때문에.
//	private static String parentPrint();     //하나의 클래스 안에서 
	
	public int parentPrint(int a) {    //메서드의 선언문  
		System.out.println("ppppp");   //  {    } 이것이 바디
		return 4;
	}
	
	public static void main(String[] args) {
		Ch07Other o = new Ch07Other();
		o.myPrint();
		Ch07Child c = new Ch07Child();
		c.parentPrint();
		
		System.out.println(o.otherNum);
		System.out.println(Ch07Other.otherNum);  //둘다 가능.
		
		
		Ch07Child2 c2 = new Ch07Child2();
		int res = c2.add();
		System.out.println(res);
		
//		Ch07Child p = new Ch07Child();
//		p.parentPrint();
		
		
		
	}

}
