import java.util.*;
import java.lang.*;
import java.io.*;

class Equilibrium 
{
	public Equilibrium(int a[],int n)
	{
		
		int i=0,j=n-1;
		int lsum=a[i],rsum=a[j];
		// int flag=0;
		if(i==j && (lsum==rsum))
				System.out.println(i+1);
		else if(i<j)
		{
			i++;
			j--;
			while(i<j)
			{
				
				if(lsum>rsum)
				{	
					rsum+=a[j];
					j--;
				}
				if(rsum>lsum)
				{
					lsum+=a[i];
					i++;
				}
			}
			if(i==j && (lsum==rsum))
				System.out.println(i+1);
			else
				System.out.println("-1");
		}
		
			
		
			
	}
}
class EquilibriumDriver
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
	 Equilibrium e=new Equilibrium(a,n);
	 t--;
	 }
	 }
}