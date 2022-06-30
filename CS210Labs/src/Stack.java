public class Stack 
{
	//****Attributes****
	private int maxSize;//max size of the array
	private String[] stackArray;
	private int top;//top of stack
	//*****Constructor*****
	public Stack(int s)
	{
		maxSize = s;
		stackArray = new String[maxSize];
		top = -1;//no items yet
	}
	//*****Methods*****
	public void push(String j)//put item on top of stack
	{
		top++;
		stackArray[top] = j;
	}
	
	public String pop()//take item from top of stack
	{
		return stackArray[top--];
	}
	
	public String peek()//peek at top
	{
		return stackArray[top];
	}
	
	public boolean isEmpty()//true if stack is empty
	{
		return (top==-1);
	}
	
	public boolean isFull()//true if stack is full
	{
		return (top == maxSize);
	}
	
	public void makeEmpty()//empty stack
	{
		top = -1;
	}
	
	public void printStack()
	{
		for(int i = maxSize-1; i >= 0; i--)
		{
			System.out.println(stackArray[i]);
		}
	}
}
