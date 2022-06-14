import java.util.Comparator;
import java.util.*;
import java.lang.*;
class Movie{
    public String Name;
    public String TypeCode[] = {"Thriller", "Comedy", "Action", "Romance"};
    public int Type;
    public String Hero;
    public String Heroine;
    public float Budget;
    public void Input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Movie Name.");
        Name = sc.nextLine();
        for(int i = 0; i<4; i++)
        {
            System.out.println(i+"."+TypeCode[i]);
        }
        System.out.println("Enter Type. (0-3)");
        Type = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Hero Name.");
        Hero = sc.nextLine();
        System.out.println("Enter Heroine Name.");
        Heroine = sc.nextLine();
        System.out.println("Enter Budget.");
        Budget = sc.nextFloat();
    }
    public void Display()
    {
        System.out.println("Movie Name: "+Name);
        System.out.println("Type: "+TypeCode[Type]);
        System.out.println("Hero Name: "+Hero);
        System.out.println("Heroine Name: "+Heroine);
        System.out.println("Budget: "+Budget);
    }

}
class Compare implements Comparator<Movie>{
    public int compare(Movie a, Movie b)
    {
        float diff = a.Budget - b.Budget;
        if(diff>0)
            return 1;
        else if(diff == 0)
            return 0;
        else
            return -1;
    }
}
public class Movies{
    public static void main(String args[])
    {
        Movie A[] = new Movie[3];
        for(int i = 0; i<3; i++)
        {
            A[i] = new Movie();
            A[i].Input();
        }
        Arrays.sort(A, new Compare());
        for(int i = 0; i<3; i++)
            A[i].Display();
    }
}
