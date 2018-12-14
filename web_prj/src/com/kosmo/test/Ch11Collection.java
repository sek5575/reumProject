package com.kosmo.test;
import java.util.ArrayList;  // import 남의 클래스를 가져와서 나의 폴더에 복사한 효과.
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
//    *****  문법 알기   *****
//------------------------------
//	배열		arr[0] = "aa"
//			syso(arr[0])
//------------------------------
//	리스트	list.add("aa")
//	 		list.get(i)
//------------------------------
//	셋		set.add("aa")
//			iterator.next()
//------------------------------
//	맵		map.put("k","aa")
//			map.get("k")
//------------------------------

public class Ch11Collection {

	public static void main(String[] args) {
		int[] numarr = {1,2,3};
		//************************************
		// 초기 사이즈가 있다/없다   차이
		Object[] arr = new Object[3];
		ArrayList list = new ArrayList();   //ArrayList로 클래스를 선언하면 list에 배열이 생겨서 아래의 "aa", 69, numarr이 담긴다고 생각하면 된다.
		Ch02Var chVar = new Ch02Var();      //ArrayList는 크기가 담기지 않는다.
											//object[] arr = new object[5];  -->  크기를 정해줘야한다.
		list.add("aa");                     //arr[0] = "aa"; arr[1] = "bb"; 
		list.add("bb");                     
		list.add(69);  
		list.add(numarr);  //3
		list.add(chVar);   //4
		
		for(int i=0; i<list.size();i++) {
			
			System.out.println(list.get(i));    // arr[i]  
		}
		
		System.out.println("**************************************************");
		
		int[] arr1 = (int[])list.get(3);  //numarr  값을 꺼내고 싶으면 ()캐스팅을 해야한다.
		System.out.println(arr1.length);
		
		System.out.println(arr1[1]);
		
		Ch02Var crr = (Ch02Var)list.get(4);    //list는 변수명
		//Ch02Var rrr =(Ch02Var)arr[4];
		System.out.println(crr.NOT_EDIT_NUM1);
		
		String st = (String)list.get(0);
		System.out.println(st);
		
		int number = (int)list.get(2);
		//int[] rr =(int[])arr[3];
		System.out.println(number);
		
		// ---------------------------------------------------------------------------------
		HashSet set = new HashSet();
		set.add("1");
		set.add("1");
		set.add("3");
		System.out.println(set);    //클래스나 배열은 주소값이 나오지만 set은 값이 나온다.
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
//		for(int i=0; i<set.size();i++) {       이거 안된다.
//			System.out.println(set.size);
//		}
		//------------------------------------------------------------------------------------
		
		HashMap map = new HashMap();
		map.put("name", "lkh");
		map.put("age", 20);
		map.put("arr", numarr);
		map.put(1, chVar);
		
//		for(int i=0; i<map.size(); i++) {
//			System.out.println(map.get(key));  key값을 가져올 방법이 없기 때문에 for문으로 돌릴 의미가 없다.
//		}
		
								//map[0] map.get(0)
//		String mres1 = (String)map.get("name");
//		int mres2 = (int)map.get("name");
//		int[] mres3 = (int[])map.get("arr");
//		Ch02Var mres4 = (Ch02Var)map.get(1);
//		System.out.println(mres1);
		
		ArrayList<HashMap<String, Object>> mlist = new ArrayList<HashMap<String, Object>>();
		
		for(int i=0; i<2; i++) {
			HashMap<String, Object> map1 = new HashMap<String, Object>();
			map1.put("name", "lee"+i);
			map1.put("age", i+10+"");
			map1.put("number", i+01010101+"");
			mlist.add(map1);
		}
		
		
		
		
		System.out.println("총회원수" + mlist.size());
		HashMap<String, Object> hm = mlist.get(0);
		System.out.println(mlist.get(0));
		System.out.println("*****************************");
		System.out.println(hm.get("name"));
		
		for(int i=0; i<mlist.size(); i++) {
			System.out.println(mlist.get(i));
		}
		
		
		for(int i=0; i<mlist.size(); i++) {
			System.out.println(mlist.get(i) + "\t" + mlist.get(i));  // 객체(Object)끼리는 출력할수가 없다. 중간에 String을 넣어야한다.
		}
		
		
//		((HashMap)mlist.get(0)).get("name");
		
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "lee");
		map2.put("age", 20);
		mlist.add(map2);
		
		
		
//		String[] astr = new String[] {"ABCDE"};
		String[] astr = {"ABCDE"};
		for(int i=0; i<astr.length; i++) {
			System.out.println(astr[i]);
		}//  빈칸에 astr.length를 입력하면 astr배열 출력
		
		//	System.out.println(astr[2]);
		
		
	}

}
