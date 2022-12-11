package com.cdl.checkoutsystem.service;

import com.cdl.checkoutsystem.model.InventryAndOfferedProduct;
import com.cdl.checkoutsystem.model.StockPending;

/**
 * Service class of InventryAndOfferedProduct.
 * 
 * @author Ashish
 *
 */
public class InventryAndOfferedProductService {

	private static final String BLANK_SPACE = ", ";

	/**
	 * 
	 */
	private InventryAndOfferedProductService() {

	}

	/**
	 * To getInStockProductName.
	 * 
	 * @param inventryAndOfferedProduct
	 * @return
	 */
	public static String getInStockProductName(InventryAndOfferedProduct inventryAndOfferedProduct) {
		StringBuffer inStock = new StringBuffer();
		boolean flag = true;
		for (StockPending availableItems : inventryAndOfferedProduct.getInStockItems()) {
			if (flag) {
				inStock.append(availableItems.getPName().getName());
				flag = false;
			} else {
				inStock.append(BLANK_SPACE);
				inStock.append(availableItems.getPName().getName());
			}
		}

		return inStock.toString();
	}

}
