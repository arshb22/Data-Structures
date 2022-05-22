import java.io.*;
import java.util.*;
import java.lang.*;


public class Olympics
{
	private ArrayList<OlympicTeam> teams;

	public Olympics(String name)
	{
		teams = new ArrayList<OlympicTeam>();
		int sum = 0;
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text;
			input.readLine();
			while((text=input.readLine())!= null)
			{
				if(text.length() > 0)
				{
					String[] a = text.split(",");
					teams.add(new OlympicTeam (a[0],Integer.parseInt(a[1]),Integer.parseInt(a[2]),Integer.parseInt(a[3])) );
				}
			}
		}
		catch(IOException io)
		{
			System.err.println("File does not exist");
		}

		Collections.sort(teams, Collections.reverseOrder());
		System.out.println(teams);
	}

	public int bronzeMedalsObscure()
	{
		int sum = 0;
		for(OlympicTeam ot: teams)
		{
			if(ot.getNumBronze() > ot.getCountry().length())
			{
				sum += ot.getNumBronze();
			}
		}
		return sum;
	}

	public String toString()
	{
		String str = "";
		for(OlympicTeam ot: teams)
		{
			str += ot + "\n";
		}
		return str;
	}

	public static void main(String[]args)
	{
		Olympics tokyo2020 = new Olympics("olympic-medals.csv");
		System.out.println(tokyo2020);
		int x = tokyo2020.bronzeMedalsObscure();
		System.out.println("Bronze: " + x);
	}
}