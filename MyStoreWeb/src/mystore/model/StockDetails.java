package mystore.model;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class StockDetails implements java.io.Serializable{

	
	private int availableStock;

	private int itemName;
	private ItemData itemData;
	private int minimumExpectedStock;

	
	private String supplier;
		
	
	public int getAvailableStock() {
		return availableStock;
	}
	
	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}
	
	public int getMinimumExpectedStock() {
		return minimumExpectedStock;
	}
	public void setMinimumExpectedStock(int minimumExpectedStock) {
		this.minimumExpectedStock = minimumExpectedStock;
	}
	
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	@Override
    public String toString() {
        return "StockDetails:: Available Stock=" + this.availableStock+ " Minimum Expected Stock=" + this.minimumExpectedStock + " Supplier=" + this.supplier ;
    }

	public int getItemName() {
		return itemName;
	}

	public void setItemName(int itemName) {
		this.itemName = itemName;
	}

	public ItemData getItemData() {
		return itemData;
	}

	public void setItemData(ItemData itemData) {
		this.itemData = itemData;
	}
	
	
}
