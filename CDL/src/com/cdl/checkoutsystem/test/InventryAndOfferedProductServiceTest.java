package com.cdl.checkoutsystem.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cdl.checkoutsystem.model.InventryAndOfferedProduct;
import com.cdl.checkoutsystem.model.Items;
import com.cdl.checkoutsystem.model.ProductCategory;
import com.cdl.checkoutsystem.model.StockPending;
import com.cdl.checkoutsystem.service.InventryAndOfferedProductService;

/**
 * To Test InventryAndOfferedProductService
 * 
 * @author Ashish
 *
 */
public class InventryAndOfferedProductServiceTest {

	private static final String PRODUCT_NAME_1 = "C1";
	private static final String PRODUCT_NAME_2 = "C2";
	private static final String PRODUCT_DESC_1 = "Catagory1";
	private static final String PRODUCT_DESC_2 = "Catagory2";
	private static final String PRODUCT_ITEMS_1 = "A-Apple";
	private static final String PRODUCT_ITEMS_2 = "B-Banana";
	private static final String PRODUCT_ITEMS_ALL = "A-Apple, B-Banana";

	/**
	 * Test method to test getInStockProductName1.
	 */
	@Test
	public void testgetInStockProductName1() {
		InventryAndOfferedProduct inventryAndOfferedProduct = new InventryAndOfferedProduct();
		ProductCategory pCategory1 = new ProductCategory(PRODUCT_NAME_1, PRODUCT_DESC_1);
		ProductCategory pCategory2 = new ProductCategory(PRODUCT_NAME_2, PRODUCT_DESC_2);

		Items pItems1 = new Items(PRODUCT_ITEMS_1, 50, pCategory1);
		Items pItems2 = new Items(PRODUCT_ITEMS_2, 30, pCategory2);

		inventryAndOfferedProduct.addInStockItems(new StockPending(pItems1, 200));
		inventryAndOfferedProduct.addInStockItems(new StockPending(pItems2, 400));

		assertEquals(InventryAndOfferedProductService.getInStockProductName(inventryAndOfferedProduct),
				PRODUCT_ITEMS_ALL);
	}

}
