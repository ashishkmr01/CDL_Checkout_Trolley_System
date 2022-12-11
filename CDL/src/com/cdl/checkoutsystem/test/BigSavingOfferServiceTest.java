package com.cdl.checkoutsystem.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cdl.checkoutsystem.model.BigSavingOffer;
import com.cdl.checkoutsystem.model.InventryAndOfferedProduct;
import com.cdl.checkoutsystem.model.Items;
import com.cdl.checkoutsystem.model.ProductCategory;
import com.cdl.checkoutsystem.model.StockPending;
import com.cdl.checkoutsystem.model.Trolley;
import com.cdl.checkoutsystem.service.BigSavingOfferService;

/**
 * Test class to test BigSavingOfferService
 * 
 * @author Ashish
 *
 */
public class BigSavingOfferServiceTest {

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
	private static final int TROLLEY_SIZE_1 = 1;
	private static final int TROLLEY_SIZE_2 = 2;
	private static final int TROLLEY_SIZE_3 = 3;
	private static final int TOTAL_AMOUNT = 160;
	private static final int PRODUCT_PRICE_15 = 15;
	private static final int PRODUCT_PRICE_30 = 30;
	private static final int PRODUCT_PRICE_50 = 50;
	private static final int PRODUCT_PRICE_20 = 20;

	/**
	 * Test method to test FindNewTrolley.
	 */
	@Test
	public void testFindNewTrolley() {
		Map<Items, Integer> pMap = new HashMap<>();
		Map<BigSavingOffer, Integer> discountMap = new HashMap<>();
		pMap.put(getP1(), TROLLEY_SIZE_2);
		pMap.put(getP2(), TROLLEY_SIZE_1);

		Trolley currentTrolley = new Trolley();
		currentTrolley.setDiscountMap(discountMap);
		currentTrolley.setPMap(pMap);

		currentTrolley = BigSavingOfferService.findTrolleyPrice(getP1(), currentTrolley, getProdcutDiscountCategory());

		assertNotNull(currentTrolley);
		assertEquals(currentTrolley.getDiscountMap().entrySet().size(), TROLLEY_SIZE_1);
		assertEquals(currentTrolley.getPmap().entrySet().size(), TROLLEY_SIZE_1);

		assertTrue(currentTrolley.getPmap().get(getP2()) == TROLLEY_SIZE_1);
		assertEquals(currentTrolley.getDiscountMap().keySet().iterator().next().getName(), PRODUCT_DISCOUNT_1);
		// System.out.println(currentTrolley.getDiscountMap().keySet().iterator().next().getName());

		currentTrolley = BigSavingOfferService.findTrolleyPrice(getP1(), currentTrolley, getProdcutDiscountCategory());
		// System.out.println(currentTrolley.getDiscountMap().keySet().iterator().next().getName());

		assertNotNull(currentTrolley);
		assertEquals(currentTrolley.getDiscountMap().entrySet().size(), TROLLEY_SIZE_1);
		assertEquals(currentTrolley.getPmap().entrySet().size(), TROLLEY_SIZE_2);

		assertEquals(currentTrolley.getPmap().get(getP2()), new Integer(1));
		assertEquals(currentTrolley.getPmap().get(getP1()), new Integer(1));
		assertEquals(currentTrolley.getDiscountMap().keySet().iterator().next().getName(), PRODUCT_DISCOUNT_1);
	}

	@Test
	public void testfindTrolleyPrice() {
		Map<Items, Integer> pMap = new HashMap<>();
		Map<BigSavingOffer, Integer> discountMap = new HashMap<>();
		pMap.put(getP1(), TROLLEY_SIZE_2);
		pMap.put(getP2(), TROLLEY_SIZE_1);

		Trolley currentTrolley = new Trolley();
		currentTrolley.setDiscountMap(discountMap);
		currentTrolley.setPMap(pMap);

		currentTrolley = BigSavingOfferService.findTrolleyPrice(getP1(), currentTrolley, getProdcutDiscountCategory());
		// System.out.println(BigSavingOfferService.getTotalAmount(currentTrolley));

		assertTrue(BigSavingOfferService.getTotalAmount(currentTrolley) == TOTAL_AMOUNT);
	}

	/**
	 * 
	 * @return
	 */
	private Items getP1() {
		ProductCategory pCategory1 = new ProductCategory(PRODUCT_NAME_1, PRODUCT_DESC_1);
		return new Items(PRODUCT_ITEMS_1, PRODUCT_PRICE_50, pCategory1);
	}

	/**
	 * 
	 * @return
	 */
	private Items getP2() {
		ProductCategory pCategory2 = new ProductCategory(PRODUCT_NAME_2, PRODUCT_DESC_2);
		return new Items(PRODUCT_ITEMS_2, PRODUCT_PRICE_30, pCategory2);
	}

	/**
	 * To Get Dicounted Product
	 * 
	 * @return
	 */
	private InventryAndOfferedProduct getProdcutDiscountCategory() {
		InventryAndOfferedProduct inventryAndOfferedProduct = new InventryAndOfferedProduct();
		ProductCategory pCategory1 = new ProductCategory(PRODUCT_NAME_1, PRODUCT_DESC_1);
		ProductCategory pCategory2 = new ProductCategory(PRODUCT_NAME_2, PRODUCT_DESC_2);
		ProductCategory pCategory3 = new ProductCategory(PRODUCT_NAME_3, PRODUCT_DESC_3);
		ProductCategory pCategory4 = new ProductCategory(PRODUCT_NAME_4, PRODUCT_DESC_4);

		Items pItems1 = new Items(PRODUCT_ITEMS_1, PRODUCT_PRICE_50, pCategory1);
		Items pItems2 = new Items(PRODUCT_ITEMS_2, PRODUCT_PRICE_30, pCategory2);
		Items pItems3 = new Items(PRODUCT_ITEMS_3, PRODUCT_PRICE_20, pCategory3);
		Items pItems4 = new Items(PRODUCT_ITEMS_4, PRODUCT_PRICE_15, pCategory4);

		inventryAndOfferedProduct.addInStockItems(new StockPending(pItems1, 200));
		inventryAndOfferedProduct.addInStockItems(new StockPending(pItems2, 400));
		inventryAndOfferedProduct.addInStockItems(new StockPending(pItems3, 500));
		inventryAndOfferedProduct.addInStockItems(new StockPending(pItems4, 700));

		BigSavingOffer discount1 = new BigSavingOffer(PRODUCT_DISCOUNT_1, TROLLEY_SIZE_3, 130);
		BigSavingOffer discount2 = new BigSavingOffer(PRODUCT_DISCOUNT_2, TROLLEY_SIZE_2, 45);

		discount1.addItemsCategory(pCategory1);
		discount2.addItemsCategory(pCategory2);

		inventryAndOfferedProduct.addDiscountAvailable(discount1);
		inventryAndOfferedProduct.addDiscountAvailable(discount2);

		return inventryAndOfferedProduct;
	}

}
