package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long id;
	private String itemName;
	private Double price;
	public Item(Long id, String itemName, Double price) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		
	}
	public Item(String itemName, Double price) {
		super();
		this.itemName = itemName;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", item_name=" + itemName + ", item_price=" + price + "]";
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
		return Objects.equals(id, other.id) && Objects.equals(itemName, other.itemName)
				&& Objects.equals(price, other.price);
	}
	
	
}