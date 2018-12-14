package com.kosmo.test;

public class Ch02LocalVar {
	int num;  //전역변수는 초기화를 해놓지 않더라도 메모리에 올려서 사용할수있다.
	
	public static void main(String[] args) {
		int num = 555;  //지역변수는 반드시 초기화 해놓고 사용해야한다.
		Ch02LocalVar v = new Ch02LocalVar(); 
		v.myprint();
		System.out.println(v.num);
		System.out.println(num);
		//System.out.println(this.num);   // main 함수가 올라가자 마자 올라가기 때문에 this 때문에 메모리에 올리지를 못한다.
											//static 안에서 this를 쓰지를 못한다.
		
	}
	
	public void myprint() {
		int num = 999;
		System.out.println(num);
		System.out.println(this.num);   //--> 같은 변수가 있으면 꼭대기를 가리키는 것을 this라고 한다.
		System.out.println(this);
	}

}
