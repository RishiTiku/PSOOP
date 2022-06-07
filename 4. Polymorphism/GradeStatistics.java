import java.util.*;
import java.lang.*;


public class GradeStatistics{
	
	public void Sort(int A[])
	{
		for(int i = 0; i<A.length; i++)
		{
			for(int j = 0; j<A.length-1; j++)
			{
				if(A[j]>A[j+1])
				{
					A[j] += A[j+1];
					A[j+1] = A[j] - A[j+1];
					A[j] = A[j] - A[j+1]; 
				}
			}
		}
	}
	public void Display(int A[])
	{
		for(int i = 0 ; i < A.length; i++)
		{
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	public void tin()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Input number of students.");
		int t = sc.nextInt();
		int A[] = new int[t];
		for(int i = 0 ; i < t; i++)//Input
		{
			System.out.println("Enter Student "+(i+1)+"\'s marks.");
			A[i] = sc.nextInt();
		}
		Sort(A);
		float mean = 0, sd = 0;
		int min = A[0], max = A[0], median = 0, sum = 0;
		for(int i = 0; i < t; i++)
		{
			if(A[i]>=max)
			{
				max = A[i];
			}
			if(A[i]<=min)
			{
				min = A[i];
			}
			sum+=A[i];// sum = sum +A[i]
			
		}
		mean = (float) sum/t;//mean done
		sum = 0;
		if(t%2 == 0)//t is even
		{
			median  = (A[t/2] + A[t/2 - 1])/2;
		}
		else
		{
			median = A[t/2];// 7/2 = 3.5, 0, 1, 2, 3, 4, 5 , 3 = t/2, 2 = t/2 - 1
		}
		for(int i = 0; i<t; i++)
		{
			sum += Math.pow(mean - A[i], 2); 
		}
		sd = (float)Math.sqrt((float)sum/t);
		System.out.println("Mean: "+mean);//printf("%D", mean);
		System.out.println("Min: "+min);
		System.out.println("Max: "+max);
		System.out.println("Median: "+median);
		System.out.println("Standard Deviation: "+sd);
	}
	public static void main(String args[])
	{
		GradeStatistics ob = new GradeStatistics();
		ob.tin();
	}
}
