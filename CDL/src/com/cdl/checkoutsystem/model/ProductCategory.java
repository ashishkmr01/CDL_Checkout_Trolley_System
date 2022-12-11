package com.cdl.checkoutsystem.model;

/**
 * Class to implments Product Category.
 * 
 * @author Ashish
 *
 */
public class ProductCategory {

	private String productName;
	private String productDesc;

	/**
	 * 
	 * @param name
	 * @param description
	 */
	public ProductCategory(String name, String description) {
		super();
		this.productName = name;
		this.productDesc = description;
	}

	public String getName() {
		return productName;
	}

	public void setName(String name) {
		this.productName = name;
	}

	public String getDescription() {
		return productDesc;
	}

	public void setDescription(String description) {
		this.productDesc = description;
	}

}
