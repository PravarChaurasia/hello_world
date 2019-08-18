/**
 * @(#)DistinctNoWindow.java
 *
 *
 * @author 
 * @version 1.00 2019/8/17
 */
 import java.lang.*;
 import java.util.*;
 public class DistinctNoWindow
 {
 	public static void main(String []args)
 	{
 		int t=0;
 		Scanner obj=new Scanner(System.in);
 		t=obj.nextInt();
 		Gfg g=new Gfg();
 		while(t!=0)
 		{
 			int n=0,k=0;
 			n=obj.nextInt();
 			k=obj.nextInt();
 			int A[]=new int[n];
 			for(int i=0;i<n;i++)
 				A[i]=obj.nextInt();
 			g.countDistinct(A,k,n);
 			t--;
 		}
 	}
 }
 class Gfg
{
    void countDistinct(int A[], int k, int n)
    {
	// Your code here	
	int i=0;
	Distinct d=new Distinct();
	while(i<=n-k) // for evry k size window till the complete array traversal 
	{
	    System.out.print(d.disno(A,i,i+k-1)+" ");
	    i++;
	}
    }
}
class Distinct 
{
    public int disno(int []a,int i,int j)
    {
        int start=0;
        int b[]=new int[j-i+1];
        b[0]=a[i];
        int count=1; // frst elemnt distnt
        i++;
        while(i<=j)
        {
            int l=0; //for every element of a[i] need to check from initial in b[]
          /*  while(b[start]!=a[i])
            {
                start++;
                b[start]=a[i];
                count++;i++;
            }
            else
            i++;*/
            while(l<=start)
            {
                if(b[l]!=a[i])
                l++;
                else
                break;
            }
            if(l==start+1)
            {
                start++;
                b[start]=a[i];
                i++;
                count++;
            }
            else
            i++;
        }
        return count;
    }
}