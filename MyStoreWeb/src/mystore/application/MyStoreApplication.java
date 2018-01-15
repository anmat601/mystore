package mystore.application;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import mystore.model.StoreDetails;
import mystore.model.ItemData;
import mystore.model.StockDetails;
import mystore.service.StockManagement;
import mystore.service.BillingManagement;
import mystore.service.ItemManagement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyStoreApplication {
	private static ApplicationContext context;
	public static void main(String[] args) {
		//getItemsRefillInfo();
		//testAddItemToCart();
		//testAddItem();
		//testGetPrice();
		//testGetMeasurement();	
		 
		 context =new ClassPathXmlApplicationContext("Beans.xml");
		
		 testGetAllItems();
		 
	} 
	
	private static void getItemsRefillInfo()
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Vendor Name");
		try {
			String vendorName =br.readLine();

			StockManagement stockManagement =new StockManagement();

			List<String> itemsToBeRefilled = stockManagement.ItemsToBeRefilled(vendorName);

			//System.out.println("List of Items to be refilled by" +" " +vendorName+":");

			for(int i=0;i<itemsToBeRefilled.size();i++)
			{
				System.out.println(itemsToBeRefilled.get(i));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testAddItem()
	{
		ItemData pencil =new ItemData();
		ItemData sugar =new ItemData();
		StockDetails pencilStockDetails = new StockDetails();
		pencil.setItemName("pencil");
		pencil.setPrice(5);
		pencil.setStockDetails(pencilStockDetails);
		pencilStockDetails.setAvailableStock(100);
		pencilStockDetails.setMinimumExpectedStock(50);
		pencilStockDetails.setSupplier("GrocerySupplier.com");
		//storeDetails.getItemList().add(pencil);
		Boolean ifItemAdded =((ItemManagement)context.getBean("itemManagement")).addItem(pencil);
	}

	private static void testGetPrice()
	{
		int price =((ItemManagement)context.getBean("itemManagement")).getPriceOfItem("soap");
		System.out.println("Price of soap ="+price);
	}

	private static void testGetMeasurement()
	{
		String measurement =((ItemManagement)context.getBean("itemManagement")).getMeasurementOfItem("soap");
		System.out.println("Measurement :"+measurement);
	}

	private static void testAddItemToCart(){
		
		System.out.println("Item             Quantity");
		System.out.println("----             ---------");
		((BillingManagement)context.getBean("billingManagement")).addTocart("sugar",3);
		((BillingManagement)context.getBean("billingManagement")).addTocart("soap",6);
		((BillingManagement)context.getBean("billingManagement")).addTocart("pencil",5);
	}
	
	private static void testGetAllItems()
	{
		List<String> items =((ItemManagement)context.getBean("itemManagement")).GetAllItems();
		for(int i=0;i<items.size();i++)
		{
			System.out.println(items.get(i));
		}
	}
}
