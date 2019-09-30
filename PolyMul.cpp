#include <bits/stdc++.h> 
using namespace std; 

// For storing complex values of nth roots 
// of unity we use complex<double> 
typedef complex<double> cd; 

// Recursive function of FFT 
vector<cd> fft(vector<cd>& a) 
{ 
	int n = a.size(); 

	// if input contains just one element 
	if (n == 1) 
		return vector<cd>(1, a[0]); 

	// For storing n complex nth roots of unity 
	vector<cd> w(n); 
	for (int i = 0; i < n; i++) { 
		double alpha = 2 * M_PI * i / n; 
		w[i] = cd(cos(alpha), sin(alpha)); 
	} 

	vector<cd> A0(n / 2), A1(n / 2); 
	for (int i = 0; i < n / 2; i++) { 

		// even indexed coefficients 
		A0[i] = a[i * 2]; 

		// odd indexed coefficients 
		A1[i] = a[i * 2 + 1]; 
	} 

	// Recursive call for even indexed coefficients 
	vector<cd> y0 = fft(A0); 

	// Recursive call for odd indexed coefficients 
	vector<cd> y1 = fft(A1); 

	// for storing values of y0, y1, y2, ..., yn-1. 
	vector<cd> y(n); 

	for (int k = 0; k < n / 2; k++) { 
		y[k] = y0[k] + w[k] * y1[k]; 
		y[k + n / 2] = y0[k] - w[k] * y1[k]; 
	} 
	return y; 
} 
vector<cd> rfft(vector<cd>& b) 
{ 
	int n = b.size(); 

	// if input contains just one element 
	if (n == 1) 
		return vector<cd>(1, b[0]); 

	// For storing n complex nth roots of unity 
	vector<cd> w(n); 
	for (int i = 0; i < n; i++) 
	{ 
		double alpha = -1*2 * M_PI * i / n;   //****angle e^-i*theta;
		w[i] = cd(cos(alpha), sin(alpha)); 
	} 

	vector<cd> A0(n / 2), A1(n / 2); 
	for (int i = 0; i < n / 2; i++) { 

		// even indexed coefficients 
		A0[i] = b[i * 2]; 

		// odd indexed coefficients 
		A1[i] = b[i * 2 + 1]; 
	} 

	// Recursive call for even indexed coefficients 
	vector<cd> y0 = rfft(A0); 

	// Recursive call for odd indexed coefficients 
	vector<cd> y1 = rfft(A1); 

	// for storing values of y0, y1, y2, ..., yn-1. 
	vector<cd> y(n); 

	for (int k = 0; k < n / 2; k++) 
	{ 
		y[k] = y0[k] + w[k] * y1[k]; 
		y[k + n / 2] = y0[k] - w[k] * y1[k]; 
		y[k] /=2;                                   //*****************
		y[k + n / 2]/=2;							//********************
	} 
	return y; }
vector<cd> mul(vector<cd>& a,vector<cd>& b) 
{ 
	 vector<cd> c(a.size());
	 for(int i=0;i<c.size();i++)
	 {
	 	c[i]=a[i]*b[i];
	 }
	 return c;
} 
 


int main() 
{ 
	vector<cd> a={0,10,0,0}; 
	vector<cd> b={0,10,0,0};
	// for(int i=0;i<n/2;i++)
	// {
	// 	a[i]=rand()%1000;
	// 	b[i]=rand()%1000;
	// }
	// //padding
	// for(int i=0;i<n/2;i++)
	// {
	// 	a[i]=0;
	// 	b[i]=0;
	// }
	//printing given polynomial
	cout<< "Poly A:";
	for(int i=0;i<a.size() ;i++)
	{
		if(round(a[i].real())!=0)
		cout<< round(a[i].real())<<"*x^"<<i<<"+";

	} 
	cout<<endl;  
	cout<< "Poly B:";
	for(int i=0;i<b.size();i++)
	{
		if(round(b[i].real())!=0)
		cout<< round(a[i].real())<<"*x^"<<i<<"+";

	}   
	cout<<endl;
	vector<cd> a1 = fft(a);     // point(yi)
	vector<cd> b1 = fft(b); 
	// printing the point-form points.
	// for (int i = 0; i <a1.size(); i++) 
	// 	cout << a1[i] << endl; 
	// for (int i = 0; i < b1.size(); i++) 
	// 	cout << b1[i] << endl; 
	vector<cd> c= mul(a1,b1); 
	vector<cd> c1 = rfft(c);    // coeff value
	// printing
	cout<<"Poly C:";
	for(int i=0;i<c1.size();i++)
	{
		if(round(c1 [i].real())!=0)
		cout<< round(c1 [i].real())<<"*x^"<<i<<"+";

	}                                                                                                                                                                                                                                                                                                                                                                                     
	return 0; 
} 
