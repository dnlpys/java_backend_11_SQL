package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAOimpl implements EmpDAO {

	private Connection conn; // 커넥션용 객체
	private PreparedStatement pstmt; // 질의문 요청용 객체
	private ResultSet rs; // select질의문 응답객체

	private String driver_name = "oracle.jdbc.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "hr";
	private final String password = "hi123456";

	public EmpDAOimpl() {
		System.out.println("EmpDAOimpl()...");
		try {
			Class.forName(driver_name);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<EmpVO> selectSubQuery() {
		System.out.println("selectSubQuery()...");
		List<EmpVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(
					"select employee_id,first_name,last_name,"
					+ "salary,hire_date,job_id	from employees	"
					+ "where salary >	"
					+ "(select round(avg(salary)) from employees)");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmployee_id(rs.getInt("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setSalary(rs.getInt("salary"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setJob_id(rs.getString("job_id"));
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
