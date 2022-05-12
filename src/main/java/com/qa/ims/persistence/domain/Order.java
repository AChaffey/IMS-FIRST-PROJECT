package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

	private Long id;
	private Long customerId;
	private Double price;
	private List<Item> orderItems = new ArrayList<>();

	public Order(Long id, Long customerId, List<Item> orderItems) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderItems = orderItems;
	}

	public Order(Long customerId) {
		super();
		this.customerId = customerId;
	}

	public Order(Long id, Long customerId) {
		super();
		this.id = id;
		this.customerId = customerId;
	}

	public Order(Long id, Long customerId, Double price) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.setPrice(price);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<Item> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Item> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		double price = 0;
		for (Item i : orderItems)
			price += i.getItemprice();
		return "Order [id=" + id + ", customerId=" + customerId + ", orderItems=" + orderItems + "]\nOrder Total: £"
				+ price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, id, orderItems);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(id, other.id)
				&& Objects.equals(orderItems, other.orderItems);
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}