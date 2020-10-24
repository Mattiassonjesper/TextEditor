package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class Controller {

	@FXML
	private TextArea areaText;

	private Model editorModel;

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

}
