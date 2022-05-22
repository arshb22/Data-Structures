import java.util.*;

class Main 
{
  public static void main(String[] args) 
  {
    //System.out.println("Hello world!");
    int[] when = new int[]{1,2,3,4,5,2,3,4,5,6,1,2};
    System.out.println(freqMap(when));
  }

  public static Map<Integer,Integer> freqMap(int[] parameter)
  {

    Map<Integer,Integer> m = new HashMap<Integer,Integer>();
    for(int i = 0; i<parameter.length;i++)
    {
      if(m.containsKey(parameter[i]))
      {
        m.put(parameter[i], m.get(parameter[i]) + 1);
      }
      else
      {
        m.put(parameter[i],1);
      }
    }
    return m;
  }
}