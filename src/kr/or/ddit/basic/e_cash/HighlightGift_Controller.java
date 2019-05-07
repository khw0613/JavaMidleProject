package kr.or.ddit.basic.e_cash;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import kr.or.ddit.ibatis.vo.communityVO.MessageBoxVO;
import kr.or.ddit.ibatis.vo.hilightVO.Pen_managementVO;
import kr.or.ddit.ibatis.vo.hilightVO.Surpport_penVO;
import kr.or.ddit.ibatis.vo.memberVO.MemberVO;
import library.Global;
import library.ShinYS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import com.jfoenix.controls.JFXComboBox;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HighlightGift_Controller implements Initializable {

	@FXML JFXComboBox<String> gift_degree;		// 기수 콤보박스
	@FXML JFXComboBox<String> gift_name;		// 이름 콤보박스
	@FXML Label mine_pen;						// 현재 수량
	@FXML Label mine_result;					// 형광펜 결과
	@FXML Button gift_check;					// 형광펜 체크 버튼
	@FXML TextField gift_send_qt;				// 보낼 수량
	@FXML Button ok_gift;						// 보내기
	
	Pen_managementVO manageVO = new Pen_managementVO();
	Surpport_penVO svo = new Surpport_penVO();
	
	String mine_qt = "0";
	int send_qty = 0;
	int resultQt = 0;
	boolean flag = false;
	@FXML TextField txt_message;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ShinYS.visBack(true).setOnMouseClicked(e->{
			ShinYS.visBack(false);
			ShinYS.gotoHightlight();
		});

		List<String> comboList = new ArrayList<>();
		try {
			List<MemberVO> list = Global.memberService.select_MemberList();
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				comboList.add(list.get(i).getDegree() + "_" + list.get(i).getMem_name() + "(" + list.get(i).getMem_id() + ")");
			}
			
			List<MemberVO> mine = Global.memberService.selectOne(ShinYS.query_id);
			mine_qt = mine.get(0).getPen_quantity();
			mine_pen.setText(mine_qt);
					
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}
		
		ObservableList<String> degreeList = FXCollections.observableArrayList(comboList);
		gift_degree.setItems(degreeList);
		
		// 체크버튼
		gift_check.setOnAction(e-> {
			
			String send_qt = gift_send_qt.getText();
			
			send_qty = (Integer.parseInt(send_qt));
			resultQt = (Integer.parseInt(mine_qt)) - send_qty;
			System.out.println(resultQt);
			
			if(resultQt < 0) {
				ShinYS.errMsg("선물하기가 불가능합니다.", "보유한 형광펜 수량을 확인하세요");
				gift_send_qt.setText("");
				mine_result.setText("");
			} else {
				mine_result.setText(resultQt+"");
				flag = true;
			}
		});
		
		ok_gift.setOnAction(e-> {
			if(!flag) {
				ShinYS.errMsg("선물하기", "선물 할 수량을 확인하세요.");
			} else {
				String toId = gift_degree.getValue().toString();
				String toId2 = toId.substring(11, toId.length()-1);

				System.out.println(toId);
				System.out.println(toId2);
				
				
				try {
					// 주는 사람 감소
					System.out.println(ShinYS.query_id);
					System.out.println(send_qty);
					Global.exchangeService.subtration_myPen_Quantity3(send_qty+"", ShinYS.query_id);
					List<MemberVO> re_id = Global.memberService.selectOne(toId2);
					
					
					// 받는 사람 증가
					Global.payService.addition_myPen_Quantity(toId2, send_qty+"");
					
					//선물=후원 >> support테이블에 선물한 정보가 저장되도록 세팅
					svo.setMem_id(ShinYS.query_id);
					svo.setPen_code("1");
					svo.setReceive_id(toId2);
					svo.setSupport_cnt(send_qty+"");
					
					Global.supportPenService.insert_SupportInfo(svo);
					
					
					// 저장된 정보를 꺼내옴
					List<Surpport_penVO> user = Global.supportPenService.select_GiveInfo(ShinYS.query_id);
					int idx = user.size() - 1;
					String support_no = user.get(idx).getSupport_no();
					System.out.println(user.get(idx).getReceive_id());
					
					List<Surpport_penVO> info = Global.supportPenService.select_SupportDetailInfo(support_no);
					String pen_type = info.get(0).getPen_code();
					String pen_cnt 	= info.get(0).getSupport_cnt();
					String use_date = info.get(0).getSupport_date();
					String receive_id = info.get(0).getReceive_id();
					
					
					//꺼내온 정보를 세팅하여 형광펜 관리테이블에 인서트
					manageVO.setMem_id(ShinYS.query_id);
					manageVO.setPen_cnt(pen_cnt);
					manageVO.setUse_date(use_date);
					manageVO.setPen_type(pen_type);
					manageVO.setReceive_id(receive_id);
					
					Global.pen_managementService.insert_UsetypeSupport(manageVO);
					
					
					
					
					
					MessageBoxVO vo = new MessageBoxVO();
					vo.setMem_id(ShinYS.query_id);
					vo.setMsg_contents(ShinYS.query_id.toString() + "님께서 형광펜" +"["+send_qty+"]"+ "개를 선물하셨습니다" + "\n보낸쪽지:" + txt_message.getText());
					vo.setReceive_id(toId2);
					Global.messageBoxService.insert_MessageInfo(vo);
					
					
					ShinYS.infoMsg("형광펜 선물하기", "형광펜 선물이 완료되었습니다.");
					
					ShinYS.gotoHightlight();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
	}

}
