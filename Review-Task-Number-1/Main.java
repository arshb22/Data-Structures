import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.BigInteger;

class Main 
{
  public static void main(String[] args) 
  {
    BufferedReader br = null;
    String line;

    try
    {
        br = new BufferedReader(new FileReader("input.txt"));

        while((line = br.readLine()) != null)
        {
          BigInteger e = getLucasNumber(Integer.parseInt(line));
          System.out.println(e);
        }

    } catch(IOException e)
    {
      e.printStackTrace();
    }

  }

  public static BigInteger getLucasNumber(int a)
  {
    BigInteger first = BigInteger.valueOf(2);
    BigInteger second = BigInteger.valueOf(1);
    BigInteger third = null;
    int i = 0;
    if(a==0)
      return first;
    for(i=2;i<=a;i++)
    {
      third = first.add(second);
      first = second;
      second = third;
    }
    return second;
  }
}