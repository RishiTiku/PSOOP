import java.util.*;

class frac{
	public int a;
	public int b;
	frac()
	{
		a = 1;
		b = 1;
	}
	frac(int A, int B)
	{
		a = A;
		b = B;
	}
	public void reduce()
	{
		if(a<0&&b<0)
		{
			a = -a;
			b = -b;
		}
		int c = a>=b?a:b;
		for(;c>=1; c--)
		{
			if(a%c == 0 && b%c == 0)
			{
				a/=c;
				b/=c;
			}
			if(a == 1||b==1)
				return;
		}
	}
	public String toString()
	{
		return(this.a+"/"+this.b);
	}
}
class fraction{
	public static frac add(int a, int b, int c, int d)
	{	
		frac ob = new frac();
		ob.a = a*d + b*c;
		ob.b = b*d;
		ob.reduce();
		return ob;
	}
	public static frac sub(int a, int b, int c, int d)
	{	
		frac ob = new frac();
		ob.a = a*d - b*c;
		ob.b = b*d;
		ob.reduce();
		return ob;
	} 
	public static frac mult(int a, int b, int c, int d)
	{	
		frac ob = new frac();
		ob.a = a*c;
		ob.b = b*d;
		ob.reduce();
		return ob;
	}
	public static frac div(int a, int b, int c, int d)
	{	
		frac ob = new frac();
		ob.a = a*d;
		ob.b = b*c;
		ob.reduce();
		return ob;
	}
}
class fractions{
	public static void printTables(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a value for Denominator");
		int n = sc.nextInt();
		frac A[] = new frac[n];
		frac ob = new frac();
		//System.out.print("\t");
		for(int i = 1; i<=n-1; i++)
		{
			A[i] = fraction.mult(1, n, i, 1);
			System.out.print("\t");
			System.out.print(A[i].a+"/"+A[i].b+" ");
		}
		System.out.println();
		System.out.print("\t");
		for(int i = 1; i<=n-1; i++)
		{
			System.out.print("________");
		}
		System.out.println();
		for(int i = 1; i<=n-1; i++)
		{
			System.out.print(A[i].a+"/"+A[i].b+"\t|");
			for(int j = 1; j<=n-1; j++)
			{
				ob = fraction.mult(A[i].a, A[i].b, A[j].a, A[j].b);
				System.out.print(ob.a+"/"+ob.b+"\t");
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		frac ob = new frac();
		ob = fraction.add(1,2,3,4);
		System.out.println("Addition: "+ob);
		ob = fraction.sub(1,2,3,4);
		System.out.println("Subtraction: "+ob);
		ob = fraction.mult(1,2,3,4);
		System.out.println("Multiplication: "+ob);
		ob = fraction.div(1,2,3,4);
		System.out.println("Division: "+ob);
		printTables();
	}
}
