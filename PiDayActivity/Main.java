import java.util.*;

class Main 
{
  public static void main(String[] args) 
  {
    String first100pi = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";

    Map<Character, Integer> map = new HashMap<Character, Integer>();
    
        for (int i = 0; i < first100pi.length(); i++)
        {
            if(map.containsKey(first100pi.charAt(i)))
            {
                map.put(first100pi.charAt(i), map.get(first100pi.charAt(i)) + 1);
            }
            else
            {
                map.put(first100pi.charAt(i), 1);
            }
        }



      for(Map.Entry<Character, Integer>entry: map.entrySet())  
      {  
        System.out.println(entry.getKey() + " " + entry.getValue());
      }

    System.out.println("The four digits that occur exactly the same number of times are 0, 1, 5, amnd 7");
  
    //end file
  }
}