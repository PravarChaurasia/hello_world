import java.util.*;
// SC:O(1)
// TC: O(m+n(log(m+n)))

class MergeSortedArray
{
   
	public static void main (String[] args)
	 {
	 int t=0;
	 Scanner obj=new Scanner(System.in);
	 t=obj.nextInt();
	 while(t!=0)
	 {
	  int n1=0,n2=0;
	 n1=obj.nextInt();
	 n2=obj.nextInt();
	 int []a=new int[n1];
	 int []b=new int[n2];
	 for(int i=0;i<n1;i++)
	 	a[i]=obj.nextInt();
	 for(int i=0;i<n2;i++)
	 	b[i]=obj.nextInt();
	 	//merging

	 	int i=n1-1,j=n2-1,temp=0;
	 	
	    while(i>0 && j>0) // max of a i.e last elemnt should be small b[0] (min of b)
	    {
	        if(a[i]>b[j])
	        {
	           temp=a[i];
	           a[i]=b[j];
	           b[j]=temp;
	           i--;
	        }
	        else
	        j--;
	    }
	    if(i>j)
	    {
	    	i=n1-1;
	    	if(b[j]<a[i])   // max of a i.e last elemnt should be small b[0] (min of b)
	    	{
	    		temp=a[i];
	           a[i]=b[j];
	           b[j]=temp;
	    	}

	    }
	    Arrays.sort(a);
	    Arrays.sort(b);
	 	for(int x:a)
	 	System.out.print(x+" ");
	 	for(int x:b)
	 	System.out.print(x+" ");
	 	System.out.println("");
	 	
	 t--;
	 }
	 }
}

