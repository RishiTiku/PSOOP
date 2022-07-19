/*
Create a GST class in package myPackage, that calculates the tax for a product. The class has rate of interest defined based on the type of GST and has calculateGST(type, amount)

There are four different types of GST as listed below:

    The Central Goods and Services Tax (CGST) - Rate 5%

    The State Goods and Services Tax (SGST) -Rate 10%

    The Union Territory Goods and Services Tax (UTGST) -Rate 12%

    The Integrated Goods and Services Tax (IGST) - Rate 15%

Create Driver class not in myPackage with main function

to calculate the GST of a product inout by the user.

Display the GST amount.
*/

package myPackage;

public class GST{
	String[] types  = {"CGST", "SGST", "UTGST","IGST"};
	float[] rates = {0.05f, 0.10f, 0.12f, 0.15f};
	public GST()
	{
	}
	void calculateGST(String type, float amount)
	{
		int t = 0;
		for(int i = 0; i<4; i++)
		{
			if(types[i].equalsIgnoreCase(type))
			{
				t = i;
				break;
			}
		}
		System.out.println("GST Amount: "+(amount*rates[t]));
	}
}











