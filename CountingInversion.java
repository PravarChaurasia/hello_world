import java.util.*;
import java.lang.*;
import java.io.*;
class CountingInversion
 {
   
	public static void main (String[] args)
	 {
	 int t=0;
	 Scanner obj=new Scanner(System.in);
	 t=obj.nextInt();
	 while(t!=0)
	 {
	    
	  int n=0;
	  
	 n=obj.nextInt();
	 int []a=new int[n];
	 for(int i=0;i<n;i++)
	 	a[i]=obj.nextInt();
	 	MergeSort m=new MergeSort();
	   
	 	 m.sort(a,0,n-1);
	 	 System.out.println(m.count_inv);
	 t--;
	 }
	 }
}

class MergeSort 
{ 
	public  long count_inv;
	public int inversionCountMerge(int arr[], int l, int m, int r) 
	{ 
	    int count_loc=0;
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* Create temp arrays */
		int L[] = new int [n1]; 
		int R[] = new int [n2]; 

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i) 
			L[i] = arr[l + i]; 
		for (int j=0; j<n2; ++j) 
			R[j] = arr[m + 1+ j]; 


	
	
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i]; 
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
				j++; 
				count_loc+=n1-i;
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		
			
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
		return count_loc;
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(int arr[], int l, int r) 
	{ 
		if (l < r) 
		{ 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr , m+1, r); 

			// Merge the sorted halves 
			this.count_inv+=inversionCountMerge(arr, l, m, r);
		} 
		
	} 
	
} 
