package com.biz.common;

import java.util.ArrayList;

public class JDBCCall {
	
//	public searchColum() {
//		
//	}
//	ArrayList<EmpVO> list = t.empList();

	public static void main(String[] args) {
//		Ch99JDBCImpl t = new Ch99JDBCImpl();
//		ArrayList<EmpVO> list1 = t.empList(7369);   //int[] arr = {1,2,3};  똑같이 선언과 동시에 값을 할당 한 것이다.  new 선언해도 된다.
//		ArrayList<EmpVO> list = t.empList("ename", "ALLEN");
		
//		System.out.println(list1.size());
		
//		for(int i=0; i<list1.size(); i++) {
//			System.out.print(list1.get(i).getDeptno()+ "\t");
//			System.out.print(list1.get(i).getEmpno()+ "\t");
//			System.out.print(list1.get(i).getEname()+ "\t");
//			System.out.print(list1.get(i).getHiredate()+ "\t");
//			System.out.print(list1.get(i).getJob()+ "\t");
//			System.out.println(list1.get(i).getSal());
//		}
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.print(list.get(i).getDeptno()+ "\t");
//			System.out.print(list.get(i).getEmpno()+ "\t");
//			System.out.print(list.get(i).getEname()+ "\t");
//			System.out.print(list.get(i).getHiredate()+ "\t");
//			System.out.print(list.get(i).getJob()+ "\t");
//			System.out.println(list.get(i).getSal());
//		}
		
//		int delRes = t.empDelete(prmEmpno)
//		
//		int insRes = t.empInsert(5124, "망아지");
//		System.out.println(insRes+"건 입력");
//		
//		int uptRes = t.empUpdate(500, 4568);
//		System.out.println(uptRes+"건 수정");
//		
//		int delRes = t.empDelete(4568);
//		System.out.println(delRes+"건 삭제");
		
//		EmpVO vo = new EmpVO();
//		vo.setEmpno(9998);
//		vo.setEname("체인지");
//		t.empUpdateVO(vo);
//		t.empDeleteVO(vo);
		
//		int insRes = t.empInsertVO(vo);
//		System.out.println(insRes+"건 입력");
//		
//		
//		for(int i=0;i<list.size();i++) {
//			EmpVO evo = list.get(i);
//		}
//		for(EmpVO evo : list) {  //위와 같다.
//			
//			System.out.println(evo.getEname());
//		}
		
		
//		System.out.println(list.size());
		
		Ch99JDBCImpl t = new Ch99JDBCImpl();
//		ArrayList<EmpVO> list = t.Select("ename", "ALLEN");
//		
//		
//		for(int i=0; i<list.size(); i++) {
//			System.out.print(list.get(i).getEmpno()+ "\t");
//			System.out.print(list.get(i).getEname()+ "\t");
//			System.out.println(list.get(i).getJob());
//		}
		EmpVO vo = new EmpVO();
		vo.setEmpno(9997);
		
//		t.Insert(9997, "아무개");
		t.Delete(vo);
		
		
	}

}
