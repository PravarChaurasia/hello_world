import java.lang.*;
import java.util.Scanner;
import java.util.Random;

class KthSmallestDriver
{
	public static void main(String[] args)
	{
		int  n=0,ks=0,kl=0,kthsmall=0,klarge=0; // size of array
		long start=0,end=0; // for execution time calculation  
		Scanner s=new Scanner(System.in);
		Random random=new Random(); // class to generate sequence of random no's.
		System.out.println("Enter size of an array");
		n=s.nextInt ();
		System.out.println("kth smallest no and largest no");
		ks=s.nextInt();
		int  a[]=new int [n];
		for(int  i=0;i<n;i++)
		a[i]=random.nextInt(); // storing random no in a[];

		KthSmallest kth=new KthSmallest();
		start=System.currentTimeMillis();
		kthsmall=kth.smallest(a,0,n-1,k-1);
		end=System.currentTimeMillis();
		if(kthsmall>0)
		System.out.println("\nkthsmall value is"+ kthsmall +"Execution Time"+(long)(end-start)+"ms");
		else
		System.out.println("wrong input");
	//	start=System.currentTimeMillis();
	//	klarge=kth.smallest(a,0,n-1,n-k+1);
	//	end=System.currentTimeMillis();
	//	System.out.println("\nkthsmall value is"+ kthlarge +"Execution Time"+(long)(end-start)+"ms");
		// printing 

	}
}
public class KthSmallest
{
	public int smallest(int []a,int l,int r,int k)
	{
		if(k>0 && k<=r-l+1)  // k should be smaller of equal to the no of the elements
		{
			int n=r-l+1;  // no of elements in a.
			// for median calculatn first we need to divide the arr (not actual only traversing for so tht could fine median arr).
			int median[]=new int [(n+4)/5]; // size of median array equals to the no the groups formed having 5 elements each 
			int i;
			// filling median array 
			for(i=0;i<n/5;i++) // may be ek kam element rahe isme so we'll cover tht by manually assigning it.
			median[i]=findMedian(a+l+i*5,5) // (arr(base adress)+staring index,size of array); since constant length array so findmedian will take o(c) time
// now i will be in the last index of median--> may be if existed
            if(i*5<n)
            {
            	median[i]=findMedian(a+l+i*5,n%5); // bcoz last group size will be the remainder of array only if ==0 then n/5 exact groups
            	i++; // after ++ equal to size of median array 
            }
            int medofmed;
            //if we found i==1 i.e only one value in median array then return that else recursive call it
            if(i==1) // boz i telling size of array now as ++ done so index would be '0' only 
            medofmed=median[0];
            else
            medofmed=smallest(median,0,i-1,i/2); // (median arr_ref,l_index of median,r_index of median((n+4)/5) or i-1,kth smallest element and since medofmed we want mid so i/2th element)

        	// need to find pos of pivot(medofmed) in the array
         	int pos=modifiedPartition(arr,l,r,medofmed);
         	
         	// 
         	if(k==pos)
         		return pos;
         	else if(k>pos)
         		return smallest(arr,pos+1,r,k-pos+1); // go right side
         	return smallest(arr,l,pos-1,k);
		}
	}
	public int findMedian(int []a,int n)
	{
		Arrays.sort(a,a+n);
		return a[n/2];
	}
	public modifiedPartition(int a[],int l, int r,int medofmed)
	{
		int  temp=0;
		// search the medofmed in arr
		for(int i=l;i<=r;i++)
			if(a[i]==medofmed)
			{
				temp=a[i];
				a[i]=a[l];
				a[l]=temp;
				break;
			}
		// use normal partition algo now whre a[l] contains pivot
			
	}
}
