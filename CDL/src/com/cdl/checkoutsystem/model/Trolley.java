package com.cdl.checkoutsystem.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to implements Trolley.
 * @author Ashish
 *
 */
public class Trolley {

	private Map<Items, Integer> pMap = new HashMap<>();
	private Map<BigSavingOffer, Integer> discountMap = new HashMap<>();

	public Map<Items, Integer> getPmap() {
		return pMap;
	}

	public Integer getPCount(Items pItems) {
		return pMap.get(pItems);
	}

	public void addPCount(Items pItems, Integer count) {
		remove(pItems);
		pMap.put(pItems, count);
	}

	public void remove(Items pItems) {
		if (pMap.containsKey(pItems)) {
			pMap.remove(pItems);
		}
	}

	public void setPMap(Map<Items, Integer> pMap) {
		this.pMap = pMap;
	}

	public Map<BigSavingOffer, Integer> getDiscountMap() {
		return discountMap;
	}

	public Integer getDiscountNumber(BigSavingOffer offers) {
		return discountMap.get(offers);
	}

	public void addDiscountCount(BigSavingOffer offer, Integer count) {
		if (discountMap.containsKey(offer)) {
			discountMap.remove(offer);
		}

		discountMap.put(offer, count);
	}

	public void setDiscountMap(Map<BigSavingOffer, Integer> offersMap) {
		this.discountMap = offersMap;
	}

}
