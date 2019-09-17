// https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately/0/
// TC:O(n);

import java.lang.*;
import java.util.*;
class RearrangeArray
{
	public RearrangeArray(long a[],int n,long max_ele)
	{
		//max_ele bcoz mod from this <=n
		int min_val=0,max_val=n-1;
		//modify array 
		for(int i=0;i<n;i++)
		{
			if(i%2==0)  // even index for max values (i=0,2,4,..)
			{
				a[i]+=a[max_val]%max_ele*max_ele;
				max_val--;
			}
			else   	 // odd index for min value will take from previous index value (i=1,3,5..)
			{
				a[i]+=a[min_val]%max_ele*max_ele;
				min_val++;
			}
		}
		// getting required rearranged array (MAx1,Min1,Max2,Max2.....)
		for(int i=0;i<n;i++)
			a[i]/=max_ele;
		// a[i]%=max_ele;  // gives us original values.
	}
}
class RearrangeArrayDriver
{
	public static void main (String[] args)
	 {
	 int t=0;
	 Scanner obj=new Scanner(System.in);
	 t=obj.nextInt();
	 while(t!=0)
	 {
	 	int n=0;
	 	long max_ele=0;
	 	n=obj.nextInt();
	 	long []a=new long[n];
		for(int i=0;i<n;i++)
		{
		 	a[i]=obj.nextLong();			// sorted array
		 	if(a[i]>max_ele)
		 		max_ele=a[i];
		}
	 	RearrangeArray ra=new RearrangeArray(a,n,max_ele+1);
	 	for(long x:a)
	 	System.out.print(x+" ");
	 	System.out.println("");
	 t--;
	 }
	 }
}