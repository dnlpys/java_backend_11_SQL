package test.com;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class EmpMain {

	public static void main(String[] args) {
		System.out.println("Hello Emp");

		// employees테이블을 데이터포함 복제해서 emp 테이블을 만들고
		// EmpVO에 있는 속성과 관련된 컬럼만 복제할것.
		// 입력,수정,삭제,모두검색,검색어검색,번호검색

//		GregorianCalendar gcal = new GregorianCalendar(2020, 11, 25);
//		System.out.println(gcal.get(Calendar.YEAR));
//		System.out.println(gcal.get(Calendar.MONTH));
//		System.out.println(gcal.get(Calendar.DAY_OF_MONTH));
//		java.sql.Date hire_date = new Date(gcal.getTimeInMillis());
//		System.out.println(hire_date);
//		EmpVO vo = new EmpVO();
//		vo.setHire_date(hire_date);

		EmpDAO dao = new EmpDAOimpl();

		EmpVO vo = new EmpVO();
		vo.setEmployee_id(100);
		EmpVO vo2 = dao.selectOne(vo);
		System.out.print(vo2.getEmployee_id() + "\t");
		System.out.print(vo2.getFirst_name() + "\t");
		System.out.print(vo2.getLast_name() + "\t");
		System.out.print(vo2.getSalary() + "\t");
		System.out.print(vo2.getHire_date() + "\t");
		System.out.println(vo2.getJob_id());

		System.out.println("==========================");
//		vo = new EmpVO();
//		vo.setFirst_name("Gildong");
//		vo.setLast_name("Hong");
//		vo.setSalary(5000);
//		GregorianCalendar gcal = new GregorianCalendar(2023, 3, 12);
//		Date hire_date = new Date(gcal.getTimeInMillis());
//		vo.setHire_date(hire_date);
//		vo.setJob_id("AC_MGR");
//		int result = dao.insert(vo);
//		System.out.println("result:"+result);

//		System.out.println("==========================");
//
//		vo = new EmpVO();
//		vo.setEmployee_id(208);
//		vo.setFirst_name("Gildong3");
//		vo.setLast_name("Hong3");
//		vo.setSalary(15000);
//		GregorianCalendar gcal = new GregorianCalendar(2022, 3, 12);
//		Date hire_date = new Date(gcal.getTimeInMillis());
//		vo.setHire_date(hire_date);
//		vo.setJob_id("AC_ACCOUNT");
//		int result = dao.update(vo);
//		System.out.println("result:" + result);
		
		
		System.out.println("==========================");

		vo = new EmpVO();
		vo.setEmployee_id(208);
		int result = dao.delete(vo);
		System.out.println("result:" + result);
		
		System.out.println("==========================");
		
		List<EmpVO> vos = dao.selectAll();
		for (EmpVO x : vos) {
			System.out.print(x.getEmployee_id() + "\t");
			System.out.print(x.getFirst_name() + "\t");
			System.out.print(x.getLast_name() + "\t");
			System.out.print(x.getSalary() + "\t");
			System.out.print(x.getHire_date() + "\t");
			System.out.println(x.getJob_id());
		}
		System.out.println("==========================");

		vos = dao.searchList("fname", "St");
//		vos = dao.searchList("job_id", "AC");
		for (EmpVO x : vos) {
			System.out.print(x.getEmployee_id() + "\t");
			System.out.print(x.getFirst_name() + "\t");
			System.out.print(x.getLast_name() + "\t");
			System.out.print(x.getSalary() + "\t");
			System.out.print(x.getHire_date() + "\t");
			System.out.println(x.getJob_id());
		}
		
		List<ViewEmpDeptVO> vos_view = dao.selectView();//comm : null >> 0으로 표기할것
		for (ViewEmpDeptVO x : vos_view) {
			System.out.print(x.getEmpno() + "\t");
			System.out.print(x.getFname() + "\t");
			System.out.print(x.getDeptno() + "\t");
			System.out.print(x.getDname() + "\t");
			System.out.print(x.getSal() + "\t");
			System.out.println(x.getComm());
		}
	}// end main

}// end class
