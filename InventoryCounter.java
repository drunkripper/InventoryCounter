 package net.thefakejanedoe.ic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class InventoryCounter {

	static ArrayList<InventoryItem> inventory = new ArrayList<InventoryItem>();

	public static void main(String[] args) {
        System.out.println("Please Enter a Part Number");
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        
        String lastPartNumber = "";
        
        while(true) {
        	String partNumber = input.next();
        	switch (partNumber.toLowerCase()){
        	  case "done":
          		System.out.println("Done!");
          		for(int i = 0; i < inventory.size(); i++) {
          			ArrayList<InventoryItem> inventorySorted = sortInventory(inventory);
          			System.out.println(inventorySorted.get(i).getPartNumber() + " : " + inventorySorted.get(i).getPartQuantity());
  				}
          		break;
        	  case "+":
        		  if(!lastPartNumber.isEmpty()) {
        			  addToInventory(lastPartNumber, 1);
        		  } else {
        			  System.out.println("Requires Previous Entry");
        		  }
        		  break;
        	  case "*":
        		  if(!lastPartNumber.isEmpty()) {
        			  System.out.println("How many are there to add?");
        			  int amountToAdd = (input.nextInt()-1);
        			  addToInventory(lastPartNumber, amountToAdd);
        		  } else {
        			  System.out.println("Requires Previous Entry");
        		  }
        		  break;
        	  case "preaddtolist":
            	 System.out.println("Please format as \"<Part Number>:<Quantity>, \"");
        		 String toSplit = input.next();
        		 String[] splitLines = toSplit.split(",");
        		 for(int i = 0; i < splitLines.length; i++) {
        			  String[] splitData = splitLines[i].split(":");
        			  addToInventory(splitData[0], Integer.valueOf(splitData[1]));
        		  }
        		 break;
        	  default:
  				 lastPartNumber = partNumber;
        		 addToInventory(partNumber, 1); 
          	}
        }
    }
        	

	private static ArrayList<InventoryItem> sortInventory(ArrayList<InventoryItem> inventoryUnsorted) {
		ArrayList<String> unsortedInvString = new ArrayList<String>();
		ArrayList<InventoryItem> sortedInvString = new ArrayList<InventoryItem>();
		for(int i = 0; i < inventory.size(); i++) {
			unsortedInvString.add(inventoryUnsorted.get(i).getPartNumber());
		}
		Collections.sort(unsortedInvString);
		for(int i = 0; i < unsortedInvString.size(); i++) {
			for(int a = 0; a < inventoryUnsorted.size(); a++) {
				if(unsortedInvString.get(i).equalsIgnoreCase(inventoryUnsorted.get(a).getPartNumber())) {
					sortedInvString.add(inventoryUnsorted.get(a));
				}
			}
		}
		return sortedInvString;
	}
	
	private static void addToInventory(String partNumber, int quantityToIncrease) {
		boolean foundPart = false;
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getPartNumber().equalsIgnoreCase(partNumber)) {
				inventory.get(i).setPartQuantity(quantityToIncrease + inventory.get(i).getPartQuantity());
				foundPart = true;
			}
		}
		if(!foundPart) {
			foundPart = false;
			inventory.add(new InventoryItem(partNumber, quantityToIncrease));
		}
	}
	
	private static InventoryItem getInventoryItemFromPartNumber(String partNumber) {
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getPartNumber().equalsIgnoreCase(partNumber)) {
				return inventory.get(i);
			}
		}
		return null;
	}
}

final class InventoryItem {

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
