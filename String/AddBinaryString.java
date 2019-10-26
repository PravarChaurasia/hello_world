// https://practice.geeksforgeeks.org/problems/add-binary-strings/0/?ref=self
// Created by Pravar

import java.lang.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class AddBinaryString 
{
	public static String add(String s1,String s2)
	{
		int carry=0;
		String sum="";
		int i=s1.length()-1,j=s2.length()-1;
		while(i >=0 && j >=0)
		{
			if(s1.charAt(i)== '1')
			{
				if(s2.charAt(j)== '0')
				{
					if(carry == 1)
					{
						sum= "0"+ sum;
						carry=1;
					}
					else
						sum= "1"+ sum;
				}
				else
				{
					if(carry == 1)
					{
						sum= "1"+ sum;
						carry=1;
					}
					else
					{
						sum= "0"+ sum;
						carry=1;
					}
				}
			}
			else
			{
				if(s2.charAt(j)== '0')
				{
					if(carry == 1)
					{
						sum= "1"+ sum;
						carry=0;
					}
					else
						sum= "0"+ sum;
				}
				else
				{
					if(carry == 1)
					{
						sum= "0"+ sum;
						carry=1;
					}
					else
					{
						sum= "1"+ sum;
						carry=0;
					}
				}
			}
			i--;j--;
		}
		if(s1.length() > s2.length())
		{
			while(i >=0)
			{
				if(s1.charAt(i) == '1')
				{
					if(carry==1)
					{
						sum= "0"+ sum;
						carry=1;
					}
					else
						sum="1"+sum;
				}
				else
				{
					if(carry==1)
					{
						sum= "1"+ sum;
						carry=0;
					}
					else
						sum="0"+sum;
				}
				i--;
			}
		}
		else
		{
			while(j >=0)
			{
				if(s2.charAt(j) == '1')
				{
					if(carry==1)
					{
						sum= "0"+ sum;
						carry=1;
					}
					else
						sum="1"+sum;
				}
				else
				{
					if(carry==1)
					{
						sum= "1"+ sum;
						carry=0;
					}
					else
						sum="0"+sum;
				}
				j--;
			}
		}
		if(carry==1)
		sum= String.valueOf(carry)+ sum;

		return sum;
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
      		String s1=ip.next();
      		String s2=ip.next();
      		System.out.println(add(s1,s2));     
 
            

            test--;
        }

  
        pw.flush();    // clear the buffer
    } 
}