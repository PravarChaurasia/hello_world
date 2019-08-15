#include<stdio.h>
int checkleft(int *p,int s) // for s to be at correct place
{
    while(p[s]!=0)
        s++;
    return s;
};
int checkright(int *p,int e)
{
    while(p[e]!=0)
        e--;
    return e;
};
int main()
{
 int n=0,i=0,leave=0;
 scanf("%d",&n);
 int s=0,e=n-1;
 char ip[10000];
 int op[10] = {0}; // use op[10] and set all values to 0
 scanf("%s \n",ip);
 while(ip[i])
 {
     if(ip[i]=='L')
     {
         s=checkleft(op,0);
         op[s++]=1;
     }
     else if(ip[i]=='R')
     {
         e=checkright(op,9);
         op[e--]=1;
     }
     else
     {
     	op[ip[i] - '0'] = 0;
     }
     i++;
 }
 for(int i=0;i<10;i++)
     	printf("%d",op[i]);
 return 0;
}
