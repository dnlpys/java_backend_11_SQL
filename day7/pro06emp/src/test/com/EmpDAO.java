package test.com;

import java.util.List;

public interface EmpDAO {

	public List<EmpVO> selectAll();

	public EmpVO selectOne(EmpVO vo);

	public List<EmpVO> searchList(String searchKey, String searchWord);

	public int insert(EmpVO vo);

	public int update(EmpVO vo);

	public int delete(EmpVO vo);

}
