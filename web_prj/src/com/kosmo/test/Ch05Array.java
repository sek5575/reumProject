package com.kosmo.test;
public class Ch05Array {
	
	public static void main(String[] args) {
		//		타입[] ____ = new 타입[크기];   -> 타입 선언하는 문법 인지!!
		//		numArr[0] ~ numArr[크기-1]
		//		Hello ____ = new Hello();
		//x번째 : 인덱스x
		
		
		//선언 + new 생성 후 --> 사용
		//  int[] numArr; // = new int[5];   ==> int a;와 같다. 
		//  int[] numArr;   numArr = new int[5];  --> 두줄 타이핑도 같다.
		int[] numArr = new int[5];
		System.out.println(numArr[3]);
		//		numArr[0] ~ numArr[4]
		
		int[] numArr2 = new int[3];

		int[] numArr3 = new int[] {10, 30, 50};  // 뒤에 크기를 적지 않아도 값을 선언했으면 에러가 나지 않는다  // 생성과 동시에 선언.
		int[] numArr4 = {10,30,50}; //위와 같다.
		int[] numArr5 = new int[3];
		numArr5[0] = 10;
		numArr5[1] = 30;
		numArr5[2] = 50;

		HelloTest h1 = new HelloTest();
		HelloTest h2 = new HelloTest();
		HelloTest h3 = new HelloTest();
		HelloTest[] h = new HelloTest[3];

		System.out.println(h1.allnum);
		System.out.println(h2.allnum);
		System.out.println(h[0].allnum);
  
		Ch02Var c1 = new Ch02Var();
		Ch02Var c2 = new Ch02Var();
		Ch02Var c3 = new Ch02Var();
		//Ch02Var[] carr = new Ch02Var[3];

		//Ch02Var[] carr = new Ch02Var()[3];   <==== 문법()주의

		System.out.println(c1.point);   // static으로 선언한 point는 같이 메모리 상에서 공유한다
		c1.point = 5000;
		System.out.println(c2.point);   

		//------------------------
		System.out.println(c1.point2);  // point2는 c1,c2의 인스턴스를 하여 메모리에 올라가기 때문에 각각의 영역의 메모리에 저장이된다
		c1.point2 = 5000;               // 즉, c1.point2 -> 5000   c2.point2  -> 0
		System.out.println(c2.point2);
		
		new String("asdv");
		String[] abcv = new String[] {new String("asdv"), new String("asdv")};
		
		
		Ch02Var[] carr = new Ch02Var[3];
		System.out.println(carr[0].point);
		carr[0].point = 3000;
		System.out.println(carr[1].point);

		String[] starr = new String[] {"aa", "bb"};
		System.out.println(starr);
		char[] ctarr = new char[] {'a','b','c'};
		char[] ctarr1 = {'a','b','c'};
		System.out.println(ctarr[0]);
		System.out.println(ctarr1);   //************** 시험!
		//char[] ctarr1 = {'a','b','c'};
		//String[] ctarr1 = new String("abc");  //위와 같이 출력된다.

		String str = "123";                       
		String str2 = new String("123");          
		char[] str3 = new char[] {'1','2','3'};   //위의 세줄은 같은 문법이다. 
		String[] str4 = new String[] {"123", "456"};
		System.out.println(str3);        //char배열은 다른것과는 다르게 자동으로 문장을 만들기 때문에 주소값이 나오지 않고 값이 나온다.
		System.out.println(str4);
		//		
//				String str1 = new String("hello");        //배열이 아니다. str1에 new(인스턴스)한 것이다.
//				String[] str1 = new String[] {"hello"};   //위를 배열로 만들어라   같은문법
//				System.out.println(str1[0]);
//				String str5 = "hello";
//				String[] str5 = {"hello"};   //위를 배열로 만들어라       같은 문법

		String name = new String("song eun gyu");
		String name1 = "song eun gyu";
		//		
		//		int[] score = new int[3];
		//		int[] score = new int[] {88,77,66};
		int[] score1 = {88,77,66};
		int[] score2 = {55,66,44};
		


		for(int i=1; i<6; i++) {
			System.out.println(i);
		}
		
		
		//다차원 배열은 방개념으로 생각해서 length 길이를 생각한다.

		// {1,2,3,4,5,6}
		int[] dan = new int[]{2,3,4,5,6,7,8,9};
		int[] gob = new int[]{1,2,3,4,5,6,7,8,9};
		for(int d=0;d<dan.length;d++) {
			System.out.println(dan[d] + "단");
			for(int g=0;g<gob.length;g++) {
				System.out.println(dan[d]+"*"+gob[g]+"="+dan[d]*gob[g] + "\t");
			}
		}
		
		
		for(int i=0; i<3; i++) {
			System.out.println(dan[i+1]);
		}
		
		
		int[] stu = {100, 80, 90, 87};
		//for : 총합, 평균 출력
		int hap = 0;
		double avg = 0;
		for(int i=0; i<stu.length; i++) {
			hap = hap + stu[i];  //sum += stu[i];
		}
		avg = hap/stu.length;
		System.out.println("총합 : "+hap+" 평균값출력: "+avg);
		
		
		//String[] avc1 = new String[1];
		//avc1[0] = {"abcde"}; // 배열의 주소를 넣는것이지 배열을 넣는것은 아니다 --> {}
//	 ---------------------------------------------------------------------------------	
//		String[] avc1 = {"abcde"};
//		for(int i=0; i<avc1.length(); i++) {
//			System.out.println(avc1[i]);
//		}
		
		String[] astr2 = new String[1];
		String[] oarr = new String[] {"ABC"};
		//astr2[0] = {"ABC"}   -->> 에러***************************
		
		String avc = "abcde";
		for(int i=0; i<avc.length(); i++) {   // ***** 배열 X 메소드 ->length() **************************************
			char c = avc.charAt(i);    // charAt() 메소드
			System.out.println(c);
		}
		
		char[] eqstrs = avc.toCharArray();  //char만 값을 출력 시킨다 *** 알아두자
		System.out.println(eqstrs);
		
		// ------------------------------------------------------------------------------
		
		// 100 80 90
		// 98 97 96
		// 44 47 49
		System.out.println("**********************************************************************");
		
//		int[][] jtScore = new int[][] {{100, 90 ,80, 1}, 
//										{88, 87, 86, 1},
//										{44, 47, 49, 1}
//										};
		
//		1. 각 학생별 평균점수 계산
//		2. 각 회차별 평균점수 계산
		//*****************************
										
//		int[][] jtScoreEp = new int[jtScore.length+1][jtScore[0].length+1]; //  크기 4,5  [3][4]
//		
//		for(int i=0; i<jtScoreEp.length; i++) {
//			if(i==jtScoreEp.length-1) {  // 4
//				break;
//			}
//			for(int j=0; j<jtScore[i].length; j++) {  //4
//					if(j==jtScoreEp.length) {   // 4일때
//						break;
//					}
//					jtScoreEp[i][j] = jtScore[i][j];
//			}
//		}
//		
//		int sero=0;
//		int garo=0;
//		for(int i=0; i<jtScoreEp.length; i++) {  //4
//			for(int j=0; j<jtScoreEp[i].length; j++) { //5
//				
//				sero += jtScoreEp[i][j];
//				if(j == jtScoreEp.length-1) {
//					jtScoreEp[i][j] = sero;
//					sero = 0;
//				}
//			}
//		}
//		
//		System.out.println(jtScoreEp[0][4]);
		
		//System.out.println(jtScoreEp[0][4]);
//		
//		for(int i=0; i<jtScoreEp.length; i++) {
//			for(int j=0; j<jtScoreEp.length; j++) { //5
//				garo += jtScoreEp[j][i];
//				if(j == jtScoreEp.length-1) {
//					jtScoreEp[j][i] = garo;
//					garo = 0;
//				}
//			}
//		}
		
		int[][] jtScore= {{100,90,80,1},{88,87,86,1},{44,47,49,1},};
	
		for(int i=0; i<jtScore.length; i++) {
			int sum = 0;
			for(int s=0; s<jtScore[i].length; s++) {
				sum += jtScore[i][s];
				
			}
			System.out.println(i+1+"학생"+sum/jtScore[i].length);
		}
		
		
		int[] answer = {1,4,4,3,2};
		// 1: *
		// 4: ****
		
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+": ");
			for(int j=0; j<answer[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
//		//		int[][] jtScore = new int[][] {{100, 90 ,80, 1}, 
//												{88, 87, 86, 1},
//												{44, 47, 49, 1}
//		};
		
	      int[][] jtcp = new int[jtScore.length+1][jtScore[0].length+1];
	         
	      for(int i=0; i<jtScore.length;i++) {         
	         for(int j=0;j<jtScore[i].length;j++) {
	            jtcp[i][j]= jtScore[i][j];
	            jtcp[i][jtScore[i].length]= jtcp[i][jtScore[i].length]+ jtScore[i][j];
	            jtcp[jtScore.length][j]=jtcp[jtScore.length][j]+jtScore[i][j];
	            }
	            jtcp[jtScore.length][jtScore[i].length]=jtcp[jtScore.length][jtScore[i].length]+jtcp[i][jtScore[i].length];
	      }
	      
	      for (int i=0;i<jtcp.length;i++) {
	         for(int j=0;j<jtcp[i].length;j++) {
	            System.out.print(jtcp[i][j]+ "\t");
	         }
	         System.out.println();
	      }
	      
	      
	      
	      
	      

	}

	
}

