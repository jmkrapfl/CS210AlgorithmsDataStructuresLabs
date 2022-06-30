public class Queue 
{
	//*******attributes*******
	private int maxSize;
	private String[] queArr;
	private int front;
	private int rear;
	private int nItems;
	
	//******constructor******
	public Queue(int s)
	{
		maxSize = s;
		queArr = new String[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	//******Methods********
	public boolean insert(String j)//put item at rear of queue
	{
		if(isFull() == true)//Don't remove if full
		{
			return false;
		}
		if(rear == maxSize-1)//deal with wrap around
		{
			rear = -1;
			
		}
		//increment rear and insert
		rear++;
		queArr[rear] = j;
		//one more item
		nItems++;
		//Successfully inserted
		return true;
	}
	
	public String remove()//take item from front of queue
	{
		if(isEmpty()== true)
		{
			return null;
		}
		//get value and increment front
		String temp = queArr[front];
		front++;
		if(front == maxSize)//deal with wrap around
		{
			front =0;
		}
		nItems--;
		return temp;
	}
	
	public String peekMiddle()//peek middle of queue if even its the string closer to the front
	{
		int range = (rear-front)+1;
		int middle;
		if(front ==0)//catches the case of when the array is full with none removed
		{
			range--;
		}
		if(range % 2 ==0)//if its even
		{
			middle = (range/2)-1;
			return queArr[front + middle];
		}
		else
		{
			middle = (range/2)+1;
			return queArr[middle];
		}
	}
	
	public String peekFront()//peek at front of queue
	{
		return queArr[front];
	}
	
	public boolean isEmpty()//return true if empty
	{
		return (nItems==0);
	}
	
	public boolean isFull()//return true if full
	{
		return (nItems == maxSize);
	}
	
	public int size()
	{
		return nItems;
	}
}