import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
public class park 
{
public static void main(String[] args) 
{
	boolean flag=true;
	long arr_in[]=new long[10];
	long arr_out[]=new long[10];
	long arr_total[]=new long[10];
	HashMap<Integer, Integer> a=new HashMap<Integer,Integer>();
	for(int i=1;i<=10;i++)
	{
		a.put(i, 0);
	}
	while(flag)
	{
	System.out.println("1.Park:\n");
	System.out.println("2.Remove from Parking:\n");
	System.out.println("3.Find the Slot for parked vehical:\n");
	System.out.println("4.Empty slots for parking:\n");
	Scanner sc=new Scanner(System.in);
	int j=sc.nextInt();
	switch(j)
	{
	case 1:
		System.out.println("Enter registration number :");
		String s=sc.next();
		Set set=a.entrySet();
		Iterator it=set.iterator();
		while(it.hasNext())
		{
			Map.Entry e=(Entry) it.next();
			if(e.getValue()==(Integer)0)
			{
				
				a.put((Integer)e.getKey(), Integer.parseInt(s.substring(s.length()-4,s.length())));
				long startTime = System.currentTimeMillis();
				arr_in[(Integer)e.getKey()]=startTime;
				System.out.println("Vehicle is parked");
				break;
			}
		}
		break;
	case 2:
		
		System.out.println("Enter registration number of vehical to be remove:");
		String s4=sc.next();
		Set set4=a.entrySet();
		Iterator it4=set4.iterator();
		while(it4.hasNext())
		{
			Map.Entry e4=(Entry) it4.next();
			if((Integer)e4.getValue()==Integer.parseInt(s4.substring(s4.length()-4,s4.length())))
			{
				long stopTime = System.currentTimeMillis();
				arr_out[(Integer)e4.getKey()]=stopTime;	
				arr_total[(Integer)e4.getKey()]=arr_out[(Integer)e4.getKey()]-arr_in[(Integer)e4.getKey()];
				System.out.println(arr_total[(Integer)e4.getKey()]);
				float minutes=(float) Math.ceil(arr_total[(Integer)e4.getKey()]/60000);
				System.out.println("The Vehicle has been parked here from "+minutes+" mins");
				float charge=minutes*(float)1.0;
				a.put((Integer)e4.getKey(), 0);
				System.out.println("Please pay the amount Rs."+charge);
				break;
			}
		}
		break;
	case 3:
		System.out.println("Enter registration number of vehical for finding parked slot:");
		String s1=sc.next();
		Set set1=a.entrySet();
		Iterator it1=set1.iterator();
		while(it1.hasNext())
		{
			Map.Entry e1=(Entry) it1.next();
			if((Integer)e1.getValue()==Integer.parseInt(s1.substring(s1.length()-4,s1.length())))
			{

				System.out.println("Vehicle is parked at slot number:");
				System.out.println(e1.getKey());
				break;
					
			}
			else
				System.out.println("entry has not done for entered registration number");
				break;
		}
		break;
	case 4:
		Set set2=a.entrySet();
		Iterator it2=set2.iterator();
		
		int count=0;
		while(it2.hasNext())
		{
			Map.Entry e2=(Entry) it2.next();
			if((Integer)e2.getValue()==(Integer)0)
			{

				count++;
			}
		}
		System.out.println("Available Slots are: "+count);
		break;
	default:
		flag=false;
		break;
	}
	
}
}
}
