// Created by Pravar
// https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places/0
import java.lang.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class String_RotatedBy_2Places 
{ 
	
	public static String rotate(String s ,int left,int right)
	{
		char c;
		while(left!=0)
		{
			c=s.charAt(0);
			s=s.substring(1);
			s+=String.valueOf(c);
			left--;
		}
		while(right!=0)
		{
			c=s.charAt(s.length()-1);
			s=s.substring(0,s.length()-1);
			s=String.valueOf(c)+s;
			right--;
		}
		return s;
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
            String a=ip.next();
            String b=ip.next();
            //NOTE: Rotation can be clockwise and anticlockwise 
            // and the point to note is that whichever index rote in whatever direction the 
            // finally shift will be in the last or one frst index only.
            // And the possible 2 rotation only can be left-left,l-r,r-l,r-r;
            // Remeber here right-left and left-right will be same 
            String a1=rotate(a,2,0); // left-left
            String a2=rotate(a,1,1);
            String a3=rotate(a,0,2);
            if(a1.equals(b) || a2.equals(b) || a3.equals(b))
            	System.out.println("1");
            else
            	System.out.println("0");

            

            test--;
        }

  
        pw.flush();    // clear the buffer
    } 
}