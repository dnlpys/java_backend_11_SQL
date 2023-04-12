package test.com;

import java.util.List;

public class EmpDeptMain {

	public static void main(String[] args) {
		System.out.println("Hello EmpDept");
		
		EmpDeptDAO dao = new EmpDeptDAOimpl();
		
		List<EmpDeptVO> vos =  dao.selectJoin();
		System.out.println(vos);
		for (EmpDeptVO x : vos) {
			//System.out.println(x);
			System.out.print(x.getEmployee_id()+" ");
			System.out.print(x.getFirst_name()+" ");
			System.out.print(x.getLast_name()+" ");
			System.out.print(x.getSalary()+" ");
			System.out.print(x.getHire_date()+" ");
			System.out.println(x.getDepartment_name());
		}
		System.out.println("==================");
		vos.forEach(x->{
			System.out.print(x.getEmployee_id()+" ");
			System.out.print(x.getFirst_name()+" ");
			System.out.print(x.getLast_name()+" ");
			System.out.print(x.getSalary()+" ");
			System.out.print(x.getHire_date()+" ");
			System.out.println(x.getDepartment_name());
		});
		System.out.println("==================");
		
		
		int total_count = dao.getTotalCount();
		System.out.println("total_count:"+total_count);
		
	}//end main

}//end class
