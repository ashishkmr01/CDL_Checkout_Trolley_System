package com.cdl.checkoutsystem.model;

/**
 * Class to implements Stock Pending.
 * 
 * @author Ashish
 *
 */
public class StockPending {

	private Items items;
	private int stockVailability;

	/**
	 * 
	 * @param productItem
	 * @param inStockNumber
	 */
	public StockPending(Items productItem, int inStockNumber) {
		this.items = productItem;
		this.stockVailability = inStockNumber;
	}

	public Items getPName() {
		return items;
	}

	public void setProductItem(Items productItem) {
		this.items = productItem;
	}

	public int getInStockNumber() {
		return stockVailability;
	}

	public void setInStockNumber(int inStockNumber) {
		this.stockVailability = inStockNumber;
	}

}
