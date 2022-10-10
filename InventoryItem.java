package net.thefakejanedoe.ic;

public class InventoryItem {

	private String partNumber = null;
	private int partQuantity = 0;
	
	public InventoryItem(String partNumber, int partQuantity) {
		this.partNumber = partNumber;
		this.partQuantity = partQuantity;
	}
	
	public String getPartNumber() {
		return this.partNumber;
	}
	
	public int getPartQuantity() {
		return this.partQuantity;
	}
	
	public boolean setPartQuantity(int quantity) {
		this.partQuantity = quantity;
		return true;
	}
	
	public boolean incPartQuantity() {
		this.partQuantity = this.partQuantity + 1;
		return true;
	}

}
