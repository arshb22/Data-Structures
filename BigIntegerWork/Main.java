import java.util.*;
import java.math.BigInteger;


class Main 
{
  public static void main(String[] args) 
  {
    //My factorial stuff works; now I need a while loop that constantly divides it each time
    //My prime shit works too
          
    //BigInteger when = factorial(17);
    //System.out.println(when);

    //Finds factorial
    //Gets a counter that goes through all numbers
    //Has a while loop to stop it when it reaches 0
    //Inside it checks if its prime and then it has a while loop that counts how many times it goes on till when you divide it it becomes something other than 0


    Map<BigInteger, Integer> map = new HashMap<BigInteger, Integer>();

    BigInteger when = factorial(12);

    BigInteger start = BigInteger.valueOf(1);

    while(!(when.equals(BigInteger.valueOf(0))))
    {
        boolean shouldIPutItIn = isPrime(start);
        if(shouldIPutItIn)
        {
          int howMany = 0;
          while((when.mod(start)).equals(BigInteger.valueOf(0)))
          {
            when = when.divide(start);
            howMany++;
          }
          while(!((when.mod(start)).equals(BigInteger.valueOf(0)))) 
          {
            map.put(start,howMany);
            break;
          }        
        }
        start.add(BigInteger.valueOf(1));
    }

    System.out.println(map);

    //System.out.println(isPrime(BigInteger.valueOf(10)));
          
    //System.out.println(BigInteger.valueOf(23).mod(BigInteger.valueOf(2)));
    //Goes through and finds each prime number
      /*
      int primeCheckNumber;
      int a = 1;
      int divisibleCount;

      while (a<=n) 
      {
        divisibleCount = 0;
        primeCheckNumber = 2;
        while (primeCheckNumber <= n / 2) 
        {
          if (a % primeCheckNumber == 0) 
          {
            divisibleCount++;
            break;
          }
          primeCheckNumber++;
        } 
        if (divisibleCount == 0 && a != 1) 
        {
          int count = 0;
          while(when.mod(BigInteger.valueOf(a)) == BigInteger.valueOf(0))
          {
            count++;
            when = when.divide(BigInteger.valueOf(a));
          }
          map.put(a,count);
        }
      a++;
      */
          /*
          Map<String, Integer> map = new HashMap<String, Integer>();
  
        // Mapping int values to string keys
        map.put("Geeks", 10);
        map.put("4", 15);
        map.put("Geeks", 20);
        map.put("Welcomes", 25);
        map.put("You", 30);
  
        // Displaying the Map
        System.out.println("Initial Mappings are: " + map);
  
        // Getting the value of "Geeks"
        System.out.println("The Value is: " + map.get("Geeks"));
  
        // Getting the value of "You"
        System.out.println("The Value is: " + map.get("You"));

        System.out.println("Mappings are: " + map);
    //System.out.println("Hello world!");

    System.out.println(isPrime(factorial(1)));
    */
    }
  

    public static BigInteger factorial(int number) 
    {
        BigInteger factorial = BigInteger.ONE;

        for (int i = number; i > 0; i--) 
        {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

    public static boolean isPrime(BigInteger n) 
    {  
       if((n.compareTo(BigInteger.valueOf(1))) > 1) 
       {  
           return false;  
       }  
      for (BigInteger bi = BigInteger.valueOf(2); bi.compareTo(n) < 0; bi = bi.add(BigInteger.ONE)) 
      {
        if(n.mod(bi) == BigInteger.valueOf(0))
          return false;
      }
    return true;
  }
}

/*
import java.util.*;
import java.math.BigInteger;

class FactDecomp 
{    
    public static String decomp(int n) 
    {
      //Go in order of prime numbers and see which ones are actually divisible
      
      //Find factorial
      //Goes through prime numbers
      //For each prime number, finds how many times it can go into the value before the result is not an integer
      //Keeps updating the value
      
      //key will hold prime factor and value will hold power
      //program will print out correct string in entry set
      Map<Integer,Integer> map = new HashMap<Integer,Integer>();

      //Calculates Factorial
      BigInteger when = factorial(n);

      
      //For loop to go through every single prime number until the factorial
      for (BigInteger bi = BigInteger.valueOf(2); bi.compareTo(when) < 0; bi = bi.add(BigInteger.ONE))
      {
        //Checks if its prime
        if(isPrime(bi))
        {
          map.put(bi.intValue(), 1);
          
          BigInteger moon = when;
          int count = 0;
          //mod should return 0 if they are divisible; gets compared to 0 [what is should return];
          //if they are equal it'll return 0
          if(moon.mod(bi).compareTo(BigInteger.valueOf(0)) == 0)
          {
            count++;
            moon = moon.divide(bi);
            map.put(bi.intValue(), count);
          }
          else
          {
            map.put(bi.intValue(), count);
            break;
          }
          
        }        
      }
      
      String result = "";

      //prime number is key and power is value
      for(Map.Entry<Integer, Integer>entry: map.entrySet())  
      {   
          result += entry.getKey() + " " + entry.getValue() + " | ";
      }   

      return result;
      
    }
  
    //Finds factorial
    public static BigInteger factorial(int number) 
    {
        BigInteger factorial = BigInteger.ONE;

        for (int i = number; i > 0; i--) 
        {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }
  
    //Checks if values are prime numbers
    public static boolean isPrime(BigInteger n) 
    {  
       if((n.compareTo(BigInteger.valueOf(1))) > 1) 
       {  
           return false;  
       }  
      for (BigInteger bi = BigInteger.valueOf(2); bi.compareTo(n) < 0; bi = bi.add(BigInteger.ONE)) 
      {
        if(n.mod(bi) == BigInteger.valueOf(0))
          return false;
      }
    return true;
  }
} 
*/
