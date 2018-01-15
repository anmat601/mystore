package mystore.service;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import mystore.model.ItemData;
import mystore.model.StoreDetails;

public class StockManagement {

	private ItemManagement itemManagement;
	//this method returns the list of items needed to be refilled for the given vendor
	public List<String> ItemsToBeRefilled(String vendorName)
	{
		List<String> itemsToBeRefilled =new ArrayList<String>();
		StoreDetails storeDetails =itemManagement.getStoreDetails();
		boolean vendorFound=false;
		ItemData item;
		boolean shortInStock =false;

		for(int i=0;i<storeDetails.getItemList().size();i++)
		{
			item=storeDetails.getItemList().get(i);

			if(storeDetails.getItemList()!=null
					&&item.getStockDetails()!=null
					&&item.getStockDetails().getSupplier().equals(vendorName))
			{
				vendorFound=true;
				int refill =(item.getStockDetails().getMinimumExpectedStock())-(item.getStockDetails().getAvailableStock());

				if(refill>0)
				{
					shortInStock =true;
					itemsToBeRefilled.add(item.getItemName());	
				}
			}
		}
		if(shortInStock)
		{
			System.out.println("Items to be refilled ");
		}
		if((!shortInStock)&&(vendorFound))
		{
			System.out.println("Enough Stock available");
		}
		if(!vendorFound)
		{
			System.out.println("No items of this vendor found");
		}
		return itemsToBeRefilled;
	}
	public ItemManagement getItemManagement() {
		return itemManagement;
	}
	public void setItemManagement(ItemManagement itemManagement) {
		this.itemManagement = itemManagement;
	}
}
