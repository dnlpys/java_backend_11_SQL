package test.com;

import java.util.List;

public interface EmpDeptDAO {

	public List<EmpDeptVO> selectJoin();

	public int getTotalCount();
	
}
