import java.util.*;

interface SavingAccount{
    void getSimpleInterest();
}

interface CurrentAccount{
    void getCompoundInterest();
}


class Customer implements SavingAccount, CurrentAccount{
    public char accountType;
    float rate;
    float balance;
    public void getSimpleInterest(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Simple Interest: ");
        System.out.println("Enter Balance.");
        balance = sc.nextFloat();
        System.out.println("Enter Rate%");
        rate = sc.nextFloat();
        System.out.println("Enter Time.");
        int time = sc.nextInt();
        System.out.println("Simple Interest: "+(balance*rate*time/100));
    }
    public void getCompoundInterest(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Compound Interest: ");
        System.out.println("Enter Balance.");
        balance = sc.nextFloat();
        System.out.println("Enter Rate%");
        rate = sc.nextFloat();
        System.out.println("Enter Time.");
        int time = sc.nextInt();
        System.out.println("Compound Interest: "+((balance*Math.pow((100+rate)/100, time))-balance));
    }
}

public class tester {
    public static void main(String args[])
    {
        Customer ob = new Customer();
        System.out.println("Enter Account Type. (S/C)");
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        ob.accountType = ch;
        if(ch == 'S'||ch == 's')
        {
            ob.getSimpleInterest();
        }
        else
        {
            ob.getCompoundInterest();
        }

    }
}
