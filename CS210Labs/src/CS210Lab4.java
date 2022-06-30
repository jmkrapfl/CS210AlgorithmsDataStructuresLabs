import java.util.Random;
import java.util.Scanner;
public class CS210Lab4 
{
	//********MAIN*********
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int classSize = sc.nextInt();
		int match = sc.nextInt();
		String[] arr = new String[classSize];
		
		int runtime = 100000;
		int numTrue = 0;
		double probability = 0.0;
		
		for(int i = 0; i<runtime; i++)
		{
			for(int j = 0; j<classSize; j++)//makes an array of birth dates = to the class size
			{
				arr[j]=randomBirthday();//calls the random birthday function to add a random birthday to the array
				//System.out.println(arr[j]);
				
			}
			if(checkForMatch(arr,match)==true)//every time checkForMatch returns true numTrue increases by 1
			{
				numTrue++;
			}
			//System.out.println(numTrue);
		}
		
		//need to make numTrue and runtime a double so i don't get 0 as an answer
		double numT = numTrue;
		double runT = runtime;
		//calculate and print probability
		probability = (numT /runT) * 100;
		System.out.println(probability);
	}
	//************CHECK FOR MATCH************
	public static boolean checkForMatch(String[] arr, int match)
	{
		int count = 0;
		for(int i = 0; i < arr.length; i++)//checks the birthday at arr[i] against the birthday at arr[j]
		{
			for(int j = 0; j < arr.length; j++)
			{
				if(arr[i].matches(arr[j]) && i != j)//if the birthday matches and its not matching with itself count increases by 1
				{
					count++;
				}
			}
		}
		if(count >= match)//if the count is greater than or equal to the number to match return true else return false
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//***********RANDOM BIRTHDAY***********
	public static String randomBirthday()
	{
		String randBDay = "";
		Random rand = new Random();
		int day = rand.nextInt(31-1)+1;
		int month = rand.nextInt(12-1)+1;
		int year = rand.nextInt(2021-1920)+1920;
		
		if(month==2 && day > 28)//February either ends in 28 or 29 depending if it is a leap year
		{
			if(day>=29 && (year%4==0 && year%100==0 && year%400==0))//if it is a leap year 
			{
				day=29;
			}
			else
			{
				day=28;
			}
		}
		else if((month==4||month==6||month==9||month==11) && day>30)//these months end in 30 instead of 31
		{
			
			day=30;
			
		}
		
		randBDay= day + "/" + month;
		
		
		return randBDay;
	}
}
