import java.io.*;
import java.lang.*;
import java.util.*;
public class FileTemplate
{
	public FileTemplate()
	{
		try
		{
			int x=10/0;
		}catch(ArithmeticException e)
		{
			System.out.println("problem but keep going");
		}



		File name = new File("FileName.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text,output="";
			while((text=input.readLine())!= null)
			{
				System.out.println(text);
				output+=text;
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
	public static void main(String[] args)
	{
		FileTemplate app=new FileTemplate();
	}
}