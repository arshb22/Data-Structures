import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import java.math.BigInteger;
import java.lang.reflect.Array;

class Main 
{
  public static void main(String[] args) 
  {
    BufferedReader br = null;
    String line;
    ArrayList<String> ok3 = new ArrayList<String>();

    try
    {
        br = new BufferedReader(new FileReader("input.txt"));

        while((line = br.readLine()) != null)
        {
          ok3.add(line);
        }

    } catch(IOException e)
    {
      e.printStackTrace();
    }

    int counter = 1;
    for(int i = 0; i<ok3.size(); i+=3)
    {
      ArrayList<Integer> sets = new ArrayList<Integer>();
      String[] first = ok3.get(i).split(" ");
      String[] second = ok3.get(i+1).split(" ");
      String[] third = ok3.get(i+2).split(" ");

      for(int a = 0; a<first.length;a++)
      {
        for(int b = 0; b<second.length; b++)
        {
            if(first[a].equals(second[b]))
            {
              for(int c = 0; c<third.length;c++)
              {
                if(second[b].equals(third[c]))
                {
                  sets.add(Integer.valueOf(first[a]));
                }
              }
            }
        }
      }
    
      System.out.print("Set " + counter + " intersection = ");
      for(int a : sets)
      {
        System.out.print(a + "   ");
      }
      System.out.println();
      counter++;
    }      
  }
}