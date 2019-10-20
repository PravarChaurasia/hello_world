//https://practice.geeksforgeeks.org/problems/implement-strstr/1

import java.util.*;
import java.util.regex.*;
class SubStringMatch
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String a = line.split(" ")[0];
			String b = line.split(" ")[1];
			
			GfG g = new GfG();
			System.out.println(g.strstr(a,b));
			
			t--;
		}
	}
}

class GfG
{
    int strstr(String str, String target)
    {
       // Your code here
      int flag=0;
      int loop=str.length()-target.length();
       for(int i=0;i<=loop;i++)
       {
          if(str.charAt(i)==target.charAt(0))
          {
            flag=1;
            int j=1,k=i+1;
            while(j<target.length())
            {
              if(str.charAt(k)==target.charAt(j))
              {
                flag=1;
                k++;
                j++;
              }
              else
              {
                flag=0;
                break;
              }
            }
            if(flag==1 && j==target.length())
              return i;
          }
       }
       return -1;
    }
}