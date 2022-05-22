import java.util.*;
import java.io.*;
public class StackAssignmentPart3
{
	public static void main(String[]args)
	{
		Municipalities example1 = new Municipalities("NJMunicipalities.csv");
	}
}

class Municipalities
{

	private ArrayList<Stack<Municipality>> listOfStackOfMunicipalities;

	public Municipalities(String file)
	{
		boolean landfill = false;

		listOfStackOfMunicipalities = new ArrayList<Stack<Municipality>>();
		for (int i=0; i<21; i++)
			listOfStackOfMunicipalities.add(new Stack<Municipality>());

		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));
			String text;

			while((text = input.readLine())!= null)
			{
				String a[] = text.split(",");

				if (a[1].equals("Burlington"))
					listOfStackOfMunicipalities.get(0).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Cumberland"))
					listOfStackOfMunicipalities.get(1).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Somerset"))
					listOfStackOfMunicipalities.get(2).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Essex"))
					listOfStackOfMunicipalities.get(3).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Camden"))
					listOfStackOfMunicipalities.get(4).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Monmouth"))
					listOfStackOfMunicipalities.get(5).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Morris"))
					listOfStackOfMunicipalities.get(6).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Middlesex"))
					listOfStackOfMunicipalities.get(7).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Bergen"))
					listOfStackOfMunicipalities.get(8).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Hunterdon"))
					listOfStackOfMunicipalities.get(9).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Ocean"))
					listOfStackOfMunicipalities.get(10).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Salem"))
					listOfStackOfMunicipalities.get(11).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Atlantic"))
					listOfStackOfMunicipalities.get(12).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Cape May"))
					listOfStackOfMunicipalities.get(13).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Union"))
					listOfStackOfMunicipalities.get(14).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Gloucester"))
					listOfStackOfMunicipalities.get(15).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Warren"))
					listOfStackOfMunicipalities.get(16).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Sussex"))
					listOfStackOfMunicipalities.get(17).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Mercer"))
					listOfStackOfMunicipalities.get(18).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Passaic"))
					listOfStackOfMunicipalities.get(19).push(new Municipality(a[0], a[1], a[2]));

				else if (a[1].equals("Hudson"))
					listOfStackOfMunicipalities.get(20).push(new Municipality(a[0], a[1], a[2]));
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}

		for (int i = 0; i<listOfStackOfMunicipalities.size() && !landfill; i++)
		{
			int randomType = (int)(Math.random()*((20-0)+1));
			System.out.println("Chosen: " + listOfStackOfMunicipalities.get(randomType).peek().getCounty() + " County \n");

			while (!(listOfStackOfMunicipalities.get(randomType).isEmpty()) && !landfill)
			{
				Municipality mC = listOfStackOfMunicipalities.get(randomType).pop();
				System.out.print(mC.getType() + " of: " + mC.getName() + " rolled by the die: ");

				int decision = (int)(Math.random()*((6-1)+1))+1;
				if (decision == 1)
				{
					System.out.println(decision + ". They have recieved the landfill! \n");
					landfill = true;
				}
				else
				{
					System.out.println(decision + ". No landfill recieved! \n");
				}
			}
			System.out.println();
		}

		if (!landfill)
			System.out.println("Garbage was given to Pennsylvania");
	}
}