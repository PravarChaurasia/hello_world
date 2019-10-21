// Created by Pravar

import java.lang.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class Longest_Pallindrome 
{  
	public static String reverseString(String s)
	{
		char ch[]=s.toCharArray();
		char temp;
		int i=0,j=ch.length-1;
		while(i<j)
		{
			temp=ch[i];
			ch[i]=ch[j];
			ch[j]=temp;
			i++;j--;
		}
		return String.valueOf(ch);
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
            String s=new String(ip.next());
            int i=0,j=s.length()-1,k=0,l=0;
            int flagCount=0;
            String temp="";
            while(i<= j)
            {
            	if(i==j)
            	{
            		if(temp.length() <=1)   // = bcoz if conflict occures(all distinct) then choose frst index ,ip:rfkqyuqfjkxy op:r            								
            			temp=String.valueOf(s.charAt(0));
            		

            	}
            	else
            	{
	            	k=0;l=j;
	            	while(k <= l)
	            	{
		            	if(reverseString(s.substring(k,l+1)).equals(s.substring(k,l+1)))
		            	 {
		            	 	
		            		if(temp.length() <= l-k +1)   // = bcz frtmost index
		            			temp= s.substring(k,l+1);
		            		break;
		            	 }
		            	 k++;
		            }
            	}
            	j--;
            }
            if(temp.length()> 0)
            	System.out.println(temp);
            else
            	System.out.println("-1");
            

            test--;
        }

  
        pw.flush();    // clear the buffer
    } 
}