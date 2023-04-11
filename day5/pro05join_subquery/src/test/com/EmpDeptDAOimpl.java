package test.com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDeptDAOimpl implements EmpDeptDAO {
	
	private Connection conn; // 커넥션용 객체
	private PreparedStatement pstmt; // 질의문 요청용 객체
	private ResultSet rs; // select질의문 응답객체

	private String driver_name = "oracle.jdbc.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "hr";
	private final String password = "hi123456";
	
	public EmpDeptDAOimpl() {
		System.out.println("EmpDeptDAOimpl()...");
		try {
			Class.forName(driver_name);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<EmpDeptVO> selectJoin() {
		System.out.println("selectJoin()...");
		List<EmpDeptVO>  vos = new ArrayList<>();
		
		
		try {
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("conn successed...");
			
			pstmt = conn.prepareStatement(
					"select e.employee_id,e.first_name,"
					+ "e.last_name,e.salary,e.hire_date,"
					+ "d.department_name "
					+ "from employees e left join departments d "
					+ "on(e.department_id=d.department_id) "
					+ "order by employee_id desc");

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDeptVO vo = new EmpDeptVO();
				vo.setEmployee_id(rs.getInt("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setSalary(rs.getInt("salary"));
				vo.setDepartment_name(rs.getString("department_name"));
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		}//end finally
		
		return vos;
	}

	@Override
	public int getTotalCount() {
		System.out.println("getTotalCount()...");
		
		int total_count = 0;
		try {
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("conn successed...");
			
			pstmt = conn.prepareStatement(
					"select count(*) cnt from employees");

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				total_count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		}//end finally
		
		return total_count;
	}

}
