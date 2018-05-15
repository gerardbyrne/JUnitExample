package gerry.invoice.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InvoiceClassTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCostOfItems() 
	{
		// Create an instance of the Invoice class
		Invoice invoice1 = new Invoice ();
		double totalCostOfItems = invoice1.totalCostOfItems("A5544", "Big Black Book", 5, 20.00);
		assertEquals(100.00, totalCostOfItems, 0.0);
	}

	@Test
	public void totalCostOfVAT() 
	{
		// Create an instance of the Invoice class
		Invoice invoice1 = new Invoice();
		double vatAmount = invoice1.totalCostOfItemsWithVAT("T1544", "Big Red Book", 5, 20.00);
		assertEquals(20.00, vatAmount, 0.0);
	}

	@Test
	public void totalInvoiceCost() 
	{
		// Create an instance of the Invoice class
		Invoice invoice1 = new Invoice();
		double vatAmount = invoice1.totalCostOfInvoice ("T1544", "Big Red Book", 5, 20.00);
		assertEquals(120.00, vatAmount, 0.0);
	} 

	@Test
	public void commissionEarned() 
	{
		// Create an instance of the Invoice class
		Invoice invoice1 = new Invoice();
		double commission = invoice1.commissionEarnedBySalesPerson("T1544", "Big Red Book", 5, 20.00);
		assertEquals(2.40, commission, 0.0);
	} 

}
