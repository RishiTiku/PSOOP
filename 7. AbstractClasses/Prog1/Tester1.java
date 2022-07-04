import java.util.*;

abstract class Course{
	String Years[] = {"FE", "SE", "TE", "BE"};
	String CourseName;
	String Dept;
	public int year;
	abstract void studentDetails();
	abstract void getStudentDetails();
}

class sorter implements Comparator<Course>
{
	public int compare(Course c1, Course c2)
	{
		return c1.year - c2.year;
	}
}

class Comps extends Course{
	String student_name;
	long UID;
	Comps(){getStudentDetails();}
	void getStudentDetails(){
		Scanner sc = new Scanner(System.in);	
		System.out.println("Enter Name:");
		student_name = sc.nextLine();
		System.out.println("Enter UID:");
		UID = sc.nextLong(); 
		System.out.println("Enter Year: (1-4)");
		System.out.println("1. FE\n2. SE\n3. TE\n4. BE");
		year = sc.nextInt(); 
		System.out.println("Enter Course Name");
		CourseName = sc.next();
		Dept = "COMPS";
	}
	public void studentDetails(){
		System.out.println("Name: "+student_name);
		System.out.println("UID: "+ UID); 
		System.out.println("Year: "+Years[year-1]);
		System.out.println("Course: "+CourseName);
		System.out.println("Department: "+Dept);
	}

}



class IT extends Course{
	String student_name;
	long UID;
	int year;
	IT()
	{getStudentDetails();}
	void getStudentDetails(){
		String Years[] = {"FE", "SE", "TE", "BE"};
		Scanner sc = new Scanner(System.in);	
		System.out.println("Enter Name:");
		student_name = sc.nextLine();
		System.out.println("Enter UID:");
		UID = sc.nextLong(); 
		System.out.println("Enter Year: (1-4)");
		System.out.println("1. FE\n2. SE\n3. TE\n4. BE");
		year = sc.nextInt();
		System.out.println("Enter Course Name");
		CourseName = sc.next();
		Dept = "IT";
	}
	public void studentDetails(){
		System.out.println("Name: "+student_name);
		System.out.println("UID: "+ UID); 
		System.out.println("Year: "+Years[year-1]);
		System.out.println("Course: "+CourseName);
		System.out.println("Department: "+Dept);
	}

}


public class Tester1{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("How many COMPS students you want to enter?");
		int c = sc.nextInt();
		System.out.println("How many IT students you want to enter?");
		int it = sc.nextInt();
		Comps Students1[] = new Comps[c];
		IT Students2[] = new IT[it];
		System.out.println("Comps Students: ");
		for(int i = 0; i<c; i++)
		{
			Students1[i] = new Comps();
		}
		System.out.println("IT Students: ");
		for(int i = 0; i<it; i++)
		{
			Students2[i] = new IT();
		}
		Arrays.sort(Students1, new sorter());
		System.out.println("Comps Students: ");
		for(int i = 0; i<c; i++)
		{
			Students1[i].studentDetails();
			System.out.println();
		}
		Arrays.sort(Students1, new sorter());
		System.out.println("IT Students: ");
		for(int i = 0; i<it; i++)
		{
			Students2[i].studentDetails();
			System.out.println();
		}
	}
}
