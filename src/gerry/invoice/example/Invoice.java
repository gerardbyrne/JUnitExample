package gerry.invoice.example;

public class Invoice {
	public double totalCostOfItems(String partNumberPassedIn, 
			String partDescriptionPassedIn, 
			int quantityPassedIn,
			double pricePassedIn) {
		double invoiceItemTotal = quantityPassedIn * pricePassedIn;
		return invoiceItemTotal;
	}

	public double totalCostOfItemsWithVAT(String partNumberPassedIn, String partDescriptionPassedIn, int quantityPassedIn, double pricePassedIn) 
	{
		double vatRate;
		String vatIdentifier = partNumberPassedIn.substring( 0, 2 );
		if (vatIdentifier.equals("T1") )
		{
			vatRate = 0.20;		
		} 
		else if (vatIdentifier.equals("T2") )
		{
			vatRate = 0.05;	
		}
		else if (vatIdentifier.equals("A5") )
		{
			vatRate = 0.00;	
		}
		else
		{
			vatRate = 0.00;	
		}
		double vatAmountToBePaid = quantityPassedIn * pricePassedIn * vatRate;
		return vatAmountToBePaid;
	}

	public double totalCostOfInvoice(String partNumberPassedIn, String partDescriptionPassedIn, int quantityPassedIn, double pricePassedIn) 
	{
		double invoiceGoodsVAT 	= totalCostOfItemsWithVAT(partNumberPassedIn, partDescriptionPassedIn,  quantityPassedIn,  pricePassedIn);
		double invoiceGoodsTotal 	= totalCostOfItems(partNumberPassedIn, partDescriptionPassedIn, quantityPassedIn, pricePassedIn);
		double invoiceTotal	= invoiceGoodsTotal + invoiceGoodsVAT;
		return invoiceTotal;
	}

	public double commissionEarnedBySalesPerson(String partNumberPassedIn, String partDescriptionPassedIn, int quantityPassedIn, double pricePassedIn) 
	{
		double invoiceTotal 		= totalCostOfInvoice(partNumberPassedIn, partDescriptionPassedIn,  quantityPassedIn,  pricePassedIn);
		double commission;
		if (invoiceTotal >1000) 
		{
			commission = invoiceTotal * 0.05;
		} 
		else 
		{
			commission = invoiceTotal * 0.02;
		}
		return commission;
	}
}