package kr.or.ddit.basic.h_management;

import java.net.URL;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.ibatis.vo.boarderVO.BoardVO;
import kr.or.ddit.ibatis.vo.boarderVO.Persnal_boardVO;
import kr.or.ddit.ibatis.vo.hilightVO.Pen_managementVO;
import library.Global;
import javafx.scene.control.TableColumn;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Pagination;

public class ProfitManger_Controller implements Initializable{

	
	
	// 매출 나올 테이블뷰
	@FXML TableView<Pen_managementVO> table_profit;
	@FXML TableColumn<Pen_managementVO, String> tbc_profit_date;
	@FXML TableColumn<Pen_managementVO, String> tbc_profit_exchange;
	@FXML TableColumn<Pen_managementVO, String> tbc_profit;
	
	// 테이블에 담을 데이터 저장소
	ObservableList<Pen_managementVO> tb_data;
	List<Pen_managementVO> tb_list;
	
	// 바차트
	@FXML BarChart profit_barchart;
	@FXML CategoryAxis bar_x;
	@FXML NumberAxis bar_y;
	
	List<Pen_managementVO> bar_data1; // 12월꺼
	List<Pen_managementVO> bar_data2; // 1월꺼
	//라인 차트
	@FXML LineChart profit_linechart;
	@FXML NumberAxis line_y;
	@FXML CategoryAxis line_x;
	List<Map> list;
	
	int from, to, itemsForPage, totPageCount;
	ObservableList<Pen_managementVO> currentPageData;
	@FXML Pagination board_page;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//가격 포맷	
	DecimalFormat format = new DecimalFormat("###,###");
	
	
	tbc_profit_date.setCellValueFactory(new PropertyValueFactory<>("use_date"));
	tbc_profit_exchange.setCellValueFactory(new PropertyValueFactory<>("exchange_amount"));
	tbc_profit.setCellValueFactory(new PropertyValueFactory<>("profit"));
	
	// 가져오는 로직	
	try {
		tb_list = Global.pen_managementService.select_Profit_Management();
		
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	tb_data = FXCollections.observableArrayList(tb_list);
	table_profit.setItems(tb_data);
	itemsForPage = 9;	
	board_paging();
	
	
	// barchart
	profit_barchart.setTitle("월별 순이익");
	
	String bf_use_date = "2018-12";
	
	try {
		bar_data1 = Global.pen_managementService.select_Profit_BarGrape(bf_use_date);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int sum =0;
	for(int i =0; i < bar_data1.size(); i++) {
		sum += Integer.parseInt(bar_data1.get(i).getProfit());
	}
	
	
	
	
	String af_usedate = "2019-01";
	
	try {
		bar_data2 = Global.pen_managementService.select_Profit_BarGrape(af_usedate);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int sum1 =0;
	for(int i =0; i < bar_data2.size(); i++) {
		sum1 += Integer.parseInt(bar_data2.get(i).getProfit());
	}
	
	
	
	
	bar_x = new CategoryAxis();
	bar_y = new NumberAxis();
	
	bar_x.setLabel("월별");
	bar_y.setLabel("순수익");
	
	
	XYChart.Series<String, Number> series = new XYChart.Series<>();
	series.setName("전월 순이익");
	series.getData().add(new XYChart.Data<String, Number>(bf_use_date ,sum));
	
	XYChart.Series<String, Number> series1 = new XYChart.Series<>();
	series1.setName("현월 순이익");
	series1.getData().add(new XYChart.Data<String, Number>(af_usedate ,sum1));
	
	profit_barchart.getData().addAll(series,series1);
	
	// LineChart
	profit_linechart.setTitle("일별 순이익");

	line_x = new CategoryAxis();
	line_y = new NumberAxis();
	
	XYChart.Series<String, Number> line_series = new XYChart.Series<>();
	line_series.setName("LineChart");
	
	try {
		list = Global.pen_managementService.select_Profit_LineGrape();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int i=0; i<list.size(); i++) {
		
	}
	
	int profit = Integer.parseInt(list.get(0).get("PROFIT").toString());
	String date = list.get(0).get("PROFIT_DATE").toString();
	
	int profit1 = Integer.parseInt(list.get(1).get("PROFIT").toString());
	String date1 = list.get(1).get("PROFIT_DATE").toString();
	
	int profit2 = Integer.parseInt(list.get(2).get("PROFIT").toString());
	String date2 = list.get(2).get("PROFIT_DATE").toString();
	
	int profit3 = Integer.parseInt(list.get(3).get("PROFIT").toString());
	String date3 = list.get(3).get("PROFIT_DATE").toString();
	
	int profit4 = Integer.parseInt(list.get(4).get("PROFIT").toString());
	String date4 = list.get(4).get("PROFIT_DATE").toString();
	
	int profit5 = Integer.parseInt(list.get(5).get("PROFIT").toString());
	String date5 = list.get(5).get("PROFIT_DATE").toString();
	
	int profit6 = Integer.parseInt(list.get(6).get("PROFIT").toString());
	String date6 = list.get(6).get("PROFIT_DATE").toString();
	
	
	line_series.getData().add(new XYChart.Data<>(date,profit));
	line_series.getData().add(new XYChart.Data<>(date1,profit1));
	line_series.getData().add(new XYChart.Data<>(date2,profit2));
	line_series.getData().add(new XYChart.Data<>(date3,profit3));
	line_series.getData().add(new XYChart.Data<>(date4,profit4));
	line_series.getData().add(new XYChart.Data<>(date5,profit5));
	line_series.getData().add(new XYChart.Data<>(date6,profit6));
	
	profit_linechart.getData().add(line_series);
	
	
	}

	private ObservableList<Pen_managementVO> getTableViewData(int from, int to) {

		currentPageData = FXCollections.observableArrayList(); // 현재페이지 데이터 초기화
		int totSize = tb_data.size();
		for (int i = from; i <= to && i < totSize; i++) {

			currentPageData.add(tb_data.get(i));
		}

		return currentPageData;
	}
	private void board_paging() {
		totPageCount = tb_data.size() % itemsForPage == 0 ? tb_data.size() / itemsForPage
				: tb_data.size() / itemsForPage + 1;

		board_page.setPageCount(totPageCount); // 전체 페이지 수 설정

		board_page.setPageFactory((Integer pageIndex) -> {

			from = pageIndex * itemsForPage;
			to = from + itemsForPage - 1;
			table_profit.setItems(getTableViewData(from, to));

			return table_profit;
		});
	}
	
}
