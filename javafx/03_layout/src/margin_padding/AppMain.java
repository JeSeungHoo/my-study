package margin_padding;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		HBox hBox = new HBox();
		
		// 상 우 하 좌
		Insets insets = new Insets(50,10,10,50);
		hBox.setPadding(insets);
		
		Button button = new Button();
		// 폭과 넓이를 한번에 지정
		button.setPrefSize(100, 100);
		button.setText("확인");
		HBox.setMargin(button, new Insets(30));
		
		hBox.getChildren().add(button);
		primaryStage.setScene(new Scene(hBox));
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}







