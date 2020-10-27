package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

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

	}

	@FXML
	private void onClose() {
		System.exit(0);
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
		S.setMin(1);
		S.setValue(20);

		S.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				areaText.setFont(Font.font("SansSerif", S.getValue()));

			}
		});
	}

}
