import java.util.Scanner;
public class CS210Lab10 
{
	//arrays we sort
	public static String[] myarray;
	public static int[] myIntArr;
	//length of the array
	public static int num;
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		num = Integer.parseInt(sc.nextLine());
		myarray = new String[num];
		
		for(int i = 0;i<num;i++)//scan in the words
		{
			myarray[i] = sc.nextLine();
		}
		sc.close();
		
		findVal(myarray);//create int array corresponding to the string array
		
		mergeSort(myIntArr, myarray);//call the sort method that splits up the array recursively until there is only 1 digit in each array
		//mergeSort also calls sort that sorts out the order of the words/ints
		
		for(int i = 0;i<myarray.length;i++)//print out the words
		{
			System.out.println(myarray[i]);
		}
	}
	
	//splits/sorts the array
	public static void mergeSort(int[] intarr, String[] strarr)//Splits up the array recursively until there is just one digit in each array
	{
		int len = intarr.length;
		
		if(len <2)
		{
			return;
		}
		else
		{
			int midIndex = len/2;
			//int arrays
			int[] leftnum = new int[midIndex];
			int[] rightnum = new int[len-midIndex];
			//sting arrays
			String[] leftstr = new String[midIndex];
			String[] rightstr = new String[len-midIndex];
			
			//fill left arrays
			for(int i = 0;i< midIndex; i++)
			{
				leftnum[i] = intarr[i];
				leftstr[i] = strarr[i];
			} 
			//fill right arrays
			for(int i = midIndex;i< len; i++)
			{
				rightnum[i-midIndex] = intarr[i];
				rightstr[i-midIndex] = strarr[i];
			}
			mergeSort(leftnum,leftstr);//keeps splitting up the left side
			mergeSort(rightnum,rightstr);//keeps splitting up the right side
			
			merge(intarr, leftnum, rightnum, strarr, leftstr, rightstr);//calls merge that sorts out the words/ints
		}
	}
	public static void merge(int[] intarr, int[] leftnum, int[] rightnum, String[] strarr, String[] leftstr, String[] rightstr)
	{
		int leftLen = leftnum.length;
		int rightLen = rightnum.length;
		
		int itLeft=0, itRight=0, itMerge=0;
		
		while(itLeft< leftLen && itRight<rightLen)//while the left index is less than the left length and the same for the right
		{
			if(leftnum[itLeft] == rightnum[itRight])//if the ascii code is the same
			{
				if((int)leftstr[itLeft].charAt(0)> (int)rightstr[itRight].charAt(0))//compare the first char of the word 
				{//if the left is greater have the left word be the next word
					intarr[itMerge] = leftnum[itLeft];
					strarr[itMerge] = leftstr[itLeft];
					itLeft++;
				}
				else//else have the right word be the next word
				{
					intarr[itMerge] = rightnum[itRight];
					strarr[itMerge] = rightstr[itRight];
					itRight++;
				}
			}
			else if(leftnum[itLeft] < rightnum[itRight])//if the left is less than the right the left is the next word
			{
				intarr[itMerge] = leftnum[itLeft];
				strarr[itMerge] = leftstr[itLeft];
				itLeft++;
			}
			else//else the right side is the next word
			{
				intarr[itMerge] = rightnum[itRight];
				strarr[itMerge] = rightstr[itRight];
				itRight++;			
			}
			itMerge++;
		}
		while(itLeft<leftLen)//cleans up any extra words left over on the left side
		{
			intarr[itMerge] = leftnum[itLeft];
			strarr[itMerge] = leftstr[itLeft];
			itLeft++;
			itMerge++;
		}
		while(itRight<rightLen)//cleans up any extra words left over on the right side
		{
			intarr[itMerge] = rightnum[itRight];
			strarr[itMerge] = rightstr[itRight];
			itRight++;
			itMerge++;
		}
	}
	
	//Create the num array corresponding to the string array
	public static void findVal(String[] list)
	{
		myIntArr = new int[num];
		int val = 0;
		for(int i=0; i<num;i++)
		{
			for(int j = 0; j<list[i].length();j++)
			{
				val = val + (int)list[i].charAt(j);
			}
			myIntArr[i] = val;
			val = 0;
		}
	}
}