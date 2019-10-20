// Created by Pravar
// https://practice.geeksforgeeks.org/problems/roman-number-to-integer/0
import java.lang.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class Roman2Int 
{ 
  
    public static void romanToInt(String roman)
    {
    	int num=0;
    	char rom[]=roman.toCharArray();
    	int i=0,temp=0,count=0;
    	while(i<rom.length)
    	{
    		if(rom[i]=='I')
    		{
    			if(i<rom.length-1 && rom[i+1]=='V')
    			{
    				num+=4;
    				i=i+2;
    				continue;
    			}
    			else if(i<rom.length-1 && rom[i+1]=='X')
    			{
    				num+=9;
    				i=i+2;
    				continue;
    			}
    			else
	    			num+=1;  			
    		}    	
    		else if(rom[i]=='V')
    			num+=5;
    		
    		else if(rom[i]=='X')
    		{
    			if(i<rom.length-1 && rom[i+1]=='L')
    			{
    				num+=40;
    				i=i+2;
    				continue;
    			}
    			else if(i<rom.length-1 && rom[i+1]=='C')
    			{
    				num+=90;
    				i=i+2;
    				continue;
    			}
    			else
    			num+=10;
    		}

    		else if(rom[i]=='L')
    			num+=50;

    		else if(rom[i]=='C')
    		{
    			if(i<rom.length-1 && rom[i+1]=='D')
    			{
    				num+=400;
    				i=i+2;
    				continue;
    			}
    			else if(i<rom.length-1 && rom[i+1]=='M')
    			{
    				num+=900;
    				i=i+2;
    				continue;
    			}
    			else
    			num+=100;
    		}

    		else if(rom[i]=='D')
    			num+=500;

    		else if(rom[i]=='M')
    			num+=1000;
    	
    		i++;		
    	}
    	
    	System.out.println(num);
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
            String roman=ip.next();
            romanToInt(roman);
            test--;
        }

  
        pw.flush();    // clear the buffer
    } 
}