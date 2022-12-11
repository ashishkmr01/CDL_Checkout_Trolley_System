package com.cdl.checkoutsystem.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cdl.checkoutsystem.model.InventryAndOfferedProduct;
import com.cdl.checkoutsystem.service.InventoryProcess;

/**
 * To test InventoryProcess
 * 
 * @author Ashish
 *
 */
public class InventoryProcessTest {

	private static final String PRODUCT_NAME_1 = "C1";
	private static final String PRODUCT_NAME_2 = "C2";
	private static final String PRODUCT_NAME_3 = "C3";
	private static final String PRODUCT_ITEMS_1 = "A-Apple";
	private static final String PRODUCT_ITEMS_2 = "B-Banana";
	private static final String PRODUCT_ITEMS_3 = "C-Carrot";
	private static final int TROLLEY_SIZE_4 = 4;
	private static final int PRODUCT_GROUP_NUMBER_2 = 2;
	private static final int PRODUCT_GROUP_NUMBER_3 = 3;
	private static final double PRODUCT_GROUP_PRICE = 130.0;
	private static final float PRODUCT_PRICE_50 = 50.0f;
	private static final double PRODUCT_PRICE_30 = 30.0;
	private static final double PRODUCT_PRICE_20 = 20.0;

	/**
	 * Test method to test findStartingcatalogue.
	 */
	@Test
	public void testFindStartingcatalogue() {
		InventryAndOfferedProduct inventryAndOfferedProduct = InventoryProcess.findStartingcatalogue();
		assertNotNull(inventryAndOfferedProduct);
		assertNotNull(inventryAndOfferedProduct.getInStockItems());
		assertNotNull(inventryAndOfferedProduct.getAvailableDiscount());
		assertEquals(inventryAndOfferedProduct.getInStockItems().size(), TROLLEY_SIZE_4);

		assertNotNull(inventryAndOfferedProduct.getInStockItems().get(0).getPName());
		assertNotNull(inventryAndOfferedProduct.getInStockItems().get(1).getPName());
		assertNotNull(inventryAndOfferedProduct.getInStockItems().get(2).getPName());
		assertNotNull(inventryAndOfferedProduct.getInStockItems().get(3).getPName());

		assertEquals(inventryAndOfferedProduct.getInStockItems().get(0).getPName().getName(), PRODUCT_ITEMS_1);
		assertEquals(inventryAndOfferedProduct.getInStockItems().get(0).getPName().getCaragory().getName(),
				PRODUCT_NAME_1);
		assertTrue(inventryAndOfferedProduct.getInStockItems().get(0).getPName().getPrice() == PRODUCT_PRICE_50);

		assertEquals(inventryAndOfferedProduct.getInStockItems().get(1).getPName().getName(), PRODUCT_ITEMS_2);
		assertEquals(inventryAndOfferedProduct.getInStockItems().get(1).getPName().getCaragory().getName(),
				PRODUCT_NAME_2);
		assertTrue(inventryAndOfferedProduct.getInStockItems().get(1).getPName().getPrice() == PRODUCT_PRICE_30);

		assertEquals(inventryAndOfferedProduct.getInStockItems().get(2).getPName().getName(), PRODUCT_ITEMS_3);
		assertEquals(inventryAndOfferedProduct.getInStockItems().get(2).getPName().getCaragory().getName(),
				PRODUCT_NAME_3);
		assertTrue(inventryAndOfferedProduct.getInStockItems().get(2).getPName().getPrice() == PRODUCT_PRICE_20);

		assertEquals(inventryAndOfferedProduct.getAvailableDiscount().size(), PRODUCT_GROUP_NUMBER_2);

		assertNotNull(inventryAndOfferedProduct.getAvailableDiscount().get(0).getCategory());
		assertNotNull(inventryAndOfferedProduct.getAvailableDiscount().get(1).getCategory());

		assertEquals(inventryAndOfferedProduct.getAvailableDiscount().get(0).getCategory().get(0).getName(),
				PRODUCT_NAME_1);
		assertTrue(inventryAndOfferedProduct.getAvailableDiscount().get(0).getGroupNumber() == PRODUCT_GROUP_NUMBER_3);
		assertTrue(inventryAndOfferedProduct.getAvailableDiscount().get(0).getGroupPrice() == PRODUCT_GROUP_PRICE);

	}

}
