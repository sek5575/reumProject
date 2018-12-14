package com.kosmo.test;


import java.util.ArrayList;

class Cart {
	public ArrayList<CartVO> cartList() {
		ArrayList<CartVO> list = new ArrayList<CartVO>();
		CartVO cvo = new CartVO();
		cvo.setCseq(1);
		cvo.setUserid("kim");
		cvo.setGcode("gcode_123456");
		cvo.setGname("상품명");
		list.add(cvo);
		return list;
	}
	
//	-- Cart class에 작성 : 상품담기
//	파라미터 : 상품코드(포맷 : gcode_6자리숫자)
//	리턴 :  성공/실패 
//	메서드 : addCart
	public boolean addCart(String gcode) {
		return true;
	}
	
//	-- Cart class에 작성 : 상품목록
//	파라미터 : userid
//	리턴 :  상품목록 
//	메서드 : cartList
	public ArrayList<CartVO> cartList(String usrid) {
		ArrayList<CartVO> list = new ArrayList<CartVO>();
		CartVO cvo = new CartVO();
		cvo.setCseq(1);
		cvo.setUserid("kim");
		cvo.setGcode("gcode_123456");
		cvo.setGname("상품명");
		list.add(cvo);
		return list;
	}
	
}
class CartVO { 	
	private int cseq; 
	private String userid; 
	private String gcode; //(상품코드) 
	private String gname; //(상품명)
	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}	
}
//--------------------------------------------------
class Pay {
	public ArrayList<PayVO> payList() {
		ArrayList<PayVO> list = new ArrayList<PayVO>();
		PayVO pvo = new PayVO();
		pvo.setPseq(1);
		pvo.setOrderno("1234567");
		pvo.setPrice(10000);
		pvo.setUserid("kim");
		list.add(pvo);
		return list;
	}
	
//-- Pay class에 작성 : 결제
//	파라미터 : 결제금액
//	리턴 :  성공/실패 
//	메서드 : pay
	public boolean pay(int price) {
		return true;
	}
	
//	-- Pay class에 작성 : 결제목록
//	파라미터 : userid
//	리턴 :  결제목록 
//	메서드 : payList
	public ArrayList<PayVO> payList(String userid) {
		ArrayList<PayVO> list = new ArrayList<PayVO>();
		PayVO pvo = new PayVO();
		pvo.setPseq(1);
		pvo.setOrderno("1234567");
		pvo.setPrice(10000);
		pvo.setUserid("kim");
		list.add(pvo);
		return list;
	}
//	-- Pay class에 작성 : 우수회원선정(사용자별 총 결제금액)
//	파라미터 : userid
//	리턴 :  총결제금액 
//	메서드 : payPrice
	public int payPrice(String userid) {
		return 50000; 
	}
}
class PayVO {
	private int pseq;
	private String userid;
	private String orderno; //(주문번호)
	private int price;		//(결제금액)
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	
}
//--------------------------------------------------
public class Quiz2 {

	//	파라미터 : Cart 또는 Pay
	//	리턴 :  payList() 또는 cartList() 호출 결과
	//	메서드 : myPageView
	public ArrayList myPageView(Object o) {
		ArrayList list = new ArrayList();
		if(o.getClass().getTypeName().equals("Cart")) {    //노이해
			Cart c = (Cart)o;
			list = c.cartList();
		} else if(o.getClass().getTypeName().equals("Pay")) {
			Pay p = (Pay)o;
			list = p.payList();
		}
		return list;
	}
	
	
	public static void main(String[] a) {
		Quiz2 quiz = new Quiz2();
		ArrayList list = quiz.myPageView(new Cart());
		System.out.println(list.size());
		
		Cart c = new Cart();
		ArrayList<CartVO> res1 = c.cartList();
		System.out.println(res1.size());
		
		boolean res2 = c.addCart("gcode_000000");
		System.out.println(res2);
		
		ArrayList<CartVO> res3 = c.cartList("kim");
		System.out.println(res3.get(0).getGname());
		
		
		Pay p = new Pay();
		ArrayList<PayVO> res4  = p.payList();
		System.out.println(res4.get(0).getPrice());
		
		
		boolean res5 = p.pay(50000);
		System.out.println(res5);
		
		ArrayList<PayVO> res6 = p.payList("kim");
		System.out.println(res6.get(0).getPrice());
		
		int res7 = p.payPrice("kim");
		System.out.println(res7);
	}

}
