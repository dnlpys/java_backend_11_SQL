package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOimpl implements MemberDAO {

	private Connection conn; // 커넥션용 객체
	private PreparedStatement pstmt; // 질의문 요청용 객체
	private ResultSet rs; // select질의문 응답객체

	private String driver_name = "oracle.jdbc.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "hr";
	private final String password = "hi123456";

	public MemberDAOimpl() {
		System.out.println("MemberDAOimpl()..");
		try {
			Class.forName(driver_name);
			System.out.println("Driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("selectAll()..");

		List<MemberVO> vos = new ArrayList<>();
		
		
		try {
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("conn successed...");
			
			pstmt = conn.prepareStatement("select * from member");

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
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
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("selectOne()..");
		System.out.println("selectOne().." + vo);

		MemberVO vo2 = new MemberVO();
		
		try {
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("conn successed...");
			
			pstmt = conn.prepareStatement(
					"select * from member where num=?");
			pstmt.setInt(1, vo.getNum());

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
				vo2.setPw(rs.getString("pw"));
				vo2.setName(rs.getString("name"));
				vo2.setTel(rs.getString("tel"));
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
		
		
		
		return vo2;
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		System.out.println("searchList()..");
		System.out.println("searchKey.." + searchKey);
		System.out.println("searchWord.." + searchWord);

		List<MemberVO> vos = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("conn successed...");
			
			String sql = "";
			if(searchKey.equals("name")) {
				sql = "select * from member where name like ?";
			}else if(searchKey.equals("tel")){
				sql = "select * from member where tel like ?";
			}
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
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

}
