import java.util.Scanner;
public class CS210Lab9Q1 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		System.out.println(recursive(n));
	}
	public static long recursive(long n)//basically just put in the function he gave us in the question
	{
		if(n ==1)
		{
			return 2;
		}
		else
		{
			return (4*recursive(n-1))-(3*n);
		}
		
	}
}
