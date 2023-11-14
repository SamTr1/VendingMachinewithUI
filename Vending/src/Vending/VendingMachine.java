/*
Name:  Samuel Trujillo
Date:  3/27/2023
Description: Vending Machine Class
Sources Cited: None
*/

package Vending;

public class VendingMachine implements VendingMachineInterface{
	
	// ------------------------------------
	// Attributes that will be are given by the constructor
	private int limitSnickers;
	private int limitTwix;
	private int limitReese;
	
	// ------------------------------------
	// Vending Machine Item Related Variables
	private int selection = -1;
	private int itemCost = 0;
	
	// ------------------------------------
	// Coins related variables
	private int totalCoins = 0;
	private int totalProfit = 0;
	
	// =======================================================================		
	// Vending Machine Constructor
	public VendingMachine(int s, int t, int r) {
		limitSnickers = s;
		limitTwix = t;
		limitReese = r;
	}

	// =======================================================================	
	// Function checks if Cents enter is divisble by 5
	public void insertCents(int c) {
		
		// ------------------------------------
		if (c % 5 == 0 && c >= 0) {
			totalCoins += c;
		}
		
		// ------------------------------------
		else {
			throw new ImproperCoinsException(); // Error for Cents enter not being divisble by 5
		}
		
	}

	// =======================================================================	
	// Allows user to make item selection make verify if selection is valid
	public void makeSelection(int s) {
		
		// ------------------------------------
		// Checks for Snickers
		if (s == 0) {
			
			if (limitSnickers > 0) { // Make sure there is enough snickers to be sold
				selection = 0;
				itemCost = 100;
			}
			
			// ------------------------------------
			else {
				throw new ImproperSelectionException("Snickers"); // Error for No Snicker bars left to be sold
			}	
		}
		
		// ------------------------------------
		// Checks for Twix
		else if (s == 1) {
			
			if (limitTwix > 0) { // Make sure there is enough twix to be sold
				selection = 1;
				itemCost = 115;
			}
			
			// ------------------------------------
			else {
				throw new ImproperSelectionException("Twix"); // Error for No Twix bars left to be sold
			}
		}
		
		// ------------------------------------
		// Check for Reese
		else if (s == 2) {
			
			if (limitReese > 0) { // Make sure there is enough Reese to be sold
				selection = 2;
				itemCost = 130;
			}
			
			// ------------------------------------
			else {
				throw new ImproperSelectionException("Reese"); // Error for No Reese bars left to be sold
			}
		}
		
		// ------------------------------------
		else {
			throw new ImproperSelectionException(); // Error for invalid selection
		}
		
	}

	// =======================================================================	
	// Allows user to purcahse selection and verifies selection has been amde
	public int purchaseSelection() {
		
		// ------------------------------------
		// Checks if selection has been made
		if (selection == -1) {
			throw new ImproperPurchaseException(); // Error for no selection has been made
		}
		
		// ------------------------------------
		else if (itemCost > totalCoins) {
			throw new ImproperPurchaseException((itemCost - totalCoins)); // Error for not enough Cents to buy selection
		}
		
		// ------------------------------------
		// Purchase is successful
		else {
			totalCoins -= itemCost;
			totalProfit += itemCost;
			
			return selection;
		}
	}

	// =======================================================================		
	// Returns Cents which are not spent
	public int returnUnspentCents() {
		
		int temp = totalCoins;
		totalCoins = 0;
		
		return temp;
	}

	// =======================================================================	
	// Returns Profits of the VendingMachine
	public int getProfits() {
		return totalProfit;
	}

}
