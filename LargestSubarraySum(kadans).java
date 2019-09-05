import java.util.*;
class LargestSubArraySumDriver
{
	public static void main(String[] args) 
	{
		
		int n=0;
		Scanner obj=new Scanner(System.in);
		n=obj.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=obj.nextInt();
		LargestSubArraySum s=new LargestSubArraySum();
		s.subArraySum(a,n);
	}

}
class LargestSubArraySum
{
	public void subArraySum(int a[],int n)
	{
		int flag=0,max=0;
		int max_local=0,max_subArray=0;
		for(int i=0;i<n;i++)
		{
			max_local+=a[i];
			if(max_local<0)
				max_local=0;
			if(max_local>max_subArray)
				max_subArray=max_local;
		}
			// checking all negative to nhi hai 
		 max=a[0];
		for(int i=0;i<n;i++)
		{
		    if(a[i]>0)
		    {
		        flag=1;
		        break;
		    }
		    else
		    {
		       
		        if(a[i]>max)
		        max=a[i];
		    }
		}
		if(flag==0)
		System.out.println(max);
		else
		System.out.println(max_subArray);
	}
}
