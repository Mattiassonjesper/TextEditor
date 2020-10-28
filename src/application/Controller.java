package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {

	@FXML
	private TextArea areaText;

	@FXML
	private Model editorModel;

	@FXML
	private Slider S;

	public Controller(Model editorModel) {
		this.editorModel = editorModel;
	}

	@FXML
	private void onSave() {

	}

	@FXML
	private void onLoad() {
		Stage stage = new Stage();
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open File");
		File selectedFile = chooser.showOpenDialog(stage);

		FileReader FR = null;
		try {
			FR = new FileReader(selectedFile.getAbsoluteFile().toString());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
		BufferedReader BR = new BufferedReader(FR);

		StringBuilder sb = new StringBuilder();

		String myText = "";

		try {
			while ((myText = BR.readLine()) != null) {
				sb.append(myText + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		areaText.setText(sb.toString());
	}

	@FXML
	private void onClose() {
		Model.close();
	}

	@FXML
	private void onAbout() {
		System.out.println("About was clicked");
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("Jesper");
		alert.setTitle("About");
		alert.setContentText("This is a text editor");
		alert.show();
	}

	@FXML
	public void onSlide() {
		System.out.println("Slider be Sliding!");
		S.setMax(100);
		S.setMin(20);
		S.setValue(20);

		S.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				areaText.setFont(Font.font("SansSerif", S.getValue()));

			}
		});
	}

}
