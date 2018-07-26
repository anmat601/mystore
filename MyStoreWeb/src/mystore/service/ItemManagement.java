package mystore.service;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import mystore.bean.BeanManager;
import mystore.controller.ItemManagementController;
import mystore.dao.ItemDataDao;
import mystore.model.ItemData;
import mystore.model.StoreDetails;
import javax.jws.WebService;


@WebService(endpointInterface = "mystore.service.ItemManagementInterface")
@Transactional

public class ItemManagement implements ItemManagementInterface {
	private ItemDataDao itemDataDao;
	final static Logger logger = LogManager.getLogger(ItemManagement.class);


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
	{ 
		try 
		{
			File file1 = new File("C:/Users/eldho/Desktop/storeDetails.xml");
			JAXBContext jaxbContext1 = JAXBContext.newInstance(StoreDetails.class);
			Marshaller jaxbMarshaller = jaxbContext1.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StoreDetails storeDetails = null;
			jaxbMarshaller.marshal(storeDetails, file1);
			jaxbMarshaller.marshal(storeDetails, System.out);
		} catch (JAXBException e) 
		{
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


	public boolean validate(ItemData item)
	{
		boolean itemValid = false;
		boolean itemExist =false;
		boolean itemAlreadyExist=false;
		boolean noItemName=false;
		boolean noPrice=false;
		boolean noMeasurement=false;
		try
		{
			if(item.equals(null))
			{
				itemExist=false;
			}
			else
			{
				itemExist=true;
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
			if((itemExist)
					&&!noItemName
					&&!noPrice
					&&!noMeasurement)
			{
				List<ItemData> itemList=new ArrayList<ItemData>();
				itemList =GetAllItems();
				for(int i=0;i<itemList.size();i++)
				{
					if(item.getItemName().equals(itemList.get(i).getItemName()))
					{
						itemAlreadyExist =true;
					}
				}
			}
			if((itemExist)
					&&!itemAlreadyExist
					&&!noItemName
					&&!noPrice
					&&!noMeasurement)
			{
				itemValid=true;
			}
			if(!itemExist)
			{
				logger.debug("No Item data entered");
			}
			if(itemAlreadyExist)
			{
				logger.debug("The entered item already exist");
			}
			if(noItemName)
			{
				logger.debug(" name of the item not entered");
			}
			if(noPrice)
			{
				logger.debug("price of the item not entered");
			}
			if(noMeasurement)
			{
				logger.debug("measurement field of the item not entered");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return itemValid;
	}


	public void addItem(ItemData item)
	{     

		boolean itemValid=validate(item);
		if(itemValid==true)
		{
			itemDataDao.saveItemData(item);
		}
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


	/**
	 * ghjghjghjghj
	 * @return return blah is wjkljkl
	 */
	public List<ItemData> GetAllItems()
	{
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

