package com.kosmo.test;

import com.kosmo.other.Ch07Parent;

//구현하다 : implements
public class Ch07InterfaceImpl extends Ch07Parent //implements Ch07InterfaceParent
							implements Ch07Interface, Ch07Interface2 {

	public static void main(String[] args) {
		
		
	}
	
	@Override
	public void myPrint() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int sendEmail(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void myPrint2() {
		// TODO Auto-generated method stub
		
	}

}
