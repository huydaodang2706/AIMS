package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hust.soict.hedspi.aims.order.Order;
import javafx.fxml.FXMLLoader;

public class MediaCreator {
	
	public static List<String> mediaList = Arrays.asList("DigitalDisc", "CompactDisc", "Book");
	
	public FXMLLoader createMedia(String selected) {
		FXMLLoader loader = new FXMLLoader();
		System.out.println(selected);
		switch (selected) {
			case "DigitalDisc":
				loader.setLocation(getClass().getResource("../view/DigitalVideo.fxml"));
				break;
			case "CompactDisc":
				loader.setLocation(getClass().getResource("../view/CompactDisc.fxml"));
				break;
			case "Book":
				loader.setLocation(getClass().getResource("../view/Book.fxml"));
				break;
		}
		return loader;
	}
	
}
