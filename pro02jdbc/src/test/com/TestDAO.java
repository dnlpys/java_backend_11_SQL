package test.com;

import java.util.List;

public interface TestDAO {
	
	public List<TestVO> selectAll();
	public TestVO selectOne(TestVO vo);

}
