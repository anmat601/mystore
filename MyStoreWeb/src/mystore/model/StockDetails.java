package mystore.model;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class StockDetails {

	
	private int availableStock;

	
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
	
	
}
