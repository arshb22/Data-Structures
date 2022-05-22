import java.util.*;
import java.math.BigInteger;


class When
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

    BigInteger start = BigInteger.valueOf(2);

    while(!(when.equals(BigInteger.valueOf(0))))
    {

			//This works
			int howMany = 0;

			//This finds out how many times it can go in; now we need it to increase start till when = 0;
    		while((when.mod(start)).equals(BigInteger.valueOf(0)))
			{
				when = when.divide(start);
				howMany++;
			}
			map.put(start,howMany);

	}
	System.out.println(map);

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

