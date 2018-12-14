package com.biz.common;

import java.util.ArrayList;

public interface JDBC {
	//Create : insert
	//Read : select
	//Update : update
	//Delete : delete
	public abstract ArrayList<EmpVO> empListint(String mname, Object obj);

	public abstract int empInsert(int prmEmpno, String prmEname);
	public abstract int empUpdate(int prmSal, int prmEmpno);
	public abstract int empDelete(int prmEmpno);
	public abstract int empInsertVO(EmpVO vo);
	
}
