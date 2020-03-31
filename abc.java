
import java.util.Scanner;

import java.lang.*;
import java.io.*;
import java.util.*;
class node
{
	node link;
	int food,acc,hosp,dist,alert,visited;
	String name;
	node()
	{
		link=null;
		visited=0;
		food=50;
		acc=100;
		hosp=100;
		dist=0;
		alert=0;
		name=null;
	}
}
public class abc
{
	Scanner x=new Scanner(System.in);
	int tot_city=0;
	String n,start,end;
	int ac,h,o,cn,en;
	node head[]=new node[50];
	int i,j,a,k,l,d1;
	char ans;
	void accept()
	{
		i=0;
	    char ch;
		Scanner x=new Scanner(System.in);
			do
			{
				
				head[i]=new node();
				//head[i]=null;
			System.out.println("Enter the city name");
			n=x.next();
			head[i].name=n;
			i++;
			System.out.println("do u want to continue?");
			cn++;
			ch=x.next().charAt(0);
			}while(ch!='n');
		do

			{
			System.out.println("Enter starting city:");
			start=x.next();
			System.out.println("Enter ending city:");
			end=x.next();
			System.out.println("Enter distance between the cities:");
			d1=x.nextInt();
			insert(start,end,d1);
			//insert(end,start,d1);
			System.out.println("do u want to continue");
			ans=x.next().charAt(0);
			}while(ans=='y');
	
	}		

	void calamity()
	{
		int food,m=999,s=0,q=0;
		node ptr = null;
		node p=null;
		System.out.println("enter the city of calmaity");
		String city=x.next();
		System.out.println("enter required amount of food");
		food=x.nextInt();
		int totalfood=0;
		int v[]=new int[20];
		int t[]=new int[20];
		int ch[]=new int[20];
		int rem=food;
		for(i=0;i<cn;i++)
		{
			v[i]=0;
		}
		for(i=0;i<cn;i++)    
		{
			if(city.compareTo(head[i].name)==0)
			{
				ch[q]=i;
				q++;
				v[i]=1;
				break;
			}
		}
		while(totalfood<food)
		{
		for(i=0;i<q;i++)
		{
			ptr=head[ch[i]];
			while(ptr!=null)
			{
				for(j=0;j<cn;j++)
				{
					if(ptr.name.compareTo(head[j].name)==0)
					{
				if(v[j]==0)
				{
					if(ptr.dist<m)
					{
						m=ptr.dist;
						p=ptr;
					}
				}
				}
				}
				ptr=ptr.link;
			}
		}
		m=999;
			for(j=0;j<cn;j++)      //city whose food is taken
			{
				if( (p.name).compareTo(head[j].name)==0)
				{
				ch[q]=j;
					v[j]=1;
					q++;
					rem=food-totalfood;
					if(rem>head[j].food)
					{
						totalfood+=head[j].food;
						head[j].food=0;
						System.out.println("  name:"+head[j].name +""
								+ "\tRemaining food:"+head[j].food);
					}
					else
					{
						totalfood+=rem;
						head[j].food=head[j].food-rem;
					    System.out.println("  name:"+head[j].name +""
					    		+ "\tRemaining food:"+head[j].food);
					}
				}
			}
			
		}
			System.out.println("Totalfood:"+totalfood);
	}
	
	void insert(String u,String v,int d)
    {
		node temp=new node();
		temp.name=v;
		temp.link=null;
		temp.dist=d;
	node ptr;
    for(j=0;j<cn;j++)
    {
    	if(head[j].name.compareTo(u)==0)
    	{
    		a=j;
    	}   
   	}
     	if(head[a].link==null)
    			{
    				head[a].link=temp;
    			}
    			else
    			{
    				ptr=head[a];
    				while(ptr.link!=null)
    				{
    					ptr=ptr.link;
    				}
    				ptr.link=temp;
    			}
    }
	void hospitalacc()
	{
		int hacc,m=999,s=0,q=0;
		node ptr = null;
		node p=null;
		System.out.println("enter the city of calmaity");
		String city=x.next();
		System.out.println("enter total number of people injured");
		hacc=x.nextInt();
		int acchosp=0;
		int v[]=new int[20];
		int t[]=new int[20];
		int ch[]=new int[20];
		int rem=hacc;
		for(i=0;i<cn;i++)
		{
			v[i]=0;
		}
		for(i=0;i<cn;i++)    
		{
			if(city.compareTo(head[i].name)==0)
			{

				ch[q]=i;
				q++;
				v[i]=1;
				break;
			}
		}
		while(acchosp<hacc)
		{
		for(i=0;i<q;i++)
		{
			ptr=head[ch[i]];
			while(ptr!=null)
			{
				for(j=0;j<cn;j++)
				{
					if(ptr.name.compareTo(head[j].name)==0)
					{
				if(v[j]==0)
				{
					if(ptr.dist<m)
					{
						m=ptr.dist;
						p=ptr;
					}
				}
				}
				}
				ptr=ptr.link;
			}
		}
		m=999;
		
			for(j=0;j<cn;j++)      //city whose food is taken
			{
				if( (p.name).compareTo(head[j].name)==0)
				{
				ch[q]=j;
					v[j]=1;
					q++;
					rem=hacc-acchosp;
					if(rem>head[j].food)
					{
						acchosp+=head[j].hosp;
						head[j].hosp=0;
						System.out.println("  name:"+head[j].name +""
								+ "\tRemaining acc:"+head[j].hosp);
					}
					else
					{
						acchosp+=rem;
						head[j].hosp=head[j].hosp-rem;
						System.out.println("  name:"+head[j].name +""
								+ "\tRemaining acc:"+head[j].hosp);
					}
					
				}
			}
			
		}
			System.out.println("Total accomodation:"+acchosp);
			
	}
	 void rescueoperation()
	    {
	       String exception = null;
	    	String city;
	       node pou=null;
	       int gg=0;
	       int m=9999;
	       int o=0;
	       node ptr=null;
	       node ptr3=null;
	       node ptr2=null;
	       node check=null;
	       int dist=0;
	       int c=0;
	       int cntr=0;
	       int v[]=new int[20];
	       for(i=0;i<cn;i++)
	       {
	    	   v[i]=0;
	       }
	       for(i=0;i<cn;i++)
	       {
	    	   head[i].alert=0;
	       }
	       node p=null;
	       System.out.println("Enter the city where the calamity is expected");
	       city=x.next();
	       for(i=0;i<cn;i++)
	       {
	    	   if(city.compareTo(head[i].name)==0)
	    	   {
	    		 k=i;
	    	   }
	       }
	       ptr=head[k];
	       p=ptr;
	       while(dist<250)
	       {  
	    	   cntr=0;
	    	   for(j=0;j<cn;j++)
	    	   {
	    		   if(p.name.compareTo(head[j].name)==0)
	    		   {
	    			   ptr=head[j];
	    			   ptr2=head[j];
	    			   k=j;
	    			   break;
	    		   }
	    	   }
	    	   v[k]=1;
	    	   ptr=ptr.link;
	    	   while(ptr!=null)
	    	   {
	    		   for(i=0;i<cn;i++)
	    		   {
	    			   if(ptr.name.compareTo(head[i].name)==0)
	    			   {
	    				   a=i;
	    				   //System.out.println("inside loop a:"+head[a].name);
	    				   break;
	    			   }
	    		   }
	    		   //ptr=head[a];
	           if(ptr.alert==0 &&v[a]==0)
	           {
	        	   //System.out.println("gone once");
	    	   if(ptr.dist<m)
	    	   {
	    		   m=ptr.dist;
	    		   p=ptr;
	    		   ptr3=ptr;
	    		   check=ptr;
	    		   //System.out.println(p.name+m+"......");
	    		   //v[a]=1;
	    		   for(int i=0;i<cn;i++)
	    			{
	    				ptr3=head[i];
	    				while(ptr3!=null)
	    				{
	    					if(ptr3.name.compareTo(p.name)==0)
	    					{
	    						ptr3.visited=1;
	    					}
	    					ptr3=ptr3.link;
	    				}
	    			}
	    	   }
	           }
	           ptr=ptr.link;
	           //System.out.println("dist:"+dist);
	    	   }
	    	  
	    	   for(i=0;i<cn;i++)
	    	   {
	    		   if(head[i].name.compareTo(p.name)==0)
	    		   {
	    			   o=i;
	    			   exception=p.name;
	    			   break;
	    		   }
	    	   }
	    	   ptr3=head[o];
	    	   while(ptr3!=null)
	    	   {
	    		   if(ptr3.visited!=1)
	    		   {
	    			   cntr++;
	    		   }
	    		   ptr3=ptr3.link;
	    	   }
	  	    	   if(cntr==0)
	    	   {
	    		   p=head[o];
	    		   //ptr3=p.link;
	    		   p=p.link;
	    		   v[o]=1;
	    	   }
	    	   for(l=0;l<cn;l++)
	    	   {
	    		   if((head[l].name.compareTo(exception))==0)
	           {
	                     k=l;
	                     break;
	            }
	    	   }
	    	  /* if(cntr!=0)
	    	   {
	    		   int k1=0;
	    		   for(i=0;i<20;i++)
	    		   {
	    			   if(head[i].name.compareTo(exception)==0)
	    			   {
	    				   k1=i;
	    			   }
	    		   }
	    		   p=head[i];
	    	   }*/
	    	   //System.out.println(":kkkk"+head[k].name);
	       if(c==0)
	       {
	    	   while(ptr2!=null)
	    	   {
	    		   ptr2.alert=1;
	    		   ptr2=ptr2.link;
	    	   }
	    	   c++;
	       }
	       if(cntr!=0)
	       {
	    	   System.out.println("city to be traversed  :"+p.name);
	           dist+=m;
	           //System.out.println("dist:"+dist);
	           //System.out.println("linkkkk"+p.link);
	       }
	      
	       m=999;
	       }
	       System.out.println("Total distance is :"+dist);
	    }
		void foodsupply(String s)
		{
			Scanner x=new Scanner(System.in);
			int f;
			System.out.println("\nEnter amount of food to be kept in kg");
			f=x.nextInt();
			node ptr;
			for(int i=0;i<cn;i++)
			{
				ptr=head[i];
				while(ptr!=null)
				{
					if(ptr.name.compareTo(s)==0)
					{
						ptr.food=f;
					}
					ptr=ptr.link;
				}
			}
		}
	void display()
    {
        for(int i=0;i<cn;i++) 
        {
            node ptr=head[i];
            System.out.println("For "+(i+1)+" links are");
            while(ptr!=null)
            {
            	
                System.out.println("\nName:"+ptr.name+"\nAccomodation:"+ptr.acc+""
                		+ "\nHospital:"+ptr.hosp+"\nFood:"+ptr.food+"\nDistance "
                				+ "from "+head[i].name+" is"+ptr.dist);
                ptr=ptr.link;
            } 
            System.out.println("\n");
         }
    }
	public static void main(String[] args) 
	{
		String pin="srn";
		String password,city;
		Scanner sc=new Scanner(System.in);
		int s1,s2,s3;
		char choice;
      abc p=new abc();
      System.out.println("\t\t\t\t\t\t\t\t\tDISASTER MANAGEMENT");
      do
      {
    	  System.out.println("\n\nENTER CHOICE\n1-Enter graph of the state"
    	  		+ "\n2-Display information of graph\n3-Before calamity"
    	  		+ " \n4-After calamity\n5-Exit");
    	  s1=sc.nextInt();
    	  switch(s1)
    	  {
    	  case 1:
    		  System.out.println("\nTo edit/enter graph you have to be super user"
    		  		+ "\nENTER PASSWORD");
    		  password=sc.next();
    		  if(password.compareTo(pin)==0)
    		  {
    			  p.accept();
    		  }
    		  else
    		  {
    			  System.out.println("\nYou are not allowed");
    		  }
    		  break;
    	  case 2:
    		  System.out.println("\nDisplaying all the information");
    		  p.display();
    		  break;
    	  case 3:
    		  do
    		  {
    		  System.out.println("ENTER OPTION\n1-Supplying food to cities to be"
   	 	  		+ "kept in stock(in case of calamity)\n2-Escaping to a safe city"
     		  	+ "from a calamity prone city \n3-exit");
    	    		  s2=sc.nextInt();
    	    		  switch(s2)
    	    		  {
    	    		  case 1:
    	    			  System.out.println("\nEnter city where food is"
    	    			  		+ "to be supplied ");
    	    			  city=sc.next();
    	    			  p.foodsupply(city);
    	    			  break;
    	    		  case 2:
    	    			  p.rescueoperation();
    	    		  }
    		  }while(s2!=3);
    	  break;
    	  case 4:
    		  do
    		  {
    		  System.out.println("ENTER OPTION\n1-Supplying food to city in calamity"
    		  		+ "\n2-Providing hospital facility to injured people in"
    		  		+ "the calamity city\n3-exit");
    	    		  s3=sc.nextInt();
    	    		  switch(s3)
    	    		  {
    	    		  case 1:
    	    			 p.calamity();
    	    			  break;
    	    		  case 2:
    	    			  p.hospitalacc();
    	    		  }
    		  }while(s3!=3);
    	  break; 
    	  case 5:
    		  System.out.println("\nEXIT");
    	  }
      }while(s1!=5);
	}
}
/*OUTPUT
DISASTER MANAGEMENT


ENTER CHOICE
1-Enter graph of the state
2-Display information of graph
3-Before calamity 
4-After calamity
5-Exit
1

To edit/enter graph you have to be super user
ENTER PASSWORD
srn
Enter the city name
nagpur
do u want to continue?
y
Enter the city name
akola
do u want to continue?
y
Enter the city name
virat
do u want to continue?
y
Enter the city name
nashik
do u want to continue?
y
Enter the city name
mumbai
do u want to continue?
y
Enter the city name
alibagh
do u want to continue?
y
Enter the city name
pune
do u want to continue?
y
Enter the city name
mahabaleshwar
do u want to continue?
y
Enter the city name
ratnagiri
do u want to continue?
y
Enter the city name
satara
do u want to continue?
y
Enter the city name
shirdi
do u want to continue?
y
Enter the city name
ahmednagar
do u want to continue?
y
Enter the city name
aurangabad
do u want to continue?
y
Enter the city name
karjat
do u want to continue?
y
Enter the city name
latur
do u want to continue?
y
Enter the city name
baramati
do u want to continue?
y
Enter the city name
akluj
do u want to continue?
y
Enter the city name
pandharpur
do u want to continue?
y
Enter the city name
solapur
do u want to continue?
y
Enter the city name
kolhapur
do u want to continue?
n
Enter starting city:
nagpur
Enter ending city:
akola
Enter distance between the cities:
309
do u want to continue
y
Enter starting city:
nagpur
Enter ending city:
pune
Enter distance between the cities:
800
do u want to continue
y
Enter starting city:
akola
Enter ending city:
nagpur
Enter distance between the cities:
309
do u want to continue
y
Enter starting city:
akola
Enter ending city:
shirdi
Enter distance between the cities:
415
do u want to continue
y
Enter starting city:
akola
Enter ending city:
latur
Enter distance between the cities:
489
do u want to continue
y
Enter starting city:
virat
Enter ending city:
mumbai
Enter distance between the cities:
80
do u want to continue
y
Enter starting city:
nashik
Enter ending city:
mumbai
Enter distance between the cities:
177
do u want to continue
y
Enter starting city:
nashik
Enter ending city:
baramati
Enter distance between the cities:
315
do u want to continue
y
Enter starting city:
nashik
Enter ending city:
ratnagiri
Enter distance between the cities:
502
do u want to continue
y
Enter starting city:
shirdi
Enter ending city:
aurangabad
Enter distance between the cities:
128
do u want to continue
y
Enter starting city:
shirdi
Enter ending city:
ahmednagar
Enter distance between the cities:
410
do u want to continue
y
Enter starting city:
shirdi
Enter ending city:
akola
Enter distance between the cities:
415
do u want to continue
y
Enter starting city:
mumbai
Enter ending city:
virat
Enter distance between the cities:
80
do u want to continue
y
Enter starting city:
mumbai
Enter ending city:
alibagh
Enter distance between the cities:
135
do u want to continue
y
Enter starting city:
mumbai
Enter ending city:
pune
Enter distance between the cities:
147
do u want to continue
y
Enter starting city:
mumbai
Enter ending city:
nashik
Enter distance between the cities:
177
do u want to continue
y
Enter starting city:
ahmednagar
Enter ending city:
karjat
Enter distance between the cities:
100
do u want to continue
y
Enter starting city:
ahmednagar
Enter ending city:
pune
Enter distance between the cities:
220
do u want to continue
y
Enter starting city:
ahmednagar
Enter ending city:
aurangabad
Enter distance between the cities:
350
do u want to continue
y
Enter starting city:
ahmednagar
Enter ending city:
shirdi
Enter distance between the cities:
410
do u want to continue
y
Enter starting city:
aurangabad
Enter ending city:
latur
Enter distance between the cities:
240
do u want to continue
y
Enter starting city:
aurangabad
Enter ending city:
ahmednagar
Enter distance between the cities:
350
do u want to continue
y
Enter starting city:
aurangabad
Enter ending city:
pandharpur
Enter distance between the cities:
480
do u want to continue
y
Enter starting city:
latur
Enter ending city:
aurangabad
Enter distance between the cities:
240
do u want to continue
y
Enter starting city:
latur
Enter ending city:
akola
Enter distance between the cities:
489
do u want to continue
y
Enter starting city:
latur
Enter ending city:
karjat
Enter distance between the cities:
328
do u want to continue
y
Enter starting city:
pune
Enter ending city:
mumbai
Enter distance between the cities:
147
do u want to continue
y
Enter starting city:
pune
Enter ending city:
mahabaleshwar
Enter distance between the cities:
180
do u want to continue
y
Enter starting city:
pune
Enter ending city:
ahmednagar
Enter distance between the cities:
220
do u want to continue
y
Enter starting city:
punr
Enter ending city:
nagpur
Enter distance between the cities:
800
do u want to continue
y
Enter starting city:
pune
Enter ending city:
nagpur
Enter distance between the cities:
800
do u want to continue
y
Enter starting city:
karjat
Enter ending city:
ahmednagar
Enter distance between the cities:
100
do u want to continue
y
Enter starting city:
karjat
Enter ending city:
akluj
Enter distance between the cities:
110
do u want to continue
y
Enter starting city:
karjat
Enter ending city:
baramati
Enter distance between the cities:
195
do u want to continue
y
Enter starting city:
karjat
Enter ending city:
latur
Enter distance between the cities:
328
do u want to continue
y
Enter starting city:
alibagh
Enter ending city:
mumbai
Enter distance between the cities:
135
do u want to continue
y
Enter starting city:
alibagh
Enter ending city:
mahabaleshwar
Enter distance between the cities:
200
do u want to continue
y
Enter starting city:
alibagh
Enter ending city:
ratnagiri
Enter distance between the cities:
233
do u want to continue
y
Enter starting city:
mahabaleshwar
Enter ending city:
satara
Enter distance between the cities:
90
do u want to continue
y
Enter starting city:
mahabaleshwar
Enter ending city:
pune
Enter distance between the cities:
180
do u want to continue
y
Enter starting city:
mahabaleshwar
Enter ending city:
alibagh
Enter distance between the cities:
200
do u want to continue
y
Enter starting city:
baramati
Enter ending city:
satara
Enter distance between the cities:
120
do u want to continue
y
Enter starting city:
baramati
Enter ending city:
karjat
Enter distance between the cities:
195
do u want to continue
y
Enter starting city:
baramati
Enter ending city:
kolhapur
Enter distance between the cities:
285
do u want to continue
y
Enter starting city:
baramati
Enter ending city:
solapur
Enter distance between the cities:
180
do u want to continue
y
Enter starting city:
baramati
Enter ending city:
nashik
Enter distance between the cities:
315
do u want to continue
y
Enter starting city:
akluj
Enter ending city:
karjat
Enter distance between the cities:
110
do u want to continue
y
Enter starting city:
akluj
Enter ending city:
solapur
Enter distance between the cities:
150
do u want to continue
y
Enter starting city:
pandharpur
Enter ending city:
aurangabad
Enter distance between the cities:
480
do u want to continue
y
Enter starting city:
satara
Enter ending city:
mahabaleshwar
Enter distance between the cities:
90
do u want to continue
y
Enter starting city:
satara
Enter ending city:
baramati
Enter distance between the cities:
120
do u want to continue
y
Enter starting city:
satara
Enter ending city:
kolhapur
Enter distance between the cities:
200
do u want to continue
y
Enter starting city:
ratnagiri
Enter ending city:
alibagh
Enter distance between the cities:
233
do u want to continue
y
Enter starting city:
ratnagiri
Enter ending city:
nashik
Enter distance between the cities:
502
do u want to continue
y
Enter starting city:
kolhapur
Enter ending city:
satara
Enter distance between the cities:
200
do u want to continue
y
Enter starting city:
kolhapur
Enter ending city:
baramati
Enter distance between the cities:
285
do u want to continue
y
Enter starting city:
solapur
Enter ending city:
akluj
Enter distance between the cities:
150
do u want to continue
y
Enter starting city:
solapur
Enter ending city:
baramati
Enter distance between the cities:
180
do u want to continue
n


ENTER CHOICE
1-Enter graph of the state
2-Display information of graph
3-Before calamity 
4-After calamity
5-Exit
2

Displaying all the information
For 1 links are

Name:nagpur
Accomodation:100
Hospital:100
Food:50
Distance from nagpur is0

Name:akola
Accomodation:100
Hospital:100
Food:50
Distance from nagpur is309

Name:pune
Accomodation:100
Hospital:100
Food:50
Distance from nagpur is800


For 2 links are

Name:akola
Accomodation:100
Hospital:100
Food:50
Distance from akola is0

Name:nagpur
Accomodation:100
Hospital:100
Food:50
Distance from akola is309

Name:shirdi
Accomodation:100
Hospital:100
Food:50
Distance from akola is415

Name:latur
Accomodation:100
Hospital:100
Food:50
Distance from akola is489


For 3 links are

Name:virat
Accomodation:100
Hospital:100
Food:50
Distance from virat is0

Name:mumbai
Accomodation:100
Hospital:100
Food:50
Distance from virat is80


For 4 links are

Name:nashik
Accomodation:100
Hospital:100
Food:50
Distance from nashik is0

Name:mumbai
Accomodation:100
Hospital:100
Food:50
Distance from nashik is177

Name:baramati
Accomodation:100
Hospital:100
Food:50
Distance from nashik is315

Name:ratnagiri
Accomodation:100
Hospital:100
Food:50
Distance from nashik is502


For 5 links are

Name:mumbai
Accomodation:100
Hospital:100
Food:50
Distance from mumbai is0

Name:virat
Accomodation:100
Hospital:100
Food:50
Distance from mumbai is80

Name:alibagh
Accomodation:100
Hospital:100
Food:50
Distance from mumbai is135

Name:pune
Accomodation:100
Hospital:100
Food:50
Distance from mumbai is147

Name:nashik
Accomodation:100
Hospital:100
Food:50
Distance from mumbai is177


For 6 links are

Name:alibagh
Accomodation:100
Hospital:100
Food:50
Distance from alibagh is0

Name:mumbai
Accomodation:100
Hospital:100
Food:50
Distance from alibagh is135

Name:mahabaleshwar
Accomodation:100
Hospital:100
Food:50
Distance from alibagh is200

Name:ratnagiri
Accomodation:100
Hospital:100
Food:50
Distance from alibagh is233


For 7 links are

Name:pune
Accomodation:100
Hospital:100
Food:50
Distance from pune is0

Name:mumbai
Accomodation:100
Hospital:100
Food:50
Distance from pune is147

Name:mahabaleshwar
Accomodation:100
Hospital:100
Food:50
Distance from pune is180

Name:ahmednagar
Accomodation:100
Hospital:100
Food:50
Distance from pune is220

Name:nagpur
Accomodation:100
Hospital:100
Food:50
Distance from pune is800

Name:nagpur
Accomodation:100
Hospital:100
Food:50
Distance from pune is800


For 8 links are

Name:mahabaleshwar
Accomodation:100
Hospital:100
Food:50
Distance from mahabaleshwar is0

Name:satara
Accomodation:100
Hospital:100
Food:50
Distance from mahabaleshwar is90

Name:pune
Accomodation:100
Hospital:100
Food:50
Distance from mahabaleshwar is180

Name:alibagh
Accomodation:100
Hospital:100
Food:50
Distance from mahabaleshwar is200


For 9 links are

Name:ratnagiri
Accomodation:100
Hospital:100
Food:50
Distance from ratnagiri is0

Name:alibagh
Accomodation:100
Hospital:100
Food:50
Distance from ratnagiri is233

Name:nashik
Accomodation:100
Hospital:100
Food:50
Distance from ratnagiri is502


For 10 links are

Name:satara
Accomodation:100
Hospital:100
Food:50
Distance from satara is0

Name:mahabaleshwar
Accomodation:100
Hospital:100
Food:50
Distance from satara is90

Name:baramati
Accomodation:100
Hospital:100
Food:50
Distance from satara is120

Name:kolhapur
Accomodation:100
Hospital:100
Food:50
Distance from satara is200


For 11 links are

Name:shirdi
Accomodation:100
Hospital:100
Food:50
Distance from shirdi is0

Name:aurangabad
Accomodation:100
Hospital:100
Food:50
Distance from shirdi is128

Name:ahmednagar
Accomodation:100
Hospital:100
Food:50
Distance from shirdi is410

Name:akola
Accomodation:100
Hospital:100
Food:50
Distance from shirdi is415


For 12 links are

Name:ahmednagar
Accomodation:100
Hospital:100
Food:50
Distance from ahmednagar is0

Name:karjat
Accomodation:100
Hospital:100
Food:50
Distance from ahmednagar is100

Name:pune
Accomodation:100
Hospital:100
Food:50
Distance from ahmednagar is220

Name:aurangabad
Accomodation:100
Hospital:100
Food:50
Distance from ahmednagar is350

Name:shirdi
Accomodation:100
Hospital:100
Food:50
Distance from ahmednagar is410


For 13 links are

Name:aurangabad
Accomodation:100
Hospital:100
Food:50
Distance from aurangabad is0

Name:latur
Accomodation:100
Hospital:100
Food:50
Distance from aurangabad is240

Name:ahmednagar
Accomodation:100
Hospital:100
Food:50
Distance from aurangabad is350

Name:pandharpur
Accomodation:100
Hospital:100
Food:50
Distance from aurangabad is480


For 14 links are

Name:karjat
Accomodation:100
Hospital:100
Food:50
Distance from karjat is0

Name:ahmednagar
Accomodation:100
Hospital:100
Food:50
Distance from karjat is100

Name:akluj
Accomodation:100
Hospital:100
Food:50
Distance from karjat is110

Name:baramati
Accomodation:100
Hospital:100
Food:50
Distance from karjat is195

Name:latur
Accomodation:100
Hospital:100
Food:50
Distance from karjat is328


For 15 links are

Name:latur
Accomodation:100
Hospital:100
Food:50
Distance from latur is0

Name:aurangabad
Accomodation:100
Hospital:100
Food:50
Distance from latur is240

Name:akola
Accomodation:100
Hospital:100
Food:50
Distance from latur is489

Name:karjat
Accomodation:100
Hospital:100
Food:50
Distance from latur is328


For 16 links are

Name:baramati
Accomodation:100
Hospital:100
Food:50
Distance from baramati is0

Name:satara
Accomodation:100
Hospital:100
Food:50
Distance from baramati is120

Name:karjat
Accomodation:100
Hospital:100
Food:50
Distance from baramati is195

Name:kolhapur
Accomodation:100
Hospital:100
Food:50
Distance from baramati is285

Name:solapur
Accomodation:100
Hospital:100
Food:50
Distance from baramati is180

Name:nashik
Accomodation:100
Hospital:100
Food:50
Distance from baramati is315


For 17 links are

Name:akluj
Accomodation:100
Hospital:100
Food:50
Distance from akluj is0

Name:karjat
Accomodation:100
Hospital:100
Food:50
Distance from akluj is110

Name:solapur
Accomodation:100
Hospital:100
Food:50
Distance from akluj is150


For 18 links are

Name:pandharpur
Accomodation:100
Hospital:100
Food:50
Distance from pandharpur is0

Name:aurangabad
Accomodation:100
Hospital:100
Food:50
Distance from pandharpur is480


For 19 links are

Name:solapur
Accomodation:100
Hospital:100
Food:50
Distance from solapur is0

Name:akluj
Accomodation:100
Hospital:100
Food:50
Distance from solapur is150

Name:baramati
Accomodation:100
Hospital:100
Food:50
Distance from solapur is180


For 20 links are

Name:kolhapur
Accomodation:100
Hospital:100
Food:50
Distance from kolhapur is0

Name:satara
Accomodation:100
Hospital:100
Food:50
Distance from kolhapur is200

Name:baramati
Accomodation:100
Hospital:100
Food:50
Distance from kolhapur is285




ENTER CHOICE
1-Enter graph of the state
2-Display information of graph
3-Before calamity 
4-After calamity
5-Exit
4
ENTER OPTION
1-Supplying food to city in calamity
2-Providing hospital facility to injured people inthe calamity city
3-exit
1
enter the city of calmaity
ahmednagar
enter required amount of food
542
name:karjat	Remaining food:0
name:akluj	Remaining food:0
name:solapur	Remaining food:0
name:baramati	Remaining food:0
name:satara	Remaining food:0
name:mahabaleshwar	Remaining food:0
name:pune	Remaining food:0
name:mumbai	Remaining food:0
name:virat	Remaining food:0
name:alibagh	Remaining food:0
name:nashik	Remaining food:8
Totalfood:542
ENTER OPTION
1-Supplying food to city in calamity
2-Providing hospital facility to injured people inthe calamity city
3-exit
2
enter the city of calmaity
ahmednagar
enter total number of people injured
245
name:karjat	Remaining acc:0
name:akluj	Remaining acc:0
name:solapur	Remaining acc:0
Total accomodation:300
ENTER OPTION
1-Supplying food to city in calamity
2-Providing hospital facility to injured people inthe calamity city
3-exit
3


ENTER CHOICE
1-Enter graph of the state
2-Display information of graph
3-Before calamity 
4-After calamity
5-Exit
3
ENTER OPTION
1-Supplying food to cities to bekept in stock(in case of calamity)
2-Escaping to a safe cityfrom a calamity prone city 
3-exit
1

Enter city where food isto be supplied 
mumbai

Enter amount of food to be kept in kg
100
ENTER OPTION
1-Supplying food to cities to bekept in stock(in case of calamity)
2-Escaping to a safe cityfrom a calamity prone city 
3-exit
2
Enter the city where the calamity is expected
ahmednagar
city to be traversed  :karjat
city to be traversed  :akluj
city to be traversed  :solapur
Total distance is :360
ENTER OPTION
1-Supplying food to cities to bekept in stock(in case of calamity)
2-Escaping to a safe cityfrom a calamity prone city 
3-exit
2
Enter the city where the calamity is expected
alibagh
city to be traversed  :mumbai
city to be traversed  :pune
Total distance is :282
ENTER OPTION
1-Supplying food to cities to bekept in stock(in case of calamity)
2-Escaping to a safe cityfrom a calamity prone city 
3-exit
2
Enter the city where the calamity is expected
shirdi
city to be traversed  :aurangabad
city to be traversed  :latur
Total distance is :368
ENTER OPTION
1-Supplying food to cities to bekept in stock(in case of calamity)
2-Escaping to a safe cityfrom a calamity prone city 
3-exit
2
Enter the city where the calamity is expected
latur
city to be traversed  :aurangabad
city to be traversed  :ahmednagar
Total distance is :590
ENTER OPTION
1-Supplying food to cities to bekept in stock(in case of calamity)
2-Escaping to a safe cityfrom a calamity prone city 
3-exit
3


ENTER CHOICE
1-Enter graph of the state
2-Display information of graph
3-Before calamity 
4-After calamity
5-Exit
5

EXIT
*/
