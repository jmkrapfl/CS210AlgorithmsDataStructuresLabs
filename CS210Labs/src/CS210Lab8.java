import java.util.Scanner;
public class CS210Lab8 
{
	//******** MAIN *******
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		Link[] array = new Link[num];
		
		for(int i = 0; i<num;i++)
		{
			array[i] = new Link(Integer.parseInt(sc.nextLine()));
		}
		while(sc.hasNext())
		{
			int select = sc.nextInt();
			int previous = sc.nextInt();
			int next = sc.nextInt();
			if(previous !=-1)
			{
				array[select].previous = array[previous];
			}
			if(next!=-1)
			{
				array[select].next = array[next];
			}
		}
		LinkedList mylist = new LinkedList();
		if(num>0)
		{
			mylist.first = array[0];
			mylist.last = array[num-1];
		}
		System.out.println(search(mylist));
	}
	
	//search method
	public static int search(LinkedList myList)
	{
		if(myList.isEmpty())
		{
			return -1;
		}
		return 0;
	}
	
}

//****** link class *****
class Link 
{
	//attributes
	public int data;
	public Link next;
	public Link previous;
		
	//constructor
	public Link(int input)
	{
		data = input;
		next = null;
		previous = null;
	}
}
//******* linked list class ********
class LinkedList
{
	//attributes 
	public Link first;
	public Link last;
	
	//constructor
	public LinkedList()
	{
		first=null;
		last=null;
	}
	
	//methods
	public boolean isEmpty()//return true when empty
	{
		return(first==null);
	}
	
	public void insertHead(Link insert)
	{
		if(isEmpty())
		{
			first = insert;
			last = insert;
		}
		else
		{
			first.previous = insert;
			insert.next = first;
			first=insert;
		}
	}	
}