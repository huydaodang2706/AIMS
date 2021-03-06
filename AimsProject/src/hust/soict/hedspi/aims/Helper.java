package hust.soict.hedspi.aims;

import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.order.Order;

public class Helper {
	Scanner sc = new Scanner(System.in);

	public void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public float inputCost() {
		float cost = 0;
		boolean check = true;
	    while (check) {
			System.out.printf("Enter cost:");
			try {
				 cost = sc.nextFloat();
				
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Error in input");
				continue;
			}
			check = false;
			sc.nextLine();
		}
	    return cost;
	}
	
	public int inputLength() {
		boolean check = true;
		int length = 0;
		while (check) {
			System.out.printf("Enter length:");
			try {
				 length = sc.nextInt();
				
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Error in input");
				continue;
			}
			check = false;
			sc.nextLine();
		}
		return length;
	}
	
	public int inputOption(int begin, int end) {
		boolean check_temp = true;
		int option = -1;
		while(check_temp) {			
			try {
				option = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Invalid input");
				sc.nextLine();
				continue;
				// TODO: handle exception
			}

			if(option >= begin && option <= end)
				check_temp = false;
			else
				System.out.println("Enter option from " + begin + " to " + end);
			sc.nextLine();
		}

		return option;
	}
	
	public boolean check_id_list(List<Order> listOrder,int option) {
		for(int i=0;i<listOrder.size();i++) {
			if(listOrder.get(i).getId() == option)
				return true;
		}
		return false;
	}
	public int getOrder(List<Order> listOrder,int option) {
		for(int i=0;i<listOrder.size();i++) {
			if(listOrder.get(i).getId() == option)
				return i;
		}
		return -1;
	}
	
}
