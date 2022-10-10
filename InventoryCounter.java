package net.thefakejanedoe.ic;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryCounter {

	static ArrayList<InventoryItem> inventory = new ArrayList<InventoryItem>();

	public static void main(String[] args) {
        System.out.println("Please Enter a Part Number");
        Scanner input = new Scanner(System.in);
        
        while(true) {
        	boolean foundPart = false;
        	String partNumber = input.next();
        	if(partNumber.equalsIgnoreCase("done")) {
        		System.out.println("Done!");
        		for(int i = 0; i < inventory.size(); i++) {
        			System.out.println(inventory.get(i).getPartNumber() + " : " + inventory.get(i).getPartQuantity());
				}
            } else if(!partNumber.equalsIgnoreCase("done")){
            	System.out.println(partNumber + " recieved. Added to list.");
				for(int i = 0; i < inventory.size(); i++) {
					if(inventory.get(i).getPartNumber().equalsIgnoreCase(partNumber)) {
					    inventory.get(i).incPartQuantity();
					    foundPart = true;
					}
				}
				if(!foundPart) {
					foundPart = false;
					inventory.add(new InventoryItem(partNumber, 1));
				}
        		}
        	}
        }

	}


