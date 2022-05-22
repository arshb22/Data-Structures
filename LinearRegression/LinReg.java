import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.stream.*;
import java.util.Scanner;

public class LinReg
{
	public static void main(String[]args)
	{
		Map<String, int[]> linReg = new HashMap<String, int[]>();
		List<Double> x = new ArrayList<Double>();
		List<Double> y = new ArrayList<Double>();

		//x is net points and y is wins

		try
		{
			BufferedReader input = new BufferedReader(new FileReader("TeamScores.csv"));
			input.readLine();
			String text;

			while(((text = input.readLine()) != null))
			{
				String[] data = text.split(",");
				linReg.put(data[0], new int[]{Integer.parseInt(data[1]), Integer.parseInt(data[2])});
				x.add(Double.parseDouble(data[1]));
				y.add(Double.parseDouble(data[2]));
			}

			for(Map.Entry<String,int[]> entry: linReg.entrySet())
			{
				System.out.println("Name: " + entry.getKey() +  " Wins: " + entry.getValue()[0] + " Net Points: " + entry.getValue()[1]);
			}
		}
		catch(Exception E)
		{
			System.out.println("File not found");
		}

		//Converts arraylist to Double[] array (Object)
		Double[] x1 = new Double[x.size()];
		Double[] y1 = new Double[y.size()];

		x1 = x.toArray(x1);
		y1 = y.toArray(y1);

		//Had to convert object Double[] to primitive type double[]
		double[] x2 = Stream.of(x1).mapToDouble(Double::doubleValue).toArray();
		double[] y2 = Stream.of(y1).mapToDouble(Double::doubleValue).toArray();

		LinearRegression equation = new LinearRegression(x2,y2);

		System.out.println(equation);

		//Lookup Tool
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter Team: ");
		String teamName = myObj.nextLine();
		//Actual Wins
		int[] actualWins = linReg.get(teamName);
		System.out.println(actualWins[0]);
		//Predicted Wins
		double netPoints = actualWins[0];
		double predictedWins = equation.predict(netPoints);
		System.out.println(predictedWins);
	}
}