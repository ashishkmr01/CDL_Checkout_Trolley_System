package com.cdl.checkoutsystem.service;

import com.cdl.checkoutsystem.model.InventryAndOfferedProduct;
import com.cdl.checkoutsystem.model.Items;
import com.cdl.checkoutsystem.model.StockPending;

/**
 * Service class to implements Items service.
 * 
 * @author Ashish
 *
 */
public class ItemsService {

	private ItemsService() {

	}

	/**
	 * To get Product Items.
	 * 
	 * @param pName
	 * @param inventryAndOfferedProduct
	 * @return
	 */
	public static Items getPItems(String pName, InventryAndOfferedProduct inventryAndOfferedProduct) {
		for (StockPending inStsockItems : inventryAndOfferedProduct.getInStockItems()) {
			if (inStsockItems.getPName().getName().equals(pName)) {
				return inStsockItems.getPName();
			}
		}
		return null;
	}

}
