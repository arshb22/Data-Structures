import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.BigInteger;
import java.util.ArrayList;

class Main 
{
  public static void main(String[] args) 
  {
    BufferedReader br = null;
    String line;

    ArrayList<acceleration> a = new ArrayList<acceleration>();
    ArrayList<cylinders> b = new ArrayList<cylinders>();
    ArrayList<displacement> c = new ArrayList<displacement>();
    ArrayList<horsepower> d = new ArrayList<horsepower>();
    ArrayList<mpg> e = new ArrayList<mpg>();
    ArrayList<weight> f = new ArrayList<weight>();
    ArrayList<year> g = new ArrayList<year>();

    try
    {
        br = new BufferedReader(new FileReader("input.txt"));

        while((line = br.readLine()) != null)
        {
          /*
          ArrayList<String> data2 = new ArrayList<String>();
          String[] data = line.split("_");
          for(String s : data)
          {
            data2.add(s);
          }
          System.out.println(data[1]);
          a.add(new acceleration(Double.parseDouble(data2.get(1)),data2.get(0)));
          b.add(new cylinders(Double.parseDouble(data2.get(2)),data2.get(0)));
          c.add(new displacement(Double.parseDouble(data2.get(3)),data2.get(0)));
          d.add(new horsepower(Double.parseDouble(data2.get(4)),data2.get(0)));
          e.add(new mpg(Double.parseDouble(data2.get(5)),data2.get(0)));
          f.add(new weight(Double.parseDouble(data2.get(6)),data2.get(0)));
          g.add(new year(Double.parseDouble(data2.get(7)),data2.get(0)));
          */
        }
    } catch(IOException y)
    {
      y.printStackTrace();
    }

    /*
    Collections.sort(a);
    Collections.sort(b);
    Collections.sort(c);
    Collections.sort(d);
    Collections.sort(e);
    Collections.sort(f);
    Collections.sort(g);
    System.out.println("Highest Acceleration");
    for(acceleration ah: a)
    {
      System.out.println(ah);
    }
    System.out.println("Highest Cylinders");
    for(cylinders bh: b)
    {
      System.out.println(bh);
    }
    System.out.println("Highest Displacement");
    for(displacement ch: c)
    {
      System.out.println(ch);
    }
    System.out.println("Highest Horsepower");
    for(horsepower dh: d)
    {
      System.out.println(dh);
    }
    System.out.println("Highest MPG");
    for(mpg eh: e)
    {
      System.out.println(eh);
    }
    System.out.println("Highest Weight");
    for(weight fh: f)
    {
      System.out.println(fh);
    }
    System.out.println("Highest Year");
    for(year gh: g)
    {
      System.out.println(gh);
    }

    Collections.sort(a, Collections.reverseOrder());
    Collections.sort(b, Collections.reverseOrder());
    Collections.sort(c, Collections.reverseOrder());
    Collections.sort(d, Collections.reverseOrder());
    Collections.sort(e, Collections.reverseOrder());
    Collections.sort(f, Collections.reverseOrder());
    Collections.sort(g, Collections.reverseOrder());
    System.out.println("Lowest acceleration");
    for(acceleration ah: a)
    {
      System.out.println(ah);
    }
    System.out.println("Lowest cylinders");
    for(cylinders bh: b)
    {
      System.out.println(bh);
    }
    System.out.println("Lowest displacement");
    for(displacement ch: c)
    {
      System.out.println(ch);
    }
    System.out.println("Lowest horsepower");    
    for(horsepower dh: d)
    {
      System.out.println(dh);
    }
    System.out.println("Lowest MPG");
    for(mpg eh: e)
    {
      System.out.println(eh);
    }
    System.out.println("Lowest Weight");
    for(weight fh: f)
    {
      System.out.println(fh);
    }
    System.out.println("Lowest Year");
    for(year gh: g)
    {
      System.out.println(gh);
    }
    */
  }
}