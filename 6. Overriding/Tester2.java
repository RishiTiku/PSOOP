class Employee{
   public double getSalary(){return 10000;}
   public double getBonus(){return 0;}
}

class Intern extends Employee{
    public double getSalary(){return 7500;}
    public double getBonus(){return 5000;}
}

class Clerk extends Employee{
    public double getSalary(){return 5000;}
    public double getBonus(){return 7000;}
}
class Manager extends Employee{
    public double getSalary(){return 20000;}
    public double getBonus(){return 3000;}
}
public class Tester2 {
    public static void main(String []args)
    {
        Employee ob1 = new Employee();
        Intern ob2 = new Intern();
        Clerk ob3 = new Clerk();
        Manager ob4 = new Manager();
        System.out.println("Employee: Salary: "+ob1.getSalary()+" Bonus: "+ob1.getBonus());
        System.out.println("Total: "+(ob1.getSalary()+ob1.getBonus()));
        System.out.println("Intern: Salary: "+ob2.getSalary()+" Bonus: "+ob2.getBonus());
        System.out.println("Total: "+(ob2.getSalary()+ob2.getBonus()));
        System.out.println("Clerk: Salary: "+ob3.getSalary()+" Bonus: "+ob3.getBonus());
        System.out.println("Total: "+(ob3.getSalary()+ob3.getBonus()));
        System.out.println("Manager: Salary: "+ob4.getSalary()+" Bonus: "+ob4.getBonus());
        System.out.println("Total: "+(ob4.getSalary()+ob4.getBonus()));
    }
}
