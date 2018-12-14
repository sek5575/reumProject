package com.kosmo.test;

public class Del {

	private int point;       //프로퍼티 property   -->지금 프로퍼티는 2개
	private String nation;   //전역변수의 내용을 넣다 뺏다하는 용도.
							//private는 다른 클래스에서 못쓴다.
	
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	
}
