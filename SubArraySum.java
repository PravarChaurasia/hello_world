import java.util.*;
 import java.lang.*;
 class GfG
 {
    public static void main (String[] args)
     {
     int t=0;
     Scanner obj=new Scanner(System.in);
     t=obj.nextInt();
     while(t!=0)
     {
      int n=0,sum=0,temp=0,flag=0;
     n=obj.nextInt();
     sum=obj.nextInt();
     int []a=new int[n];
     for(int i=0;i<n;i++)
     a[i]=obj.nextInt();

     int i=0;
     temp=a[0];
     for(int j=1;j<=n;j++)
     {
        while(temp>sum && i<j-1)
        {
            temp-=a[i];
            i++;
        }
        if(temp==sum)
        {
            System.out.println(i+1+" "+j);
            flag=1;
            break;
        }
        if(j<n)
        {
            temp+=a[j];
        }
     }
     if(flag==0)
        System.out.println(-1);
//   for(int i=0;i<n;i++)
//   {
//       temp=0;
//       j=i;
//       while(j<n)
//       {
//           temp+=a[j];
//           if(temp==sum)
//           {
//               System.out.println((i+1)+" "+(j+1));
//               i=n;
//               flag=1;
//               break;
//           }
//           j++;
//       }
//   }
//   if(flag!=1)
//   System.out.println("-1");

//%%%%  m2 %%%%%
    // int i=0,j=1;
    // temp=a[i];
    // while(j<n && i<n && temp!=sum )
    // {
    //         if(i>j)
    //         j=i;  // if crosses
            
    //     if(temp>sum)
    //     {
    //         temp=temp-a[i];
    //           i++;
    //     }
    //     else
    //     {
    //          temp+=a[j];
    //          j++;
             
    //     }
    // }
    
    // if(temp==sum)
    // System.out.println((i+1)+" "+(j));
    // else
    // System.out.println("-1");
     t--;
     }
     }
}