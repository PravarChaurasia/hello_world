/**
 * @(#)Pendulam_order.java
 *
 *
 * @author 
 * @version 1.00 2019/8/14
 */

import java.util.*;
import java.lang.*;
import java.io.*;
public class Pendulam_order 
{
	public static void main (String[] args)
	{
	 int t=0;
	 Scanner obj=new Scanner(System.in);
	 t=obj.nextInt();
	 while(t!=0)
	 {
	 // code
	 int n=0;
	 n=obj.nextInt();
	 int []a=new int[n];
	 int []p=new int[n];
	 for(int i=0;i<n;i++)
	 	a[i]=obj.nextInt();
	 	
	 	//bubble_sort
	/* 	int temp=0;
	 	for(int i=0;i<n-1;i++)
	 	{
	 		int sw=0;
	 		for(int j=0;j<n-i-1;j++)
	 		{
	 			if(a[j]>a[j+1])
	 			{
	 					temp=a[j];
	 					a[j]=a[j+1];
	 					a[j+1]=temp;
	 					sw++;
	 			}
	 		}
	 		if(sw==0)
	 			break;
	 	}*/
	 	Arrays.sort(a); // static fun under util package.
	 	
	 	//arrange
	 	int ind=0;
	 	ind=(int)(n-1)/2;
	 	for(int i=0;i<n;i++)
	 	{
	 		if(i%2!=0)
	 		{
	 			ind=ind+i;
	 			p[ind]=a[i];
	 		}
	 		
	 			else
	 			{
	 				ind=ind-i;
	 				p[ind]=a[i];
	 			}
	 	}
	 	
	 	//print
	 	for(int x:p)
	 		System.out.print (x+" ");
	 		System.out.println("");
	 t--;
   	 }
	 }
}
    
