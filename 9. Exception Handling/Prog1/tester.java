import java.util.Scanner;

abstract class Account{
    String name;
    double balance;
    long Acc_No;
    Account()
    {
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter Name. ");
            try{
                name = sc.next();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Value Entered: "+e.getMessage());
            }
            sc.nextLine();
        }while(true);
        do{
            System.out.println("Enter Balance.");
            try{
                balance = sc.nextDouble();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Value Entered: "+e.getMessage());
            }
            sc.nextLine();
        }while(true);
        do{
            System.out.println("Enter Account Number.");
            try{
                Acc_No = sc.nextLong();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Value Entered: "+e.getMessage());
            }
            sc.nextLine();
        }while(true);
    }
    abstract void Deposit(int a, double bal) throws InsufficientAmountException, NegativeAmountException;
    abstract void Withdraw(int a, double bal) throws InsufficientAmountException, NegativeAmountException;
    abstract void Display();
}

class NegativeAmountException extends Throwable{
    public String getMessage()
    {
        return "Zero/Negative Value not Allowed";
    }
}
class InsufficientAmountException extends Throwable{
    public String getMessage()
    {
        return "Balance Below Mininimum Balance. Suspending Operation.";
    }
}

class SavingsAccount extends Account{
    double interestRate;
    double minBalance;
    SavingsAccount()
    {
        super();
        this.interestRate = 0.06;
        this.minBalance = 10000;
    }

    void transfer(SavingsAccount ob)  throws InsufficientAmountException, NegativeAmountException
    {
        boolean w = false;
        double amt;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("How much money to be Transferred?");
            try{
                amt = sc.nextDouble();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Value Entered: "+e.getMessage());
            }
            sc.nextLine();
        }while(true);
        try{
            this.Withdraw(1, amt);
            w = true;
        }
        catch(InsufficientAmountException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NegativeAmountException e)
        {
            System.out.println(e.getMessage());
        }
        if(w)
        {
            try{
                ob.Deposit(1, amt);
                w = true;
            }
            catch(NegativeAmountException e)
            {
                System.out.println(e.getMessage());
            }
        }
        if(w)
        {
            System.out.println("Transfer Successful.");
            System.out.println("Transferred: "+amt);
            System.out.println("Balance: "+balance);
        }
    }
    
    void addInterest()
    {
        Scanner sc = new Scanner(System.in);
        double rate;
        do{
            System.out.println("How much Interest to be added?");
            try{
                rate = sc.nextDouble();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Value Entered: "+e.getMessage());
            }
            sc.nextLine();
        }while(true);
        interestRate += rate;
    }
    
    public void Deposit(int a, double bal) throws InsufficientAmountException, NegativeAmountException
    {
        if(a == 0)
        {
            System.out.println("How much Money to be added?");
            Scanner sc = new Scanner(System.in);
            do{
                try{
                    bal = sc.nextDouble();
                    break;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Value Entered: "+e.getMessage());
                }
                sc.nextLine();
            }while(true);
        }
        if(bal<=0)
            throw new NegativeAmountException();
        balance += bal;
        if(a == 0)
        {
            System.out.println("Deposited: "+bal);
            System.out.println("Balance: "+balance);
        }
    }
    
    void Withdraw(int a, double bal) throws InsufficientAmountException, NegativeAmountException
    {
        if(a == 0)
        {
            System.out.println("How much Money to be Withdrawn?");
            Scanner sc = new Scanner(System.in);
            do{
                try{
                    bal = sc.nextDouble();
                    break;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Value Entered: "+e.getMessage());
                }
                sc.nextLine();
            }while(true);            
        }
        if(bal<=0)
            throw new NegativeAmountException();
        double temp = balance - bal;
        if(balance<minBalance||temp<minBalance)
            throw new InsufficientAmountException();
        balance = temp;
        if(a == 0)
        {
            System.out.println("Withdrawn: "+bal);
            System.out.println("Balance: "+balance);
        }
    }
    
    public void Display()
    {
        System.out.println("Name: "+name);
        System.out.println("Balance: "+balance);
        System.out.println("Account Number: "+Acc_No);
        System.out.println("Interest Rate: "+interestRate);
        System.out.println("Min Balance Limit: "+minBalance);
    }
}


public class tester{
    public static int menu()
    {
        System.out.println("1. New Account");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Display");
        System.out.println("6. Exit");
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter your choice: 1-6");
            try{
                choice = sc.nextInt();
                if(choice>6||choice<1)
                    continue;
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Value Entered. ");
            }
            sc.nextLine();
        }while(true);
        return choice;
    }
    public static int ChooseAccount(SavingsAccount ob[], int limit, int except)
    {
        Scanner sc = new Scanner(System.in);
        if(limit <= 0)
        return -1;
        for(int i = 0; i<limit; i++)
        {
            if(i == except)
                continue;
            System.out.println((i+1)+" - "+ob[i].name);
        }
        int choice;
        
        do{
            System.out.println("Enter Choice: (1 - "+limit+")");
            try{
                choice = sc.nextInt();
                if(choice>limit||choice<1)
                    continue;
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Value Entered: "+e.getMessage());
            }
            sc.nextLine();
        }while(true);
        if(choice-1 == except)
            return -2;
        return choice-1;
    }
    public static void main(String args[])
    {
        int i = 0;
        int choice;
        Scanner sc = new Scanner(System.in);
        SavingsAccount ob[] = new SavingsAccount[20];
        System.out.println("Press Enter Key To Start...");
        sc.nextLine();
        do{
            choice = menu();
            if(choice == 1)
            {
                ob[i] = new SavingsAccount();
                i++;
            }
            else if(choice == 2)
            {
                int ch = ChooseAccount(ob, i, -1);
                if(ch == -1)
                {   
                    System.out.println("No Account Available for Withdrawal");
                    continue;
                }
                SavingsAccount source = ob[ch];
                try{
                    source.Withdraw(0,0);
                }
                catch(InsufficientAmountException e)
                {
                    System.out.println(e.getMessage());
                }
                catch(NegativeAmountException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            else if(choice == 3)
            {
                int ch = ChooseAccount(ob, i, -1);
                if(ch == -1)
                {   
                    System.out.println("No Account Available for Deposit");
                    continue;
                }
                SavingsAccount source = ob[ch];
                try{
                    source.Deposit(0,0);
                }
                catch(InsufficientAmountException e)
                {
                    System.out.println(e.getMessage());
                }
                catch(NegativeAmountException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            else if(choice == 4)
            {
                System.out.println("Choose Source Account.");
                int ch = ChooseAccount(ob, i, -1);
                if(ch == -1)
                {   
                    System.out.println("Don't have any Account in Record.");
                    continue;
                }
                SavingsAccount source = ob[ch];
                System.out.println("Choose Destination Account.");
                ch = ChooseAccount(ob, i, ch);
                if(ch == -2)
                {   
                    System.out.println("Can't be the Same Account");
                    continue;
                }
                SavingsAccount dest = ob[ch];
                try{
                    source.transfer(dest);
                }
                catch(InsufficientAmountException e)
                {
                    System.out.println(e.getMessage());
                }
                catch(NegativeAmountException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            else if(choice == 5)
            {
                int ch = ChooseAccount(ob, i, -1);
                if(ch == -1)
                {   
                    System.out.println("No Account Available");
                    continue;
                }
                SavingsAccount source = ob[ch];
                source.Display();
            }
            else if(choice == 6)
            {
                break;
            }
        }while(true);
    }
}