package hust.soict.hedspi.aims.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
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
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DigitalDiscController extends MediaController implements Initializable{

	@FXML
	private Button createButton;

	@FXML
	private TextField titleText;

	@FXML
	private TextField categoryText;

	@FXML
	private TextField lengthText;

	@FXML
	private TextField directorText;

	@FXML
	private TextField costText;

	@FXML
	private Button backButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void addItem(ActionEvent e) {
		String title = titleText.getText();
		String category = categoryText.getText();
		String director = directorText.getText();
		int length;
		float cost;
		try {
			length = Integer.parseInt(lengthText.getText());
			cost = Float.parseFloat(costText.getText());
		} catch (Exception e2) {
			showAlertWithoutHeaderText("Length or Cost Error", "You must input an integer");
			return;
		}
		System.out.println(title);
		System.out.println(category);
		System.out.println(director);
		System.out.println(length);
		System.out.println(cost);
		DigitalVideoDisc disc = new DigitalVideoDisc(title, category, director, length, cost);
		if(order.addMedia(disc)) 
			showAlertWithoutHeaderText("Digital Disc", "Add digital disc succesfully");
		else
			showAlertWithoutHeaderText("Digital Disc", "Can't add any more items");
	}
	
	public void goBack(ActionEvent e) throws IOException {
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("../view/MyScene.fxml"));
		Parent mainRoot = loader.load();
		Scene scene = new Scene(mainRoot);
		stage.setScene(scene);
	}
	
	public void showAlertWithoutHeaderText(String title,String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText(content);

		alert.showAndWait();
	}
}
