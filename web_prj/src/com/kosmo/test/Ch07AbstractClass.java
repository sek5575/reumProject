package com.kosmo.test;

import com.kosmo.other.Ch07Parent;

//추상클래스 : 추상메서드 (바디가 없는 메서드)를 가질 수도 있다.
//인스턴스(주소)를 생성할 수 없고 상속에 의해서만 메서드/변수 사용 가능
//자식 클래스는 반!드!시! 추상메서드를 구현{}해야한다.
//자식 클래스가 추상클래스이면 추상메서드를 구현하지 않아도 된다.
public abstract class Ch07AbstractClass extends Ch07Parent implements Ch07Interface {
	
	//추상메서드 : 바디가 없는 메서드
	public abstract void absFunc();
	
//	{
//		System.out.println("absFunc");
//	}

	public boolean ipinCheck(String pinno) {
		//500
		return true;
	}
	//abstract메소드는 바디가 없는 abstract가 올 수 있고 abstract없는 메소드가 올 수 있다.
	//abstract클래스를 쓰는 이유는 일부만 구현이 필요할 경우 abstract클래스를 사용한다.
	//==> 즉, 일반 메소드를 공통적으로 사용한다.
	
}
