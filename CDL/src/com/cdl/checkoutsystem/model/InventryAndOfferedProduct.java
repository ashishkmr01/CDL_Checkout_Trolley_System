package com.cdl.checkoutsystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to implements InventryAndOfferedProduct
 * 
 * @author Ashish
 *
 */
public class InventryAndOfferedProduct {
	
	List<StockPending> itemsAvailable = new ArrayList<>();
	List<BigSavingOffer> discountAvailable = new ArrayList<>();
	
	/**
	 * 
	 * @return
	 */
	public List<StockPending> getInStockItems() {
		return itemsAvailable;
	}
	/**
	 * 
	 * @param items
	 */
	public void addInStockItems(StockPending items) {
		itemsAvailable.add(items);
	}
	/**
	 * 
	 * @return
	 */
	public List<BigSavingOffer> getAvailableDiscount() {
		return discountAvailable;
	}
	/**
	 * 
	 * @param offer
	 */
	public void addDiscountAvailable(BigSavingOffer offer) {
		this.discountAvailable.add(offer);
	}

}
