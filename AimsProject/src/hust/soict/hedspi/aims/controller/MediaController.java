package hust.soict.hedspi.aims.controller;

import hust.soict.hedspi.aims.order.Order;

public class MediaController {
	protected static Order order;

	public Order getOrder() {
		return order;
	}

	public static void setOrder(Order order) {
		MediaController.order = order;
	}
	
}
