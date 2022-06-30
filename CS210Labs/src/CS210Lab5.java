import java.util.Scanner;
public class CS210Lab5 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();//get the length of array
		String[] array = new String[len];
		int[] numArr = new int[len];
		int score;
		char checking;
		String charecter;
		
		//*********set up arrays*******
		for(int i = 0; i < array.length; i++)
		{
			score=0;
			array[i]=sc.next();//get the word into the array
			for(int j=0;j<array[i].length();j++)//run through the word to get the score
			{
				checking = array[i].charAt(j);//get the char
				charecter = String.valueOf(checking);//convert it to a string to check regex
				
				//checks the char to get the score
				if(charecter.matches("(?i)(a|e|i|o|u|l|n|s|t|r)"))
				{
					score++;
				}
				else if(charecter.matches("(?i)(d|g)"))
				{
					score =score+2;
				}
				else if(charecter.matches("(?i)(b|c|m|p)"))
				{
					score=score+3;
				}
				else if(charecter.matches("(?i)(f|h|v|w|y)"))
				{
					score=score+4;
				}
				else if(charecter.matches("(?i)(k)"))
				{
					score=score+5;
				}
				else if(charecter.matches("(?i)(j|x)"))
				{
					score=score+8;
				}
				else if(charecter.matches("(?i)(q|z)"))
				{
					score=score+10;
				}
				numArr[i]=score;
			}
		}
		
		//*********sorting the array*****
		//what you do to the numArr you do to the string array
		int temp = 0;
		String tempStr;
		
		for(int pass = 0; pass < array.length; pass++)
		{	
			for(int i = 0; i < array.length-1; i++)
			{
				if(numArr[i] > numArr[i+1])
				{
					//store and switch the int
					temp = numArr[i];
					numArr[i] = numArr[i+1];
					numArr[i+1] = temp;
					//store and switch the string
					tempStr = array[i];
					array[i] = array[i+1];
					array[i+1] = tempStr;
				}
			}
		}
		
		//******for testing purposes*******
		for(int i = 0; i<array.length;i++)
		{
			System.out.println(array[i]);
			System.out.println(numArr[i]);
		}
	}
}
