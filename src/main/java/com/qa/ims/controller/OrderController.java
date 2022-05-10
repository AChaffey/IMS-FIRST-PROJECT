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
		Long customer_id = utils.getLong();
		Order order = orderDAO.create(new Order(customer_id));
//		LOGGER.info("Would you like to add an item to your Order? ");
//		LOGGER.info("Yes or No? ");
//
//		String newItem = utils.getString();
//		addItem(newItem);
		return order;
	}

	public Order addItem(String newItem) {
		Order updatedOrder=null;
		boolean boo = true;

		while (boo) {
			LOGGER.info("Please enter a Item ID");
			Long itemId = utils.getLong();
			LOGGER.info("Please enter your Order ID");
			Long orderId = utils.getLong();
			updatedOrder = this.orderDAO.addItem(itemId, orderId);
			LOGGER.info(" Item added to your order");
			LOGGER.info("Yes or no?");
			LOGGER.info("Would you like to add more to your items?");
			String addMore = utils.getString();

			if (addMore.toLowerCase().equals("no")) {
				boo = false;

				return updatedOrder;
			} else {

				
				return updatedOrder;
			}
		}
		return null;
	}

	

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a new order number");
		Long orderNum = utils.getLong();
		LOGGER.info("Please enter a new order price");
		Double price = utils.getDouble();
		Order order = orderDAO.update(new Order(id, orderNum, price));
		LOGGER.info("Customer Updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
	Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
