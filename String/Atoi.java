// Created by Pravar
// https://practice.geeksforgeeks.org/problems/implement-atoi/1
import java.lang.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class Atoi 
{ 
 	
 	public static int atoi(String s)
 	{
 		char ch[]=s.toCharArray();
 		int flag=0,temp=-1;
 		int a=0,j=0;
 		if(ch[0]=='-')   // i.e negative no
 			j=1;
 		for(int i=j;i<ch.length;i++)
 		{

 			if(ch[i]-'0' > 9)
 			{
 				flag=1;
 				break;
 			}
 			a=a*10 + (ch[i]-'0');  // for positive works well
 		}
 		if(flag==1)
 			a=temp;
 		else if(ch[0]=='-')
 			a=-a;
 		return a;

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
            // ------------M-I-------------------------------
            // int flag=0;
            // int a=0;
            // String s="";
            // try
            // {
            // 	 s=ip.next();
            // 	 a=Integer.parseInt(s);  // now here the error comes
            // }
            // catch(NumberFormatException e)
            // {
            // 	flag=1;
            // 	System.out.println("-1");
            // }
            // if(flag==0)
            // 	System.out.println(a);

            // ---------------------M-II----------------------------------------
        	String s=ip.next();
        	System.out.println(atoi(s));


            test--;
        }

  
        pw.flush();    // clear the buffer
    } 
}