// https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix/0

// Created by Pravar

import java.lang.*;
import java.io.*;
import java.util.*;
class Traversal
{
	public void spiralTraversal(int matrix[][],int m,int n)
	{
         // index value of all corner and on evry circle completion change its values.
        int itop=0,ibot=m-1,jleft=0,jright=n-1; 
        int i=0,j=0; 
        while(itop<ibot && jleft<jright)
        {
            i=itop;j=jleft;

          
                while(j<jright)
                {
                    System.out.print(matrix[i][j]+" ");
                    j++;
                }            
                while(i<ibot)
                {
                    System.out.print(matrix[i][j]+" ");
                    i++;
                }
                while(j>jleft)
                {
                    System.out.print(matrix[i][j]+" ");
                    j--;
                }
                while(i>itop)
                {
                    System.out.print(matrix[i][j]+" ");
                    i--;
                }
                jleft++;itop++;jright--; ibot--;
        } 
        // single element left
        if(itop==ibot && jleft==jright)
            {
              System.out.print(matrix[itop][jleft]+" ");
            }
            // one row or one column left
        else 
        {
            if(itop==ibot && jleft<jright)
                while(jleft<=jright)
                    System.out.print(matrix[itop][jleft++]+" ");

            else if(jleft==jright && itop<ibot)
                while(itop<=ibot )
                    System.out.print(matrix[itop++][jleft]+" ");

        }
        System.out.println("");


	}
}
class SpiralMatrix
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
            int m=ip.nextInt();
            int n=ip.nextInt();
            int matrix[][]=new int[m][n];
            for(int i=0;i<m;i++)
            	for(int j=0;j<n;j++)
            	matrix[i][j]=ip.nextInt();
            Traversal t=new Traversal();
            t.spiralTraversal(matrix,m,n);
            test--;
        }

  
        pw.flush();    // clear the buffer
    } 
}