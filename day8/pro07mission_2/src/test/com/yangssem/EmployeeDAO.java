package test.com.yangssem;

import java.util.List;

public interface EmployeeDAO {

	public List<EmployeeVO> selectAll();

	public List<EmployeeVO> searchList(String searchKey, String searchWord);

	public EmployeeVO selectOne(EmployeeVO vo);

	public List<EmployeeVO> selectDeptList(EmployeeVO vo);

	public List<EmployeeVO> searchListDeptGroupBy(String searchKey);

	public List<EmployeeVO> searchListJobGroupBy(String searchKey);

}
