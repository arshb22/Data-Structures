import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

class Main 
{
  public static void main(String[] args) 
  {
    BufferedReader br = null;
    String line;
    ArrayList<String> firstStep = new ArrayList<String>();
    Queue<Passenger> q = new LinkedList<Passenger>(); 
    Queue<Passenger> q2 = new PriorityQueue<Passenger>(); 

    
    try
    {
        br = new BufferedReader(new FileReader("PassengerInfo.txt"));

        while((line = br.readLine()) != null)
        {
          firstStep.add(line);        
        }

    } catch(IOException e)
    {
      e.printStackTrace();
    }

    for(int i = 0; i<firstStep.size(); i+=3)
    {
      String[] nameDivide = firstStep.get(i).split(" ");
      Passenger p = new Passenger(nameDivide[0],nameDivide[1], firstStep.get(i+1), firstStep.get(i+2));
      q.add(p);
    }

    System.out.println("Queue:");
    int count = 1;
    while(!(q.isEmpty()))
    {
      
      String additions1 = q.peek().etdCalc();
      //System.out.println(additions1);
      String[] additions2 = additions1.split(" ");
      if(additions2[0].equalsIgnoreCase("0"))
      {
        q2.add(q.peek());
      }
      System.out.print(count + ". ");
      System.out.println(q.poll());
      count++;
    }

    
    System.out.println();
    System.out.println("Priority Queue");
    int count1 = 1;
    while(!(q2.isEmpty()))
    {
        System.out.print(count1 + ". ");
        System.out.println(q2.poll());
        count1++;
    }
  
  }
}