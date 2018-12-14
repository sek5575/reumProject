package com.kosmo.test;

import java.util.ArrayList;

public class Ch11PropertyPractice {

	public static void main(String[] args) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		MemberVO mvo = new MemberVO();
		mvo.setMseq(1);
		mvo.setMname("사람1");
		mvo.setMid("불쌍한");
		mvo.setMpw("123abc");
		list.add(mvo);
		
		MemberVO mvo2 = new MemberVO();
		mvo2.setMseq(2);
		mvo2.setMname("사람2");
		mvo2.setMid("고생한");
		mvo2.setMpw("123abc");
		list.add(mvo2);
		
		for(int i=0; i<list.size(); i++) {
			MemberVO vo = (MemberVO) list.get(i);
			System.out.println(vo.getMseq());
			System.out.println(vo.getMname());
			System.out.println(vo.getMid());
			System.out.println(vo.getMpw());
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMseq());
		}

	}

}
