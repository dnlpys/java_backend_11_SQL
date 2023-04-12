package test.com;

import java.util.List;

public class EmpMain {

	public static void main(String[] args) {
		System.out.println("Hello Emp sub query");

		// EmpVO
		// EmpDAO <--- EmpDAOimpl
		// selectSubQuery() : List<EmpVO>
		/*
		 * select employee_id,first_name,last_name,salary,hire_date,job_id from
		 * employees where salary > (select round(avg(salary)) from employees);
		 */

		EmpDAO dao = new EmpDAOimpl();
		List<EmpVO> vos = dao.selectSubQuery();
		System.out.println(vos);
		for (EmpVO x : vos) {
			System.out.print(x.getEmployee_id() + " ");
			System.out.print(x.getFirst_name() + " ");
			System.out.print(x.getLast_name() + " ");
			System.out.print(x.getSalary() + " ");
			System.out.print(x.getHire_date() + " ");
			System.out.println(x.getJob_id());
		}

	}// end main

}// end class
