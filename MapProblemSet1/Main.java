import java.util.*;
import java.io.*;  

class Main 
{
  public static void main(String[] args) 
  {
  System.out.println("Values including how any times they appeared:");
   System.out.println(Problem1("1.61803398874989484820458683436563811772030917980576286213544862270526046281890244970720720418939113748475408807538689175212663386222353693179318006076672635"));

    System.out.println("\nThe total number of combinations:");
    System.out.println(Problem1TotalNumberOfCombinations(Problem1("1.61803398874989484820458683436563811772030917980576286213544862270526046281890244970720720418939113748475408807538689175212663386222353693179318006076672635")));
    System.out.println("\nThe 2 digit combinations that occured more than 4 times:");
    System.out.println(Problem1MoreThan4(Problem1("1.61803398874989484820458683436563811772030917980576286213544862270526046281890244970720720418939113748475408807538689175212663386222353693179318006076672635")));

    System.out.println("\nBowler Data:");
    
    problem2();

  }

  public static Map<String,Integer> Problem1(String value)
  {
    Map<String,Integer> m = new HashMap<String,Integer>();
     
    String whatINeed = value.split("\\.")[1];

    //new StringBuilder().append(whatINeed.charAt(i)).append(whatINeed.charAt(i+1)).toString(); 
    //whatINeed.charAt(i) + whatINeed.charAt(i+1)
    
    for(int i = 0; i<whatINeed.length()-1;i++)
    {
      if(m.containsKey(new StringBuilder().append(whatINeed.charAt(i)).append(whatINeed.charAt(i+1)).toString()))
      {
        m.put(new StringBuilder().append(whatINeed.charAt(i)).append(whatINeed.charAt(i+1)).toString(), m.get(new StringBuilder().append(whatINeed.charAt(i)).append(whatINeed.charAt(i+1)).toString()) + 1);
      }
      else
      {
        m.put(new StringBuilder().append(whatINeed.charAt(i)).append(whatINeed.charAt(i+1)).toString(),1);
      }
    }
      
    return m;
  }

  public static int Problem1TotalNumberOfCombinations(Map<String, Integer> value)
  {
    int total = 0; 
    for(Map.Entry<String, Integer>entry: value.entrySet())  
    {   
      total++;
    }
    return total;  
  }

  public static Map<String,Integer> Problem1MoreThan4(Map<String, Integer> value)
  {
    Map<String,Integer> m = new HashMap<String,Integer>();
    
    for(Map.Entry<String, Integer>entry: value.entrySet())  
    {   
      if(entry.getValue()>4)
      {
        m.put(entry.getKey(),entry.getValue());
      }
    }
    return m;
  }

  public static void problem2()
	{

		Map<Integer, PriorityQueue<Bowler>> bowlers = new TreeMap<Integer, PriorityQueue<Bowler>>();

		try {
			BufferedReader input = new BufferedReader(new FileReader("BowlingData.txt"));
			String text;
			while ((text=input.readLine()) != null)
			{
				int score = Integer.parseInt(text.split(" ")[2]);
				Bowler b = new Bowler(text.split(" ")[0], text.split(" ")[1], score);
				if (bowlers.containsKey(score))
				{
					bowlers.get(score).add(b);
					bowlers.put(score, bowlers.get(score));
				}
				else {
					PriorityQueue<Bowler> pq = new PriorityQueue<Bowler>();
					pq.add(b);
					bowlers.put(score, pq);
				}
			}
		} catch (IOException io) {
			System.err.println("File does not exist");
		}
		for (Map.Entry<Integer, PriorityQueue<Bowler>> entry : bowlers.entrySet())
			System.out.println(entry.getKey() + "=" + entry.getValue());
	}
}