import java.util.*;

public class Tester {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Persons");
        int n = sc.nextInt();
        Person p[] = new Person[n];
        CashPayment ob1[] = new CashPayment[n];
        CreditCardPayment ob2[] = new CreditCardPayment[n];
        Westside w[] = new Westside[n];
        int ch[] = new int[n];
        for(int i = 0; i<n; i++)
        {
            p[i] = new Person();
            w[i] = new Westside();
            double pur = w[i].Purchase();
            System.out.println("(1)Cash or (2)Card?(1/2)");
            ch[i] = sc.nextInt();
            if(ch[i] == 1)
            {
                ob1[i] = new CashPayment();
                ob1[i].paymentDetails(pur);
            }
            else
            {
                ob2[i] = new CreditCardPayment();
                ob2[i].paymentDetails(pur);
            }

        }
        System.out.println("\nPayment Details: \n");
        for(int i = 0; i<n; i++)
        {
            p[i].PersonDetails();
            w[i].PurchaseDetails();
            if(ch[i] == 1)
                ob1[i].paymentDetails(0);
            else
                ob2[i].paymentDetails(0);
            System.out.println();
        }
    }    
}

class Westside{
    static int clothes;
    static int accessories;
    public int bclothes;//bought clothes
    public int baccessories;//bought accessories
    public double purchase;
    Westside()
    {
        clothes = 100;
        accessories = 100;
        purchase = 0;
    }
    void Restock()
    {
        clothes+=100;
        accessories+=100;
    }
    public double Purchase()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many clothes you want to buy?");
        bclothes = sc.nextInt();
        System.out.println("How many accesories you want to buy?");
        baccessories = sc.nextInt();
        purchase += bclothes*5000 + baccessories*2500;
        clothes-=bclothes;
        accessories-=baccessories;
        if(clothes<=10||accessories<=10)
        {
            System.out.println("Restock Required!!");
            Restock();
        }
        return purchase;
    }
    public void PurchaseDetails()
    {
        System.out.println("Clothes bought: "+bclothes);
        System.out.println("Accesories bought: "+baccessories);
        
    }  
}

class Person{
    public String person_name;
    public long phone_n;
    Person()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name.");
        person_name = sc.nextLine();
        System.out.println("Enter Phone Number.");
        phone_n = sc.nextLong();
    }
    public void PersonDetails()
    {
        System.out.println("Name: "+person_name);
        System.out.println("Phone Number: "+phone_n);
    }
}

abstract class Payment{
    double amount;
    Payment()
    {
        amount = 25000;
    }
    abstract void paymentDetails(double p);
}

class CreditCardPayment extends Payment{
    double creditamt;
    String CardName;
    String exp;
    long CardNo;
    CreditCardPayment()
    {
        super();
        Scanner sc = new Scanner(System.in);
        creditamt = 100000;
        System.out.println("Enter Name on Card.");
        CardName = sc.nextLine();
        System.out.println("Enter Expiry Date.");
        exp = sc.nextLine();
        System.out.println("Enter Card Number.");
        CardNo = sc.nextLong();
    }
    void paymentDetails(double p)
    {
        if(p!=0)
        {
            amount+=p;
            System.out.println("Amount to pay: "+p);
            creditamt-=amount;
        }
        else
        {
            System.out.println("Amount paid: "+amount);
        }
        System.out.println("Name on Card: "+CardName);
        System.out.println("Expiry Date: "+exp);
        System.out.println("Card Number: "+CardNo);
        System.out.println("Remaining Credit Amount: "+creditamt);

    }
}

class CashPayment extends Payment{
    double cashamt;
    CashPayment()
    {
        super();
        cashamt = 100000;
    }
    void paymentDetails(double p)
    {
        if(p!=0)
        {   
            amount+=p;
            System.out.println("Amount to pay: "+amount);
            cashamt-=amount;
        }
        else
        {
            System.out.println("Amount paid: "+amount);
        }
        System.out.println("Remaining Cash: "+cashamt);
    }
}