package test.com.yangssem;

import java.util.List;

public class Test03Main {

	public static void main(String[] args) {
		System.out.println("Hello Test03...");

		//Employees, Departments, Jobs 3개를 조인하는 쿼리를 활용
		//select e.employee_id,j.job_title,d.department_name
//		from employees e inner join jobs j
//		on (e.job_id = j.job_id)
//		inner join departments d
//		on (d.department_id=e.department_id);
		//조인쿼리를 뷰(view_emp_dept_job)로 만들어서 selectAll하세요.
		//EmpDeptJobVO
		//EmpDeptJobDAO
		//EmpDeptJobDAOimpl
		
		EmpDeptJobDAO dao = new EmpDeptJobDAOimpl();
		List<EmpDeptJobVO> vos = dao.selectAll();
		for (EmpDeptJobVO x : vos) {
			System.out.print(x.getEmployee_id()+" ");
			System.out.print(x.getDepartment_name()+" ");
			System.out.println(x.getJob_title());
		}
		
	}//end main

}//end class
