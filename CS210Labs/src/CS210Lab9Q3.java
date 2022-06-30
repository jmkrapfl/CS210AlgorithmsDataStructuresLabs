import java.util.Scanner;
public class CS210Lab9Q3 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		double numOfPeople = sc.nextDouble();
		
		double probOfNotBirth = probOfBirthdays(numOfPeople,0);
		double probOfSame = 1-probOfNotBirth;
		
		//round prob of same
		probOfSame = probOfSame*1000;
		probOfSame = Math.round(probOfSame);
		probOfSame = probOfSame/1000;
		
		System.out.println(probOfSame);
		
	}
	public static double probOfBirthdays(double numOfPeople, double numNot)
	{
		double year = 365;
		double numNotBir = year-(numOfPeople-1);
		double result;
		if(numOfPeople==1)
		{
			return 1;
		}
		else
		{
			result = (numNotBir/year) * probOfBirthdays(numOfPeople-1,numNotBir+1);
			return result;
		}
	}
}
