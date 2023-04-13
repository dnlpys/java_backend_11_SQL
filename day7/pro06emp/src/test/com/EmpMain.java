package test.com;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class EmpMain {

	public static void main(String[] args) {
		System.out.println("Hello Emp");
		
		//employees테이블을 데이터포함 복제해서 emp 테이블을 만들고
		//EmpVO에 있는 속성과 관련된 컬럼만 복제할것.
		//입력,수정,삭제,모두검색,검색어검색,번호검색
		
		GregorianCalendar gcal = new GregorianCalendar(2020, 11, 25);
//		System.out.println(gcal.get(Calendar.YEAR));
//		System.out.println(gcal.get(Calendar.MONTH));
//		System.out.println(gcal.get(Calendar.DAY_OF_MONTH));
		java.sql.Date hire_date = new Date(gcal.getTimeInMillis());
		System.out.println(hire_date);
		EmpVO vo = new EmpVO();
		vo.setHire_date(hire_date);
		
		EmpDAO dao = new EmpDAOimpl();
		List<EmpVO> vos = dao.selectAll();
		for (EmpVO x : vos) {
			System.out.print(x.getEmployee_id() + "\t");
			System.out.print(x.getFirst_name() + "\t");
			System.out.print(x.getLast_name() + "\t");
			System.out.print(x.getSalary() + "\t");
			System.out.print(x.getHire_date() + "\t");
			System.out.println(x.getJob_id());
		}
		
//		vos = dao.searchList("fname", "St");
		vos = dao.searchList("job_id", "AC");
		for (EmpVO x : vos) {
			System.out.print(x.getEmployee_id() + "\t");
			System.out.print(x.getFirst_name() + "\t");
			System.out.print(x.getLast_name() + "\t");
			System.out.print(x.getSalary() + "\t");
			System.out.print(x.getHire_date() + "\t");
			System.out.println(x.getJob_id());
		}
		
	}//end main

}//end class
