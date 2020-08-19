package hust.soict.hedspi.aims.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import hust.soict.hedspi.aims.OrderCreator;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.MediaCreator;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.order.UserOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MyController implements Initializable {

	public static final int MAX_LIMITED_ORDERS = 5;

	@FXML
	private Button orderCreate;

	@FXML
	private Button itemDelete;

	@FXML
	private Button itemAdd;

	@FXML
	private Button exitProgram;

	@FXML
	private ComboBox<String> itemType;

	ObservableList<String> list;

	@FXML
	private TableView<Order> tableOrder;

	ObservableList<Order> orderList;

	@FXML
	private TableColumn<Order, Integer> orderIDColumn;

	@FXML
	private TableView<Media> tableItem;

	@FXML
	private TableColumn<Media, Integer> itemIDColumn;
	@FXML
	private TableColumn<Media, String> titleColumn;
	@FXML
	private TableColumn<Media, String> categoryColumn;
	@FXML
	private TableColumn<Media, Float> costColumn;
	
	ObservableList<Media> itemList;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		// Initialize for combobox;
		list = FXCollections.observableArrayList(MediaCreator.mediaList);
		itemType.setItems(list);

		// Initialize for order table
		orderList = FXCollections.observableArrayList(UserOrder.listOrder);
		orderIDColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
		tableOrder.setItems(orderList);
		
		
		//Initialize for item table
		itemList = FXCollections.observableArrayList();
		itemIDColumn.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<Media,String>("category"));
		costColumn.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tableItem.setItems(itemList);
		
		//Change state of itemlist when select order in ordertable
		tableOrder.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				itemList.clear();
				Order selected = tableOrder.getSelectionModel().getSelectedItem();
				for(int i = 0;i<selected.getItemsOrdered().size();i++) {
					itemList.add(selected.getItemsOrdered().get(i));
				}
			}
		});
		
	}

	public void addOrder(ActionEvent event) {
		int max = 0;
		if (orderList.size() < MAX_LIMITED_ORDERS) {
			Order order = new Order();
			for (int i = 0; i < orderList.size(); i++) {
				if (orderList.get(i).getId() > max)
					max = orderList.get(i).getId();
			}
			order.setId(max + 1);
			orderList.add(order);
			UserOrder.listOrder.add(order);
		} else {
			showAlertWithoutHeaderText("Order Full!!","Can't add more order!");
		}
	}

	public void showAlertWithoutHeaderText(String title,String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText(content);

		alert.showAndWait();
	}
	
	public void addItemToOrder(ActionEvent e) throws IOException {
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Order selectedOrder = tableOrder.getSelectionModel().getSelectedItem();
		if(selectedOrder == null) {
			showAlertWithoutHeaderText("Add Item Error", "You have to choose an order to add item!");
			return;
		}
			
		String selected = itemType.getValue();
		if(selected == null) {
			showAlertWithoutHeaderText("Add Item Error!!", "You have to select one type of item");
			return;
		}
		MediaCreator mediaCreator = new MediaCreator();
		FXMLLoader loader = mediaCreator.createMedia(selected);
		
		MediaController.setOrder(selectedOrder);
		
		Parent ItemScene = loader.load();
		Scene scene = new Scene(ItemScene);
		stage.setScene(scene);
	}
	
	public void removeItem(ActionEvent e) {
		Media item = tableItem.getSelectionModel().getSelectedItem();
		if(item == null) {
			showAlertWithoutHeaderText("Delete Item Error", "You have to choose an item!");
			return;
		}
		Order order = tableOrder.getSelectionModel().getSelectedItem();
		order.removeMedia(item);
		itemList.remove(item);
	}
	
	public void exitAction(ActionEvent e) {
		System.exit(0);
	}

}
