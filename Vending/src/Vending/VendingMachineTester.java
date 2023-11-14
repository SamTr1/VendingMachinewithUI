/*
Name:  Samuel Trujillo
Date:  3/27/2023
Description: JUnit Tester for the VendingMachine class
Sources Cited: None
*/

package Vending;

import static org.junit.Assert.*;
import org.junit.Test;

public class VendingMachineTester {
	
	// =======================================================================
	// Checks to make sure Error is thrown when cents entered is not divisble by 5
	@Test(expected = ImproperCoinsException.class)
	public void insertCointTest() {
		VendingMachine vm = new VendingMachine(1,1,1);
		
		vm.insertCents(7);
	}
	
	// =======================================================================	
	// Checks to make sure Error is thrown when valid selection is not entered
	@Test(expected = ImproperSelectionException.class)
	public void outOfBoundsSelectionTest() {
		VendingMachine vm = new VendingMachine(1,1,1);
		
		vm.makeSelection(7);
	}
	
	// =======================================================================	
	// Checks to make sure Error is thrown when selection chosen is sold out
	@Test(expected = ImproperSelectionException.class)
	public void soldOutSelectionTest() {
		VendingMachine vm = new VendingMachine(0,0,0);
		
		vm.makeSelection(1);
	}
	
	// =======================================================================	
	// Checks to make sure Error is thrown when a purchase is tried to happen without a selection
	@Test(expected = ImproperPurchaseException.class)
	public void noSelectionPurchaseTest() {
		VendingMachine vm = new VendingMachine(1,1,1);
		
		vm.purchaseSelection();
	}
	
	// =======================================================================	
	// Checks to make sure Error is thrown when a purchase without enough Cents occurs
	@Test(expected = ImproperPurchaseException.class)
	public void notEnoughCoinsPurchaseTest() {
		VendingMachine vm = new VendingMachine(1,1,1);
		
		vm.makeSelection(1);
		vm.insertCents(15);
		vm.purchaseSelection();
	}
	
	// =======================================================================	
	// Checks to make sure correct number of cents is returned to User with purchase
	@Test
	public void returnCoinAfterPurchaseTest() {
		VendingMachine vm = new VendingMachine(1,1,1);
		
		vm.makeSelection(1);
		vm.insertCents(150);
		vm.purchaseSelection();
		
		assertEquals(vm.returnUnspentCents(), 35);
	}
	
	// =======================================================================	
	// Checks to make sure correct number of cents is returned to User without purchase
	@Test
	public void returnCoinNoPurchaseTest() {
		VendingMachine vm = new VendingMachine(1,1,1);
		
		vm.insertCents(150);
		
		assertEquals(vm.returnUnspentCents(), 150);
	}
	
	// =======================================================================	
	// Checks to make sure Profits are returned correctly
	@Test
	public void returnProfitTest() {
		VendingMachine vm = new VendingMachine(1,1,1);
		
		vm.makeSelection(0);
		vm.insertCents(150);
		vm.purchaseSelection();

		vm.makeSelection(1);
		vm.insertCents(150);
		vm.purchaseSelection();

		vm.makeSelection(2);
		vm.insertCents(150);
		vm.purchaseSelection();
		
		assertEquals(vm.getProfits(), 345);
	}
	
	// =======================================================================	
	
	
	
	
	
	
}
