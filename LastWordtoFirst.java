//https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0

// Created by Pravar

import java.lang.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class LastWordtoFirst 
{ 
  static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 

        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 

        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 

        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 

        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            } while ((c = read()) >= '0' && c <= '9'); 

            if (neg) 
                return -ret; 
            return ret; 
        } 

        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 

        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 

            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 

            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 

            if (neg) 
                return -ret; 
            return ret; 
        } 

        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 

        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 

        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
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
        Reader ip=new Reader();
        int test=ip.nextInt();
        while(test!=0)
        {
            //code
            String s=new String();
            s=ip.readLine();
            char c[]=s.toCharArray();
            int i=c.length-1,j=i;
            int tempi=0,tempj=0;
            while(j>=0)
            {
            	if(c[j]=='.')
            	{
            		tempi=j+1;
            		tempj=i;
            		while(tempi<=tempj)
            		{
            			System.out.print(c[tempi]);
            			tempi++;
            		}
                   System.out.print(".");
                   i=j-1;
                }
                else if(j==0)
                {
                    while(j<=i)
                    {
                        System.out.print(c[j]);
                        j++;
                    }
                    j=0;
                }
            		
            		j--;
            }
            System.out.println("");

            test--;
        }

  
        pw.flush();    // clear the buffer
    } 
}
