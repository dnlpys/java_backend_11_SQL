package test.com;

import java.util.List;

public class DepartmentDAOimpl implements DepartmentDAO {
	
	public DepartmentDAOimpl() {
		System.out.println("DepartmentDAOimpl()...");
	}

	@Override
	public List<DepartmentVO> selectAll() {
		System.out.println("selectAll()...");
		return null;
	}

	@Override
	public DepartmentVO selectOne(DepartmentVO vo) {
		System.out.println("selectOne()...");
		System.out.println("selectOne()..."+vo);
		return null;
	}

}
