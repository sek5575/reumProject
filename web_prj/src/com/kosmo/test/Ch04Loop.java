package com.kosmo.test;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Ch04Loop {

	public static void main(String[] args) {
		//for(_s_;조건;_증감_) {...}
		//while(조건) { ... }
		//do{...} while(조건)

		for(int i=1; i<3; i++) {  //for문안에 있는 i는 for문 안에서만 사용, for문이 끝나면 메모리와 함께 날라간다.
			System.out.println(i);
		}
//
//		int i=1;    //위와 같은 문법.
//		for( ;i<3; ) {    // for(int i=1; i<3; ) ---> 에러!! 밖에 int i=1 있기에 안에다가 i를 선언하면 에러가 난다.
//			System.out.println(i);
//			i=i+1;
//		}
		
		int r = 0;
		for(;;) {     //while true같은 형태
			if(r<5) {
				System.out.println(r);
				r++;
			}else {
				break;
			}
		}

		for(int dan=2; dan<=9; dan++) {
			System.out.println(dan+"단");
			for(int num=1; num<=9; num++) {
				int res = dan * num;
				System.out.print(dan + "*" + num + "=" + res + "\t");  //  \t -> 자동 (가로)탭     \n -> 자동 (세로)탭
			}
			System.out.println("");   // System.out.println(\n);
		}

		//디버깅한다.
		//버그:벌레 
		//		for(int num=10; num>0; num--) {
		//			System.out.println(num + " ");
		//			myprint();
		//		}
		//		

		String job = "SALES";
		int num = 3;
		while(job == "SALES") {
			System.out.println("true");
			num--;
			if(num == 0) break;
		}

		
		System.out.println("_______________________________________________________");
		
		int dan = 2;
		int numt = 1;
		int res = 0;
		while(dan<10) {
			System.out.println(dan+ "단");
			while(numt<10) {
				res = dan * numt;
				System.out.print(dan + "*" + numt + "=" + res + "\t");
				numt++;
			}
			dan++;
			numt = 1;
			System.out.println("");
			
		}
		
		System.out.println("_______________________________________________________");
		
		String line = null;
//		do {
//			System.out.println("메세지:");
//			Scanner s = new Scanner(System.in);
//			line = s.nextLine();
//			//if(line.equals("q")) break;
//		} while(!line.equals("q"));
		
//		int age = 5;
//		do {
//			System.out.println("나이:");
//			Scanner s = new Scanner(System.in);
//			age = s.nextInt();
//		} while(age > 10);
//		
//		
		
		//1~10까지의 합 출력
		int hap = 0;
		// 1 3 6 10 15 ...
		for(int bar=1; bar<=10; bar++) {
			hap = hap + bar;
			System.out.println(bar + "번째 " + " = " + hap);
		}
		
		
		String str = "";
		int sum = 0;
		for(int i = 1; i<=10; i++) {
			if(i<10) {
				str += (i + "+");
			}else {
				str += i;
			}
			sum = sum + i;
		}
		System.out.println("계산식" + str);
		System.out.println("합" + sum);
		
		
		for(int s=1; s<6; s++) {
			for(int k=0; k<s; k++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		
		
		
		
	}

	public static void myprint() {
		System.out.print("1");
		System.out.print("2");
		System.out.print("3");
		System.out.println("");
	}

}
