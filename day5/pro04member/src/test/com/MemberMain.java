package test.com;

import java.util.List;

public class MemberMain {

	public static void main(String[] args) {
		System.out.println("Hello Member...");
		
		//1.member table
		//2.MemberVO
		//3.MemberDAO interface <--- MemberDAOimpl
		//		selectAll,selectOne,searchList
		
		MemberDAO dao = new MemberDAOimpl();
		List<MemberVO> vos = dao.selectAll();
		System.out.println(vos);
		System.out.println(vos.size());
		
		for (MemberVO x : vos) {
			System.out.print(x.getNum()+" ");
			System.out.print(x.getId()+" ");
			System.out.print(x.getPw()+" ");
			System.out.print(x.getName()+" ");
			System.out.println(x.getTel());
		}
		
		vos.forEach(System.out::println);
		
		for (int i = 0; i < vos.size(); i++) {
			//MemberVO x = vos.get(i);
			System.out.print(vos.get(i).getNum()+" ");
			System.out.print(vos.get(i).getId()+" ");
			System.out.print(vos.get(i).getPw()+" ");
			System.out.print(vos.get(i).getName()+" ");
			System.out.println(vos.get(i).getTel());
		}
		System.out.println("======================");
		
		vos = dao.searchList("name", "ee");
//		vos = dao.searchList("tel", "02");
		System.out.println(vos);
		for (MemberVO x : vos) {
			System.out.print(x.getNum()+" ");
			System.out.print(x.getId()+" ");
			System.out.print(x.getPw()+" ");
			System.out.print(x.getName()+" ");
			System.out.println(x.getTel());
		}
		
		
		System.out.println("======================");
		MemberVO vo = new MemberVO();
		vo.setNum(5);
//		vo.setId("admin11");
//		vo.setPw("hi1111");
//		vo.setName("kim11");
//		vo.setTel("011");
		MemberVO vo2 = dao.selectOne(vo);
		System.out.println(vo2);
		
		
		System.out.println("======================");
		
		
		
		//4.jdbc driver
		//5.conn
		//6.pstmt
		//7.select >> rs >> while
		
		
	}//end main

}//end class
