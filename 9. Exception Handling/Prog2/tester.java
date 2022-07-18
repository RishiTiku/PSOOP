import java.util.InputMismatchException;
import java.util.Scanner;

public class tester {
    public static void main(String[] args) throws DoseException, NegativeDaysException    
    {
        Scanner sc = new Scanner(System.in);
        int days = 0;
        do{
            try{
                System.out.println("Enter Number of Days between 2 Doses.");
                days = sc.nextInt();
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Wrong datatype entered.");
            }
            sc.nextLine();
        }while(true);
        if(days<=0)
            throw new NegativeDaysException();
        else if (days>100||(days<84&&days>=1))
            throw new DoseException();
    }
}
class DoseException extends Throwable{}

class NegativeDaysException extends Throwable{}