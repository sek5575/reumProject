package com.kosmo.test;

public class Ch04if {

	public static void main(String[] args) {
		
		//조건문  : num>7, num==7 --> O   num=7 --> X
		//whrer num>7 and sal>2000
		//empno=7733 and sal>2000
		int empno = 7733;
		int sal = 2010;
		//DB  : empno = 7733 and sal > 2000
		//java: empno == 7733 && sal > 2000
		
		if(empno==7733 && sal>2000) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		
		
//		if(empno==7733 && sal>2000) 
//			System.out.println("true");
//		System.out.println("done");          //if절에는 {}없으면 한줄만 인식한다.  에러는 3번째 줄로 나온다.
//		else                                      
//			System.out.println("false");
//		
		
		// decode(deptno
		//, 10, '10번부서'
		//, 20, '20번부서' 
		//, 30, '30번부서'
		//,   , '해당없음')
		int deptno = 10;
		if(deptno == 10) {
			System.out.println("10번부서");
		}
		else if(deptno == 20) {
			System.out.println("20번부서");
		}
		else if(deptno == 30) {
			System.out.println("30번부서");
		}
		else {
			System.out.println("해당없음");
		}
		
		int comm = 100;
		if(comm >= 90) {
			System.out.println("90");
		}
		else if(comm >= 80) {
			System.out.println("80");
		}
		else {
			System.out.println("해당없음");
		}
		
		
		switch(deptno) {   // **************
			case 10:  // case 11, 12, 13 --> X  case 11: case 12: case 13: --> O  **********
				System.out.println("10");
				break;   //break; 걸어야 다음코드로 안넘어간다.
			case 20:
				System.out.println("20");
				break;
			case 30:
				System.out.println("30");
				break;
			//else -->이거아니다!!
			default:
				System.out.println("해당없음");
				//break;
		}
		
		

	}

}
