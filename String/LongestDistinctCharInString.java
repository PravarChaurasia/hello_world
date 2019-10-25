// Created by Pravar
// https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string/0
import java.lang.*;
import java.io.*;
import java.util.*;
class LongestDistinctCharInString 
{ 
    public static boolean distinct(String s)
    {
        if(s.length()==1)
            return true;
        int alpha[]=new int[26];
        //filling and checking
        for(int i=0;i<s.length();i++)
        {
            if(alpha[s.charAt(i)-'a'] >= 1)  // ==1 tht show already hai and fr aaya
                return false;
            alpha[s.charAt(i)-'a']++;
        }
        return true;
    }
    public static String longestDistinctSubString(String s)
    {
        int i=0,j=s.length()-1,k=0,l=0;
        String temp="";
        while(i<= j)
        {
            k=0;l=j;
            while(k <= l)
            {
                if(distinct(s.substring(k,l+1)))
                 {
                    if(temp.length() < l-k +1)   // = bcz frtmost index
                        temp= s.substring(k,l+1);
                    break;                       // bcoz longest hi hoga agr milega is loop mai
                 }
                 k++;
            }       
            j--;
        }
        return temp;
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
            System.out.println(longestDistinctSubString(s).length());
            test--;
        }

    } 
}