package test.com;

public class TestMain {

	public static void main(String[] args) {
		
		System.out.println("Hello...jdbc");
		
		//***java코드 + DB
		//1.사용할 data객체(VO,DTO) 선정 >> 2.DB테이블의 행데이터를 결정
		TestDAO dao = new TestDAOimpl();
		//data 처리객체(3.인터페이스(DAO),4.클래스 상속관계(DAOimpl))
		//상속받은 클래스를 통해 DB와 연동하는 로직 작성
		//	연동순서(5.드라이버연결,6.커넥션,7.질의문요청및 응답,8.예외처리)
		
		
	}//end main

}//end class
