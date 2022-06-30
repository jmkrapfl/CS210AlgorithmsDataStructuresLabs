import java.util.Scanner;
public class CS210Lab10InLab2 
{
	//array we sort
    public static String[] myarray;
    //length of array
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
        
        mergeSort(myarray);//call the sort method that splits up the array recursively until there is only 1 digit in each array
        //mergeSort also calls sort that sorts out the order of the words/ints
        
        for(int i = 0;i<myarray.length;i++)//print out the words
        {
            System.out.println(myarray[i]);
        }
    }
    
    //splits/sorts the array
    public static void mergeSort(String[] strarr)//Splits up the array recursively until there is just one digit in each array
    {
        int len = strarr.length;
        
        if(len <2)
        {
            return;
        }
        else
        {
            int midIndex = len/2;
            //sting arrays
            String[] leftstr = new String[midIndex];
            String[] rightstr = new String[len-midIndex];
            
            //fill left arrays
            for(int i = 0;i< midIndex; i++)
            {
                leftstr[i] = strarr[i];
            } 
            //fill right arrays
            for(int i = midIndex;i< len; i++)
            {
                rightstr[i-midIndex] = strarr[i];
            }
            mergeSort(leftstr);//keeps splitting up the left side
            mergeSort(rightstr);//keeps splitting the right
            
            merge(strarr, leftstr, rightstr);//calls merge that sorts out the words/ints
        }
    }
    public static void merge(String[] strarr, String[] leftstr, String[] rightstr)
    {
        int leftLen = leftstr.length;
        int rightLen = rightstr.length;
        
        int itLeft=0, itRight=0, itMerge=0;
        
        while(itLeft< leftLen && itRight<rightLen)//while the left index is less than the left length and the same for the right
        {
            if(findVal(leftstr[itLeft]) == findVal(rightstr[itRight]))//if the ascii code is the same
            {
                int indexOfDiff = samechar(0,leftstr[itLeft],rightstr[itRight]);
                if((int)leftstr[itLeft].charAt(indexOfDiff)> (int)rightstr[itRight].charAt(indexOfDiff))//compare the first char of the word 
                {//if the left is greater have the left word be the next word
                    strarr[itMerge] = leftstr[itLeft];
                    itLeft++;
                }
                else
                {
                    strarr[itMerge] = rightstr[itRight];
                    itRight++;
                }
            }
            else if(findVal(leftstr[itLeft])< findVal(rightstr[itRight]))//if the left is less than the right the left is the next word
            {
                strarr[itMerge] = leftstr[itLeft];
                itLeft++;
            }
            else//else the right side is the next word
            {
                strarr[itMerge] = rightstr[itRight];
                itRight++;            
            }
            itMerge++;
        }
        while(itLeft<leftLen)//cleans up any extra words left over on the left side
        {
            strarr[itMerge] = leftstr[itLeft];
            itLeft++;
            itMerge++;
        }
        while(itRight<rightLen)//cleans up any extra words left over on the right side
        {
            strarr[itMerge] = rightstr[itRight];
            itRight++;
            itMerge++;
        }
    }
    
    //Create the num array corresponding to the string array
    public static int findVal(String word)
    {
        int val = 0;
        
        for(int i = 0; i<word.length();i++)
        {
            val = val+ (int)word.charAt(i);
        }
        return val;
    }
    
    
    //method for checking chars
    public static int samechar(int index, String str1, String str2)
    {
        if((int)str1.charAt(index) == (int) str2.charAt(index))
        {
           index++;
           return samechar(index, str1, str2);
        }
        else
        {
            return index;
        }
    }
    
    
    
    
    
    public void recMergeSort(String[] workSpace,int upperbound,int lowerbound)
    {
        if(lowerbound==upperbound)
        {
            return;
        }
        else
        {
            int mid = (lowerbound+upperbound)/2;//midpoint
            
            recMergeSort(workSpace, lowerbound, mid);//sort left
            recMergeSort(workSpace, mid+1, upperbound);//sort right
            
        }
    }
    
}
