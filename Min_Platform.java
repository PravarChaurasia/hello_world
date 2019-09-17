
//https://practice.geeksforgeeks.org/problems/minimum-platforms/0
// TC:O(n^2),SC:O(2400)i.e O(c)
import java.util.*;
import java.lang.*;
import java.io.*;

class Min_Platform
{
	
	public int count_min(int arrival[],int dep[],int n,int max_dep_time)
	{
		int []time=new int[max_dep_time+1];       // last index should be equal to max_dep time
		// Arrays.fill(time,0);       // java.util.Array --public static void fill(int a[],int value) 
		int start=0,end=0;
		for(int i=0;i<n;i++)
			// for(int j=i+1;j<n;j++)
			// {
			// 	// if(((arrival[i]>=arrival[j]) && (dep[j]<=dep[i] && dep[j]>=arrival[i])) ||
			// 	// 	((arrival[i]>=arrival[j]) && (dep[j]<=dep[i] && dep[j]>=arrival[i])) ||
			// 	// 	((arrival[i]<=arrival[j]) && (dep[j]<=dep[i] && dep[j]>=arrival[i])) ||
			// 	// 	((arrival[i]<=arrival[j]) && (dep[j]>=dep[i] && dep[j]>=arrival[i])))
			// 		count++;
			// } 
		{
			start=arrival[i];
			end=dep[i];
			while(start<=end)
			{
				time[start]++;
				start++;
			}
		}
		for(int i=0;i<2401;i++)
			if(time[i]>count)
			count=time[i];
        return count;
	}
}
class Min_PlatformDriver
 {
	public static void main (String[] args)
	 {
		 int t=0;
		 Scanner obj=new Scanner(System.in);
		 t=obj.nextInt();
		 while(t!=0)
		 {
		  int n=0,max_dep_time=0;
		  n=obj.nextInt();  // no of trains
		 int []arrival=new int[n];
		 int []dep=new int[n];
		 for(int i=0;i<n;i++)
		 	arrival[i]=obj.nextInt();
		 for(int i=0;i<n;i++)
		 {
		 	dep[i]=obj.nextInt();
		 	// if(dep[i]>max_dep_time)                     // for size of array -- can be max of 2400 size of can reduce taking min arr times as 0th index.
		 	// 	max_dep_time=dep[i];
		 }
		 Min_Platform m=new Min_Platform();
		 System.out.println("Minimun no of Platform :"+m.count_min(arrival,dep,n,2400));  //2400

		 t--;
	 }
	 }
}