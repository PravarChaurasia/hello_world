/**
 * @(#)StockBuySell.java
 *
 *
 * @author 
 * @version 1.00 2019/8/17
 */
import java.lang.*;
import java.util.*;
public class StockBuySell
{
   public static void main (String[] args)
	 {
	 int t=0;
	 Scanner obj=new Scanner(System.in);
	 t=obj.nextInt();
	 while(t!=0)
	 {
	  int n=0,profit=0;
	 n=obj.nextInt();
	 int []a=new int[n];
	 for(int i=0;i<n;i++)
	 	a[i]=obj.nextInt();
	 int buy=0,sell=0;
	 while(buy<n && sell<n)
	 {
	 	while( buy<n-1 && a[buy+1]<a[buy] )
	 		buy++;
	 	sell=buy;
	 	while(sell<n-1 && a[sell+1]>a[sell] )
	 		sell++;
	 	profit=profit+a[sell]-a[buy];
	 	if(profit>0 && buy!=sell)
	 	System.out.print("("+buy+" "+sell+") ");
	
	 	buy=sell+1;
	 }	
	 if(profit==0)
	 System.out.println("No Profit ");
	 else
	 System.out.println("");
	 t--;
	 }
	 } 
}