// Created by Praver
import java.io.*; 
import java.util.*;
class Job
{
	public int job_Id;
	public int profit;
	public int deadline;

	public Job(int job_Id,int profit,int deadline)
	{
		this.job_Id=job_Id;
		this.profit=profit;
		this.deadline=deadline;
	}
}
class MergeSort 
{ 
    void sort(Job j[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 

            // Sort first and second halves 
            sort(j, l, m); 
            sort(j, m+1, r); 

            // Merge the sorted halves 
            merge(j,l, m, r); 
        } 
    }
	void merge(Job p[], int l, int m, int r) 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1; 
		int n2 = r - m; 
		int temp=0;
	
		Job L[] = new Job [n1]; 
		Job R[] = new Job [n2]; 

	
		for (int i=0; i<n1; ++i) 
        {
			L[i] =new Job(p[l + i].job_Id,p[l+i].profit,p[l+i].deadline); 
        }
		for (int j=0; j<n2; ++j) 
        {
			R[j] = new Job(p[m + 1+ j].job_Id,p[m+1+j].profit,p[m+1+j].deadline); 
        }


		/* Merge the temp arrays */

		
		int i = 0, j = 0; 

		
		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i].profit >= R[j].profit)  // decreasing order
			{ 
				p[k].job_Id = L[i].job_Id;
				p[k].profit = L[i].profit;
				p[k].deadline = L[i].deadline;
				i++; 
			} 
			else
			{ 
				p[k].job_Id = R[j].job_Id;
				p[k].profit = R[j].profit;
				p[k].deadline = R[j].deadline;
				j++; 
			} 
			k++; 
		} 

	
		while (i < n1) 
		{ 
			p[k].job_Id = L[i].job_Id;
			p[k].profit = L[i].profit;
			p[k].deadline = L[i].deadline;
			i++; 
			k++; 
		} 

		while (j < n2) 
		{ 
			p[k].job_Id = R[j].job_Id;
			p[k].profit = R[j].profit;
			p[k].deadline = R[j].deadline;
			j++; 
			k++; 
		} 
	}  
}
class Job_Schedule 
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
    public static void schedule(Job j[])
    {
        int t_profit=0;
        int k=0;
        int schedule_arr[]=new int[j.length];
        for(int i=0;i<j.length;i++)
        {
            if(schedule_arr[j[i].deadline]==0)
            {
                schedule_arr[j[i].deadline]=j[i].job_Id;
                t_profit+=j[i].profit;
            }
            else
            {
                k=j[i].deadline-1;
                while(k>=0)
                {
                    if(schedule_arr[k]==0)
                    {
                        schedule_arr[k]=j[i].job_Id;
                        t_profit+=j[i].profit;
                        break;
                    }
                    k--;
                }
            }
        }
        System.out.print("Job scheduled : ");
        for(int i=0;i<schedule_arr.length;i++)
        {
            if(schedule_arr[i]!=0)
            System.out.print("job"+schedule_arr[i]+" ");          
        }
        System.out.print("And the Scheduled Jobs Profit is :"+t_profit);
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
        Job j[]=new Job[n];

        int job_Id=0;
		int profit=0;
		int deadline=0;
        for(int i=0;i<n;i++)
        {
        	job_Id=ip.nextInt();
        	profit=ip.nextInt();
        	deadline=ip.nextInt();
        	j[i]=new Job(job_Id,profit,deadline);
        }
        MergeSort ms=new MergeSort();
        ms.sort(j,0,n-1);       
        // for(int i=0;i<n;i++)
        // {
        // 	System.out.println(j[i].job_Id+","+j[i].profit+","+j[i].deadline);      	
        // }
        schedule(j);
        pw.flush(); 
    } 
} 