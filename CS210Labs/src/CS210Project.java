/*
 * CS210 Project
 * this program reads through a text file, creates an array out of the text file and then compares 2 sentences hash codes
 * to find this highest hash score
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;

public class CS210Project
{
	//global
	public static String[] strArr = load("/Users/jessicakrapfl/Desktop/projectWords.txt");
	
	public static void main(String args[])
	{
		int score = 0;
		int current=0;
		String str1,str2;
		for(int i = 0;i<strArr.length;i++)
		{
			for(int j = i+1; j< strArr.length;j++)
			{
				str1 = sha256(strArr[i]);
				str2 = sha256(strArr[j]);
				current = compare(str1,str2,0,0);
				if(current > score)
				{
					score = current;
					//print statement here because i was curious what the 2 most similar sentences are
					System.out.println(strArr[i]+ " "+ strArr[j]); 
					System.out.println(current);
				}
				if(current==score)
				{
					System.out.println(strArr[i]+ " "+ strArr[j]);
					System.out.println(current);
				}
				//helps find out if i have any of the same sentences in the file
				//if(current ==64)
				//{
					//System.out.println(strArr[i]+ " "+i+ " " +strArr[j]+" "+j);
				//}
				//System.out.println(count + " "+ current);
			}
			
		}
		System.out.println(score);
		//System.out.println(strArr.length);
	}
	
	public static int compare(String str1,String str2,int i,int score)//comparing the hash codes using recursion
	{
		if(str1.charAt(i) == str2.charAt(i))
		{
			if(i==63)//so it doesn't run out of bounds
			{
				return score+1;
			}
			else
			{
				return compare(str1, str2, i+1, score+1);
			}
		}
		else if(str1.charAt(i) != str2.charAt(i))
        {
			if(i==63)//so it doesn't run out of bounds
			{
				return score;
			}
			else
			{
				return compare(str1, str2, i+1, score);
			}
        }

		return score;
	}
	
	//**********LOAD**********************
	public static String[] load(String file) 
    {
        File aFile = new File(file);     
        StringBuffer contents = new StringBuffer();
        BufferedReader input = null;
        try 
        {
            input = new BufferedReader( new FileReader(aFile) );
            String line = null; 
            int i = 0;
            while (( line = input.readLine()) != null)
            {
                contents.append(line);
                i++;
                contents.append(System.getProperty("line.separator"));
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Can't find the file - are you sure the file is in this location: "+file);
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            System.out.println("Input output exception while processing file");
            ex.printStackTrace();
        }
        finally
        {
            try {
                if (input!= null) 
                {
                    input.close();
                }
            }
            catch (IOException ex)
            {
                System.out.println("Input output exception while processing file");
                ex.printStackTrace();
            }
        }
        String[] array = contents.toString().split("\n");
        for(String s: array)
        {
            s.trim();
        }
        return array;
    }
	
	
	//************HASH*************
	public static String sha256(String input)
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
}