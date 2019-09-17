//https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately/0/
// TC:O(n).
//   ---------------------
//// NOTE: Odd length array ke liye chalta hai .
//   ----------------------------------------
import java.util.*;
import java.lang.*;
import java.io.*;

class RearrangeArray
{
	public RearrangeArray(int a[],int n)
	{
		int i=0,j=n-1,k=0,temp=0,last_ind=n-1,second_pass=0;
// 		
			k=j/2;  // last min/max value;
			temp=a[j];
			while(k!=last_ind)  // first pass (i.e 7 last index contains 2 passes)  last-0=last
			{
				a[j]=a[k];
				j=k;		// j ko bhrna hai ab
				if(k%2==0) // max value aani chahiye and from last we can get max's value as gap is 2 on evry max.
				{
					k=k/2;	// knsi max value(1st,2nd..)
					k=last_ind-k;  // picking max value  (from right)
				}
				else
				{
					k=k/2;        // picking min value (from left)
				}
			} 
			if(k==last_ind)
			a[j]=temp;
			// second pass
			// second_pass=last_ind/2;
			// if(second_pass%2==0)  // as noted a pattern second pass required in this condn.
			// {
   //  			j=last_ind-1;
   //  			k=(last_ind+1)/2; 
   //  			temp=a[j];
   //  			while(k!=last_ind-1)  // first pass (i.e 7 last index contains 2 passes)
   //  			{
   //  				a[j]=a[k];
   //  				j=k;		// j ko bhrna hai ab
   //  				if(k%2==0) // max value aani chahiye and from last we can get max's value as gap is 2 on evry max.
   //  				{
   //  					k=k/2;	// knsi max value(1st,2nd..)
   //  					k=last_ind-k;  // picking max value  (from right)
   //  				}
   //  				else
   //  				{
   //  					k=k/2;        // picking min value (from left)
   //  				}
   //  			}
   //  			if(k==last_ind-1)
   //  			a[j]=temp;  
		 //    }
// 		}
	}

}
class Rearrange_ArrayDriver
 {
	public static void main (String[] args)
	 {
	 int t=0;
	 Scanner obj=new Scanner(System.in);
	 t=obj.nextInt();
	 while(t!=0)
	 {
	 	int n=0;
	 	n=obj.nextInt();
	 	int []a=new int[n];
		for(int i=0;i<n;i++)
	 	a[i]=obj.nextInt();			// sorted array
	 	RearrangeArray ra=new RearrangeArray(a,n);
	 	for(int x:a)
	 	System.out.print(x+" ");
	 	System.out.println("");
	 t--;
	 }
	 }
}