package draw_line;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class CanvasController implements Initializable {

	@FXML private Canvas canvas;
	@FXML private TextArea txtArea;
	@FXML private ColorPicker pick;
	@FXML private Slider slider;
	@FXML private Button btnClear;
	
	// 그리기 도구
	GraphicsContext gc;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gc = canvas.getGraphicsContext2D();
		gc.setStroke(Color.BLACK); 	// 선색
		gc.setLineWidth(1);			// 선 굵기
		slider.setMin(1);
		slider.setMax(100);
		// == read only
		txtArea.setEditable(false);
		
		// canvas위에서 마우스가 움직일때
		canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				double x = event.getSceneX();
				double y = event.getSceneY();
				txtArea.appendText("x : " + x+", y : "+ y+"\n");
			}
		});
		// 마우스가 눌러졌을때
		canvas.setOnMousePressed(e->{
			gc.beginPath();
			gc.lineTo(e.getX(), e.getY());
		});
		// 마우스가 드래그 되는 동안
		canvas.setOnMouseDragged(e->{
			double x = e.getX();
			double y = e.getY();
			txtArea.appendText(x+":"+y+"\n");
			gc.lineTo(x, y);
			gc.stroke();
		});
		
		btnClear.setOnAction(e->{
			gc.clearRect(0, 0, 
					canvas.getWidth(), 
					canvas.getHeight());
			pick.setValue(Color.WHITE);
			slider.setValue(1);
			gc.setLineWidth(1);
			gc.setStroke(Color.BLACK);
		});
		
		pick.valueProperty().addListener((t,o,n)->{
			gc.setStroke(n);
		});
		
		slider.valueProperty().addListener((target,oldValue,newValue)->{
			int value = newValue.intValue();
			double result = value/10;
			gc.setLineWidth(result);
		});
		
	}

}













