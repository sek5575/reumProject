package com.kosmo.test;

import java.util.ArrayList;

public class Ch11PropertyTest {

	public static void main(String[] args) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		MemberVO mvo = new MemberVO();
		mvo.setMseq(1);
		mvo.setMid("lee");
		mvo.setMpw("111");
		mvo.setMname("이씨");
		mvo.setMgubun("u");
		list.add(mvo);
		System.out.println(list.get(0));
		
		MemberVO mvo2 = new MemberVO();
		mvo2.setMseq(2);
		mvo2.setMid("lee2");
		mvo2.setMpw("1112");
		mvo2.setMname("이씨2");
		mvo2.setMgubun("u");
		list.add(mvo2);
		
		System.out.println(list.get(1));  // mvo2 주소를 담는다.
		
		for(int i=0; i<list.size(); i++) {
//			MemberVO vo = (MemberVO)list.get(i);  //캐스팅 
			MemberVO vo = list.get(i);   // MemberVO타입의 vo로 선언하지 않으면 내용을 꺼내볼 수 가 없음.
			System.out.print(vo.getMid()+"\t");
			System.out.print(vo.getMpw()+"\t");
			System.out.print(vo.getMname()+"\t");
			System.out.print(vo.getMseq()+"\t");
			System.out.println(vo.getMgubun());
		}
		
		for(int i=0; i<list.size(); i++) {  //캐스팅 변환
			System.out.print(list.get(i).getMseq()+"\t");
			System.out.print(list.get(i).getMid()+"\t");
			System.out.print(list.get(i).getMname()+"\t");
			System.out.print(list.get(i).getMpw()+"\t");
			System.out.println(list.get(i).getMgubun());
		}
		
		
		
		
		
		
		
		
		

	}

}
