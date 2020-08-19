package hust.soict.hedspi.aims.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.hedspi.aims.media.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthorController implements Initializable{
	public static Book book;
	
	public static Book getBook() {
		return book;
	}

	public static void setBook(Book book) {
		AuthorController.book = book;
	}

	@FXML
	private TextField nameText;
	@FXML 
	private Button addButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void addAuthor(ActionEvent e) {
		String author = nameText.getText();
		book.addAuthor(author);
		
	}
}
