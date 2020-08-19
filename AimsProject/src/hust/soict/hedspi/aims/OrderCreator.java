package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.order.Order;

public class OrderCreator {
	public static final int MAX_NUMBERS_ORDERED = 5;
	public static List<Order> listOrder = new ArrayList<Order>();
	int max = 0;
	
	public boolean createOrder() {
		Order order = new Order();
		if(listOrder.size()<MAX_NUMBERS_ORDERED) {
			for(int i=0;i<listOrder.size();i++) {
				if(listOrder.get(i).getId() > max)
					max = listOrder.get(i).getId();
			}
			order.setId(max+1);
			listOrder.add(order);
			return true;
		}else
			return false;
	}
	
	public Order findOrderInList(int option_1) {
		Helper help = new Helper();
		if(help.check_id_list(listOrder, option_1))
			return listOrder.get(help.getOrder(listOrder, option_1));
		return null;
	}
}
