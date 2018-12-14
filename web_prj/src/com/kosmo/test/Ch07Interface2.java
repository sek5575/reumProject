package com.kosmo.test;

public interface Ch07Interface2 extends Ch07InterfaceParent {
	//상수만 올 수 있다. 인터페이스는 항상 상수로 온다. 대문자화
	//모든변수에 public final static의 키워드는 따라 붙는다.
	public final static int NUM2 = 200;   // 즉, final이 없어도 무조건 상수화 된다. 또한 public, static도 항상 되어있다.
	
	//모든메서드는 추상(바디가 없는) 메서드이어야 한다.
	//public void myPrint() {}  //에러
	//모든 메서드에는 public abstract 키워드가 붙는다.
	public abstract void myPrint2();
	
	
	
}
