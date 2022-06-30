//Idea: I decided to solve this by creating a multidimensional int array that keeps track of what strings i am comparing and their similar score
//example say i am comparing 4 strings the int array would look like this:{1,2,score},{1,3,score},{1,4,score},{2,3,score},{2,4,score},{3,4,score}
//the ints in the first column are the index+1 of the first string in strArr and the second column of ints is the index+1 of the second string in strArr
import java.security.MessageDigest;
import java.util.Scanner;
public class CS210Lab11 
{
	//Global variables
	public static String[] strArr;
	public static int[][] intArr;
	
	//********Main***********
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		strArr = new String[num];
		
		//fill strArr
		for(int i = 0;i<=num-1;i++)
		{
			strArr[i] = sc.nextLine();
		}
		
		combos();//finds how many combinations there are and fills the intArr with the combinations of the strArr indexes and finds the score
		
		//***print out intArr for testing***
		//for(int i=0;i<intArr.length;i++)
		//{
			//for(int j=0; j< 3;j++)
			//{
				//System.out.print(intArr[i][j]);
			//}
			//System.out.println();
		//}
		
		//***print strArr for testing***
		//for(int i=0; i<strArr.length;i++)
		//{
			//System.out.println(strArr[i]);
		//}
		System.out.println(strArr[findL(intArr)]);//findL finds the largest similar score
	}
	
	//*******get hash********
	public static String getHash(String input)
	{
		try
		{
			MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
			byte[] salt= "CS210+".getBytes("UTF-8");
			mDigest.update(salt);
			byte[] data = mDigest.digest(input.getBytes("UTF-8"));
			StringBuffer sb =  new StringBuffer();
			for(int i  = 0; i<data.length;i++)
			{
				sb.append(Integer.toString((data[i]&0xff)+0x100,16).substring(1));
			}
			return sb.toString();
		}
		catch(Exception e)
		{
			return(e.toString());
		}
	}
	
	//********Hash code Compare*******
	public static int compare(String str1,String str2)//this compares the hashes of the strings and returns a score of how similar they are
	{
		int score = 0;
		String hash1 = getHash(str1);
		String hash2 = getHash(str2);
		for(int i = 0;i<64;i++)
		{
			if(hash1.charAt(i) == hash2.charAt(i))
			{
				score++;
			}
		}
		return score;
	}
	public static int compare(String str1,String str2,int i,int score)//this compares the hashes of the strings and returns a score of how similar they are
	{
		//int score = 0;
		//String hash1 = getHash(str1);
		//String hash2 = getHash(str2);
		
			if(str1.charAt(i) == str2.charAt(i))
			{
				return compare(str1, str2, i+1, score+1);
			}
			else if(str1.charAt(i) != str2.charAt(i))
	        {
	            return compare(str1, str2, i+1, score);
	        }

		return score;
	}
	
	
	//********Find possible combos********
	public static void combos()// fills intArr with all possible combinations of strArr and fills the score in
	{
		int len = strArr.length;
		int lenFactor = factorial(len);
		int rowLen = (lenFactor)/(2*factorial(len-2));
		
		intArr = new int[rowLen][3];
		
		//fill the possible combos into intArr and their scores in the last column
		int incr1 = 1;
		int incr2 = 2;
		for(int i = 0;i<rowLen;i++)
		{
			intArr[i][0] = incr1;
			for(int j = 0;j<3;j++)
			{
				intArr[i][1] = incr2; 
				intArr[i][2] = compare(strArr[incr1-1], strArr[incr2-1]);
			}
			if(incr2==len)
			{
				incr1++;
				incr2 = incr1+1;
			}
			else
			{
				incr2++;
			}
		}
	}
	//*****factorial******
	public static int factorial(int num)//finds the factorial needed to find how many different combinations
	{
		if(num<=2)
		{
			return num;
		}
		else
		{
			return num*factorial(num-1);
		}
	}
	
	//finds largest similar score by looking at the last column of the intArr
	public static int findL(int[][] arr)
	{
		int L = 0;
		int indexOfL=0;
		for(int i = 0;i < arr.length;i++)
		{
			if(arr[i][2]>L)
			{
				L=arr[i][2];
				indexOfL = i;
			}
		}
		return indexOfL;
	}
}