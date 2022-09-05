package c5_chart_controls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class ChartController implements Initializable {

	@FXML private PieChart pieChart;
	@FXML private BarChart<String,Integer> barChart;
	@FXML private AreaChart<String,Integer> areaChart;
	@FXML private BubbleChart<Integer,Integer> bubbleChart;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// list = PieChart.Data 객체를 저장
		ObservableList<PieChart.Data> list
				= FXCollections.observableArrayList();
		list.add(new PieChart.Data("AWT", 5));
		list.add(new PieChart.Data("Swing", 25));
		list.add(new PieChart.Data("SWT", 30));
		list.add(new PieChart.Data("JavaFX", 60));
		pieChart.setData(list);
		
		barChart.setTitle("평균 키");
		XYChart.Series<String, Integer> series1
				= new XYChart.Series<>();
		series1.setName("남성");
		
		XYChart.Series<String, Integer> series2
				= new XYChart.Series<>();
		series2.setName("여성");
		
		ObservableList<XYChart.Data<String, Integer>> listBar
					= FXCollections.observableArrayList();
		listBar.add(new XYChart.Data<>("2019",170));
		listBar.add(new XYChart.Data<>("2020",171));
		listBar.add(new XYChart.Data<>("2021",173));
		listBar.add(new XYChart.Data<>("2022",174));
		series1.setData(listBar);
		
		listBar = FXCollections.observableArrayList();
		listBar.add(new XYChart.Data<>("2019",162));
		listBar.add(new XYChart.Data<>("2020",163));
		listBar.add(new XYChart.Data<>("2021",162));
		listBar.add(new XYChart.Data<>("2022",164));
		series2.setData(listBar);
		
		barChart.getData().add(series1);
		barChart.getData().add(series2);
		
		// AreaCHart
		// 지역별 평균 온도
		areaChart.setTitle("평균 온도");
		XYChart.Series<String, Integer> series3
						= new XYChart.Series<>();
		series3.setName("서울");
		series3.setData(FXCollections.observableArrayList(
			new XYChart.Data<String,Integer>("2016",26),
			new XYChart.Data<String,Integer>("2017",27),
			new XYChart.Data<String,Integer>("2018",24),
			new XYChart.Data<String,Integer>("2019",28),
			new XYChart.Data<String,Integer>("2020",27)
		));
		areaChart.getData().add(series3);
		
		XYChart.Series<String, Integer> series4
						= new XYChart.Series<>();
		series4.setName("부산");
		series4.setData(FXCollections.observableArrayList(
			new XYChart.Data<>("2016",31),
			new XYChart.Data<>("2017",30),
			new XYChart.Data<>("2018",33),
			new XYChart.Data<>("2019",34),
			new XYChart.Data<>("2020",32)
		));
		areaChart.getData().add(series4);
		
		// BubbleChart
		// 체류 시간별 상품 구매 수와 판매 금액
		XYChart.Series<Integer, Integer> seriesA
							= new XYChart.Series<>();
		seriesA.setName("40대");
		//									 체류시간 금액  구매수		
		//									     x, y, scale			
		seriesA.getData().add(new XYChart.Data<>(5,  0,  0 ));
		seriesA.getData().add(new XYChart.Data<>(10, 1,  5));
		seriesA.getData().add(new XYChart.Data<>(20, 3,  7));
		seriesA.getData().add(new XYChart.Data<>(30, 5,  1));
		bubbleChart.getData().add(seriesA);
		
		
	}

}












