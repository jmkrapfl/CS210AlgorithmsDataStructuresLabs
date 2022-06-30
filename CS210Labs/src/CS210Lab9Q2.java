import java.util.Scanner;
public class CS210Lab9Q2 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		double years = sc.nextDouble();
		double interest = sc.nextDouble();
		double bal = sc.nextDouble();
		System.out.println(interest(bal, interest, years));
	}
	public static double interest(double bal, double interest, double years)
	{
		double percent = (interest/100)+1;
		if(years==1)
		{
			bal = bal*percent;
			//rounding
			bal = (bal*100);
			bal = Math.round(bal);
			bal = bal/100;
			return bal;
		}
		else
		{
			return interest(bal*percent, interest, years-1);
		}
	}
}
