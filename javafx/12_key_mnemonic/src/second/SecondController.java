package second;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.MainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecondController implements Initializable {

	@FXML private Button btn1, btn2;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		Stage s
//		= (Stage)btn1.getScene().getWindow();
//		s.close();
		
		
		btn1.setOnAction(event->{
			FXMLLoader loader 
			= new FXMLLoader(
				getClass().getResource(
					"../application/Root.fxml"
				)
			);
			
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException e) {}
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			MainController cont = loader.getController();
			cont.setPrimaryStage(stage);
			stage.show();
			
			Stage secondStage
				= (Stage)btn1.getScene().getWindow();
			secondStage.close();
		});
		
	}

}
