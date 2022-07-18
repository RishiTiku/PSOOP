import java.util.InputMismatchException;
import java.util.Scanner;

class Cricketer{
    String name;
    int runs;
    int innings;
    int not_out;
    int batting_avg;
    Cricketer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name.");
        name = sc.nextLine();
        do{
            try{
                System.out.println("Enter Runs.");
                runs = sc.nextInt();
                break;
            }
            catch(InputMismatchException i)
            {
                System.out.println("Invalid Input Entered.");
            }
            sc.nextLine();
        }while(true);
        do{
            try{
                System.out.println("Enter Number of Innings.");
                innings = sc.nextInt();
                break;
            }
            catch(InputMismatchException i)
            {
                System.out.println("Invalid Input Entered.");
            }
            sc.nextLine();
        }while(true);
        do{
            try{
                System.out.println("Enter Times Not Out.");
                not_out = sc.nextInt();
                break;
            }
            catch(InputMismatchException i)
            {
                System.out.println("Invalid Input Entered.");
            }
            sc.nextLine();
        }while(true);
        try{
            batting_avg = runs/innings;
        }
        catch(ArithmeticException e)
        {
            batting_avg = 0;
        }
    }
    public int get_avg(){return batting_avg;}
}


public class tester {
    
}
