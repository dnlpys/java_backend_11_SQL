package test.com.yangssem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAO {
	
	private Connection conn; // 커넥션용 객체
	private PreparedStatement pstmt; // 질의문 요청용 객체
	private ResultSet rs; // select질의문 응답객체

	private String driver_name = "oracle.jdbc.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "hr";
	private final String password = "hi123456";

	public EmployeeDAOimpl() {
		System.out.println("EmployeeDAOimpl()...");
		try {
			Class.forName(driver_name);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<EmployeeVO> selectAll() {
		System.out.println("selectAll()...");
		List<EmployeeVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement("select * from employees order by employee_id desc");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmployee_id(rs.getInt("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setSalary(rs.getInt("salary"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setCommission_pct(rs.getDouble("commission_pct"));
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

	@Override
	public List<EmployeeVO> searchList(String searchKey, String searchWord) {
		System.out.println("searchList()...");
		System.out.println("searchKey..." + searchKey);
		System.out.println("searchWord..." + searchWord);
		List<EmployeeVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn successed...");

			String sql = "";
			if (searchKey.equals("first_name")) {
				sql = "select * from employees where first_name like ? order by employee_id desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + searchWord + "%");
			} else {
				sql = "select * from employees where salary = ? order by employee_id desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(searchWord));

			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmployee_id(rs.getInt("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setSalary(rs.getInt("salary"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setDepartment_id(rs.getInt("department_id"));
				vo.setCommission_pct(rs.getDouble("commission_pct"));
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

	@Override
	public EmployeeVO selectOne(EmployeeVO vo) {
		System.out.println("selectOne()..."+vo);

		EmployeeVO vo2 = new EmployeeVO();

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement("select * from employees where employee_id = ?");
			pstmt.setInt(1, vo.getEmployee_id());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2.setEmployee_id(rs.getInt("employee_id"));
				vo2.setFirst_name(rs.getString("first_name"));
				vo2.setLast_name(rs.getString("last_name"));
				vo2.setEmail(rs.getString("email"));
				vo2.setSalary(rs.getInt("salary"));
				vo2.setHire_date(rs.getDate("hire_date"));
				vo2.setDepartment_id(rs.getInt("department_id"));
				vo2.setCommission_pct(rs.getDouble("commission_pct"));
				vo2.setJob_id(rs.getString("job_id"));
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

		return vo2;
	}

	@Override
	public List<EmployeeVO> selectDeptList(EmployeeVO vo) {
		System.out.println("selectDeptList()..."+vo.getDepartment_id());
		List<EmployeeVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement("select * from employees where department_id=? order by employee_id desc");
			pstmt.setInt(1, vo.getDepartment_id());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeVO vo2 = new EmployeeVO();
				vo2.setEmployee_id(rs.getInt("employee_id"));
				vo2.setFirst_name(rs.getString("first_name"));
				vo2.setLast_name(rs.getString("last_name"));
				vo2.setEmail(rs.getString("email"));
				vo2.setSalary(rs.getInt("salary"));
				vo2.setHire_date(rs.getDate("hire_date"));
				vo2.setDepartment_id(rs.getInt("department_id"));
				vo2.setCommission_pct(rs.getDouble("commission_pct"));
				vo2.setJob_id(rs.getString("job_id"));
				vos.add(vo2);
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

	@Override
	public List<EmployeeVO> searchListDeptGroupBy(String searchKey) {
		System.out.println("searchListDeptGroupBy()...");
		System.out.println("searchKey..." + searchKey);
		List<EmployeeVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn successed...");

			String sql = "";
			if (searchKey.equals("sum_sal")) {
				sql = "select department_id , sum(salary) salary "
						+ "from employees group by department_id";
			} else if (searchKey.equals("avg_sal")) {
				sql = "select department_id , floor(avg(salary)) salary "
						+ "from employees group by department_id";
			}else if (searchKey.equals("min_sal")) {
				sql = "select department_id , min(salary) salary "
						+ "from employees group by department_id";
			}else if (searchKey.equals("max_sal")) {
				sql = "select department_id , max(salary) salary "
						+ "from employees group by department_id";
			}  
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setSalary(rs.getInt("salary"));
				vo.setDepartment_id(rs.getInt("department_id"));
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

	@Override
	public List<EmployeeVO> searchListJobGroupBy(String searchKey) {
		System.out.println("searchListJobGroupBy()...");
		System.out.println("searchKey..." + searchKey);
		List<EmployeeVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn successed...");

			String sql = "";
			if (searchKey.equals("sum_sal")) {
				sql = "select job_id , sum(salary) salary "
						+ "from employees group by job_id";
			} else if (searchKey.equals("avg_sal")) {
				sql = "select job_id , floor(avg(salary)) salary "
						+ "from employees group by job_id";
			}else if (searchKey.equals("min_sal")) {
				sql = "select job_id , min(salary) salary "
						+ "from employees group by job_id";
			}else if (searchKey.equals("max_sal")) {
				sql = "select job_id , max(salary) salary "
						+ "from employees group by job_id";
			}  
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setSalary(rs.getInt("salary"));
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
