package mystore.service;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import mystore.model.ItemData;
import mystore.model.StoreDetails;

public class BillingManagement {

	private int total;
	private static HashMap<String,Integer> itemsInCart = new HashMap<String,Integer>();
	private static BillingManagement instance;
	private BillingManagement(){
		
	}
	public static BillingManagement getInstance(){
		if(instance==null){
			instance=new BillingManagement();
		}
		return instance;
	}
	
 
	/**
	 * Adds an item to the cart and re-calculates the total price of the items in the cart
	 * @param itemName Name of the item
	 * @param count count of the item
	 */
	public void addTocart(String itemName, int count)
	{
		try
		{ 
			StoreDetails storeDetails =ItemManagement.getInstance().getStoreDetails();

			itemsInCart.put(itemName, count);

			Set<Entry<String,Integer>> hashSet=itemsInCart.entrySet();
			for(Entry<String, Integer> entry:hashSet)
			{
				System.out.println(""+entry.getKey()+"                "+ entry.getValue());
			}

			ItemData item =ItemManagement.getInstance().getItem(itemName);

			total +=(item.getPrice())*count;

			System.out.println(total);
			//itemsInCart.clear();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

