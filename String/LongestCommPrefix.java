// Created by Pravar
// https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array/0
import java.lang.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class LongestCommPrefix
{ 
	public static void swap(String s[],int minLenIndex)
	{
		int index=s.length-1;
		String temp=s[minLenIndex];
		s[minLenIndex]=s[index];
		s[index]=temp;
	}
  	public static void lcp(String s[])
  	{
  		if(s.length==1)
  		{
  			System.out.println(s[0]);
  			return;
  		}
  		int i=s.length-1;
  		String maxCommPref=s[i];i--;
  		int j=0,k=0,flagCount=0;
  		while(i>=0)
  		{
  			j=0;k=0;flagCount=0;
  			String temp="";
  			while(j< maxCommPref.length() )
  			{

  				if(maxCommPref.charAt(j)==s[i].charAt(k))
  				{
  					flagCount++;
  					temp+=String.valueOf(maxCommPref.charAt(j));
  					j++;k++;
  				}
  				else
  					break;
  			}
  			if(flagCount>0)
  			{
  				maxCommPref=temp;
  				i--;
  			}
  			else
  			{
  				System.out.println("-1");
  				break;
  			}
  			
  		}
  		if(flagCount>0)
  		System.out.println(maxCommPref);	
  	}
    public static void main(String[] args) throws IOException 
    { 
        // BufferedReader Class for Fast buffer Input 
        BufferedReader br1 = new BufferedReader( 
                               new FileReader("input.txt")); 
  
        // PrintWriter class prints formatted representations 
        // of objects to a text-output stream. 
        PrintWriter pw=new PrintWriter(new
                BufferedWriter(new FileWriter("output.txt"))); 
  
        // Your code goes Here 
        Scanner ip=new Scanner(System.in);
        int test=ip.nextInt();
        while(test!=0)
        {
            //code
            int minLen=0,minLenIndex=0;
            int n=ip.nextInt();
            String s[]=new String[n];
            s[0]=new String(ip.next());
            minLen=s[0].length();
            for(int i=1;i<n;i++)
            {
           		 s[i]=new String(ip.next());
           		 if(s[i].length()< minLen)
           		 {
           		 	minLen=s[i].length();
           		 	minLenIndex=i;
           		 }
           	}
           	swap(s,minLenIndex); //max comm pref can be upto of length last index 
           	// for(int i=0;i<s.length;i++)
           	// {
           	// 	System.out.println(s[i]);
           	// }
           
        	lcp(s); 
            

            test--;
        }

  
        pw.flush();    // clear the buffer
    } 
}