/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/8/15
 */

import java.util.*;
import java.lang.*;
import java.io.*;
class Closest
 {
	public static void main (String[] args)
	 {
	 int t=0;
	 Scanner obj=new Scanner(System.in);
	 t=obj.nextInt();
	 while(t!=0)
	 {
	  int n=0,k=0,least_diff=0,diff;
	 n=obj.nextInt();
	 k=obj.nextInt();
	 int []a=new int[n];
	 for(int i=0;i<n;i++)
	a[i]=obj.nextInt();
	least_diff=k-a[0];
	int i=0;
	if(least_diff>0)
	{
	for(i=0;i<n-1;i++)
	{
	    if(k-a[i+1]>=0)
	    {
	        diff=k-a[i+1];
	        if(least_diff < diff) //move forward
	        break;
	        else
	        least_diff=diff;
	    }
	    else if(k-a[i+1]<0)
	    {
	        diff=a[i+1]-k;
	         if(least_diff < diff) //move forward
	        break;
	        else
	        least_diff=diff;
	    }
	}
	}
	System.out.println(a[i]);
	 t--;
	 }
	 }
}