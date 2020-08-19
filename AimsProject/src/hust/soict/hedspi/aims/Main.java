package hust.soict.hedspi.aims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/MyScene.fxml"));
			stage.setTitle("Order management Program");
			stage.setScene(new Scene(root,725,500));
			stage.show();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	 
	public static void main(String[] args) {
		launch(args);
	}
}
