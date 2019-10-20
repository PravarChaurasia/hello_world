// Created by Pravar
// https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
import java.lang.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class String_Permutation 
{ 
  // static class Reader 
  //   { 
  //       final private int BUFFER_SIZE = 1 << 16; 
  //       private DataInputStream din; 
  //       private byte[] buffer; 
  //       private int bufferPointer, bytesRead; 

  //       public Reader() 
  //       { 
  //           din = new DataInputStream(System.in); 
  //           buffer = new byte[BUFFER_SIZE]; 
  //           bufferPointer = bytesRead = 0; 
  //       } 

  //       public Reader(String file_name) throws IOException 
  //       { 
  //           din = new DataInputStream(new FileInputStream(file_name)); 
  //           buffer = new byte[BUFFER_SIZE]; 
  //           bufferPointer = bytesRead = 0; 
  //       } 

  //       public String readLine() throws IOException 
  //       { 
  //           byte[] buf = new byte[64]; // line length 
  //           int cnt = 0, c; 
  //           while ((c = read()) != -1) 
  //           { 
  //               if (c == '\n') 
  //                   break; 
  //               buf[cnt++] = (byte) c; 
  //           } 
  //           return new String(buf, 0, cnt); 
  //       } 

  //       public int nextInt() throws IOException 
  //       { 
  //           int ret = 0; 
  //           byte c = read(); 
  //           while (c <= ' ') 
  //               c = read(); 
  //           boolean neg = (c == '-'); 
  //           if (neg) 
  //               c = read(); 
  //           do
  //           { 
  //               ret = ret * 10 + c - '0'; 
  //           } while ((c = read()) >= '0' && c <= '9'); 

  //           if (neg) 
  //               return -ret; 
  //           return ret; 
  //       } 

  //       public long nextLong() throws IOException 
  //       { 
  //           long ret = 0; 
  //           byte c = read(); 
  //           while (c <= ' ') 
  //               c = read(); 
  //           boolean neg = (c == '-'); 
  //           if (neg) 
  //               c = read(); 
  //           do { 
  //               ret = ret * 10 + c - '0'; 
  //           } 
  //           while ((c = read()) >= '0' && c <= '9'); 
  //           if (neg) 
  //               return -ret; 
  //           return ret; 
  //       } 

  //       public double nextDouble() throws IOException 
  //       { 
  //           double ret = 0, div = 1; 
  //           byte c = read(); 
  //           while (c <= ' ') 
  //               c = read(); 
  //           boolean neg = (c == '-'); 
  //           if (neg) 
  //               c = read(); 

  //           do { 
  //               ret = ret * 10 + c - '0'; 
  //           } 
  //           while ((c = read()) >= '0' && c <= '9'); 

  //           if (c == '.') 
  //           { 
  //               while ((c = read()) >= '0' && c <= '9') 
  //               { 
  //                   ret += (c - '0') / (div *= 10); 
  //               } 
  //           } 

  //           if (neg) 
  //               return -ret; 
  //           return ret; 
  //       } 

  //       private void fillBuffer() throws IOException 
  //       { 
  //           bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
  //           if (bytesRead == -1) 
  //               buffer[0] = -1; 
  //       } 

  //       private byte read() throws IOException 
  //       { 
  //           if (bufferPointer == bytesRead) 
  //               fillBuffer(); 
  //           return buffer[bufferPointer++]; 
  //       } 

  //       public void close() throws IOException 
  //       { 
  //           if (din == null) 
  //               return; 
  //           din.close(); 
  //       } 
  //   }
    // public static void permutation(String s,String perString)
    // {
    	//M-I---------------------------------------------------------------------
  //   	if(s.length()==0)
  //   	{
  //   		System.out.print(perString+" ");
  //   		return;
  //   	} 	
  //   	boolean alpha[] = new boolean[26]; // default false alpha[0] represent a;
		// for(int i=0;i<s.length();i++)
		// {
		// 	char ith=s.charAt(i);
		// 	String s1=s.substring(0,i)+s.substring(i+1);
		// 	perString+=ith;
		// 	if (alpha[ith - 'A'] == false) 
  //           permutation(s1, perString); 
  //       	alpha[ith - 'A'] = true;
		// }
		//-------------------------------------------------------------------------

    // } 
    
    // M-II for lexograpgical order need to jst substitute that at frst (i) place
    public static String swap(String s,int i,int j)
    {
    	// non lexograpgical------------------------------

    	char ch[]=s.toCharArray();
    	char temp=ch[i];
    	ch[i]=ch[j];
    	ch[j]=temp;
        Arrays.sort(ch,i+1,ch.length);
        // for lexographical order

    	return String.valueOf(ch);

    	// // // lexograpgical ---s is sorted-----------------------------------
    	// // char ch=s.charAt(j);
    	// // s=s.substring(0,i) + String.valueOf(ch) + s.substring(i,j) + s.substring(j+1); // jth ko skip kr denge
    	// return s;

    }
    // for distinct char string 
    public static void permutation(String s,int i,int j)
    {
    	if(i==j)
			System.out.print(s+" ");
    	else
    	for(int k=i;k<=j;k++)
    	{
    		s=swap(s,i,k);  // bringing kth to ith index 
    		permutation(s,i+1,j);
    		s=swap(s,i,k);  // reseting to same

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
        // Reader ip=new Reader();
        Scanner ip=new Scanner(System.in);
        int test=ip.nextInt();
        while(test!=0)
        {
            //code
           	String s=ip.next();
           	char ch[]=s.toCharArray();
			Arrays.sort(ch);
			s=String.valueOf(ch);
            permutation(s,0,s.length()-1);  
            System.out.println("");      
            test--;
        }
        pw.flush();    // clear the buffer
    } 
}