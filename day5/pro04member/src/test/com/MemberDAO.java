package test.com;

import java.util.List;

public interface MemberDAO {

	public List<MemberVO> selectAll();

	public MemberVO selectOne(MemberVO vo);

	public List<MemberVO> searchList(String searchKey, String searchWord);

}
