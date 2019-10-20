// Created by Pravar

import java.lang.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class String_Permutation_1
{ 
  
    
    public static String swap(String s,int i,int j)
    {
    	char ch[]=s.toCharArray();
    	char temp=ch[i];
    	ch[i]=ch[j];
    	ch[j]=temp;
        Arrays.sort(ch,i+1,ch.length);
        // for lexographical order

    	return String.valueOf(ch);

    	// // // lexograpgical ---s is sorted-----------------------------------
    	// // char ch=s.charAt(j);
    	// // s=s.substring(0,i) + String.valueOf(ch) + s.substring(i,j) + s.substring(j+1); // jth ko skip kr denge
    	// return s;

    }
    // Repeated letter is allowed char string 
    public static void permutation(String s,int i,int j)
    {
    	if(i==j)
			System.out.print(s+" ");
    	else
    	for(int k=i;k<=j;k++)
    	{
        while(k<j && s.charAt(k+1)==s.charAt(k))
          k++;

    		s=swap(s,i,k);  // bringing kth to ith index 
    		permutation(s,i+1,j);
    		s=swap(s,i,k);  // reseting to same

    	}
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
        // Reader ip=new Reader();
        Scanner ip=new Scanner(System.in);
        int test=ip.nextInt();
        while(test!=0)
        {
            //code
           	String s=ip.next();
           	char ch[]=s.toCharArray();
      			Arrays.sort(ch);
      			s=String.valueOf(ch);
            permutation(s,0,s.length()-1);  
            System.out.println("");      
            test--;
        }
        pw.flush();    // clear the buffer
    } 
}
