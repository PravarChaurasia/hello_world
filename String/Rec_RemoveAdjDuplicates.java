// Created by Pravar
// https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0
import java.lang.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class Rec_RemoveAdjDuplicates 
{ 
	public static int flag;
	public static String remAdjDuplicate(String s,int start)
	{	

		// if(start == s.length()-1 && flag==1) // one element
		// 	return "";
		if(start == s.length()-1 )
		{
			if(s.length()-1==0 && flag==1)      //ip:aaaaaaaaaaaaa op: nothing should come 
			{
				flag=0;
				return "";
			}
			else if(flag == 1)  // last element pe hai ip:cafzpnii
			{
				flag=0;
				return s.substring(0,start);
			}
			return s;
		}
		
		else if(start < s.length()-1 && s.charAt(start+1)==s.charAt(start))
		{
			flag=1;
			s= s.substring(0,start)+ s.substring(start+1);
			return remAdjDuplicate(s,start);

		}
		if(flag==1)
		{
			s= s.substring(0,start)+ s.substring(start+1);
			flag=0;
			return remAdjDuplicate(s,start);
		}

			return remAdjDuplicate(s,start+1);
	}
	public static boolean check(String s)
	{
		for(int i=0;i<s.length()-1;i++)
		{
			if(s.charAt(i+1)==s.charAt(i))
				return false;
		}
		return true;
	}
    public static void main(String[] args) throws IOException 
    { 
      
        // Your code goes Here 
        Scanner ip=new Scanner(System.in);
        int test=ip.nextInt();
        while(test!=0)
        {
            //code
            String s=ip.next();
            s=remAdjDuplicate(s,0);
            while(!check(s))   // not true -------for ip:mississipie op:mpie
            {
            	s=remAdjDuplicate(s,0);
            }
            System.out.println(s);
            

            test--;
        }

    } 
}