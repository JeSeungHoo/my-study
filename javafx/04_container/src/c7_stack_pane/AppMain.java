package c7_stack_pane;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox();
		root.setAlignment(Pos.BOTTOM_CENTER);
		root.setSpacing(10.0);
		root.setPadding(new Insets(15));
		
		Button btn1 = new Button("버튼1");
		// 특정 노드에 접근하기 위한 구별 값
		btn1.setId("btn1");
		btn1.setPrefSize(200, 100);
		
		
		Button btn2 = new Button("버튼2");
		
		Button btn3 = new Button("버튼3");
		/*
		root.getChildren().add(btn1);
		root.getChildren().add(btn2);
		root.getChildren().add(btn3);
		*/
		ObservableList<Node> list = root.getChildren();
		list.addAll(btn1,btn2,btn3);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}









