package library;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.ibatis.ServerOn;
import kr.or.ddit.ibatis.service.AttendanceService;
import kr.or.ddit.ibatis.service.BoardCommentService;
import kr.or.ddit.ibatis.service.BoarderService;
import kr.or.ddit.ibatis.service.ExchangeService;
import kr.or.ddit.ibatis.service.FaqService;
import kr.or.ddit.ibatis.service.FaqServiceImpl;
import kr.or.ddit.ibatis.service.LogWindowService;
import kr.or.ddit.ibatis.service.MemberService;
import kr.or.ddit.ibatis.service.MessageBoxService;
import kr.or.ddit.ibatis.service.OrderService;
import kr.or.ddit.ibatis.service.PayService;
import kr.or.ddit.ibatis.service.PbBoardCommentService;
import kr.or.ddit.ibatis.service.Pen_managementService;
import kr.or.ddit.ibatis.service.PersnalBoarderService;
import kr.or.ddit.ibatis.service.RefundService;
import kr.or.ddit.ibatis.service.ResMenuService;
import kr.or.ddit.ibatis.service.RestaurantService;
import kr.or.ddit.ibatis.service.SupportPenService;

public class Global{
	
	public static final boolean RMI = false;	//RMI 사용여부 : true = 사용
	private static final String HOST = "localhost";
	private static final int PORT = 10005;
	public static final String RootDir = "/kr/or/ddit/basic/";
	
	public static MemberService memberService;					// 회원테이블
	public static ResMenuService resMenuService;				// 식단표
	public static BoarderService boarderService;				// 게시판테이블
	public static PersnalBoarderService persnalBoardService; 	// 개인게시판
	public static PayService payService;						// 결제
	public static SupportPenService supportPenService; 			// 후원
	public static LogWindowService logWindowService; 			// 로그인 정보
	public static RefundService refundService;					// 환불하기
	public static BoardCommentService boardCommentService;		// 댓글
	public static AttendanceService attendanceService;			// 출석
	public static PbBoardCommentService pbBoardCommentService; 	// 개인댓글
	public static ExchangeService exchangeService;				// 환전
	public static MessageBoxService messageBoxService;			// 쪽지
	public static OrderService orderService;					// 주문
	public static RestaurantService restaurantService;			// 도시락 업체
	public static FaqService faqService;						// FAQ
	public static Pen_managementService pen_managementService;	// 형광펜 사용내역관리
	
	
	public static void DbConnect() throws Exception {
		
		if(Global.RMI) {
			Registry reg = Global.ServerConnect();
			memberService			= (MemberService) reg.lookup("memberService");
			resMenuService 			= (ResMenuService) reg.lookup("resMenuService");
			boarderService 			= (BoarderService) reg.lookup("boarderService");
			persnalBoardService	 	= (PersnalBoarderService) reg.lookup("persnalBoardService");
			payService 				= (PayService) reg.lookup("payService");
			supportPenService		= (SupportPenService) reg.lookup("supportPenService");
			logWindowService 		= (LogWindowService) reg.lookup("logWindowService");
			refundService			= (RefundService) reg.lookup("refundService");
			boardCommentService		= (BoardCommentService) reg.lookup("boardCommentService");
			attendanceService		= (AttendanceService) reg.lookup("attendanceService");
			pbBoardCommentService	= (PbBoardCommentService) reg.lookup("pbBoardCommentService");
			exchangeService			= (ExchangeService) reg.lookup("exchangeService");
			messageBoxService		= (MessageBoxService) reg.lookup("messageBoxService");
			orderService			= (OrderService) reg.lookup("orderService");
			restaurantService		= (RestaurantService) reg.lookup("restaurantService");
			faqService				= (FaqService) reg.lookup("faqService");
			pen_managementService	= (Pen_managementService) reg.lookup("pen_managementService");
			
		}else {
			String[] args=null;
			ServerOn.main(args);
			System.out.println("다이렉트 DB연결");
			memberService  		= ServerOn.memberService;
			resMenuService 		= ServerOn.resMenuService;
			boarderService 		= ServerOn.boarderService;
			persnalBoardService = ServerOn.persnalBoardService;
			payService			= ServerOn.payService;
			supportPenService	= ServerOn.supportPenService;
			logWindowService	= ServerOn.logWindowService;
			refundService		= ServerOn.refundService;
			boardCommentService	= ServerOn.boardCommentService;
			attendanceService	= ServerOn.attendanceService;
			pbBoardCommentService = ServerOn.pbBoardCommentService;
			exchangeService		= ServerOn.exchangeService;
			messageBoxService	= ServerOn.messageBoxService;
			orderService		= ServerOn.orderService;
			restaurantService	= ServerOn.restaurantService;
			faqService			= ServerOn.faqService;
			pen_managementService = ServerOn.pen_managementService;
			
		}
		
		// 해쉬맵으로 게시판 타입 사용 - 유수
//		Creat_board_type_HashMap();
		
	}
	
	
	

	//클라이언트 - 서버연결
	public static Registry ServerConnect() {
		try {
			return LocateRegistry.getRegistry(HOST, PORT);
		} catch (RemoteException e) {
			System.out.println("RMI - DB서버요청 실패");
			e.printStackTrace();
			return null;
		}

	}
	

	
	// Rmi레지스트 가져오기  // 보류
	/**
	 * 
	 * @param regName
	 * @ F = 인터페이스
	 * @ M = 임플리먼츠
	 * @return
	 */
	public static <F> F getRmiRegistry (String regName) {
		
		//Rmi레지스트 사용시
		Registry reg = ServerConnect();
		F Shin_interface;
		try {
			Shin_interface = (F) reg.lookup(regName);
			return Shin_interface;
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
			return null;
		}
		//F Shin_interface2 = (F) SingleTone.getInstance2();
	}
	
	
//	public static HashMap<String,String> b_type = new HashMap<>();
//	
//	static void Creat_board_type_HashMap() throws RemoteException {
//		//게시판타입 해시맵으로 만들기
//		
//		List<Board_typeVO> list = Global.boarderService.select_BoardType();
//		for(Board_typeVO ff : list) {
//			b_type.put(ff.getBoard_name(), ff.getBoard_type());
//		}
		
		
//		공지사항 : 1
//		(기수별)스터디게시판 : 3
//		자유게시판 : 5
//		오픈소스게시판 : 6
//		취업게시판 : 4
//		(기수별)자유게시판 : 2
		

		//게시판타입 해시맵 리스트 출력
//		Set<String> keySet = b_type.keySet();
//		Iterator<String> it = keySet.iterator();
//		while(it.hasNext()) {
//			String key = it.next();
//			System.out.println(key + " : " + b_type.get(key));
//		}
// 	}
	
	

}
