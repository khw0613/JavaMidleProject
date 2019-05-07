package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import kr.or.ddit.ibatis.vo.boarderVO.Board_typeVO;
import library.Global;

public class ServerGet_Test {

	public static void main(String[] args) throws Exception{

		Global.DbConnect();
		System.out.println("result");
		
		
		//게시판타입 해시맵으로 만들기
		
		List<Board_typeVO> list = Global.boarderService.select_BoardType();
		
		HashMap<String, String> b_type = new HashMap<>();
		
		for(Board_typeVO ff : list) {
			b_type.put(ff.getBoard_name(), ff.getBoard_type());
		}
		
		System.out.println("선택한 게시판 번호 : " + b_type.get("취업게시판"));
		System.out.println("=================");
		
		//게시판타입 해시맵 리스트 출력
		Set<String> keySet = b_type.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + b_type.get(key));
		}
		
		
		//아이디 중복체크
		List<String> pw = Global.memberService.select_findId("신유수2", "sys0130@naver.com");
		
		//System.out.println(pw.get(0).toString());
		
		if (pw.size() == 0) {
			System.out.println("없다");
		}
	
		
		System.out.println("end2");
		
		
		int right = 5;
		// 1,2,3,4,5
		
		if ( right == 1) {
			System.out.println("관리자");
			// 관리자 Fx Show
		} else if( right == 2) {
			System.out.println("관리자2");
			// 관리자2 Fx Show
		}else if( right == 3) {
			System.out.println("반장");
			// 반장 Fx Show
		}else if( right == 4) {
			System.out.println("회원");
			// 회원 Fx Show
		}else if( right == 5) {
			System.out.println("가입대기");
			// 가입대기 Fx Show
		}
		
	}

}