// Created by Praver
import java.io.*;
class MinMaxDAC
{
	public int min,max;
	public int[] rec(int a[],int i,int j)
	{
		int mm[]=new int[2];  // store min max
		if(i==j) // single element 
		{
			mm[0]=a[i];  // min
			mm[1]=a[i];	// max
			return mm;
		}
		else if(i==j-1)  // two elements 
		{
			if(a[i]>a[j])
			{
				mm[0]=a[j];
				mm[1]=a[i];
			}
			else
			{
				mm[0]=a[i];
				mm[1]=a[j];
			}
			return mm;
		}
		// >2 elemets
		int mid=i+j/2;
		int left[]=rec(a,i,mid);
		int right[]=rec(a,mid+1,j);

		// now the left and right
		if(left[0]>right[0])
			mm[0]=right[0];
		else
			mm[0]=left[0];
		if(left[1]>right[1])
			mm[1]=left[1];
		else
			mm[1]=right[1];
		return mm;
		
	}
} 
class MinMax
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
        BufferedReader br = new BufferedReader( 
                               new FileReader("input.txt")); 
  
        // PrintWriter class prints formatted representations 
        // of objects to a text-output stream. 
        PrintWriter pw=new PrintWriter(new
                BufferedWriter(new FileWriter("output.txt"))); 
  
        // Your code goes Here 
        Reader ip=new Reader();
        int n=ip.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        	a[i]=ip.nextInt();
        MinMaxDAC dac=new MinMaxDAC();
        int mm[]=dac.rec(a,0,n-1);
        // print
        	System.out.print(mm[0]+" "+mm[1]);
  
        pw.flush(); 
    } 
} 