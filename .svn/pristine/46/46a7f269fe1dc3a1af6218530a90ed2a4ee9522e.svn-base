package kr.or.ddit.basic;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import kr.or.ddit.ibatis.vo.hilightVO.Pen_managementVO;
import kr.or.ddit.ibatis.vo.restaurantVO.Resmenu_daysVO;
import library.Global;


public class ServerGet {
	public static void main(String[] args) throws Exception{

		Global.DbConnect();
		System.out.println("result");	/////////////////////////////////////////////////////////
		
		
//		1. 아이디 중복체크
//		System.out.println(Global.memberService.idCheck("admin"));
		
//		2. 파라미터로 회원아이디를 주면해당 아이디에 대한 정보를 가져오는 메서드 에요.
//		Global.memberService.selectOne("ljw1234");
		
//		2-1. 기수로 회원 검색
//		List<MemberVO> list = Global.memberService.search_member_to_degree("201809");
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getMem_id() + "	" + list.get(i).getMem_name());
//		}
		
//		2-2. 등급(권한)으로 회원 검색
//		List<MemberVO> list = Global.memberService.search_member_to_rightcode("1");
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getMem_id() + "	" + list.get(i).getMem_name());
//		}
		
//		2-3. 호수로 회원 검색
//		List<MemberVO> list = Global.memberService.search_member_to_class("206");
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getMem_id() + "	" + list.get(i).getMem_name());
//		}
		
//		2-4. 회원 등급(권한)변경 (관리자 기능)
		/*MemberVO vo = new MemberVO();
		vo.setMem_id("ljw1234");
		vo.setRight_code("4");
		int parameter = Global.memberService.update_member_reght(vo);
		System.out.println(parameter);*/
		
//		2-5. 등급(권한)으로 회원 검색
//		List<MemberVO> list = Global.memberService.search_member_to_rightcode("1");
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getMem_id() + "	" + list.get(i).getMem_name());
//		}
		
//		3. 통합게시판 모든 정보 가져오기
//		List<BoardVO> list = Global.boarderService.select_boardList("1");
//		System.out.println(list);
		
//		4.기수별 게시판 데이터 불러오기 (pram1 : 게시판 타입 //pram2 : 회원 기수)
		
		/*List<BoardVO> list = Global.boarderService.select_boardList_degree("4", "201810");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("현재시간 :" + list.get(0).getBoard_date());
		}*/
		
		
//		5. 메뉴 전체 출력하기
//		List<Resmenu_daysVO> list  = Global.resMenuService.selectList();
		
//		6. 월별 메뉴 출력하기 (파라미터 : 연도월 까지만 [6자리] )
//		List<Resmenu_daysVO> list  = Global.resMenuService.selectList_month("201901");		
//		System.out.println(list.get(0).getRes_no());
		
//		7. 일별 메뉴 츌력하기
//		List<Resmenu_daysVO> list  = Global.resMenuService.select_menuList_day("20190103");
//		System.out.println(list.get(0).getRes_no());
		
		
//		8. 메뉴 추가하기
		
		/*Resmenu_daysVO rvo = new Resmenu_daysVO();
		rvo.setRes_order_date("20190115");
		rvo.setRes_no("a001");
		rvo.setMenu_soup("두부된장국");
		rvo.setMenu_1("치즈돈까스");
		rvo.setMenu_2("동그랑땡");
		rvo.setMenu_3("맛살볶음");
		rvo.setMenu_4("감자채볶음");
		rvo.setMenu_5("김치");
		rvo.setOrder_check("1");
		rvo.setRes_price("3500");
		
		int cnt = 0;
		cnt = Global.resMenuService.insert_menu(rvo);
		System.out.println(cnt + "  개 메뉴 추가");*/
		
		
//		9. 회원정보 수정하기
		
		/*MemberVO vo = new MemberVO();
		vo.setEmail("goo8455@naver.com");
		vo.setMem_id("goo8455");
		vo.setAccount("110-304-645522");
		vo.setBank("신한은행");
		vo.setTelno("010-5366-8455");
		vo.setAcnt_owner("장구현");
		vo.setMem_name("장구현");
		Global.memberService.updateMemberInfo(vo);*/
		
		
//		10.회원정보 삭제하기 
//		Global.memberService.deleteMemberInfo("sys3");
		

//		11. 아이디 찾기 (1번 파라미터 : 이름 // 2번 파라미터 : 이메일)
//		System.out.println(Global.memberService.select_findId("한상호", "dlstpdlem@naver.com"));
		
		
//		12. 비밀번호 찾기 (1번 파라미터 : 아이디 // 2번 파라미터 : 이메일)
//		System.out.println(Global.memberService.select_findPwd("hsh0611", "dlstpdlem@naver.com"));
		
		
		
//		13. 개인 방명록 데이터 가져오기 (파라미터 : 받은 사람  <=  현재 로그인된 사람의 아이디)
		/*List<Persnal_boardVO> list = Global.persnalBoardService.select_guestBook("hsh0611");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getPb_guestbook_no());
		}*/
		
		
//		14. 개인 게시판 게시글 번호 증가
//		Global.memberService.update_pb_post_no("admin");
		 
		
//		15. 방명록 게시글 번호 증가
//		Global.memberService.update_pb_guestbook_no("admin");
		 
		
//		16. 공통 게시글 가져오기
		
		/*BoardVO vo = new BoardVO();
		vo.setBoard_type("2");
		vo.setBoard_no("2");
		
		List<BoardVO> list = Global.boarderService.select_common_post(vo); 
		for(BoardVO dd : list) {
			System.out.println( dd.getBoard_contents());
		}*/
		
		
		
//		17. 기수별 게시판 게시글 가져오기
		
		/*BoardVO vo = new BoardVO();
		vo.setBoard_no("777");
		
		List<BoardVO> list = Global.boarderService.select_degree_post(vo);
		for(BoardVO dd : list) {
			System.out.println(dd.getBoard_no());
			 System.out.println(dd.getBoard_contents());
		 }*/
		 
		
		
//		18.공통게시판 게시글 정보 데이터베이스에 삽입하기
		
		/*BoardVO vo = new BoardVO();
		vo.setBoard_type("1");
		vo.setMem_id("ljw1234");
		vo.setBoard_title("현욱 테스트");
		vo.setBoard_contents("시퀀스");
		Global.boarderService.insert_common_post(vo);*/
		
		
		
//		19.게시판 게시글 정보 데이터베이스에 삽입하기
		
		/*BoardVO vo = new BoardVO();
		vo.setBoard_type("4");				// 게시판 타입
		vo.setMem_id("ljw1234");			// 작성자 아이디
		vo.setBoard_title("글쓰기테스트A");		// 제목		
		vo.setBoard_contents("글쓰기테스트A");			// 내용
		vo.setBoard_image("");				// 첨부파일 (NULL 허용)
		Global.boarderService.insert_post(vo);*/
		
		
		
		
		
//		20. 게시물 정보 수정하기
		
		/*BoardVO vo = new BoardVO();
		vo.setBoard_title("강현욱 테스트");
		vo.setBoard_contents("테스트11");
		vo.setBoard_no("31");
		Global.boarderService.update_post(vo);*/
		
		
		
		
//		21. 게시물 삭제하기 
//		int parameter = Global.boarderService.delete_post("87");
//		System.out.println(parameter);
		
		
		
		
		
		
//		22. 조회수 업데이트 하기
		/*Global.boarderService.update_viewCount("32");
		
		List<PayVO> list = Global.payService.select_PayList();
		for(PayVO payVO : list) {
			System.out.println(payVO.getMem_id());
		}
		
		Global.payService.select_myPayInfo("goo8455");*/
		
		
		
		
//		23. 개인 방명록 가져오기
		/*List<Persnal_boardVO> list = Global.persnalBoardService.select_guestBook("hsh0611");
		for(Persnal_boardVO dd : list) {
			 System.out.println(dd.getPb_contents());
		}*/
		
//		24. 개인게시판 정보 가져오기
		
		/*List<Persnal_boardVO> list = Global.persnalBoardService.select_PersnalBoardList("sys0130");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getPb_post_no() + "	" + list.get(i).getPb_title() + "	" + list.get(i).getPb_contents() + "	" + list.get(i).getMem_id());
		}*/
		
//		25. 개인게시판 게시글 정보 가져오기
		/*List<Persnal_boardVO> list = Global.persnalBoardService.select_PersnalBoard_post("81");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getPb_post_no());
			System.out.println(list.get(i).getPb_title());
			System.out.println(list.get(i).getPb_contents());
			System.out.println(list.get(i).getReceive_id());
		}*/
		

		
		
//		28. 개인게시판 게시글 수정하기
//		Persnal_boardVO vo = new Persnal_boardVO();
//		vo.setPb_title("수정 황수정 크리스탈");
//		vo.setPb_contents("이글은 수정화되었다리");
//		vo.setPb_no("143");
//		
//		int parameter = Global.persnalBoardService.update_PersnalBoard_post(vo);
//		System.out.println(parameter);
		
//		29. 방명록 수정하기
		/*Persnal_boardVO vo = new Persnal_boardVO();
		vo.setPb_contents("피로 회복엔 우루사!! update문을 사용하여 수정하였습니다.");
		vo.setPb_no("68");
		
		int parameter = Global.persnalBoardService.update_GuestBook_post(vo);
		System.out.println(parameter);*/
		
//		30. 개인게시판 게시글 삭제하기(작동 안합니다. 서버문제일수도 있습니다. DB에서 쿼리는 에러없이 작동합니다.)
//		int parameter = Global.persnalBoardService.delete_PersnalBoard_post("91");
//		System.out.println(parameter);
		
//		31. 후원 정보 전체 가져오기
		/*List<Surpport_penVO> list = Global.supportPenService.select_SupportList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getSupport_cnt());
			System.out.println(list.get(i).getMem_id());
			System.out.println(list.get(i).getReceive_id());
			System.out.println(list.get(i).getPen_code());
		}*/
		
//		32. 내가 준 후원정보 조회하기 ( 파라미터 : 누가 후원했는가? // mem_id가 들어가는거에요. )
//		List<Surpport_penVO> list = Global.supportPenService.select_GiveInfo("goo8455");
//		System.out.println(list.get(0).getSupport_cnt());
		
//		33. 내가 받은 후원정보 조회하기 (파라미터 : 현재 로그인 된 아이디를 넣어주세요 // mem_id가 들어가는거에요. )
//		List<Surpport_penVO> list = Global.supportPenService.select_ReceiveInfo("ljw1234");
//		System.out.println(list.get(0).getSupport_no());
		
		
//		34. 형광펜 후원하기 (파라미터 : 로그인된 아이디(mem_id) // 후원할 수량 // 받는사람 아이디(receive_id) ) 
//		 1을 리턴받으면 후원하기 성공 이에요
		/*Surpport_penVO vo = new Surpport_penVO();
		vo.setMem_id("goo8455");
		vo.setSupport_cnt("500");
		vo.setReceive_id("hsh0611");
		vo.setPen_code("1");
		int cnt = Global.supportPenService.insert_SupportInfo(vo);
		System.out.println(cnt);*/
		
		

//		35. 형광펜 수량 감소하기 (1번 파라미터 : 회원 아이디 // 2번 파라미터 : 사용한 수량)
//		Global.supportPenService.subtration_myPen_Quantity2("goo8455", "500");

		
//		36. 형광펜 수량 증가 (1번 파라미터 : 회원 아이디 // 2번 파라미터 : 받은 수량)
//		Global.supportPenService.addition_myPen_Quantity2("hsh0611", "500");
		
		
		
		
//		37. 형광펜 결제정보(전체정보)
		/*List<PayVO> list = Global.payService.select_PayList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getPay_no());
		}*/
		
//		38. 형광펜 결제정보(회원별 정보 >> 파라미터 : 회원 아이디)
		/*List<PayVO> list = Global.payService.select_myPayInfo("goo8455");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getPay_cnt());
		}
		System.out.println(list.get(0).getPay_cnt());*/
		
		
//		39. 형광펜 결제하기(insert >> 파라미터 : payVO)
		/*PayVO vo = new PayVO();
		vo.setMem_id("hsh0611");
		vo.setPay_cnt("1000");
		vo.setPay_type_no("1");
		vo.setPen_code("1");
		Global.payService.insert_PayInfo(vo);*/

//		40. 결제된 형광펜 갯수 만큼 회원의 형광펜 수량 더하기(update >> 파라미터1 : 회원 아이디, 파라미터2 : 충전수량 >> 맵으로 넘겨줌)
//		Global.payService.addition_myPen_Quantity("hsh0611", "1000");
		
//		41. 로그인 정보 저장하기
//		int cnt = Global.logWindowService.insert_LogInfo("hsh0611");
//		System.out.println(cnt);
		
		//42. 로그인 정보 가져오기
		/*List<String> id = Global.logWindowService.select_LogInfo();
		for(int i = 0; i < id.size(); i++) {
			System.out.println(id.get(i).toString());
		}*/
		
//		43. 로그인 정보 삭제하기
//		Global.logWindowService.delete_LogInfo("ljw1234");
		
//		41 ~ 43 확인 못해봤습니다만 메인에서 사용중이므로 문제없다고 판단하겠습니다리
		
//		44. 모든 환불정보 조회하기
		/*List<RefundVO> list = Global.refundService.select_RefundList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMem_id());
			System.out.println(list.get(i).getRefund_no());
			System.out.println(list.get(i).getPen_code());
			System.out.println(list.get(i).getRefund_cnt());
		}*/
		
//		45. 회원별 환불정보 조회하기
//		List<RefundVO> list = Global.refundService.select_myRefundInfo("goo8455");
//		System.out.println(list.get(0).getPay_no());
		
//		46. 형광펜 환불하기
		/*RefundVO vo = new RefundVO();
		vo.setMem_id("goo8455");
		vo.setPay_no("61");
		vo.setRefund_type_code("1");
		vo.setPen_code("1");
		vo.setRefund_cnt("1500");
		Global.refundService.insert_RefundInfo(vo);*/
		
		
//		47. 회원 형광펜 수량 업데이트 하기(환불에 의한 감소)
//													   환불금액, 아이디
//		Global.refundService.subtration_myPen_Quantity("1500", "goo8455");
		
		
		//	*****주의사항  : 장문의 테스트문은 /* */로 묶어주세요!!
		//				  단문의 테스트문은  ****행 시작부분에 주석처리(//) 해주세요!!
		
		
//		48. 댓글 데이터 전체 조회하기
		/*List<Board_commentVO> list = Global.boardCommentService.select_listComment();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getComment_no());
		}*/
		
//		49. 댓글 데이터 조회하기 = 게시글 번호 별
		/*List<Board_commentVO> list = Global.boardCommentService.select_listCommentInboardNo("264");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getComment_no());
		}*/
		
//		50. 댓글 작성하기
		/*Board_commentVO vo = new Board_commentVO();
		vo.setBoard_no("102");										 // !! 댓글 달 게시글 번호 	!!
		vo.setMem_id("goo8455");									 // !! 현재 로그인 된 아이디 !!
		vo.setComment_contents("댓글 입력 테스트입니다요3");			 // !! 작성 내용 			!!
		int cnt = Global.boardCommentService.insert_comment(vo);*/
		
//		51. 댓글 삭제하기 ( 파라미터로 댓글번호를 입력해주세요 )
//		int cnt = Global.boardCommentService.delete_comment("23");
//		System.out.println("댓글  " + cnt + "개 가 삭제되었습니다.");
		
		
		
//		52. 댓글 수정하기 (파라미터 : 변경할 내용 // 변경할 댓글의 번호)
		
		/*Board_commentVO vo = new Board_commentVO();
		vo.setComment_contents("iBatis를 활용하여 수정한 댓글입니다.");	
		vo.setComment_no("24");
		int cnt = Global.boardCommentService.update_comment(vo);
		System.out.println(cnt + " 개 수정");*/
		
		
		//53. 작성자로 게시물 검색 (파라미터가 2개입니다. mem_id, board_type을 vo에 담아서 넘겨주세요.)
		/*BoardVO vo = new BoardVO();
		vo.setMem_id("ljw1234");
		vo.setBoard_type("5");
		List<BoardVO> list1 =  Global.boarderService.search_post_to_id(vo);
		for(int i = 0; i<list1.size(); i++) {
			System.out.println(list1.get(i).getBoard_title());
		}*/
		
		
		//54. 글번호로 게시물 검색
		
		/*List<BoardVO> list =  Global.boarderService.search_post_to_no("103");
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).getMem_id());
		}*/
		
		//55. 제목으로 게시물 검색(파라미터가 2개입니다. board_title, board_type을 vo에 담아서 넘겨주세요.)
		/*BoardVO vo = new BoardVO();
		vo.setBoard_title("우리들");
		vo.setBoard_type("2");
		List<BoardVO> list =  Global.boarderService.search_post_to_title(vo);
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).getBoard_no());
		}*/
//		56. 제목+내용으로 게시물 검색(파라미터가 3개입니다. board_title, board_contents, board_type을 vo에 담아서 넘겨주세요.
//								단, 쿼리에서 or조건을 사용했기 때문에 board_title과 board_contents에 들어가는 내용이 같게 세팅해주세요. 동적쿼리를 내다버린 저때문에... 죄송합니다...)
		/*BoardVO vo = new BoardVO();
		vo.setBoard_title("잡힘");
		vo.setBoard_contents("잡힘");
		vo.setBoard_type("3");
		List<BoardVO> list =  Global.boarderService.search_post_to_titleAndcontents(vo);
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).getBoard_no());
		}*/
		
		//57. 출석정보 삽입(상호형 이거 보시면 String으로 받아서 넣는걸로 고쳐주세요 제발 ㄷㄷ...에러나서 못하겠어열...)
		
		/*AttendanceVO vo = new AttendanceVO();
		vo.setMem_id("ljw1234");
		Global.attendanceService.insert_AttendanceInfo(vo);*/
		
		
		//58. 전체 출석정보 조회
		/*List<AttendanceVO> list = Global.attendanceService.select_AttendanceList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMem_id() + "	" + list.get(i).getDays_check() + "	" + list.get(i).getDays_date());
		}*/
		
		//59. 내 출석정보 조회
		
		/*List<AttendanceVO> list = Global.attendanceService.select_AttendanceInfo("ljw1234");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getDays_date() + "	" +list.get(i).getDays_check());
		}*/
		
		
		
		// 60. 비밀번호 변경
		
		/*MemberVO vo = new MemberVO();
		vo.setMem_id("goo8455");		// 키 값
		vo.setMem_pwd("qwe123");		// 변경할 비밀번호
		Global.memberService.updateMemberInfoPwd(vo);*/
		
		
//		61. 개인게시판 댓글 전부 가져오기
		/*List<Board_pb_commentVO> list = Global.pbBoardCommentService.select_pblistComment();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getPb_comment_no() + "	" + list.get(i).getPb_comment_contents());
		}*/
		
		
//		62. 게시글 번호 별 댓글 가져오기 
		/*List<Board_pb_commentVO> list2 = Global.pbBoardCommentService.select_pblistCommentInboardNo("5");
		for(int i=0; i<list2.size(); i++) {
			System.out.println(list2.get(i).getPb_comment_no()+ "	" + list2.get(i).getMem_id() + "	" +list2.get(i).getPb_comment_contents());
		}*/
		
//		63. 게시판 유형 가져오기
//		List<Board_typeVO> list = Global.boarderService.select_BoardType();
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getBoard_name());
//		}
		
//		64. 전체 환전정보 조회
		/*List<ExchangeVO> list = Global.exchangeService.select_ExchangeList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getExchange_no()+"	"+list.get(i).getMem_id()+"	"+list.get(i).getExchange_cnt());
		}*/
		

//		65. 회원별 환불정보 조회(내 환불정보 보기)
//		List<ExchangeVO> list = Global.exchangeService.select_ExchangeInfo("goo8455");
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getExchange_no()+"	"+list.get(i).getExchange_cnt()+"	"+list.get(i).getExchange_date());
//		}
		
//		66. 환전정보 삽입
		
		/*ExchangeVO vo = new ExchangeVO();
		vo.setMem_id("goo8455");
		vo.setExchange_cnt("1500");
		Global.exchangeService.insert_ExchangeInfo(vo);*/
		

//		67. 개인게시판 댓글 작성하기(2개씩 insert됩니다. 보류 - 문제되는 부분을 아직 못찾았습니다.)
		/*Board_pb_commentVO vo = new Board_pb_commentVO();
		vo.setPb_no("48");										// 개인 게시글 번호
		vo.setMem_id("goo8455");								// 작성자 아이디
		vo.setPb_comment_contents("하나씩만 입력될거야...분명히!!");				// 내용
		int cnt = Global.pbBoardCommentService.insert_pbcomment(vo);
		System.out.println(cnt);*/
		

//		68. 회원 형광펜 수량 업데이트 하기(환전에 의한 감소-주는 회원)
//		Global.exchangeService.subtration_myPen_Quantity3("100", "goo8455");
		
//		69. 게시판 타입 가져오기
//		List<Board_typeVO> list = Global.boarderService.select_OneBoardType("자유게시판");
//		System.out.println(list.get(0).getBoard_type());
		
				
		
//		70. 쪽지 보내기(데이터 삽입)(보낸 아이디(mem_id), 내용(msg_contents), 받는 아이디(receive_id)만 세팅해서 넣어주세요.)
		
		/*MessageBoxVO vo = new MessageBoxVO();
		vo.setMem_id("goo8455");
		vo.setMsg_contents("삭제예정");
		vo.setReceive_id("sys0130");
		Global.messageBoxService.insert_MessageInfo(vo);*/
		
//		71. 전체쪽지 조회하기
		
		/*List<MessageBoxVO> list = Global.messageBoxService.select_MessageList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMsg_no() + "	" + list.get(i).getMem_id() + "	" + list.get(i).getReceive_id() + "	" 
					+ list.get(i).getMsg_contents() + "	" + list.get(i).getMsg_date());
		}*/
		
//		72. 보낸쪽지 조회하기(mem_id를 로그인한 회원의 아이디로 해주셔야 합니다.)
		
		/*List<MessageBoxVO> list = Global.messageBoxService.select_sendMessageInfo("goo8455");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMsg_no() + "	" + list.get(i).getReceive_id() + "	" + list.get(i).getMsg_contents() + "	" + list.get(i).getMsg_date());
		}*/
		
//		73. 받은쪽지 조회하기(receive_id를 로그인한 회원의 아이디로 해주셔야 합니다.)
		
		/*List<MessageBoxVO> list = Global.messageBoxService.select_receiveMessageInfo("goo8455");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMsg_no() + "	" + list.get(i).getMem_id() + "	" + list.get(i).getMsg_contents() + "	" + list.get(i).getMsg_date());
		}*/
		
//		74. 쪽지 삭제 (쪽지 번호(msg_no)를 입력받아 해당 쪽지를 삭제시킵니다.)
//		Global.messageBoxService.delete_MessageInfo("");
		
		
//		75. 도시락 월 별 주문내역 조회하기
		
		/*OrderVO vo = new OrderVO();
		vo.setMem_id("sys0130");				// 조회할 아이디
		vo.setRes_order_date("201901");			// 조회할 월(년월까지만 입력해주세요!)
		List<OrderVO> list2 = Global.orderService.select_memOrder(vo);
		for(int i=0; i<list2.size(); i++) {
			System.out.println(list2.get(i).getOrder_code());
		}*/
		
		
		
//		76. 주문내역 전체 조회하기
		/*List<OrderVO> list2 = Global.orderService.select_order();
		for(int i=0; i<list2.size(); i++) {
			System.out.println(list2.get(i).getOrder_code());
		}*/
		
		
//		77. 날짜별 주문 조회하기
		
		/*OrderVO vo = new OrderVO();
		vo.setMem_id("goo8455");					// 조회할 아이디
		vo.setRes_order_date("20190103");			// 조회할 날짜(년월일 전체를 입력해주세요!)
		List<OrderVO> list2 = Global.orderService.select_orderday(vo);
		for(int i=0; i<list2.size(); i++) {
			System.out.println(list2.get(i).getOrder_code());
		}*/
		
		
//		78. 주문하기
		
		/*OrderVO vo = new OrderVO();
		vo.setMem_id("sys0130");
		vo.setRes_order_date("20190103");
		Global.orderService.insert_order(vo);*/
		
	
		
//		79. 주문 취소하기
		
		/*OrderVO vo = new OrderVO();
		vo.setOrder_code("13");				// 삭제할 주문코드
		int cnt = Global.orderService.delete_order(vo);
		System.out.println(cnt + " : 개 주문이 취소되었습니다.");*/
		
		
		
//		80. 권한테이블 조회
		/*
		List<RightVO>list = Global.memberService.select_Right();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getRight_code());
			System.out.println(list.get(i).getRight_name());
		}*/
		
//		81. 개인 게시판 유형 조회
		/*
		List<Persnal_board_typeVO> list = Global.persnalBoardService.select_PBtype();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getPersnal_board_no());
			System.out.println(list.get(i).getPersnal_board_type());
		}*/
		
//		82. 게시판 유형명에 따른 개인게시판 유형 검색
		
		/*List<Persnal_board_typeVO> list = Global.persnalBoardService.select_OnePBtype("방명록");
		System.out.println(list.get(0).getPersnal_board_type());
		System.out.println(list.get(0).getPersnal_board_no());*/
		
//		83. 읽지않은 쪽지 전체를 조회 
		/*List<MessageBoxVO> list = Global.messageBoxService.select_allUnreadMessage("ljw1234");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMsg_no()+ "	" +list.get(i).getMsg_contents());
		}*/
		
//		84. 읽은 쪽지 전체 조회
		/*List<MessageBoxVO> list = Global.messageBoxService.select_allReadMessage("ljw1234");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMsg_no()+ "	" +list.get(i).getMsg_contents());
		}*/
		
//		85. 쪽지 상세조회
		/*List<MessageBoxVO> list = Global.messageBoxService.select_ReadMessage("6");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMsg_no()+ "	" +list.get(i).getMsg_contents());
		}*/
		
//		86. read상태 수정
//		int cnt = Global.messageBoxService.updae_ReadMessage("6");
//		System.out.println(cnt+"행 수정 완료");
		
//		87. 회원 전체정보 조회
		/*List<MemberVO> list = Global.memberService.select_MemberList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMem_id());
		}*/
		
		
//		88. 방명록 작성
		/*List<MemberVO> list = Global.memberService.selectOne("goo8455");
		String login_id = list.get(0).getMem_id();
		String guestbook_no = list.get(0).getPb_guestbook_no();
		
		Persnal_boardVO pvo = new Persnal_boardVO();

		pvo.setMem_id(login_id);
		String mem_id = pvo.getMem_id();
		
		pvo.setPb_contents("꼬르륵 소리가 어마어마 하시네요 행님!");
		String pb_contents = pvo.getPb_contents();

		pvo.setReceive_id("ljw1234");
		String receive_id = pvo.getReceive_id();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("pb_guestbook_no", guestbook_no);
		map.put("mem_id", mem_id);
		map.put("pb_contents", pb_contents);
		map.put("receive_id", receive_id);
		
		int parameter = Global.persnalBoardService.insert_GuestBook_post(map);
		System.out.println(parameter);*/
		
		
//		89. 개인 게시판 게시글 작성
		/*List<MemberVO> list = Global.memberService.selectOne("hsh0611");
		String login_id = list.get(0).getMem_id();
		String guestbook_no = list.get(0).getPb_guestbook_no();
		
		Persnal_boardVO pvo = new Persnal_boardVO();

		pvo.setMem_id(login_id);
		String mem_id = pvo.getMem_id();
		
		pvo.setPb_title("죠졌어");
		String pb_title = pvo.getPb_title();

		pvo.setPb_contents("쿼리 잘못 짯나봐 이상해...");
		String pb_contents = pvo.getPb_contents();

		pvo.setReceive_id(login_id);
		String receive_id = pvo.getReceive_id();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("pb_guestbook_no", guestbook_no);
		map.put("mem_id", mem_id);
		map.put("pb_title", pb_title);
		map.put("pb_contents", pb_contents);
		map.put("receive_id", receive_id);
		
		int parameter = Global.persnalBoardService.insert_PersnalBoard_post(map);
		System.out.println(parameter);*/

//		90. 개인 게시판 작성 시 작성한 회원(=홈페이지 주인)의 pb_post_no 업데이트(+1) >>>> receive_id = 홈페이지 주인(개인 게시판 작성 권한은 홈페이지 주인에게만 있습니다.) 
//		int parameter2 = Global.memberService.update_pb_post_no("hsh0611");
//		System.out.println(parameter2);
		
//		91.방명록 작성시 홈페이지 주인의 pb_guestbook_no 업데이트(+1) >>>> receive_id = 홈페이지 주인(방명록 작성 권한은 홈페이지 주인을 제외한 모든 회원입니다.)
//		int parameter2 = Global.memberService.update_pb_guestbook_no("ljw1234");
//		System.out.println(parameter2);
		
		// -------- 주의사항 : 개인홈페이지 에서 작성기능을 사용할 경우 90번, 91번 기능을 꼭 함께 사용해주셔야 합니다 !!!
		//					방명록 작성 시에는 91번 기능, 개인 게시판 작성 시에는 90번 기능을 꼭 함께 사용해주세요. 
		//					같은 글 번호를 가진 게시물이 삽입됩니다.
		//					insert메서드 호출 후 update 메서드를 꼭 호출해주세요 !!!
		
//		92. 업체정보 삽입
		/*RestaurantVO vo = new RestaurantVO();
		vo.setRes_no("a002");
		vo.setRes_name("틈메이러도시락");
		vo.setRes_telno("050-123-1234");
		
		int parameter = Global.restaurantService.insert_RestaurantInfo(vo);
		System.out.println(parameter);*/
		
//		93. 전체 업체정보 조회
		/*List<RestaurantVO> list = Global.restaurantService.select_RestaurantList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getRes_no() + "	" + list.get(i).getRes_name());
		}*/
		
//		94. 특정 업체정보 조회
//		List<RestaurantVO> list = Global.restaurantService.select_RestaurantInfo("a001");
//		System.out.println(list.get(0).getRes_name() + "	" + list.get(0).getRes_telno());
		
//		95. 업체정보 검색(이름으로 검색)
		/*List<RestaurantVO> list = Global.restaurantService.search_Restaurant("대전");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getRes_name() + "	" + list.get(i).getRes_telno());
		}*/
		
//		96. 업체정보 수정
		/*RestaurantVO vo = new RestaurantVO();
		vo.setRes_no("a002");
		vo.setRes_name("틈메이러");
		vo.setRes_telno("123-456-7890");
		
		int parameter = Global.restaurantService.update_RestaurantInfo(vo);
		System.out.println(parameter);*/
		
//		97. 업체정보 삭제
//		Global.restaurantService.delete_RestaurantInfo("a003");
		
//		98. 일별(오늘 or ...) 전체회원 출석 현황 조회
		
		/*List<AttendanceVO> list = Global.attendanceService.select_TodayAttendanceList(mTime.replaceAll("[.]", ""));
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getDays_check() + "	"+ list.get(i).getDays_date());
		}*/
		
//		99. 회원의 월별 출석 현황 조회
		/*AttendanceVO vo = new AttendanceVO();
		vo.setDays_date("201901");
		vo.setMem_id("goo8455");
		List<AttendanceVO> list = Global.attendanceService.select_MonthAttendanceInfo(vo);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getDays_check() + "	"+ list.get(i).getDays_date());
		}*/
		
//		100. 업체별 식단표 정보 가져오기 
		/*List<Resmenu_daysVO> list = Global.resMenuService.select_RestaurantMenuList("a001");
		for(int i=0; i<list.size(); i++) {
			System.out.println("국 : " + list.get(i).getMenu_soup());
		}*/
		
//		101. 업체별 월 식단표 정보 가져오기
		/*Resmenu_daysVO vo = new Resmenu_daysVO();
		vo.setRes_order_date("201901");
		vo.setRes_no("a001");
		
		List<Resmenu_daysVO> list = Global.resMenuService.select_RestaurantmenuList_month(vo);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getRes_order_date() + "	:	반찬 1 - " +list.get(i).getMenu_1());
		}*/
		
//		102. 업체별 일 식단표 정보 가져오기

		/*Resmenu_daysVO vo = new Resmenu_daysVO();
		vo.setRes_order_date("20190114");
		vo.setRes_no("a001");
		
		List<Resmenu_daysVO> list = Global.resMenuService.select_RestaurantmenuList_day(vo);
		System.out.println("반찬 1 - " + list.get(0).getMenu_1());*/
		
//		103. 주문/환불 전체조회
		/*List<OrderVO> list = Global.orderService.select_OrdertypeList("1");
		for(int i=0; i<list.size(); i++) {
			System.out.println("주문번호  : "+list.get(i).getOrder_code());
		}*/
		
//		104. 주문/환불 년 or 년월 or 년월일 전체조회
		/*OrderVO vo = new OrderVO();
		vo.setOrder_type("1");
		vo.setRes_order_date("201901");
		List<OrderVO> list = Global.orderService.select_OrdertypeListDate(vo);
		for(int i=0; i<list.size(); i++) {
			System.out.println("주문번호  : "+list.get(i).getOrder_code());
		}*/
		
//		105. 회원의 주문+환불 전체 조회
		/*List<OrderVO> list = Global.orderService.select_MemberOrderInfo("goo8455");
		for(int i=0; i<list.size(); i++) {
			System.out.println("주문번호  : "+list.get(i).getOrder_code());
		}*/

//		106. 회원의 주문/환불 전체조회
		/*OrderVO vo = new OrderVO();
		vo.setMem_id("hsh0611");
		vo.setOrder_type("1");
		List<OrderVO> list = Global.orderService.select_MemberOrdertypeInfo(vo);
		for(int i=0; i<list.size(); i++) {
			System.out.println("주문번호  : "+list.get(i).getOrder_code());
		}*/
//		int cnt = Global.faqService.insertFAQ("111", "2222");
//		System.out.println(cnt);
		
//		107. 회원의 주문/환불 년 or 년월 or 년월일 전체 조회
		/*OrderVO vo = new OrderVO();
		vo.setMem_id("goo8455");
		vo.setOrder_type("1");
		vo.setRes_order_date("201901");
		List<OrderVO> list = Global.orderService.select_MemberOrdertypeInfoDate(vo);
		for(int i=0; i<list.size(); i++) {
			System.out.println("주문번호  : "+list.get(i).getOrder_code());
		}*/
		
//		108. 회원의 업체별 주문+환불 전체 조회 
		/*OrderVO vo = new OrderVO();
		vo.setMem_id("goo8455");
		vo.setRes_no("a001");
		List<OrderVO> list = Global.orderService.select_ResMemberOrderInfo(vo);
		for(int i=0; i<list.size(); i++) {
			System.out.println("주문번호  : "+list.get(i).getOrder_code());
			System.out.println("유      형   : "+list.get(i).getOrder_type());
		}*/
		
//		109. 회원의 업체별 주문/환불 전체 조회
		/*OrderVO vo = new OrderVO();
		vo.setMem_id("hsh0611");
		vo.setRes_no("a002");
		vo.setOrder_type("1");
		List<OrderVO> list = Global.orderService.select_ResMemberOrdertypeInfo(vo);
		for(int i=0; i<list.size(); i++) {
			System.out.println("주문번호  : "+list.get(i).getOrder_code());
		}*/
		
//		110. 회원의 업체별 주문/환불 년 or 년월 or 년월일 전체 조회
		/*OrderVO vo = new OrderVO();
		vo.setMem_id("hsh0611");
		vo.setRes_no("a001");
		vo.setOrder_type("1");
		vo.setRes_order_date("201901");
		List<OrderVO> list = Global.orderService.select_ResMemberOrdertypeInfoDate(vo);
		for(int i=0; i<list.size(); i++) {
			System.out.println("주문번호  : "+list.get(i).getOrder_code());
		}*/
		
//		111. 개인 게시판 게시글 조회수 업데이트(게시판기능 조회수와 동일하게 사용해주세요.)
//		int parameter = Global.persnalBoardService.update_PostViewCount("143");
//		System.out.println(parameter + "행 업데이트 완료");
		
//		112. 환불하기(기존의 주문정보에서 order_type을 2로 변경)
//		int parameter = Global.orderService.update_Ordertype("65");
//		System.out.println(parameter);
		
//		113. 형광펜 사용내역정보 삽입
		/*Pen_managementVO vo = new Pen_managementVO();
		vo.setUse_type("1");
		vo.setPen_type("1");
		vo.setPen_cnt("2000");
		vo.setMem_id("goo8455");
		vo.setReceive_id("");
		
		int parameter = Global.pen_managementService.insert_UsepenInfo(vo);
		System.out.println(parameter);*/
		
//		114. 결제 상세정보 추출(형광펜 사용관리에 필요) + 115. 형광펜 사용관리 정보삽입(결제)
		/*List<PayVO> list = Global.payService.select_PayDetailInfo("23");
		String mem_id	= list.get(0).getMem_id();
		String pen_type = list.get(0).getPay_type_no();
		String pen_cnt 	= list.get(0).getPay_cnt();
		String use_date = list.get(0).getPay_date();
		
		
		System.out.println(mem_id + "	" + pen_type + "	" + pen_cnt + " " + use_date);
		
		Pen_managementVO vo = new Pen_managementVO();
		vo.setMem_id(mem_id);
		vo.setPen_type(pen_type);
		vo.setPen_cnt(pen_cnt);
		vo.setUse_date(use_date);
		
		int parameter = Global.pen_managementService.insert_UsetypePay(vo);*/
		
//		116. 형광펜 환불 상세정보 추출(형광펜 사용관리에 필요) + 117. 형광펜 사용관리 정보삽입(환불)
		/*RefundVO rvo = new RefundVO();
		rvo.setRefund_no("42");
		rvo.setPay_no("23");
		
		List<RefundVO> list = Global.refundService.select_RefundDetailInfo(rvo);
		String mem_id 		= list.get(0).getMem_id();
		String pen_type 	= list.get(0).getPen_code();
		String pen_cnt 		= list.get(0).getRefund_cnt();
		String use_date		= list.get(0).getRefund_date();
		
		System.out.println(mem_id + "	" + pen_type + "	" + pen_cnt + "	" + use_date);
		
		Pen_managementVO pvo = new Pen_managementVO();
		pvo.setMem_id(mem_id);
		pvo.setPen_type(pen_type);
		pvo.setPen_cnt(pen_cnt);
		pvo.setUse_date(use_date);
		
		int parameter = Global.pen_managementService.insert_UsetypeRefund(pvo);
		System.out.println(parameter);*/
		
//		118. 형광펜 환전 상세정보 추출(형광펜 사용관리에 필요) + 119. 형광펜 사용관리 정보삽입(환전)
		/*ExchangeVO evo = new ExchangeVO();
		evo.setExchange_cnt("500");
		evo.setMem_id("goo8455");
		evo.setPen_code("1");
		
		int parameter = Global.exchangeService.insert_ExchangeInfo(evo);
		System.out.println("parameter : "+parameter);
		
		List<ExchangeVO> user = Global.exchangeService.select_ExchangeInfo("goo8455");
		int idx = user.size() - 1;
		String exchange_no = user.get(idx).getExchange_no();
		List<ExchangeVO> list = Global.exchangeService.select_ExchangeDetailInfo(exchange_no);
		list.get(0).getExchange_cnt();
		list.get(0).getExchange_no();
		list.get(0).getPen_code();
		list.get(0).getExchange_date();
		
		System.out.println(list.get(0).getPen_code() + "	" +list.get(0).getMem_id() + "	" + list.get(0).getExchange_cnt() + "	" + list.get(0).getExchange_date());
		
		String mem_id = list.get(0).getMem_id();
		String pen_type = list.get(0).getPen_code();
		String pen_cnt = list.get(0).getExchange_cnt();
		String use_date = list.get(0).getExchange_date();
		
		Pen_managementVO pvo = new Pen_managementVO();
		pvo.setMem_id(mem_id);
		pvo.setPen_type(pen_type);
		pvo.setPen_cnt(pen_cnt);
		pvo.setUse_date(use_date);
		
		int parameter1 = Global.pen_managementService.insert_UsetypeExchange(pvo);
		System.out.println("parameter1 : "+parameter1);*/
		
		
//		120. 형광펜 후원 상세정보 추출(형광펜 사용관리에 필요) + 121. 형광펜 사용관리 정보삽입(후원)
		/*List<Surpport_penVO> list = Global.supportPenService.select_SupportDetailInfo("22");
		System.out.println(list.get(0).getSupport_no() + "	" + list.get(0).getMem_id() + "	" + list.get(0).getSupport_cnt() + "	" + list.get(0).getSupport_date());
		String mem_id = list.get(0).getMem_id();
		String pen_type = list.get(0).getPen_code();
		String pen_cnt = list.get(0).getSupport_cnt();
		String receive_id = list.get(0).getReceive_id();
		String use_date = list.get(0).getSupport_date();
		
		Pen_managementVO pvo = new Pen_managementVO();
		pvo.setMem_id(mem_id);
		pvo.setPen_type(pen_type);
		pvo.setPen_cnt(pen_cnt);
		pvo.setReceive_id(receive_id);
		pvo.setUse_date(use_date);
		
		int parameter = Global.pen_managementService.insert_UsetypeSupport(pvo);
		System.out.println(parameter);*/
		
//		122. 전체회원의 형광펜 활용정보 목록 
		/*List<Pen_managementVO> list = Global.pen_managementService.select_UsePenList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getManagement_no() + "	" + list.get(i).getUse_date());
		}*/
		
//		123. 회원별 형광펜 활용정보 목록
		/*List<Pen_managementVO> list = Global.pen_managementService.select_MemberUsePenList("goo8455");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getManagement_no() + "	" + list.get(i).getUse_date());
		}*/
		
//		124. 회원별 형광펜 결제정보 목록
		/*List<Pen_managementVO> list = Global.pen_managementService.select_MemberPayPenList("goo8455");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getManagement_no() + "	" + list.get(i).getUse_date());
		}*/
		
//		125. 회원별 형광펜 환불정보 목록
		/*List<Pen_managementVO> list = Global.pen_managementService.select_MemberRefundPenList("goo8455");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getManagement_no() + "	" + list.get(i).getUse_date());
		}*/
		
//		126. 회원별 형광펜 환전정보 목록
		/*List<Pen_managementVO> list = Global.pen_managementService.select_MemberExchangePenList("goo8455");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getManagement_no() + "	" + list.get(i).getUse_date());
		}*/
		
//		127. 회원별 형광펜 후원 한 정보 목록
		/*List<Pen_managementVO> list = Global.pen_managementService.select_MemberSupportPenList("goo8455");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getManagement_no() + "	" + list.get(i).getUse_date());
		}*/
		
//		128. 회원별 형광펜 후원받은 정보 목록
		/*List<Pen_managementVO> list = Global.pen_managementService.select_MemberReceivePenList("hsh0611");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getManagement_no() + "	" + list.get(i).getUse_date());
		}*/
		
//		---------------------------------형광펜 사용관리 테이블을 사용하는 기능은 정보 삽입, 목록출력만 있습니다.
//		---------------------------------결제, 환불, 환전, 후원 상세정보를 보여주는 기능은 이미 구현해두어서 중복되기 때문에 뺐습니다.
//		---------------------------------주석 풀고 메서드 기능 확인하시고 난 뒤 꼭 다시 주석 걸어주세요!******************
		
//		회원의 전체 결제정보 
//		List<PayVO> pay_list = Global.payService.select_myPayInfo("goo8455");
//		int a = pay_list.size()-1;
//		System.out.println(list.get(a).getPay_no());
//		String pay_no = pay_list.get(a).getPay_no();
//		System.out.println(pay_no);
//		List<PayVO> pay_info = Global.payService.select_PayDetailInfo(pay_no);
//		System.out.println(pay_info.get(0).getPay_no()  );
//		System.out.println(pay_info.get(0).getMem_id()  );
//		System.out.println(pay_info.get(0).getPen_code()  );
//		System.out.println(pay_info.get(0).getPay_cnt()  );
//		System.out.println(pay_info.get(0).getPay_date()  );
		
//		String pen_type	 = pay_info.get(0).getPen_code();
//		String mem_id	 = pay_info.get(0).getMem_id();
//		String pen_cnt	 = pay_info.get(0).getPay_cnt();
//		String use_date	 = pay_info.get(0).getPay_date();
		
		//129. 회원 아바타 수정(이미지  경로 or 랜덤변수에 의한 색상 변경)
		/*MemberVO vo = new MemberVO();
		vo.setAvatar("");
		vo.setMem_id("goo8455");
		
		int parameter = Global.memberService.update_member_avatar(vo);
		System.out.println(parameter);*/
		
		//130. 회원 프로필 사진 수정
		/*MemberVO vo = new MemberVO();
		vo.setMem_image("1");
		vo.setMem_id("goo8455");
		
		int parameter = Global.memberService.update_member_image(vo);
		System.out.println(parameter);
		*/
		
//		PayVO payVO = new PayVO();
//		payVO.setMem_id("hsh0611");
//		payVO.setPay_cnt("200");
//		payVO.setPay_type_no("1");
//		payVO.setPen_code("1");
//		Global.payService.insert_PayInfo(payVO); // 결제

//		List<PayVO> pay_list = Global.payService.select_myPayInfo("goo8455"); 
//
//		int a = pay_list.size() - 1;
//
//		String get_pay_no = pay_list.get(a).getPay_no();
//		System.out.println(get_pay_no);

//		List<PayVO> get_payInfo = Global.payService.select_PayDetailInfo(get_pay_no);
//
//		String pen_type = get_payInfo.get(0).getPen_code();
//		String pen_cnt = get_payInfo.get(0).getPay_cnt();
//		String mem_id = get_payInfo.get(0).getMem_id();
//		String use_date = get_payInfo.get(0).getPay_date();
//
//		Pen_managementVO manageVO = new Pen_managementVO();
//		manageVO.setMem_id(mem_id);
//		manageVO.setPen_cnt(pen_cnt);
//		manageVO.setUse_date(use_date);
//		manageVO.setPen_type(pen_type);
//
//		int parameter = Global.pen_managementService.insert_UsetypePay(manageVO);
		
		/*List<MemberVO> list = Global.memberService.search_member_to_name("장");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMem_id());
		}*/
	      
		
//		관리자용 회원 목록 출력
//		List<MemberVO> list = Global.memberService.select_adminUse_memberList();
//		System.out.println(list.get(0).getMem_id() + "	" + list.get(0).getRight_code() + "	" + list.get(0).getRight_name());

//		관리자용 회원검색(회원 등급명으로 검색)
//		List<MemberVO> list = Global.memberService.search_adminUse_memberRight("반장");
//		System.out.println(list.get(0).getRight_name());
		
		/*List<Pen_managementVO> list = Global.pen_managementService.select_MemberUsePenList("goo8455");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getUse_name());
		}*/
		
		/*List<MemberVO> list = Global.memberService.select_MemberList();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getRight_name());
		}*/
		
		/*Pen_managementVO useVO = new Pen_managementVO();
		useVO.setMem_id("goo8455");
		useVO.setReceive_id("goo8455");
		List<Pen_managementVO> list = Global.pen_managementService.select_MemberUsePenList(useVO);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getUse_date() + "	" + list.get(i).getManagement_no());
		}*/
		
		//Global.pen_managementService.select_MemberExchangePenList("goo8455");
		
		
		//영소문자 + 숫자 조합의 랜덤 비밀번호 생성(8자리)
		/*String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		uuid = uuid.substring(0, 8);
		System.out.println(uuid);*/
		
		/*List<MemberVO> classPre = Global.memberService.selectOne("sys0130"); //접속한 회원(반장일 때만)의 정보를 list에 저장
		
		String get_degree = classPre.get(0).getDegree(); //저장된 정보에서 degree를 추출
		
		List<MemberVO> degreeMember = Global.memberService.search_member_to_degree("201809"); //추출한 degree로 회원 검색(같은 기수를 검색)
		for(int i=0; i<degreeMember.size(); i++) {
			//콤보박스에 같은 기수 회원을 세팅
			System.out.println(degreeMember.get(i).getDegree() + "_" + degreeMember.get(i).getMem_name() + "(" + degreeMember.get(i).getMem_class() + "호)");
		}
		
		String mem_id = degreeMember.get(5).getMem_id();
		System.out.println(mem_id);
		
		int parameter = Global.memberService.update_LunchOrderDegree(mem_id);
		System.out.println(parameter);*/
		
		/*List<AttendanceVO> list = Global.attendanceService.select_AttendanceGrapeInfo();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getAttendance_date() + " : " + list.get(i).getAttendance_count() + "번");
		}*/
		
		// 오늘 접속자 비율(수강생-수료생) 파이 차트 메서드
		/*List<Map> list = Global.attendanceService.select_AttendanceRateGrapeInfo();
		for(int i=0; i<list.size(); i++) {
			String a = list.get(i).get("ATTENDANCE_DATE").toString();
			int b = Integer.parseInt(list.get(i).get("ATTENDANCE_COUNT").toString());
			
			System.out.println(a + " : " + b);
		}*/
		
		
		
		/*List<Pen_managementVO> list =  Global.pen_managementService.select_Profit_Management();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getUse_date() + "	" + list.get(i).getExchange_amount() + "	" + list.get(i).getProfit());
		}*/
		
		//bar차트용 그래프(파라미터 "년-월" : 2018-12) >> 두번 사용
		/*String use_date = "2019-01";
		
		int a = 0;
		
		List<Pen_managementVO> list = Global.pen_managementService.select_Profit_BarGrape(use_date);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getUse_date() + "	" + list.get(i).getExchange_amount() + "	" + list.get(i).getProfit());
			
			a += Integer.parseInt(list.get(i).getProfit());
		}
		
		System.out.println(a);*/
		
		/*List<Map> list = Global.pen_managementService.select_Profit_LineGrape();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).get("PROFIT").toString() + "	" + list.get(i).get("PROFIT_DATE"));
		}
		
		int profit = Integer.parseInt(list.get(0).get("PROFIT").toString());
		String date = list.get(0).get("PROFIT_DATE").toString();
		
		System.out.println(date + "	" + profit);*/
		
		//식단표 등록
		/*	Resmenu_daysVO vo = new Resmenu_daysVO();
        
        	vo.setRes_order_date("123");
        	vo.setRes_no("123");
        	vo.setMenu_soup("123");
        	vo.setMenu_1("123");
        	vo.setMenu_2("123");
        	vo.setMenu_3("123");
        	vo.setMenu_4("123");
        	vo.setMenu_5("123");
        	vo.setOrder_check("123");
        	vo.setRes_price("123");
        	//vo.setMenu_no("123");
       
        
			Global.resMenuService.insert_menu(vo);*/
		
		
		
		// 식단표 가져오기
//		List<Map> list = Global.orderService.select_order2("201809", "206", "20190125");
//		
//		System.out.println(list.get(0).get("ORDER_CODE"));
//		System.out.println(list.get(0).get("MEM_ID"));
//		System.out.println(list.get(0).get("RES_ORDER_DATE"));
//		System.out.println(list.get(0).get("RES_NO"));
//		System.out.println(list.get(0).get("RES_NAME"));
//		
		
		
		
		
		
		
		
		
		
		
		
//		List<BoardVO> list = Global.boarderService.select_notice_post("201809");
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getBoard_no() + "	" + list.get(i).getBoard_contents() + "	" + list.get(i).getMem_id() + "	" + list.get(i).getBoard_view());
//		}
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("end");		
		System.exit(0);
		
		
		
        
		
	}
	
}







		
		


