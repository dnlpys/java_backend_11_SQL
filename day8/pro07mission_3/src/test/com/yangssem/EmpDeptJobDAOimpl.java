package test.com.yangssem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDeptJobDAOimpl implements EmpDeptJobDAO {
	private Connection conn; // 커넥션용 객체
	private PreparedStatement pstmt; // 질의문 요청용 객체
	private ResultSet rs; // select질의문 응답객체

	private String driver_name = "oracle.jdbc.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "hr";
	private final String password = "hi123456";

	public EmpDeptJobDAOimpl() {
		System.out.println("EmpDeptJobDAOimpl()...");
		try {
			Class.forName(driver_name);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<EmpDeptJobVO> selectAll() {
		System.out.println("selectAll()...");
		List<EmpDeptJobVO> vos = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(
					"select * from VIEW_EMP_DEPT_JOB order by employee_id");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmpDeptJobVO vo = new EmpDeptJobVO();
				vo.setEmployee_id(rs.getInt("employee_id"));
				vo.setDepartment_name(rs.getString("department_name"));
				vo.setJob_title(rs.getString("job_title"));
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
		} // end finally
		
		return vos;
	}

}
