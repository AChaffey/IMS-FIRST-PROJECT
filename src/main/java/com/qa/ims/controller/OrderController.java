package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter Customer ID");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		boolean bool = true;
		Order updatedOrder = null;
		while (bool) {
			LOGGER.info("Would you like to add or remove and item in your order? Type Break to Exit");
			String input = utils.getString();
			if (input.toLowerCase().equals("add")) {
				LOGGER.info("Which order would you like to add to?");
				Long orderId = utils.getLong();
				LOGGER.info("Which item would you like to add to this order?");
				Long itemId = utils.getLong();
				updatedOrder = orderDAO.addItem(orderId, itemId);
				LOGGER.info("Would you like to make another change to your order?");
				String addMore = utils.getString();
				if (addMore.toLowerCase().equals("yes")) {
					bool = true;
				} else {
					bool = false;
				
				}
			} else if (input.toLowerCase().equals("remove")) {
				LOGGER.info("Which order would you like to remove from?");
				Long orderId = utils.getLong();
				LOGGER.info("Which item would you like to remove from this order?");
				Long itemId = utils.getLong();
				updatedOrder = orderDAO.addItem(orderId, itemId);
				LOGGER.info("Would you like to make another change to your order?");
				String addMore = utils.getString();
				if (addMore.toLowerCase().equals("yes")) {
					bool = true;
				} else {
					bool = false;
					
				}
			} else if (input.toLowerCase().equals("break")) {
				bool = false;
				return updatedOrder;
			}
		}
		return updatedOrder;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
