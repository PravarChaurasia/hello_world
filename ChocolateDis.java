/**
 * @(#)ChocolateDis.java
 *
 *
 * @author 
 * @version 1.00 2019/8/17
 */
import java.lang.*;
import java.util.*;
public class ChocolateDis 
{
	public static void main (String[] args)
	{
	 int t=0;
	 Scanner obj=new Scanner(System.in);
	 t=obj.nextInt();
	 while(t!=0)
	 {
	  int n=0,m=0;
	 n=obj.nextInt();
	 int []a=new int[n];
	 for(int i=0;i<n;i++)
	 	a[i]=obj.nextInt();
	  m=obj.nextInt();
	 // sort a;
	 if(n>=m)
	 {
	 Arrays.sort(a);
	 //distribution to m people 
	 int start=0,end=m-1;
	 int diff_min=0;
	 diff_min=a[end]-a[start];   // java.lang.Math.abs()for |diff_min|
	 //checking diff_min is minimum
	 start++;end++;
	 while(end!=n)
	 {
	 	if(a[end]-a[start]<diff_min)
	 	diff_min=a[end]-a[start];
	 	start++;end++;
	 }	
	 	System.out.println(diff_min);
	 }
	 t--;
	 }
	}
    
    
    
}