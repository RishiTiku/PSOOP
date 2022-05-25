import java.util.*;
import java.lang.*;

class Customer{
	//Member Variables
	private float balance;
	private float interest;
	//Constructors
	Customer(){balance = 0;interest = 1;}
	Customer(float bal, float inte){balance = bal; interest = inte;}
	//Member Methods
	public float balance(){return balance;}
	public void deposit(float sum){balance += sum;}
	public double CI(int period){return balance*(Math.pow(1+interest/100,period)-1);}
	public boolean withdraw(float sum){
		if(sum>balance)
			return false;
		else
			balance-=sum;
		return true; 
	}
}

public class Banking{
	static Scanner sc = new Scanner(System.in);
	static int printMenu()
	{
		System.out.println("1. Deposit.");
		System.out.println("2. Withdraw.");
		System.out.println("3. Calculate CI.");
		System.out.println("4. Balance Enquiry.");
		System.out.println("5. Exit.");
		System.out.println("Enter your choice. (1-5)");
		int choice = sc.nextInt();
		if(choice>5||choice<1)
			return -1;
		return choice;
	}
	public static void main(String args[])
	{
		Customer ob = new Customer(10000, 7.5f);
		do{
			float bal;
			int choice = printMenu();
			switch(choice){
			case 1: System.out.println("Enter an Amount to Deposit.");
					bal = sc.nextFloat();
					ob.deposit(bal);
					break;
			case 2: System.out.println("Enter an Amount to Withdraw.");
					bal = sc.nextFloat();
					if(!ob.withdraw(bal))
						System.out.println("Withdrawal Unsuccesful. Try a lower amount.");
					else
						System.out.println("Withdrawal Successful.");
					break;
			case 3: System.out.println("Enter the time in years.");
					int years = sc.nextInt();
					System.out.println("The CI calculated is " + ob.CI(years)+".");
					break;
			case 4: System.out.println("The balance in your account is "+ob.balance()+".");
					break;
			case 5: System.exit(0);
			default: System.out.println("Wrong Choice Entered.");
			}
		}while(true);
	}
}



/*
    To initialise the balance amount and the rate of interest using constructor member function

    To make deposit

    To withdraw an amount for the balance

    To find compound interest based on the rate of interest

    To know the balance amount

    To display the menu options
    
*/
