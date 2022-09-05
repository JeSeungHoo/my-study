package c2_input;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class InputController implements Initializable {

	@FXML private TextField txtTitle;
	@FXML private PasswordField txtPass;
	@FXML private ComboBox<String> comboPublic;
	@FXML private ColorPicker colorPicker;
	@FXML private DatePicker datePicker;
	@FXML private TextArea txtContent;
	@FXML private Button btnReg, btnCancel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnReg.setOnAction(e->{
			// TextField에 작성된 문자열
			String titleText = txtTitle.getText();
			System.out.println("제목 : "+titleText);
			String pass = txtPass.getText();
			System.out.println("pass : " + pass);
			// ComboBox에 선택된 값을 반환
			// 지정된 제네릭 타입으로 반환
			// ComboBox<String> 문자열로 반환
			String comboData = comboPublic.getValue();
			System.out.println("combobox : " + comboData);
			// Color : 색상에 대한 정보를 저장하는 객체
			// RGBA(RED,GREEN,BLUE,Alpha or brightness)
			Color color = colorPicker.getValue();
			System.out.println("color : " + color);
			System.out.println("RED : " + color.getRed());
			System.out.println("GREEN : " + color.getGreen());
			System.out.println("BLUE : " + color.getBlue());
			System.out.println("Alpha : " + color.getBrightness());
			
			// LocalDate : 날짜 정보를 yyyy-MM-dd 형태로 제공
			LocalDate date = datePicker.getValue();
			System.out.println(date);
			if(date != null) {
				System.out.println("연도 : " + date.getYear());
				System.out.println("월 : " + date.getMonth());
				System.out.println("월 : " + date.getMonthValue());
				System.out.println("일 :" + date.getDayOfMonth());
			}
			
			String content = txtContent.getText();
			System.out.println("content : " + content);
			
		}); // btnReg action event end
		
		btnCancel.setOnAction(e->{
			// 기존 값을 새로운 텍스트로 대체
			txtTitle.setText(null);
			txtPass.setText("");
			txtContent.clear();
			
			// 콤보 박스의 선택 목록
			ObservableList<String> oldList
						= comboPublic.getItems();
			ObservableList<String> newList
			= FXCollections.observableArrayList("공개","비공개");
			oldList.add("박주신 제외");
			oldList.remove("공개");
			comboPublic.setItems(newList);
			
			colorPicker.setValue(new Color(1,1,1,1));
			datePicker.setValue(null);
		}); // end btnCancel
		
		txtTitle.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				System.out.println(event.getCode());
				if(event.getCode() == KeyCode.ENTER) {
					// 비밀번호 입력란에 포커스
					// txtPass.requestFocus();
					// event 강제 실행
					btnCancel.fire();
				}
			}
		}); // KeyPressed End
		
		txtPass.textProperty()
		.addListener((target,oldValue,newValue)->{
			System.out.println(newValue);
			// 기존 값에 이어서 텍스트 추가
			txtContent.appendText(newValue+"\n");
		});
		
		
	}

}





