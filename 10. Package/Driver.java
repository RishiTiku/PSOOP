import myPackage.*;
import java.util.*;


public class Driver{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		GST ob = new GST();
		System.out.println("Enter type of tax. (CGST, SGST, UTGST, IGST)");
		//do{
			String type = sc.next();
		//}while();
		System.out.println("Enter Taxable amount.");
		float amt = sc.nextFloat();
		ob.calculateGST(type, amt);
	}



}

