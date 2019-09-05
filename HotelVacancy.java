import java.util.*;
class HotelDriver
{
	public static void main(String[] args)
	{
		int booking;
		Scanner obj=new Scanner(System.in);
		booking=obj.nextInt();

		int arrival[]=new int[booking];
		int departure[]=new int[booking];
		int k=0;  // no of rooms 	
		for(int i=0;i<booking;i++)
		{
			arrival[i]=obj.nextInt();
			departure[i]=obj.nextInt();
		}
		k=obj.nextInt();
		HotelManager h=new HotelManager();
		System.out.println(h.manages(arrival,departure,k,booking));
	}
}
class HotelManager
{
	public boolean manages(int arrival[],int departure[],int k,int booking)
	{
		int rooms[]=new int[k];  // 0 vacant ,1 filled (bcz order wont matter so simply last element modidficatn)
		int booking_trav=0;  // k rooms
		rooms[booking_trav]=1;
		arrival[booking_trav]=0; //marked as room alloted
		booking_trav++;
		int i=0;
		for(i=1;i<booking;i++)
		{
			if(booking_trav<k)
			{
				//rooms[booking_trav]=1;
				arrival[i]=0;
				booking_trav++;
			}
			else
			{
				int j=i-1;  //will check departure array wheather some left or not
				while(j>=0)
				{
					if(departure[j]<arrival[i])
					{
						departure[j]=999999;  // so that khali wala  consider na ho
						booking_trav--;
						//rooms[booking_trav]=0; // empty
					}
					j--;
				}
				if(booking_trav==k)  // abhi bhi koi leave mhi kr rha thn return False.
				return false;
				//now fill
						//rooms[booking_trav]=1;
						booking_trav++;
			}
		}
		if(i==booking)
			return true;
		else
			return false;
	}
}