package test.com;

import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		
		System.out.println("Hello...jdbc");
		
		//***java코드 + DB
		//1.사용할 data객체(VO,DTO) 선정 >> 2.DB테이블의 행데이터를 결정
		
		
		//data 처리객체(3.인터페이스(DAO),4.클래스 상속관계(DAOimpl))
		//4-1.seleceAll
		//4-2.selectOne
		TestDAO dao = new TestDAOimpl();
		List<TestVO> vos = dao.selectAll();
		System.out.println(vos);
		
		TestVO vo = new TestVO();
		vo.setNum(5);
		
		TestVO vo2 = dao.selectOne(vo);
		System.out.println(vo2);
		
		//상속받은 클래스를 통해 DB와 연동하는 로직 작성
		//	연동순서(5.드라이버연결,6.커넥션,7.질의문 요청및 응답,8.예외처리)
		
//		C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
		//ojdbc6.jar 파일복사
		//프로젝트 우클리>new>folder>lib : ojdcb6.jar파일 붙여넣기
		//ojdcb6.jar파일 우클릭 Build path >> Add to build path
		
	}//end main

}//end class
