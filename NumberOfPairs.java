// Created by Pravar
//https://practice.geeksforgeeks.org/problems/number-of-pairs/0/
//TC:O(nlogn).
import java.io.*; 
import java.util.*;
import java.lang.*;

class NumberPairs
{
	public long pairs(int x[],int y[],int nx,int ny)
	{
		int i=0,j=0,three=0;
		long count=0;
		// setting i and j
		while(x[i]<2)
			i++;
		// find index in y >4
		while(y[j]<=4)
			j++;
		int start_i=i;
		int start_j=j;
		while(i<nx)
		{
			if(x[i]==3)   // counting no of 3 in x.
				three++;

			while(j<ny && x[i]>=y[j] )
			j++;
			if(j==ny)
				break;
			// temp_j=j;
			// while(j<ny)
			// {
				else if(y[j]>x[i])
				{
						count+=ny-j;
						// while(y[temp_j+1]==y[temp_j])
						// 	temp_j++;
						// count++;
					
				// while(y[temp_j+1]==y[temp_j])
				// 			temp_j++;
				}
				// j++;
			// }
			// while(x[i+1]==y[i])   // if non distinct value comes
			// 	i++;
			i++;
		}
		// find no f pairs for j<4
		j=0;
		int temp_count=0;
		while(j<start_j)
		{
			if(y[j]==1)
				count+=nx-start_i;
			if(y[j]==2 || y[j]==4)
				temp_count++;
			j++;
		}
		count=count+three*temp_count;
		return count;
	}
}
class NumberOfPairs 
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
  
        // Your code goes Here 
        Reader s=new Reader();
        int test=s.nextInt();
        while(test!=0)
        {
            //code
            int nx=s.nextInt();
            int ny=s.nextInt();
            int x[]=new int[nx];
            int y[]=new int[ny];   
            x[i]=s.nextInt();
        	for(int i=0;i<ny;i++)
        	y[i]=s.nextInt();

        	//sort
        	Arrays.sort(x);
        	Arrays.sort(y);       	
		    NumberPairs p=new NumberPairs();
		    System.out.println(p.pairs(x,y,nx,ny));  		      
            test--;
        }
    } 
}