import java.util.Scanner;
public class CS210Lab7 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Queue que = new Queue(10);
		
		while(sc.hasNext())
		{
			String str = sc.nextLine();
			if(str.matches("(?i)remove"))//if the command is remove then remove
			{
				//System.out.println("heloo");
				if(que.isEmpty()==false)
				{
					que.remove();
				}
			}
			else if(str.matches("."))
			{
				break;
			}
			//else if(str.matches("(?i)insert"))//else put the word after insert into the queue
			else
			{
				//System.out.println("hello");
				String [] arrOfStr = str.split(" ");
				que.insert(arrOfStr[1]);
			}
			//else
			//{
				//break;
			//}
		}
		
		if(que.isEmpty() == false)
		{
			int size = que.size();
			int i = size/2;
			if(size%2==0)
			{
				i--;
			}
			while(i>0)
			{
				que.remove();
				i--;
			}
			System.out.println(que.remove());
		}
		else
		{
			System.out.println("Empty");
		}
	}
}
