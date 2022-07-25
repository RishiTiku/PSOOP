import java.util.Scanner;

/*There is an abstract class Account
Attribute:-
● Name
● Balance
● Acc_No
Method:-
● Deposit - abstract method
● withdraw - abstract method
● display - abstract method
Saving Account inherits the Account class and provides the implementation for the methods accordingly
Saving Account class Attribute:-
● interestRate
● minBalance
Method
● addInterest: handle Arithmetic Exception
● transfer():
Note:
● Balance cannot be less than 0.
● In a Saving account if minBalance is set then for that the balance
cannot go less than that amount. If it goes, an error must be shown.
● let the user deposit to or withdraw from the account. For each
transaction, a message is displayed to indicate the status of the
transaction: successful or failed. In case of failure, the failure
reason is reported.
● The possible Exceptions are negative-amount-exception (in both
deposit and withdraw transaction) and insufficient-amount-
exception ( in withdraw transaction).
For the above scenario write an interactive program in Java. Also, show output for different use cases. */

abstract class Account{
    String name;
    double balance;
    long Acc_No;
    Account()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name. ");
        this.name = sc.next();
        System.out.println("Enter Balance.");
        this.balance = sc.nextDouble();
        System.out.println("Enter Account Number.");
        this.Acc_No = sc.nextLong();
    }
    abstract void Deposit(int a, double bal) throws InsufficientAmountException, NegativeAmountException;
    abstract void Withdraw(int a, double bal) throws InsufficientAmountException, NegativeAmountException;
    abstract void Display();
}

class NegativeAmountException extends Throwable{}
class InsufficientAmountException extends Throwable{}

class SavingsAccount extends Account{
    double interestRate;
    double minBalance;
    SavingsAccount()
    {
        super();
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Enter Interest Rate.");
        //System.out.println();
        this.interestRate = 0.06;
        this.minBalance = 10000;
    }
    void transfer(SavingsAccount ob)  throws InsufficientAmountException, NegativeAmountException
    {

    }
    void addInterest()
    {
        System.out.println("How much Interest to be added?");
        Scanner sc = new Scanner(System.in);
        double rate = sc.nextDouble();
        interestRate += rate;
    }
    void Deposit(int a, double bal) throws InsufficientAmountException, NegativeAmountException
    {
        if(a == 0)
        {
            System.out.println("How much Money to be added?");
            Scanner sc = new Scanner(System.in);
            bal = sc.nextDouble();
        }
        if(bal<=0)
            throw new NegativeAmountException();
        balance += bal;
    }
    void Withdraw(int a, double bal) throws InsufficientAmountException, NegativeAmountException
    {
        if(a == 0)
        {
            System.out.println("How much Money to be Withdrawn?");
            Scanner sc = new Scanner(System.in);
            bal = sc.nextDouble();
        }
        if(bal<=0)
            throw new NegativeAmountException();
        double temp = balance - bal;
        if(balance<minBalance||temp<minBalance)
            throw new InsufficientAmountException();
    }
    void Display()
    {

    }
}