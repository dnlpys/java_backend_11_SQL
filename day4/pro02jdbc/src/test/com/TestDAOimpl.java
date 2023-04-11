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

		List<TestVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(
					url, 
					user, 
					password);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement("select * from test");

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				System.out.print(rs.getInt("num"));
//				System.out.print(rs.getString("name"));
//				System.out.println(rs.getInt("age"));
				TestVO vo = new TestVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vos.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return vos;
	}

	@Override
	public TestVO selectOne(TestVO vo) {
		System.out.println("selectOne()...");
		System.out.println(vo);

		TestVO vo2 = new TestVO();
		try {
			conn = DriverManager.getConnection(
					url, 
					user, 
					password);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(
					"select * from test where num=?");
			pstmt.setInt(1, vo.getNum());

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				System.out.print(rs.getInt("num"));
//				System.out.print(rs.getString("name"));
//				System.out.println(rs.getInt("age"));
				vo2.setNum(rs.getInt("num"));
				vo2.setName(rs.getString("name"));
				vo2.setAge(rs.getInt("age"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


		return vo2;
	}

}
