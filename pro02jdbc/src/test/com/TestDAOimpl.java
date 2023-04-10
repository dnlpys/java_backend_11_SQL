package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAOimpl implements TestDAO {

	private Connection conn; // 커넥션용 객체
	private PreparedStatement pstmt; // 질의문 요청용 객체
	private ResultSet rs; // select질의문 응답객체
	
	private String driver_name = "oracle.jdbc.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "hr";
	private final String password = "hi123456";

	public TestDAOimpl() {
		System.out.println("TestDAOimpl()...");
		try {
			Class.forName(driver_name);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TestVO> selectAll() {
		System.out.println("selectAll()...");

		try {
			conn = DriverManager.getConnection(
					url, 
					user, 
					password);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement("select * from test");

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("num"));
				System.out.print(rs.getString("name"));
				System.out.println(rs.getInt("age"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		List<TestVO> vos = new ArrayList<>();
		TestVO vo = new TestVO();
		vo.setNum(1);
		vo.setName("kim1");
		vo.setAge(11);
		vos.add(vo);

		vo = new TestVO();
		vo.setNum(2);
		vo.setName("kim1");
		vo.setAge(11);
		vos.add(vo);

		vo = new TestVO();
		vo.setNum(3);
		vo.setName("kim3");
		vo.setAge(11);
		vos.add(vo);

		return vos;
	}

	@Override
	public TestVO selectOne(TestVO vo) {
		System.out.println("selectOne()...");
		System.out.println(vo);

		try {
			conn = DriverManager.getConnection(
					url, 
					user, 
					password);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement("select * from test where num=3");

			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		TestVO vo2 = new TestVO();
		vo2.setNum(3);
		vo2.setName("kim3");
		vo2.setAge(11);
		System.out.println(vo2);

		return vo2;
	}

}
