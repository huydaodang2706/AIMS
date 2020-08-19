package hust.soict.hedspi.aims.order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 5;
	private int max = 0;

	public static int nbOrders = 0;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// private DigitalVideoDisc itemsOrdered[] = new
	// DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private List<Media> itemsOrdered = new ArrayList<Media>();

	private float ttCost;
	private MyDate dateOrdered;

	public Order() {
		super();
		if (Order.nbOrders < MAX_LIMITED_ORDERS) {
			this.ttCost = 0;
			this.dateOrdered = new MyDate();
			Order.nbOrders++;
		} else
			System.out.println("Cannot create more order");
	}

	public static int getNbOrders() {
		return nbOrders;
	}

	public static void setNbOrders(int nbOrders) {
		Order.nbOrders = nbOrders;
	}

	public List<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(List<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public float getTtCost() {
		return ttCost;
	}

	public void setTtCost(float ttCost) {
		this.ttCost = ttCost;
	}

	public static int getMaxNumbersOrdered() {
		return MAX_NUMBERS_ORDERED;
	}

	public static int getMaxLimitedOrders() {
		return MAX_LIMITED_ORDERS;
	}

	public MyDate getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public boolean addMedia(Media item) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < itemsOrdered.size(); i++) {
				if (itemsOrdered.get(i).getId() > max)
					max = itemsOrdered.get(i).getId();
			}
			item.setId(max + 1);
			itemsOrdered.add(item);
			System.out.println("The item has been added");
			return true;
		} else {
			System.out.println("The order is almost full");
			return false;
		}
	}

//	public void addMedia(Media [] items) {
//		for(int i=0;i<items.length;i++) {
//			if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
//				itemsOrdered.add(items[i]);
//				System.out.println("Item has been added");
//			}else {
//				System.out.println("Order almost full");
//				break;
//			}
//		}
//	}

	public void removeMedia(Media item) {
		if (itemsOrdered.contains(item)) {
			itemsOrdered.remove(item);
			System.out.println("The item has already removed");
		} else {
			System.out.println("The order does not have this item");
		}
	}

	public void removeMedia(int index) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == index) {
				itemsOrdered.remove(i);
				System.out.println("Remove successfully!");
				return;
			}
		}
		System.out.println("Can't find this items");
	}

	public boolean checkId(int option) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == option) {
				return true;
			}
		}
		return false;
	}

//    Get the total cost
	public float totalCost() {
		ttCost = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			ttCost += itemsOrdered.get(i).getCost();
		}
		return ttCost;
	}

	public void print() {
		System.out.printf("Created Date: ");
		this.dateOrdered.print();
		for (int i = 0; i < itemsOrdered.size(); i++) {
			itemsOrdered.get(i).print();
		}
		System.out.println("Total cost: " + this.totalCost());
	}

	public void printInOrder() {
		Collections.sort(itemsOrdered);
		System.out.printf("Created Date: ");
		this.dateOrdered.print();
		for (int i = 0; i < itemsOrdered.size(); i++) {
			itemsOrdered.get(i).print();
		}
		System.out.println("Total cost: " + this.totalCost());
	}
}
