package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private int id;
	private String itemName;
	private int price;
	
	public Item(int id, String itemName, int price) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemName, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return id == other.id && Objects.equals(itemName, other.itemName) && price == other.price;
	}
	
}