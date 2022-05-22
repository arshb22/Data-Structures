import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.stream.*;
import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    //For last part; put stuff into arrays of those types and then you don't need 4 types of array; only one which you can find first and last 5

    ArrayList<Happiness> hp = new ArrayList<Happiness>();
    ArrayList<MedianIncome> mi = new ArrayList<MedianIncome>();

    
    //Trying to find correlation between medianIncome [x] and happiness [y]
    
    //Put them into maps since they're already ordered
    //Perform some data calculation to prove something
    //Lookup tool; enter name to find median income and happiness
    //Lookup tool; find top 5 or bottom 5 in any statistic

    //x is medianIncome and y is happiness
    List<Double> x = new ArrayList<Double>();
    List<Double> y = new ArrayList<Double>();
    
    //Putting in data from the happiness csv
    Map<String, String> happyData = new TreeMap<String, String>();
    try
    {
      BufferedReader input = new BufferedReader(new FileReader("Happiness.csv"));
      //input.readLine();
      String text;

      while((text = input.readLine()) != null)
      {
      String[] data = text.split(",");
      happyData.put(data[0],data[1]);
      hp.add(new Happiness(data[0], Double.parseDouble(data[1])));
      }
    }
    catch(Exception E)
    {
      System.out.println("File not found");
    }

    //Putting in data from the medianincome csv
    Map<String, String> medianincomeData = new TreeMap<String, String>();
    try
    {
      BufferedReader input = new BufferedReader(new FileReader("MedianIncome.csv"));
      //input.readLine();
      String text;

      while((text = input.readLine()) != null)
      {
      String[] data = text.split(",");
      medianincomeData.put(data[0],data[1]);
      mi.add(new MedianIncome(data[0], Double.parseDouble(data[1])));
      }
    }
    catch(Exception E)
    {
      System.out.println("File not found");
    }

    //Use these to see how they end up ordered
    //System.out.println(happyData);
    //System.out.println(medianincomeData);

    
    //Printing out both [also to see if there are any mismatches]
    for(Map.Entry<String,String> entry: happyData.entrySet())
    {
    System.out.println("Country Name: " + entry.getKey() + " Happiness: " + entry.getValue() + " Median Income: " + medianincomeData.get(entry.getKey()));

    //adding the values into the arraylist
    x.add(Double.parseDouble(medianincomeData.get(entry.getKey())));
    y.add(Double.parseDouble(entry.getValue()));
    }

    //creating new double arrays
    Double[] x1 = new Double[x.size()];
    Double[] y1 = new Double[y.size()];

    x1 = x.toArray(x1);
    y1 = y.toArray(y1);

    //Had to convert object Double[] to primitive type double[]
    double[] x2 = Stream.of(x1).mapToDouble(Double::doubleValue).toArray();
    double[] y2 = Stream.of(y1).mapToDouble(Double::doubleValue).toArray();

    correlationCoefficient oneDataAnalysis = new correlationCoefficient(x2,y2, x.size());

    double r = oneDataAnalysis.correlation();

    System.out.println(""); 
    
    System.out.println("R is: " + r);

    System.out.println("");
    
    //The 'data analysis' part
    if(r > 0.0)
    {
      System.out.println("R indicates a positive correlation. A positive correlation is a relationship between two variables in which both variables move in the same direction. Essentially, when happiness increases as the median income increases, or when happiness decreases while median income decreases.");
    }
    if(r < 0.0)
    {
      System.out.println("R indicates a negative correlation. A negative correlation is a relationship between two variables in which an increase in one variable is associated with a decrease in the other. Essentially, when happiness increases as the median income decreases, or when happiness decreases while median income increases.");
    }
    if(r == 0.0)
    {
      System.out.println("R indicates zero correlation. A zero correlation exists when there is no relationship between two variables. Essentially, when happiness increases is not associated with a median income increase or decrease, and vice versa.");
    }

    System.out.println("");

    //Sort data for 'Tool 2'
    Collections.sort(hp);
    Collections.sort(mi);

    /*
    boolean askOn = true;

    while(askOn)
    {
    */
    
    boolean askOn = true;

    String choice = "";

    //Tool Stuff
    while(askOn)
    {
      Scanner myObj = new Scanner(System.in);
      System.out.println("Type in 'Tool 1' if you want to find the data on median income and happiness for a specific country or 'Tool 2' if you want to find the top 5 or bottom 5 in median income or happiness. If you don't want ot use this tool, type in 'No': ");
      choice = myObj.nextLine();

    //First Tool
    if(choice.equalsIgnoreCase("Tool 1"))
    {
      Scanner m1 = new Scanner(System.in);
      System.out.println("Enter Country: ");
      String country = m1.nextLine();

      System.out.println("Country: " + country);
      System.out.println("Happiness Level: " + happyData.get(country));
      System.out.println("Median Income: " + medianincomeData.get(country));     
    }

    //Second Tool
    if(choice.equalsIgnoreCase("Tool 2"))
    {
        //Asking if they want top 5 or bottom 5
        Scanner m2 = new Scanner(System.in);
        System.out.println("Enter TOP or BOTTOM: ");
        String upDown = m2.nextLine();

        if(upDown.equalsIgnoreCase("TOP"))
        {
          //then asks of what
          //then it returns in
          Scanner m3 = new Scanner(System.in);
          System.out.println("What Data Set. Type 'Happiness' or 'Median Income': ");
          String whatDataSet = m3.nextLine();
          if(whatDataSet.equalsIgnoreCase("Happiness"))
          {
              for(int i = 135; i>130; i--)
              {
                System.out.println(hp.get(i));
              }
          }
          if(whatDataSet.equalsIgnoreCase("Median Income"))
          {
              for(int i = 135; i>130; i--)
              {
                System.out.println(mi.get(i));
              }
          }
        }

        if(upDown.equalsIgnoreCase("BOTTOM"))
        {
          //then asks of what
          //then it returns in
          Scanner m4 = new Scanner(System.in);
          System.out.println("What Data Set. Type 'Happiness' or 'Median Income': ");
          String whatDataSet = m4.nextLine();
          if(whatDataSet.equalsIgnoreCase("Happiness"))
          {
              for(int i = 0; i<5; i++)
              {
                System.out.println(hp.get(i));
              }
          }
          if(whatDataSet.equalsIgnoreCase("Median Income"))
          {
              for(int i = 0; i<5; i++)
              {
                System.out.println(mi.get(i));
              }
          }
        }
    }

    //Stops everything
    if(choice.equalsIgnoreCase("No"))
    {
      System.out.println("Thank you for using these tools!");
      askOn = false;
    }
  }
  }
}