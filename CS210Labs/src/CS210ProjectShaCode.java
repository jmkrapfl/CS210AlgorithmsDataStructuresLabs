import java.security.MessageDigest;
import java.util.Scanner;
public class CS210ProjectShaCode 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		System.out.println(str);
		System.out.println(sha256(str));
	}
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
