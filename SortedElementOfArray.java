// Created by Pravar

import java.lang.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class FindSortedElement
{
	public FindSortedElement(int a[],int n)
	{	
		int left_Max[]=new int[n];
		int right_Min[]=new int[n];
		//filling
		int left_Max_var=a[0],right_Min_var=a[n-1];
		left_Max[0]=0;
		right_Min[n-1]=0;
		for(int i=1;i<n;i++)
		{
			left_Max[i]=left_Max_var;
			if(a[i]>left_Max_var)
			{
				left_Max_var=a[i];

			}
			
			right_Min[n-i-1]=right_Min_var;
			if(a[n-i-1]<right_Min_var)
			{
				right_Min_var=a[n-i-1];
			}
			
		}
		// traversing
		int flag=0;
		for(int i=1;i<n-1;i++)
		{
			if(a[i]>=left_Max[i] && a[i]<=right_Min[i])
			{
				flag=1;
				System.out.println(a[i]);
				break;
			}
		}
		if(flag!=1)
		System.out.println("-1");	
			
	}
}
class SortedElementOfArray
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
            int n=ip.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=ip.nextInt();
        	FindSortedElement f=new FindSortedElement(a,n);
            

            test--;
        }

  
        pw.flush();    // clear the buffer
    } 
}