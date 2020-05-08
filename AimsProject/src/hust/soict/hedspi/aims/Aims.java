package hust.soict.hedspi.aims;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;

public class Aims {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	Thread memCon = new Thread(new MemoryDaemon(), "Memory Observation");
//    memCon.setDaemon(true);
//    memCon.start();	
		
	List<Order> listOrder = new ArrayList<Order>();
	boolean check_program = true;
	Scanner sc = new Scanner(System.in);
	int option = -1;
	int option_1 = -1;
	int option_2 = -1;
	int option_3 = -1;
	int max = 0;
	
	Helper help = new Helper();
	
	while(true) {
		
		help.showMenu();
		option = help.inputOption(0, 4);
//		System.out.println(option);
		
		switch (option) {
		case 1:
			Order order = new Order();
			if(listOrder.size()<5) {
				for(int i=0;i<listOrder.size();i++) {
					if(listOrder.get(i).getId() > max)
						max = listOrder.get(i).getId();
				}
				order.setId(max+1);
				listOrder.add(order);
				System.out.println("Create order succesfully");
			}else
				System.out.println("Cannot add more order");
			break;
		case 2:
			
			check_program = true;
			String title;
			String category;
			float cost = 0;
			int length = 0;
			String artist;
			if(listOrder.size() == 0) {
				System.out.println("There are no order here");
				break;
			}
			while (check_program) {
				System.out.println("Enter id of order to add item in");
				try {
					 option_1 = sc.nextInt();
					
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("Error in input");
					continue;
				}
				if(help.check_id_list(listOrder, option_1))
					check_program = false;
				else
					System.out.println("Id not exists");
				sc.nextLine();
			}
			Order tempOrder = listOrder.get(help.getOrder(listOrder, option_1)); 
			if(tempOrder.getItemsOrdered().size() > tempOrder.MAX_NUMBERS_ORDERED ) {
				System.out.println("Order is full, you can't add more items");
				break;
			}
		
			System.out.println("Select type of media");
			System.out.println("1.Digital Video Disc");
			System.out.println("2.Book");
			System.out.println("3.Compact Disc");
			option_2 = help.inputOption(1, 3);

			switch (option_2) {
			case 1:
				System.out.println("Now you can add new Disc");
				System.out.printf("Enter title:");
				title = sc.nextLine();
				System.out.printf("Enter category:");
				category = sc.nextLine();
				System.out.printf("Enter director:");
				String director = sc.nextLine();
				
				length = help.inputLength();
			    cost = help.inputCost();

				DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
				tempOrder.addMedia(dvd);
				break;
			case 2:
				System.out.println("Now you can add new Book");
				System.out.printf("Enter title:");
				title = sc.nextLine();
				System.out.printf("Enter category:");
				category = sc.nextLine();
				
				List<String> authors = new ArrayList<String>();
				String author;
				check_program = true;
								
				while(check_program) {
					System.out.println("Add authors");
					System.out.println("1.add more author");
					System.out.println("2.Exit add author");
					option_3 = help.inputOption(1, 2);
					switch (option_3) {
					case 1:
						System.out.printf("Enter author:");
						author = sc.nextLine();
						authors.add(author);
						break;
					case 2:
						break;

					default:
						break;
					}
					if(option_3 == 2)
						break;
				}

			    cost = help.inputCost();
			    
				Book book = new Book(authors, title, category, cost);
				tempOrder.addMedia(book);
		
				break;
				
			case 3:
				System.out.println("Now you can add new Compact Disc");
				System.out.printf("Enter title:");
				title = sc.nextLine();
				System.out.printf("Enter category:");
				category = sc.nextLine();
				cost = help.inputCost();
				System.out.printf("Enter artist:");
				artist = sc.nextLine();
				
				CompactDisc compactdvd = new CompactDisc(artist, title, category, cost);
				check_program = true;
				String track_title;
				int track_length = 0;
				while(check_program) {
					System.out.println("Add tracks");
					System.out.println("1.Add more track");
					System.out.println("2.Exit add track");
					option_3 = help.inputOption(1, 2);
					switch (option_3) {
					case 1:
						System.out.println("Enter track ");
						System.out.printf("Enter title: ");
						track_title = sc.nextLine();
						track_length = help.inputLength();
						Track track = new Track(track_title, track_length);
						compactdvd.addTrack(track);
						break;
					case 2:
						break;

					default:
						break;
					}
					if(option_3 == 2)
						break;
				}
				tempOrder.addMedia(compactdvd);
				
				break;
				
			default:
				break;
			}
			
			break;
		case 3:
			check_program = true;
			while (check_program) {
				System.out.println("Enter id of order to delete item ");
				try {
					 option_1 = sc.nextInt();
					
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("Error in input");
					continue;
				}
				if( help.check_id_list(listOrder, option_1))
					check_program = false;
				else
					System.out.println("Id not exists");
				sc.nextLine();
			}
			tempOrder = listOrder.get(help.getOrder(listOrder, option_1)); 
			check_program = true;
			while(check_program) {
				System.out.println("Enter id of item ");
				try {
					 option_2 = sc.nextInt();
					
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("Error in input");
					continue;
				}
				if( tempOrder.checkId(option_2))
					check_program = false;
				else
					System.out.println("Id not exists");
				sc.nextLine();
			}
			tempOrder.removeMedia(option_2);
			
			break;

		case 4:
			System.out.println("Print order");
			for(int i=0;i<listOrder.size();i++) {
				System.out.println("------------------------------");
				System.out.println("Order " + listOrder.get(i).getId());
				listOrder.get(i).printInOrder();
			}
			break;
		case 0:
			System.out.println("Bye bye");
			System.exit(0);;
			break;
		
		default:
			break;
		}
	}

	}

}
