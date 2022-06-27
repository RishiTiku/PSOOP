import java.util.*;;
public class Tester3 {
    public static void main(String[] args) {
    int t = 2;
       while( t != 0 ){
          Billing B = new Billing();
          B.TotalBill();
          System.out.println();
          t--;
       }
    }
}
class Person
{   
    Scanner sc = new Scanner(System.in);
    String name;
    public void setName(String n)
    {
        name = n;
    }
    Person()
    {
        System.out.println("Enter name: ");
        String n = sc.next();
        /*System.out.println("Enter date: ");
        String d = sc.next();*/
        setName(n);
    }
}
class Doctor extends Person
{  
    String speciality;
    double fees;
    double income;
    /*public String getSpeciality()
    {
        return speciality;
    }
    public double getFees()
    {
        return fees;
    }
    public double getIncome()
    {
        return income;
    }*/
    public void setSpeciality(String s)
    {
        speciality = s;
    }
    public void setFees(double f)
    {
        fees = f;
    }
    public void setIncome(double i)
    {
        income = i;
    }
    Doctor()
    {
        super();
        System.out.println("Enter speciality: ");
        String sp = sc.next();
        System.out.println("Enter fees: ");
        double f = sc.nextDouble();
        System.out.println("Enter Doctor's Income: ");
        double i = sc.nextDouble();
        setSpeciality(sp);
        setFees(f);
        setIncome(i);
    }
    public String toString()
    {
        return "\nDoctor's Name: "+name+"\nSpeciality: "+speciality+"\nFees: "+fees;
    }
}
class Patient extends Person
{   
    Doctor primaryPhysician;
    Patient()
    {
        super();
        System.out.println("Enter Doctor's details: ");
        primaryPhysician = new Doctor();
    }
   public String toString()
   {
        String S ="\nName: "+name+primaryPhysician.toString();
        return S;
   }
}
class Billing
{ 
    Scanner sc2 = new Scanner(System.in);
         Patient patient;
         double amount_due;
         Billing()
         {  
                Scanner in = new Scanner(System.in);
                System.out.println("Enter patient's details: ");
                patient = new Patient();
         }
          public void TotalBill()
          {   
                System.out.println("Enter number of days patient admitted: ");
                double days = sc2.nextDouble();
        	    amount_due = ((days*2000)+(patient.primaryPhysician.fees));
                System.out.println("____________________________________");
                System.out.println("\t\tBILL");
                System.out.println(patient);
                System.out.println("Days Admitted: "+days);
                System.out.println("Admission Charges: "+days*2000);
                System.out.println("\nThe total amount due is: "+amount_due);
                System.out.println("____________________________________");
          }
}