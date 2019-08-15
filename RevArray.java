/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2019/8/11
 */


import java.util.*;
import java.lang.*;
import java.io.*;
class Reverse 
{
    public Reverse(int []arr,int n)
    {   int temp=0;
        int start=0;
        int end=n-1;
        while(start<end)
        {   //swap
            temp=arr[start];
            arr[start++]=arr[end];
            arr[end--]=temp;
        }
    }
    public void print(int []arr,int n)
    {
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
        System.out.println("");
    }
}
class RevArray
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
	 int []arr=new int[n];
	 for(int i=0;i<n;i++)
	 arr[i]=obj.nextInt();
	 //reverse arr
	 Reverse rev=new Reverse(arr,n);
	 rev.print(arr,n);
	 t--;
	 }
	}
}