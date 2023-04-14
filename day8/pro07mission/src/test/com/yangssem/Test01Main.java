package test.com.yangssem;

import java.util.List;

public class Test01Main {

	public static void main(String[] args) {
		System.out.println("Hello Test01");

		//employees 테이블을 사용하여 작성할것.
		//모든 사원들의 모든 컬럼의 정보를 selectAll
		//first_name 으로 유사검색어 검색 searchList
		//salary 로 검색 searchList
		//사원번호로 검색 selectOne
		//부서번호로 검색 selectDeptList
		//EmployeeVO, EmployeeDAO, EmployeeDAOimpl
		//2:20 까지 슬랙 업로드 박윤수선생님 전송
		
		EmployeeDAO dao = new EmployeeDAOimpl();
		
		List<EmployeeVO> vos = dao.selectAll();
		for (EmployeeVO x : vos) {
			System.out.print(x.getEmployee_id() + "\t");
			System.out.print(x.getFirst_name() + "\t");
			System.out.print(x.getLast_name() + "\t");
			System.out.print(x.getEmail() + "\t");
			System.out.print(x.getSalary() + "\t");
			System.out.print(x.getHire_date() + "\t");
			System.out.print(x.getDepartment_id() + "\t");
			System.out.print(x.getCommission_pct() + "\t");
			System.out.println(x.getJob_id());
		}
		
		
		vos = dao.searchList("first_name","St");
//		vos = dao.searchList("salary","8300");
		for (EmployeeVO x : vos) {
			System.out.print(x.getEmployee_id() + "\t");
			System.out.print(x.getFirst_name() + "\t");
			System.out.print(x.getLast_name() + "\t");
			System.out.print(x.getEmail() + "\t");
			System.out.print(x.getSalary() + "\t");
			System.out.print(x.getHire_date() + "\t");
			System.out.print(x.getDepartment_id() + "\t");
			System.out.print(x.getCommission_pct() + "\t");
			System.out.println(x.getJob_id());
		}
		
		System.out.println("===selectOne=============");
		
		EmployeeVO vo = new EmployeeVO();
		vo.setEmployee_id(100);
		EmployeeVO vo2 = dao.selectOne(vo);
		System.out.print(vo2.getEmployee_id() + "\t");
		System.out.print(vo2.getFirst_name() + "\t");
		System.out.print(vo2.getLast_name() + "\t");
		System.out.print(vo2.getEmail() + "\t");
		System.out.print(vo2.getSalary() + "\t");
		System.out.print(vo2.getHire_date() + "\t");
		System.out.print(vo2.getDepartment_id() + "\t");
		System.out.print(vo2.getCommission_pct() + "\t");
		System.out.println(vo2.getJob_id());
		
		System.out.println("===selectDeptList=============");
		vo = new EmployeeVO();
		vo.setDepartment_id(30);
		vos = dao.selectDeptList(vo);
		for (EmployeeVO x : vos) {
			System.out.print(x.getEmployee_id() + "\t");
			System.out.print(x.getFirst_name() + "\t");
			System.out.print(x.getLast_name() + "\t");
			System.out.print(x.getEmail() + "\t");
			System.out.print(x.getSalary() + "\t");
			System.out.print(x.getHire_date() + "\t");
			System.out.print(x.getDepartment_id() + "\t");
			System.out.print(x.getCommission_pct() + "\t");
			System.out.println(x.getJob_id());
		}
	}//end main

}//end class
