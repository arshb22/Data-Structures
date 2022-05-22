import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.reflect.Array;

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
          String[] sections = line.split(" "); 
          boolean b = areAmicable(sections);
          if(b == true)
          {
          System.out.println("The numbers " + sections[0] + " and " + sections[1] + " are amicable");
          System.out.print("Factors of " + sections[0] + " are ");
          int a = Integer.parseInt(sections[0]);
          int sum = 0;
          for(int i = 1;i<a;i++)
          {
            if(a%i == 0)
            {
              System.out.print(i + ", ");
              sum+=i;
            }
          }
          System.out.print("Sum is " + sum + "\n");
          System.out.print("Factors of " + sections[1] + " are ");
          int k = Integer.parseInt(sections[1]);
          int sum1 = 0;
          for(int i = 1;i<k;i++)
          {
            if(k%i == 0)
            {
              System.out.print(i + ", ");
              sum1+=i;
            }
          }
          System.out.print("Sum is " + sum1 + "\n");
          }
          else
          {
            System.out.println("The numbers " + sections[0] + " and " + sections[1] + " are not amicable");

          System.out.print("Factors of " + sections[0] + " are ");
          int e = Integer.parseInt(sections[0]);
          int sum3 = 0;
          for(int i = 1;i<e;i++)
          {
            if(e%i == 0)
            {
              System.out.print(i + ", ");
              sum3+=i;
            }
          }
          System.out.print("Sum is " + sum3 + "\n");
          System.out.print("Factors of " + sections[1] + " are ");
          int z = Integer.parseInt(sections[1]);
          int sum4 = 0;
          for(int i = 1;i<z;i++)
          {
            if(z%i == 0)
            {
              System.out.print(i + ", ");
              sum4+=i;
            }
          }
          System.out.print("Sum is " + sum4 + "\n");            
          }
            
        }

    } catch(IOException e)
    {
      e.printStackTrace();
    }

  }

  public static boolean areAmicable(String[] a)
  {
    
    int first = Integer.parseInt(a[0]);
    int second = Integer.parseInt(a[1]);
    int sumOfFirst = 0;
    int sumOfSecond = 0;
    
    for(int i = 1;i<first;i++)
    {
      if(first%i == 0)
        sumOfFirst+=i;
    }
  
    for(int i = 1;i<second;i++)
    {
      if(second%i==0)
        sumOfSecond+=i;
    }
    if(sumOfFirst == second && sumOfSecond == first)
      return true;
    return false;

  }
}