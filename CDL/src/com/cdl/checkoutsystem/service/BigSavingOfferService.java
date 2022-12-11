package com.cdl.checkoutsystem.service;

import java.util.Map.Entry;

import com.cdl.checkoutsystem.model.BigSavingOffer;
import com.cdl.checkoutsystem.model.InventryAndOfferedProduct;
import com.cdl.checkoutsystem.model.Items;
import com.cdl.checkoutsystem.model.ProductCategory;
import com.cdl.checkoutsystem.model.Trolley;

/**
 * Service class to implements big saving and offers.
 * @author Ashish
 *
 */
public class BigSavingOfferService {
	
	private BigSavingOfferService() {
		
	}

	/**
	 * To find findTrolleyPrice.
	 * @param nItems
	 * @param currentTrolley
	 * @param inventryAndOfferedProduct
	 * @return
	 */
	public static Trolley findTrolleyPrice(Items nItems, Trolley currentTrolley,
			InventryAndOfferedProduct inventryAndOfferedProduct) {
		Trolley trolley = currentTrolley;
		
		Integer itemCount = getItemsNumber(nItems, trolley);

		BigSavingOffer dicount = getDiscountForProduct(nItems, inventryAndOfferedProduct);

		if (dicount == null) {
			trolley.addPCount(nItems, itemCount);
		} else if (itemCount == dicount.getGroupNumber()) {
			addDicountToTrolley(nItems, trolley, dicount);
		} else {
			trolley.addPCount(nItems, itemCount);
		}

		return trolley;
	}
	
	public static float getTotalAmount(Trolley trolley) {
		float status = 0;
		
		for(Entry<Items, Integer> pItems:trolley.getPmap().entrySet()) {
			status += pItems.getKey().getPrice() * pItems.getValue();
		}
		
		for(Entry<BigSavingOffer, Integer> discountPrice:trolley.getDiscountMap().entrySet()) {
			status += discountPrice.getKey().getGroupPrice() * discountPrice.getValue();
		}
		
		return status;
	}

	private static Integer getItemsNumber(Items nItems, Trolley currentTrolley) {
		Integer Icount = currentTrolley.getPCount(nItems);
		if (Icount == null) {
			Icount = 0;
		}
		Icount = Icount + 1;
		return Icount;
	}

	private static void addDicountToTrolley(Items nItems, Trolley currentTrolley, BigSavingOffer discount) {
		currentTrolley.remove(nItems);
		Integer discountCount = currentTrolley.getDiscountNumber(discount);
		if (discountCount == null) {
			discountCount = 0;
		}
		discountCount = discountCount + 1;
		
		discount.addProductDiscount(nItems);
		
		currentTrolley.addDiscountCount(discount, discountCount);
	}

	

	/**
	 * To getDiscountForProduct.
	 * @param pItems
	 * @param inventryAndOfferedProduct
	 * @return
	 */
	private static BigSavingOffer getDiscountForProduct(Items pItems, InventryAndOfferedProduct inventryAndOfferedProduct) {
		for (BigSavingOffer discount : inventryAndOfferedProduct.getAvailableDiscount()) {
			boolean matching = false;
			for (ProductCategory pCategory : discount.getCategory()) {
				if (pCategory != null && pCategory.getName().equals(pItems.getCaragory().getName())) {
					matching = true;
					break;
				}
			}
			if (matching) {
				return discount;
			}
		}

		return null;
	}


}
