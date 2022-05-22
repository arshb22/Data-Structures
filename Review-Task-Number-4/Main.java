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
    ArrayList<State> ok = new ArrayList<State>();

    try
    {
        br = new BufferedReader(new FileReader("input.txt"));

        while((line = br.readLine()) != null)
        {
          String[] info = line.split("__");
          int x = Integer.parseInt(info[2]);
          int y = Integer.parseInt(info[3]);
          int total = x+y;
          String temp = info[1].replaceAll(",","");
          int finalNumber = Integer.parseInt(temp);
          ok.add(new State(info[0], finalNumber, x));
        }

    } catch(IOException e)
    {
      e.printStackTrace();
    }

    //ArrayList<repCong> ok2 = new ArrayList<repCong>();
    int max = 0;
    String maxState = "";
    int min = 1000000;
    String minState = "";
    for(State x: ok)
    {
          System.out.println(x.getState() + " -> " + (x.getPopulation()/x.getNumAppRep()));
          if((x.getPopulation()/x.getNumAppRep())>max)
          {
            max = (x.getPopulation()/x.getNumAppRep());
            maxState = x.getState();
          }
          if((x.getPopulation()/x.getNumAppRep())<min)
          {
            min = (x.getPopulation()/x.getNumAppRep());
            minState = x.getState();
          }
          //ok2.add(new repCong(x.getState(),(x.getPopulation()/x.getNumAppRep())));
    }

    System.out.println("A congressman from " + maxState + " represents " + max + " people, while a congressman from " + minState + " only represents " + min + " people!");

  }
}