package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class RootController
					implements Initializable{
	
	@FXML private TextArea textArea;
	@FXML private ComboBox<String> comboBox;
	
	private Stage primary;
	
	public void setStage(Stage stage) {
		this.primary = stage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBox.getSelectionModel()
			    .selectedIndexProperty()
			    .addListener((target,o,n)->{
			    	int index = n.intValue();
			    	System.out.println("select combobox : "+index);
			    	switch(index) {
			    	case 0 : 
			    		// directory chooser
			    		// 폴더 선택 상자
			    		DirectoryChooser chooser
			    					= new DirectoryChooser();
			    		File selectedDir = chooser.showDialog(primary);
			    		if(selectedDir != null) {
			    			for(File f : selectedDir.listFiles()) {
			    				textArea.appendText(f.getName()+"\n");
			    			}
			    		}
			    		break;
			    	case 1 : 
			    		// popup window
			    		handlePopup();
			    		break;
			    	case 2 : 
			    		// custom Window
			    		handleCustom();
			    		break;
			    	case 3 : 
			    		// custom dialog
			    		break;
			    	}
			    });
	}
	
	private void handleCustom() {
		// 새로운 무대 생성
		// DECORATED  일반적인 윈도우 스타일, 흰배경
		// 제목줄에 장식(아이콘,타이틀,축소 복원,닫기)
//		Stage stage = new Stage(StageStyle.DECORATED);
//		// 흰배경 제목줄 x
//		stage = new Stage(StageStyle.UNDECORATED);
//		// 흰배경 , 제목줄에 타이틀, 종료 버튼만 존재
//		stage = new Stage(StageStyle.UTILITY);
//		// 투명 배경 제목줄x
//		stage = new Stage(StageStyle.TRANSPARENT);
		// DECORATED와 동일
		final Stage stage = new Stage();
		// 창의 소유권 지정
		// Modality.WINDOW_MODAL APPLICATION_MODAL
		/*
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primary);
		*/
		// 소유자가 없어도 다른창으로 제어권을 넘기지 않음.
		stage.initModality(Modality.APPLICATION_MODAL);
		
		stage.setTitle("입력 창");
		Parent parent = null;
		
		try {
			parent = FXMLLoader.load(
				getClass().getResource("Custom.fxml")
			);
		} catch (IOException e) {}
		TextField textField 
			= (TextField) parent.lookup("#textTitle");
		TextArea textArea 
			=(TextArea) parent.lookup("#textContent");
		Button btnOk 
			= (Button) parent.lookup("#btnOk");
		Button btnCancel 
			= (Button) parent.lookup("#btnCancel");
		
		btnOk.setOnAction(event->{
			String title = textField.getText();
			String content = textArea.getText();
			stage.close();
			RootController.this.textArea.appendText(title+"\n");
			RootController.this.textArea.appendText(content+"\n");
			// 콤보 박스 선택 초기화
			comboBox.getSelectionModel().clearSelection();
		});
		
		btnCancel.setOnAction(event->{
			stage.close();
		});
		
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		// 창닫기 이벤트
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				System.out.println("close 이벤트");
				// 닫기 이벤트 무시
				event.consume();
			}
		});
		stage.show();
		
				
	}

	private void handlePopup() {
		System.out.println("POPUP");
		Popup popUp = new Popup();
		Parent parent = null;
		try {
			parent = FXMLLoader.load(
				getClass().getResource("Popup.fxml")
			);
		} catch (IOException e) {}
		ImageView imageView 
			= (ImageView)parent.lookup("#imgMessage");
		String imagePath = "../images/dialog-info.png";
		URL url = getClass().getResource(imagePath); 
		Image image = new Image(url.toString());
		imageView.setImage(image);
		
		
		imageView.setOnMouseClicked(event->{
			System.out.println("image mouse click");
			popUp.hide();
		});
		
		Label lblMessage
			= (Label)parent.lookup(".lblMessage");
		lblMessage.setText("메세지 알림");
		
		popUp.getContent().add(parent);
		popUp.setAutoHide(true);
		popUp.show(primary);
		
	}

	public void handleNew(ActionEvent e) throws IOException {
		System.out.println("new");
		textArea.appendText("New\n");
		Runtime rt = Runtime.getRuntime();
		rt.exec("notepad");
	}
	public void handleOpen(ActionEvent e) throws IOException {
		System.out.println("Open");
		textArea.appendText("Open\n");
		// FileChooser - 파일 선택 창
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
			new ExtensionFilter("Text files","*.txt")
		);
		File selectedFile = fileChooser.showOpenDialog(primary);
		if(selectedFile != null) {
			textArea.appendText(selectedFile.getPath()+"\n");
			FileReader reader = new FileReader(selectedFile);
			BufferedReader bReader = new BufferedReader(reader);
			
			String message = null;
			while((message = bReader.readLine()) != null) {
				textArea.appendText(message+"\n");
			}
			bReader.close();
			reader.close();
		}
		
	}
	public void handleSave(ActionEvent e) throws Exception{
		System.out.println("Save");
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(
			new ExtensionFilter("text files", "*.txt")
		);
		File selectedFile = fileChooser.showSaveDialog(primary);
		System.out.println(selectedFile.getPath());
		if(selectedFile != null) {
			FileWriter writer = new FileWriter(selectedFile);
			BufferedWriter bWriter = new BufferedWriter(writer);
			String message = textArea.getText();
			bWriter.write(message);
			bWriter.flush();
			bWriter.close();
			writer.close();
		}
	}
	public void handleClose(ActionEvent e) {
		System.out.println("Close");
		// 무대 종료
		primary.close();
	}
}










