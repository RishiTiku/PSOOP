import java.util.Scanner;

interface EatItHere{
    void deliverOrder();
}

interface TakeAway{
    void dispatchOrder();
}

class Consumer implements EatItHere, TakeAway{
    public int orderNumber;
    public float orderPrice;
    public void dispatchOrder(){
        System.out.println("Order Number: "+orderNumber);
        float calc = (float) 5/100*orderPrice;
        float serv = 45;
        if(serv<calc)
            serv = calc;
        System.out.println("Service Charge: "+serv);
        System.out.println("Total: "+(orderPrice+serv));
    }
    public void deliverOrder(){
        System.out.println("Order Number: "+orderNumber);
        float calc = (float) 10/100*orderPrice;
        System.out.println("Calc: "+calc);
        float serv = 500;
        if(serv>calc)
            serv = calc;
        System.out.println("Service Charge: "+serv);
        System.out.println("Total: "+(orderPrice+serv));
    }
}

public class tester {
    public static void main(String args[])
    {
        Consumer ob = new Consumer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Order Number.");
        ob.orderNumber = sc.nextInt();
        System.out.println("Enter Price");
        ob.orderPrice = sc.nextFloat();
        System.out.println("1. Eat Here or 2. Takeaway (1 or 2)");
        int Take = sc.nextInt();
        if(Take == 1)
        {
           ob.deliverOrder(); 
        }
        else
        {
            ob.dispatchOrder();
        }
    }    
}
