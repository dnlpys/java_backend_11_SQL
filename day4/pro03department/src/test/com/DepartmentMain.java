package test.com;

import java.util.List;

public class DepartmentMain {

	public static void main(String[] args) {
		System.out.println("Hello Department...");

		// ***java코드 + DB
		// 1.사용할 data객체(VO,DTO) 선정 >> 2.DB테이블의 행데이터를 결정

		// data 처리객체(3.인터페이스(DAO),4.클래스 상속관계(DAOimpl))
		DepartmentDAO dao = new DepartmentDAOimpl();
		// 4-1.seleceAll
		List<DepartmentVO> vos = dao.selectAll();
		System.out.println(vos);
		System.out.println(vos.size());
		for (DepartmentVO x : vos) {
			System.out.print(x.getDepartment_id()+" ");
			System.out.print(x.getDepartment_name()+" ");
			System.out.print(x.getManager_id()+" ");
			System.out.println(x.getLocation_id());
		}

		System.out.println("======================");

		// 4-2.selectOne
		DepartmentVO vo = new DepartmentVO();
		vo.setDepartment_id(10);

		DepartmentVO vo2 = dao.selectOne(vo);
		System.out.println(vo2);

		// DepartmentDAOimpl 클래스를 통해 DB와 연동하는 로직 작성
		// 연동순서(5.드라이버연결,6.커넥션,7.질의문 요청및 응답,8.예외처리)

	}// end main

}// end clas
