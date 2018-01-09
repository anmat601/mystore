package mystore.model;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemData{
	
		private String itemName;
		private int price;
		private String measurement;
		private StockDetails stockDetails = null;


		public String getItemName()
		{
			return itemName;
		}

		@XmlElement
		public void setItemName(String itemName)
		{
			this.itemName=itemName;
		}

		public int getPrice()
		{
			return price;
		}
		
		@XmlElement
		public void setPrice(int price)
		{
			this.price=price;
		}

		public String getMeasurement()
		{
			return measurement;
		}

		@XmlElement
		public void setMeasurement(String measurement)
		{
			this.measurement=measurement;
		}
		
		
		

		@Override
	    public String toString() {
	        /*return "ItemData:: itemName=" + this.itemName + " Price=" + this.price + " measurement=" + this.measurement+
	        		" StockDetails.availablestock=" + this.stockDetails.getAvailableStock();*/
	        
	        return "ItemData:: itemName=" + this.itemName + " Price=" + this.price + " measurement=" + this.measurement+
	        		" StockDetails=" + this.stockDetails.toString();
	    }

		public StockDetails getStockDetails() {
			return stockDetails;
		}

		public void setStockDetails(StockDetails stockDetails) {
			this.stockDetails = stockDetails;
		}
	}
