// https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion/0
 //  TC:O(n)

import java.util.*;
import java.lang.*;
import java.io.*;

class ZigZagArray
{
	public void arrange(int a[],int n)
	{
		for(int i=1;i<n;i+=2)  // a < b > c  , if i at last index thn check lft side only
  		{
			if(a[i-1]>a[i])  // check left of it 
			swap(a,i-1,i);
			if(i<n-1 && a[i+1]>a[i])
			swap(a,i+1,i);
		}
	}
	public void swap(int a[],int i,int j)
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
class ZigZagArrayDriver
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
	 	a[i]=obj.nextInt();
	 ZigZagArray z=new ZigZagArray(a,n);
	 t--;
	 }
	 }
}