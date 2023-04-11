package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpJobDAOimpl implements EmpJobDAO {
	
	
	private Connection conn; // 커넥션용 객체
	private PreparedStatement pstmt; // 질의문 요청용 객체
	private ResultSet rs; // select질의문 응답객체

	private String driver_name = "oracle.jdbc.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "hr";
	private final String password = "hi123456";
	
	public EmpJobDAOimpl() {
		System.out.println("EmpJobDAOimpl()...");
		try {
			Class.forName(driver_name);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public List<EmpJobVO> selectJoin() {
		System.out.println("selectJoin()...");
		
		List<EmpJobVO> vos = new ArrayList<>();
		
		
		try {
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("conn ok...");
			
			pstmt = conn.prepareStatement(
					"select e.employee_id,e.first_name,e.last_name,e.salary,e.hire_date,"
					+ "j.job_title "
					+ "from employees e join jobs j "
					+ "on(e.job_id=j.job_id) "
					+ "order by employee_id desc");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpJobVO vo = new EmpJobVO();
				vo.setEmployee_id(rs.getInt("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setSalary(rs.getInt("salary"));
				vo.setJob_title(rs.getString("job_title"));
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return vos;
	}

}
