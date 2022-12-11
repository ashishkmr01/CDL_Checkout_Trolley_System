package com.cdl.checkoutsystem.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Offer class to implement product offers.
 * 
 * @author Ashish
 *
 */
public class BigSavingOffer {
	
	private String productName;
	private List<ProductCategory> categoryApplied = new ArrayList<>();
	private List<Items> discountedProduct  = new ArrayList<>();
	private int gNumber;
	private float gPrice;
	
	private LocalDate discountStartDate = LocalDate.now();
	private LocalDate discountEndDate = LocalDate.now().plusDays(1);
	/**
	 * 
	 * @param name
	 * @param groupNumber
	 * @param groupPrice
	 */
	public BigSavingOffer(String name, int groupNumber, float groupPrice) {
		this.productName = name;
		this.gNumber = groupNumber;
		this.gPrice = groupPrice;
	}
	public String getName() {
		return productName;
	}
	public void setName(String name) {
		this.productName = name;
	}
	public List<ProductCategory> getCategory() {
		return categoryApplied;
	}
	public void addItemsCategory(ProductCategory productCatagory) {
		categoryApplied.add(productCatagory);
	}
	public int getGroupNumber() {
		return gNumber;
	}
	public void setGroupNumber(int groupNumber) {
		this.gNumber = groupNumber;
	}
	public float getGroupPrice() {
		return gPrice;
	}
	public void setGroupPrice(float groupPrice) {
		this.gPrice = groupPrice;
	}
	public List<Items> getProductsInTheOffer() {
		return discountedProduct;
	}
	public void addProductDiscount(Items items) {
		discountedProduct.add(items);
	}
	public LocalDate getOfferStartDate() {
		return discountStartDate;
	}
	public void setOfferStartDate(LocalDate offerStartDate) {
		this.discountStartDate = offerStartDate;
	}
	public LocalDate getOfferEndDate() {
		return discountEndDate;
	}
	public void setOfferEndDate(LocalDate offerEndDate) {
		this.discountEndDate = offerEndDate;
	}
	@Override
	public int hashCode() {
		return productName.hashCode();
	}
	/**
	 * Override equal method.
	 */
	@Override
	public boolean equals(Object obj) {
		if((obj == null) || (getClass() != obj.getClass())){
	        return false;
	    }
		BigSavingOffer offer = (BigSavingOffer) obj;
		if(offer.getName().equals(productName)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * override to string methods.
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	

}
