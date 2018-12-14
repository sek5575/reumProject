package com.kosmo.test;
import java.util.ArrayList;
import java.util.HashMap;

public class MethodCommon {
	// this를 주소를 말한다.
	int point;
	String nation;
	HashMap map = new HashMap();
	
	//생성자 : 클래스이름과 동일한 메서드
	//	  : 리턴이 없다...void XX ---> 2단 구성 ********
	//	  : 컴파일러는 해당클래스 컴파일 시 생성자가 단 한개도 없을 경우 기본 생성자를 만들어준다.
	//      -->ex) public MethodCommon(){}
	//생성자(함수,메서드) = constructor
	//초기화를 해주기위해서 사용한다.  ***********생성자를 쓰는 이유************
	public MethodCommon() {
		map.put("key_id","hong");  // .이라는 메서드 호출이기에 생성자를 통해서 초기화한다.
		map.put("key_pw","222");
		map.put("key_name","홍씨");
	}
	
	//파라미터가 있는 생성자
	//매개변수가 있는 생성자
	public MethodCommon(int pt, String nn) {
		this.point = pt;
		this.nation = nn;
		map.put("key_id","hong");
		map.put("key_pw","222");
		map.put("key_name","홍씨");
	}
	
	
	//맵의 키을 파라미터로 받아서
	//그 값을 리턴하는
	//getValueByMap 메서드를 생성
	public String getValueByMap(String mapname) {
		String value = (String)this.map.get(mapname);
		return value;
	}
	
	
	
	
	
	
	

	//입력받은 파라미터 값을 전역변수에 넣는
	//XXXXXXXXXXXXXXXXXX
	//set+변수명 메서드 생성
	public void setConvertPoint(int a) {
		this.point = a;
		System.out.println(this.point);
	}
	public void setConvertNation(String a) {
		this.nation = a;
		System.out.println(this.nation);
	}
	
	
	
	
	//전역변수값 리턴
	//get+변수명 ->  getPoint() 메서드 생성
	public void getPoint() {
		System.out.println(this.point);
	}
	public void getNation() {
		System.out.println(this.nation);
	}
	public int getPoint1() {
		return this.point;
	}
	public String getNation1() {
		return this.nation;
	}
	public Object getPP() {
		return this.point;
	}
	
	
	
	
	
	// double 타입 두개를 입력받아 합을 리턴하는 add 메서드를 만드시오.
	public double add(double a, double b) {
		return a + b;
	}
	
	
	
	//int[] 배열을 입력받아서 
	//3번째 값을 리턴하는 
	//getItem이란 메서드 생성
	
	public int getItem(int[] arr) {
		int aa = 0;
		if(arr.length >= 3) {
			aa = arr[2];
		}
		return aa;
	}
	
	
	
	//HashMap을 파라미터로 받아서
	//키값이 name인 값을 리턴
	//getItembyMap
	
	public String getItembyMap(HashMap xxxx) {
		String name = (String)xxxx.get("key_name");
		return name;
	}
	
	
	
	//String 배열을 파리미터로 받아 
	//ArrayList로 변환해서 그 ArrayList 리턴
	//메서드명 : convertArrayToList
	
	public ArrayList convertArrayToList(String[] iname) {
		ArrayList list = new ArrayList();
		for(int i=0; i<iname.length; i++) {
			list.add(iname[i]);
		}		
		return list;
	}
	
	
	
	
	
	//숫자배열 ,인덱스(몇번째) 를 파라미터로 받아
	//그 인덱스의 다음 데이터를 리턴하는
	//next 메서드
	
//	public int nextIndex(int[] n , int s) {
//		int number = 0;
//		if(s < n.length) {
//			number = n[s];
//		}
//		else {
//			number = -1;
//		}
//		return number;
//	}
	
	
	
	//아이디, 비밀번호를 입력받아
	//이름을 리턴하는
	//생성
	
	public String logIn(String id, int pw) {
		String name;
		if(id.equals("song")) {
			name = "송은규";
		}
		else {
			name = "id가 맞지 않습니다";
		}
		return name;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//*******************test***************************
	//int[] 배열을 입력받아서 
	//3번째 값을 리턴하는 
	//getItem이란 메서드 생성
	
	public int changeNum(int[] arr) {
		int num = arr[2];
		return num;
	}
	
	//HashMap을 파라미터로 받아서
		//키값이 name인 값을 리턴
		//getItembyMap
	
	public String getMap(HashMap hp) {
		String title = (String)hp.get("name");
		return title;
		
	}
	
	//String 배열을 파리미터로 받아 
		//ArrayList로 변환해서 그 ArrayList 리턴
		//메서드명 : convertArrayToList
	
	public ArrayList convertList(String[] arr) {
		ArrayList tot = new ArrayList();
		for(int i=0; i<arr.length; i++) {
			tot.add(arr[i]);
		}
		return tot;
	}
	
	
	//숫자배열 ,인덱스(몇번째) 를 파라미터로 받아
		//그 인덱스의 다음 데이터를 리턴하는
		//next 메서드
	public int next(int[] str, int i) {
		int num = 0;
		if(i<str.length) {
			num = str[i];
		}
		else {
			num = -1;
		}
		return num;
	}
	
	
	
	
	
	
}
