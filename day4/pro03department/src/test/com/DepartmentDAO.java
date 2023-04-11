package test.com;

import java.util.List;

public interface DepartmentDAO {

	public List<DepartmentVO> selectAll();

	public DepartmentVO selectOne(DepartmentVO vo);

}
