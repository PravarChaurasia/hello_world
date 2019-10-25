// Created by Pravar
// https://practice.geeksforgeeks.org/problems/remove-duplicates/0
import java.lang.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class RemoveDuplicates 
{ 
	static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 1000; 
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
            byte[] buf = new byte[1000]; // line length 
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
	public static String remDuplicate(String s)
	{
		int alpha[]=new int[256]; // O(1).  
		String temp="";
		// filling the occurance of char in the string
		for(int i=0;i<s.length();i++)
		{
			alpha[s.charAt(i)]++;           // space value will also inc 
		}
		//which char to take
		// NOTE:Space will also come 1 time
		// ip:kjkhjkgjhghjg hgfhggfgh  jhjhgjhghghfgfdfdghnbjhjkgfhgdfgvh             jkgtrtyrtuiokjhj              kjnkjljiohsdiufhgbsiudfguisdgbfuisdgbc uvjdbsjuhvb jhxcb
		// op:kjhg fdnbvtryuiolscx
		for(int i=0;i<s.length();i++)
		{
			if(alpha[s.charAt(i)] != 0)
			{
				// if(s.charAt(i)!= ' ') // space ascii value
				// {
					temp+=String.valueOf(s.charAt(i));
					alpha[s.charAt(i)]=0; // now not further taken this word
				// }
				// else 
				// // alpha[s.charAt(i)]--; // i.e space
				// {
				//     temp+=String.valueOf(s.charAt(i));
				//     alpha[s.charAt(i)]--; 
				// }
				
			}
			
		}
		return temp;
	}
    public static void main(String[] args) throws IOException 
    { 
       
        // Your code goes Here 
        Reader ip=new Reader();
        int test=ip.nextInt();
        while(test!=0)
        {
            //code
            String s=ip.readLine();
            System.out.println(remDuplicate(s));
            test--;
        }

    } 
}