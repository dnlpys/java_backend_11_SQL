package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOimpl implements DepartmentDAO {
	
	private Connection conn; // 커넥션용 객체
	private PreparedStatement pstmt; // 질의문 요청용 객체
	private ResultSet rs; // select질의문 응답객체
	
	private String driver_name = "oracle.jdbc.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "hr";
	private final String password = "hi123456";
	
	public DepartmentDAOimpl() {
		System.out.println("DepartmentDAOimpl()...");
		try {
			Class.forName(driver_name);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DepartmentVO> selectAll() {
		System.out.println("selectAll()...");
		List<DepartmentVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(
					url, 
					user, 
					password);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement("select * from departments");

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DepartmentVO vo = new DepartmentVO();
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setManager_id(rs.getInt("manager_id"));
				vo.setLocation_id(rs.getInt("location_id"));
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
	public DepartmentVO selectOne(DepartmentVO vo) {
		System.out.println("selectOne()...");
		System.out.println("selectOne()..."+vo);
		
		DepartmentVO vo2 = new DepartmentVO();
		
		try {
			conn = DriverManager.getConnection(
					url, 
					user, 
					password);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(
					"select * from departments where department_id=?");
			pstmt.setInt(1, vo.getDepartment_id());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo2.setDepartment_id(rs.getInt("department_id"));
				vo2.setDepartment_name(rs.getString("department_name"));
				vo2.setManager_id(rs.getInt("manager_id"));
				vo2.setLocation_id(rs.getInt("location_id"));
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
