import java.util.Scanner;


public class QuickSort
{
	public static void Display(int A[])
	{
		for(int i = 0; i<A.length; i++)
		{
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	public static void QSort(int A[], int low, int high)
	{
		if(low<high)
		{
			int pi = QuickSort.Partition(A, low, high);
			System.out.println("New");
			QuickSort.QSort(A, low, pi-1);
			System.out.println("New");
			QuickSort.QSort(A, pi+1, high);
		}
	}
	public static int Partition(int A[], int low, int high)
	{
		int a = low - 1;
		int pivot = A[high];
		int temp = 0;
		for(int i = low; i <=high-1; i++)
		{
			if(A[i]<=pivot)
			{
				Display(A);
				a++;
				temp = A[a];
				A[a] = A[i];
				A[i] = temp;
				Display(A); 
			}
		}
		temp = A[a+1];
		A[a+1] = pivot;
		A[high] = temp;
		Display(A);
		return a+1;
	}
	
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		int n; 
		System.out.println("Enter a number for Array Length.");
		n = sc.nextInt();
		int A[] = new int[n];
		for(int i = 0; i<n; i++)
		{
			System.out.println("Enter A["+i+"].");
			A[i] = sc.nextInt();
		}
		QuickSort.QSort(A, 0, n-1);
		QuickSort.Display(A);
		
	}
}

