package com.cdl.checkoutsystem.model;

/**
 * Class to implments Items.
 * 
 * @author Ashish
 *
 */
public class Items {
	private String itemsName;
	private float price;
	private ProductCategory itemsCategory;

	/**
	 * 
	 * @param name
	 * @param price
	 * @param caragory
	 */
	public Items(String name, float price, ProductCategory caragory) {
		this.itemsName = name;
		this.price = price;
		this.itemsCategory = caragory;
	}

	public String getName() {
		return itemsName;
	}

	public void setName(String name) {
		this.itemsName = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public ProductCategory getCaragory() {
		return itemsCategory;
	}

	public void setCaragory(ProductCategory caragory) {
		this.itemsCategory = caragory;
	}

	@Override
	public int hashCode() {
		return itemsName.hashCode();
	}

	/**
	 * Override equals methods
	 */
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Items prroductItem = (Items) obj;
		if (prroductItem.getName().equals(itemsName)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Override to string method.
	 */
	@Override
	public String toString() {
		return super.toString();
	}

}
