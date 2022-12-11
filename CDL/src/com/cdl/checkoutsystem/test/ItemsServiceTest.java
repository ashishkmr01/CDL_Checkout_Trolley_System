package com.cdl.checkoutsystem.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cdl.checkoutsystem.model.InventryAndOfferedProduct;
import com.cdl.checkoutsystem.model.Items;
import com.cdl.checkoutsystem.model.ProductCategory;
import com.cdl.checkoutsystem.model.StockPending;
import com.cdl.checkoutsystem.service.ItemsService;

/**
 * To Test ItemsService
 * 
 * @author Ashish
 *
 */
public class ItemsServiceTest {

	private static final String PRODUCT_NAME_1 = "C1";
	private static final String PRODUCT_NAME_2 = "C2";
	private static final String PRODUCT_DESC_1 = "Catagory1";
	private static final String PRODUCT_DESC_2 = "Catagory2";
	private static final String PRODUCT_ITEMS_1 = "A-Apple";
	private static final String PRODUCT_ITEMS_2 = "B-Banana";
	private static final int PRODUCT_PRICE_30 = 30;
	private static final int PRODUCT_PRICE_50 = 50;
	private static final double PRICE_50 = 50.0;

	/**
	 * To test method GetPItems.
	 */
	@Test
	public void testGetPItems() {
		InventryAndOfferedProduct inventryAndOfferedProduct = getProductDiscountStock();

		Items pItems = ItemsService.getPItems(PRODUCT_ITEMS_1, inventryAndOfferedProduct);

		assertNotNull(pItems);
		assertEquals(pItems.getCaragory().getName(), PRODUCT_NAME_1);
		assertEquals(pItems.getName(), PRODUCT_ITEMS_1);
		assertTrue(pItems.getPrice() == PRICE_50);

	}

	/**
	 * To get Product DiscountStock.
	 * 
	 * @return
	 */
	private InventryAndOfferedProduct getProductDiscountStock() {
		InventryAndOfferedProduct productAndOfferInventory = new InventryAndOfferedProduct();
		ProductCategory productCatagory1 = new ProductCategory(PRODUCT_NAME_1, PRODUCT_DESC_1);
		ProductCategory productCatagory2 = new ProductCategory(PRODUCT_NAME_2, PRODUCT_DESC_2);

		Items productItem1 = new Items(PRODUCT_ITEMS_1, PRODUCT_PRICE_50, productCatagory1);
		Items productItem2 = new Items(PRODUCT_ITEMS_2, PRODUCT_PRICE_30, productCatagory2);

		productAndOfferInventory.addInStockItems(new StockPending(productItem1, 200));
		productAndOfferInventory.addInStockItems(new StockPending(productItem2, 400));
		return productAndOfferInventory;
	}

}
