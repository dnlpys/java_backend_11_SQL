package test.com;

import java.util.List;

public class EmpJobMain {

	public static void main(String[] args) {
		System.out.println("Hello Emp Job jon...");

		EmpJobDAO dao = new EmpJobDAOimpl();
		
		List<EmpJobVO> vos = dao.selectJoin();
		System.out.println(vos);
		
		for (EmpJobVO x : vos) {
			System.out.print(x.getEmployee_id()+" ");
			System.out.print(x.getFirst_name()+" ");
			System.out.print(x.getLast_name()+" ");
			System.out.print(x.getSalary()+" ");
			System.out.print(x.getHire_date()+" ");
			System.out.println(x.getJob_title());
		}
		
	}//end main

}//end class
