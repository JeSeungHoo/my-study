package css01_selector;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("Root.fxml"));
			Scene scene = new Scene(root);
			/*
			scene.getStylesheets().add(
				getClass().getResource("application.css").toExternalForm()
			);
			scene.getStylesheets().add(
				getClass().getResource("state.css").toString()
			);
			*/
			/*
			scene.getStylesheets().addAll(
				getClass().getResource("application.css").toString(),
				getClass().getResource("state.css").toString()
			);
			*/
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
