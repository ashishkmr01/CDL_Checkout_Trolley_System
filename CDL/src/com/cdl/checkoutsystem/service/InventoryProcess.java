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
	
	private static final String PRODUCT_NAME_1 = "C1";
	private static final String PRODUCT_NAME_2 = "C2";
	private static final String PRODUCT_NAME_3 = "C3";
	private static final String PRODUCT_NAME_4 = "C4";
	private static final String PRODUCT_DESC_1 = "Catagory1";
	private static final String PRODUCT_DESC_2 = "Catagory2";
	private static final String PRODUCT_DESC_3 = "Catagory3";
	private static final String PRODUCT_DESC_4 = "Catagory4";
	private static final String PRODUCT_ITEMS_1 = "A-Apple";
	private static final String PRODUCT_ITEMS_2 = "B-Banana";
	private static final String PRODUCT_ITEMS_3 = "C-Carrot";
	private static final String PRODUCT_ITEMS_4 = "D-Dragon Fruit";
	private static final String PRODUCT_DISCOUNT_1 = "Discount1";
	private static final String PRODUCT_DISCOUNT_2 = "Discount2";
	private static final int PRODUCT_PRICE_15 = 15;
	private static final int PRODUCT_PRICE_30 = 30;
	private static final int PRODUCT_PRICE_50 = 50;
	private static final int PRODUCT_PRICE_20 = 20;

	private InventoryProcess() {
	}

	/**
	 * To findStartingcatalogue.
	 * 
	 * @return
	 */
	public static InventryAndOfferedProduct findStartingcatalogue() {

		InventryAndOfferedProduct inventryAndOfferedProduct = new InventryAndOfferedProduct();
		ProductCategory ProductCat1 = new ProductCategory(PRODUCT_NAME_1, PRODUCT_DESC_1);
		ProductCategory ProductCat2 = new ProductCategory(PRODUCT_NAME_2, PRODUCT_DESC_2);
		ProductCategory ProductCat3 = new ProductCategory(PRODUCT_NAME_3, PRODUCT_DESC_3);
		ProductCategory ProductCat4 = new ProductCategory(PRODUCT_NAME_4, PRODUCT_DESC_4);

		Items productI1 = new Items(PRODUCT_ITEMS_1, PRODUCT_PRICE_50, ProductCat1);
		Items productI2 = new Items(PRODUCT_ITEMS_2, PRODUCT_PRICE_30, ProductCat2);
		Items productI3 = new Items(PRODUCT_ITEMS_3, PRODUCT_PRICE_20, ProductCat3);
		Items productI4 = new Items(PRODUCT_ITEMS_4, PRODUCT_PRICE_15, ProductCat4);

		inventryAndOfferedProduct.addInStockItems(new StockPending(productI1, 200));
		inventryAndOfferedProduct.addInStockItems(new StockPending(productI2, 400));
		inventryAndOfferedProduct.addInStockItems(new StockPending(productI3, 500));
		inventryAndOfferedProduct.addInStockItems(new StockPending(productI4, 700));

		BigSavingOffer discount1 = new BigSavingOffer(PRODUCT_DISCOUNT_1, 3, 130);
		BigSavingOffer discount2 = new BigSavingOffer(PRODUCT_DISCOUNT_2, 2, 45);

		discount1.addItemsCategory(ProductCat1);
		discount2.addItemsCategory(ProductCat1);

		inventryAndOfferedProduct.addDiscountAvailable(discount1);
		inventryAndOfferedProduct.addDiscountAvailable(discount2);

		return inventryAndOfferedProduct;

	}

}
