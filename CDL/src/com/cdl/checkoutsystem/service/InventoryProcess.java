package com.cdl.checkoutsystem.service;

import com.cdl.checkoutsystem.model.BigSavingOffer;
import com.cdl.checkoutsystem.model.InventryAndOfferedProduct;
import com.cdl.checkoutsystem.model.Items;
import com.cdl.checkoutsystem.model.ProductCategory;
import com.cdl.checkoutsystem.model.StockPending;

/**
 * Service class to implements InventoryProcess.
 * 
 * @author Ashish
 *
 */
public class InventoryProcess {

	private InventoryProcess() {
	}

	/**
	 * To findStartingcatalogue.
	 * 
	 * @return
	 */
	public static InventryAndOfferedProduct findStartingcatalogue() {

		InventryAndOfferedProduct inventryAndOfferedProduct = new InventryAndOfferedProduct();
		ProductCategory ProductCat1 = new ProductCategory("C1", "Catagory1");
		ProductCategory ProductCat2 = new ProductCategory("C2", "Catagory2");
		ProductCategory ProductCat3 = new ProductCategory("C3", "Catagory3");
		ProductCategory ProductCat4 = new ProductCategory("C4", "Catagory4");

		Items productI1 = new Items("A-Apple", 50, ProductCat1);
		Items productI2 = new Items("B-Banana", 30, ProductCat2);
		Items productI3 = new Items("C-Carrot", 20, ProductCat3);
		Items productI4 = new Items("D-Dragon Fruit", 15, ProductCat4);

		inventryAndOfferedProduct.addInStockItems(new StockPending(productI1, 200));
		inventryAndOfferedProduct.addInStockItems(new StockPending(productI2, 400));
		inventryAndOfferedProduct.addInStockItems(new StockPending(productI3, 500));
		inventryAndOfferedProduct.addInStockItems(new StockPending(productI4, 700));

		BigSavingOffer discount1 = new BigSavingOffer("Discount1", 3, 130);
		BigSavingOffer discount2 = new BigSavingOffer("Discount2", 2, 45);

		discount1.addItemsCategory(ProductCat1);
		discount2.addItemsCategory(ProductCat1);

		inventryAndOfferedProduct.addDiscountAvailable(discount1);
		inventryAndOfferedProduct.addDiscountAvailable(discount2);

		return inventryAndOfferedProduct;

	}

}
