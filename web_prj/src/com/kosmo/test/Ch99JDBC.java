package com.kosmo.test;

import java.util.ArrayList;

public interface Ch99JDBC {
	//Create : insert
	//Read : select
	//Update : update
	//Delete : delete
	public abstract ArrayList<EmpVO> empList(String mname, Object obj);
	public abstract ArrayList<EmpVO> empList();
	public abstract int empInsert(int prmEmpno, String prmEname);
	public abstract int empUpdate(int prmSal, int prmEmpno);
	public abstract int empDelete(int prmEmpno);
	public abstract int empInsertVO(EmpVO vo);
	
}
