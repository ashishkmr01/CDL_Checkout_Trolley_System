package com.cdl.checkoutsystem.main;
import java.util.Scanner;

import com.cdl.checkoutsystem.model.InventryAndOfferedProduct;
import com.cdl.checkoutsystem.model.Items;
import com.cdl.checkoutsystem.model.Trolley;
import com.cdl.checkoutsystem.service.BigSavingOfferService;
import com.cdl.checkoutsystem.service.InventoryProcess;
import com.cdl.checkoutsystem.service.InventryAndOfferedProductService;
import com.cdl.checkoutsystem.service.ItemsService;

/**
 * Main class allow for items to input at the command line, and allow for a
 * final total to be calculated and for a running total after each item is
 * ‘scanned’
 * 
 * @author Ashish
 *
 */
public class CDLCheckoutSystem {
	
	private static final String PURCAHSE_DONE = "Done";

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		InventryAndOfferedProduct inventryAndOfferedProduct = null;
		try (Scanner scanner = new Scanner(System.in)) {
			
			inventryAndOfferedProduct = InventoryProcess.findStartingcatalogue();
			
			System.out.println("Enter product in shopping trolley : ");
			
			
			Trolley trolley = new Trolley();
			String trolleyProduct = null;
			Items pItems = null;
			while (!PURCAHSE_DONE.equals(trolleyProduct)) {
				System.out.println("Trolley Items : [" + InventryAndOfferedProductService.getInStockProductName(inventryAndOfferedProduct) +"]. PURCHASE : "+PURCAHSE_DONE);
				trolleyProduct = scanner.nextLine();
				pItems = ItemsService.getPItems(trolleyProduct, inventryAndOfferedProduct);
				
				
				if(pItems == null) {
					System.out.println("Trolley Product enter not valid : ");
					System.out.println("All Valid products are: " + InventryAndOfferedProductService.getInStockProductName(inventryAndOfferedProduct));
				} else if (!PURCAHSE_DONE.equals(trolleyProduct)) {
					trolley = BigSavingOfferService.findTrolleyPrice(pItems, trolley, inventryAndOfferedProduct);
				} 
				
			}
			
			System.out.println("Trolley Total cost : " + BigSavingOfferService.getTotalAmount(trolley));
		}
		
	}

}
