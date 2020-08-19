package hust.soict.hedspi.aims.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import hust.soict.hedspi.aims.media.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BookController extends MediaController implements Initializable {

	@FXML
	private TextField titleText;

	@FXML
	private TextField categoryText;

	@FXML
	private TextField costText;

	@FXML
	private Button authorAddButton;

	@FXML
	private Button createButton;

	@FXML
	private Button backButton;

	private List<String> authors = new ArrayList<String>();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void addItem(ActionEvent e) {
		String title = titleText.getText();
		String category = categoryText.getText();
		float cost;
		System.out.println("Book add item");
		try {
			cost = Float.parseFloat(costText.getText());
		} catch (Exception e2) {
			// TODO: handle exception
			showAlertWithoutHeaderText("Cost Error", "You must input a float number");
			return;
		}
		Book book = new Book(authors, title, category, cost);
		if(order.addMedia(book)) 
			showAlertWithoutHeaderText("Book", "Add book succesfully");
		else
			showAlertWithoutHeaderText("Book", "Can't add any more items");
	}

	public void addAuthor(ActionEvent e) throws IOException {

//		FXMLLoader fxmlLoader = new FXMLLoader();
//		fxmlLoader.setLocation(getClass().getResource("../view/AuthorAdd.fxml"));
//		/*
//		 * if "fx:controller" is not set in fxml
//		 * fxmlLoader.setController(NewWindowController);
//		 */
//		Scene scene = new Scene(fxmlLoader.load(), 500, 200);
//		Stage stage = new Stage();
//		stage.setTitle("Author");
//		stage.setScene(scene);
//		stage.show();
		showInputTextDialog();
	}

	public void goBack(ActionEvent e) throws IOException {
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(getClass().getResource("../view/MyScene.fxml"));
		Parent mainRoot = loader.load();
		Scene scene = new Scene(mainRoot);
		stage.setScene(scene);
	}

	public void showAlertWithoutHeaderText(String title, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText(content);

		alert.showAndWait();
	}

	private void showInputTextDialog() {

		TextInputDialog dialog = new TextInputDialog("");

		dialog.setTitle("Author");
		dialog.setHeaderText("Enter author name:");
		dialog.setContentText("Name:");

		Optional<String> result = dialog.showAndWait();

		result.ifPresent(name -> {
			authors.add(name);
		});
	}
}
