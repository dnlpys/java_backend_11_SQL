package test.com.yangssem;

import java.util.List;

public class Test02Main {

	public static void main(String[] args) {

		System.out.println("Hello Test02");

		// EmployeeDAO 기능 추가
		// searchListDeptGroupBy
		// 부서번호,결과
			// 부서별 급여합계 sum_sal
			// 부서별 급여평균 avg_sal
			// 부서별 최대급여 max_sal
			// 부서별 최소급여 min_sal
		EmployeeDAO dao = new EmployeeDAOimpl();
		System.out.println("==부서별 급여합계===sum_sal========");
		List<EmployeeVO> vos = dao.searchListDeptGroupBy("sum_sal");
		for (EmployeeVO x : vos) {
			System.out.print(x.getDepartment_id() + "\t");
			System.out.println(x.getSalary());
		}
		
		System.out.println("==부서별 급여평균===avg_sal========");
		vos = dao.searchListDeptGroupBy("avg_sal");
		for (EmployeeVO x : vos) {
			System.out.print(x.getDepartment_id() + "\t");
			System.out.println(x.getSalary());
		}		
		System.out.println("==부서별 최소급여===min_sal========");
		vos = dao.searchListDeptGroupBy("min_sal");
		for (EmployeeVO x : vos) {
			System.out.print(x.getDepartment_id() + "\t");
			System.out.println(x.getSalary());
		}		
		System.out.println("==부서별 최대급여===max_sal========");
		vos = dao.searchListDeptGroupBy("max_sal");
		for (EmployeeVO x : vos) {
			System.out.print(x.getDepartment_id() + "\t");
			System.out.println(x.getSalary());
		}		

		// searchListJobGroupBy
		// 업무코드,결과
			// 업무별 급여합계 sum_sal
			// 업무별 급여평균 avg_sal
			// 업무별 최대급여 max_sal
			// 업무별 최소급여 min_sal
		System.out.println("==업무별 급여합계===sum_sal========");
		vos = dao.searchListJobGroupBy("sum_sal");
		for (EmployeeVO x : vos) {
			System.out.print(x.getJob_id() + "\t");
			System.out.println(x.getSalary());
		}
		
		System.out.println("==업무별 급여평균===avg_sal========");
		vos = dao.searchListJobGroupBy("avg_sal");
		for (EmployeeVO x : vos) {
			System.out.print(x.getJob_id() + "\t");
			System.out.println(x.getSalary());
		}		
		System.out.println("==업무별 최소급여===min_sal========");
		vos = dao.searchListJobGroupBy("min_sal");
		for (EmployeeVO x : vos) {
			System.out.print(x.getJob_id() + "\t");
			System.out.println(x.getSalary());
		}		
		System.out.println("==업무별 최대급여===max_sal========");
		vos = dao.searchListJobGroupBy("max_sal");
		for (EmployeeVO x : vos) {
			System.out.print(x.getJob_id() + "\t");
			System.out.println(x.getSalary());
		}	
	}// end main

}// end class
