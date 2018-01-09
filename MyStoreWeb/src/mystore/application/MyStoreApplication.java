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

public class MyStoreApplication {

	public static void main(String[] args) {
		//getItemsRefillInfo();
		//testAddItemToCart();
		//testAddItem();
		testGetPrice();
		//testGetMeasurement();	
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
		Boolean ifItemAdded =ItemManagement.getInstance().addItem(pencil);
	}

	private static void testGetPrice()
	{
		int price =ItemManagement.getInstance().getPriceOfItem("soap");
		System.out.println("Price of soap ="+price);
	}

	private static void testGetMeasurement()
	{
		String measurement =ItemManagement.getInstance().getMeasurementOfItem("soap");
		System.out.println("Measurement :"+measurement);
	}

	private static void testAddItemToCart(){
		
		System.out.println("Item             Quantity");
		System.out.println("----             ---------");
		BillingManagement.getInstance().addTocart("sugar",3);
		BillingManagement.getInstance().addTocart("soap",6);
		BillingManagement.getInstance().addTocart("pencil",5);
	}
}
