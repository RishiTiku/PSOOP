import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

class Cricketer{
    String name;
    int runs;
    int innings;
    int not_out;
    double batting_avg;
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
            batting_avg = (double) runs/innings;
        }
        catch(ArithmeticException e)
        {
            batting_avg = 0;
        }
    }
    public double get_avg(){return batting_avg;}
    public void display(){
    	System.out.println("Name: "+name);
    	System.out.println("Runs: "+runs);
    	System.out.println("Innings: "+innings);
    	System.out.println("Not Outs: "+not_out);
    	System.out.println("Batting Average: "+batting_avg);
    	System.out.println();
    }
}

class TeamException extends Throwable{
	double avg;
	TeamException(double a)
	{
		avg = a;
	}
	public String toString()
	{
		return "Batting Avg is low: "+avg;
	}
}

class Sortbyavg implements Comparator<Cricketer> { 
    public int compare(Cricketer a, Cricketer b) 
    { 
        return (int) (a.get_avg() - b.get_avg()); 
    } 
} 
  

public class tester {
    public static void main(String args[]) throws TeamException
    {
        Scanner sc = new Scanner(System.in);
        int n;
        do{
            try{
                System.out.println("Enter Number of Cricketers");
                n = sc.nextInt();
                break;
            }
            catch(InputMismatchException i)
            {
                System.out.println("Invalid Input Entered.");
            }
            sc.nextLine();
        }while(true);
        Cricketer A[] = new Cricketer[n];
        double sum = 0;
        for(int i = 0; i<n; i++)
        {
            A[i] = new Cricketer();
            sum+= A[i].get_avg();
        }
        Arrays.sort(A, new Sortbyavg());
        double tavg = (double) sum/n;
        if(tavg<= 20)
        	throw new TeamException(tavg);
        for(int i = 0; i<n; i++)
        {
            A[i].display();
        }

    }
}