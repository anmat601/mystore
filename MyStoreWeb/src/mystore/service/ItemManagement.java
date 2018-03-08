package mystore.service;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import mystore.bean.BeanManager;
import mystore.dao.ItemDataDao;
import mystore.model.ItemData;
import mystore.model.StoreDetails;
import javax.jws.WebService;

@WebService(endpointInterface = "mystore.service.ItemManagementInterface")
public class ItemManagement implements ItemManagementInterface {
	private ItemDataDao itemDataDao;
	/*
	private static ItemManagement itemManagement;
	private ItemManagement()
	{

	}
	public static ItemManagement getInstance()//Singleton
	{
		if(null==itemManagement)
		{
			itemManagement =new ItemManagement();
		}
		return itemManagement;
	}*/
	public StoreDetails getStoreDetails()
	{
		StoreDetails storeDetails = null;
		try
		{
			File file = new File("C:/Users/eldho/Desktop/storeDetails.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(StoreDetails.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			storeDetails = (StoreDetails) jaxbUnmarshaller.unmarshal(file);
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
		return storeDetails;
	}

	public void updateStoreDetails()
	{ try 
	{
		File file1 = new File("C:/Users/eldho/Desktop/storeDetails.xml");
		JAXBContext jaxbContext1 = JAXBContext.newInstance(StoreDetails.class);
		Marshaller jaxbMarshaller = jaxbContext1.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StoreDetails storeDetails = null;
		jaxbMarshaller.marshal(storeDetails, file1);
		jaxbMarshaller.marshal(storeDetails, System.out);
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public ItemData getItem(String itemName) throws Exception
	{
		StoreDetails storeDetails =getStoreDetails();
		ItemData item = null;
		for(int i=0;i<storeDetails.getItemList().size();i++)
		{
			if((storeDetails.getItemList().get(i).getItemName()).equals(itemName)){
				item =storeDetails.getItemList().get(i);
				throw new Exception();
			}
		}
		return item;
	}

	public boolean addItem(ItemData item)
	{	
		boolean ifItemAdded;

		StoreDetails storeDetails =getStoreDetails();
		boolean itemAlreadyExist=false;
		boolean noItemName=false;
		boolean noPrice=false;
		boolean noMeasurement=false;

		for(int i=0;i<storeDetails.getItemList().size();i++)
		{
			ItemData storeItem =storeDetails.getItemList().get(i);

			if(storeItem.getItemName().equals(item.getItemName()))
			{
				itemAlreadyExist =true;
			}
			if(item.getItemName()==null)
			{
				noItemName=true;
			}
			if(item.getPrice()==0)
			{
				noPrice=true;
			}
			if(item.getMeasurement()==null)
			{
				noMeasurement=true;
			}
		}
		if(!itemAlreadyExist
				&&!noItemName
				&&!noPrice
				&&!noMeasurement)
		{
			storeDetails.getItemList().add(item);
			updateStoreDetails();
		}
		if(itemAlreadyExist)
		{
			System.out.println();
			System.out.println("THE ENTERED ITEM ALREADY EXIST");
		}
		if(noItemName==true)
		{
			System.out.println(" name of the item not entered");
		}
		if(noPrice==true)
		{
			System.out.println("price of the item not entered");
		}
		if(noMeasurement==true)
		{
			System.out.println("measurement field of the item not entered");
		}


		ifItemAdded =true;
		return ifItemAdded;
	}

	public int getPriceOfItem(String itemName)
	{
		int price = 0;
		try
		{   
			StoreDetails storeDetails =getStoreDetails();
			Boolean itemFound=false;
			for(int i=0;i<storeDetails.getItemList().size();i++)
			{
				String item =storeDetails.getItemList().get(i).getItemName();
				if(item.equals(itemName))
				{
					price =storeDetails.getItemList().get(i).getPrice();
					itemFound =true;
				}
			}
			if(!itemFound)
			{
				System.out.println("Item not found");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return price;
	}

	public String getMeasurementOfItem(String itemName)
	{
		String measurement = null;
		try
		{
			StoreDetails storeDetails =getStoreDetails();
			Boolean itemFound=false;
			for(int i=0;i<storeDetails.getItemList().size();i++)
			{
				String item =storeDetails.getItemList().get(i).getItemName();
				if(item.equals(itemName))
				{
					measurement =storeDetails.getItemList().get(i).getMeasurement();
					itemFound =true;
				}
			}
			if(!itemFound)
			{
				System.out.println("Item not found");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return measurement;
	}

	public List<ItemData> GetAllItems()
	{
		/*	StoreDetails storeDetails =getStoreDetails();

		for(int i=0;i<storeDetails.getItemList().size();i++)
		{
			items.add(storeDetails.getItemList().get(i).getItemName());
		}*/
		List<ItemData> items =new ArrayList<ItemData>();
		items = itemDataDao.getItemData();
		return items;

	}

	public ItemDataDao getItemDataDao() {
		return itemDataDao;
	}

	public void setItemDataDao(ItemDataDao itemDataDao) {
		this.itemDataDao = itemDataDao;
	}
}

