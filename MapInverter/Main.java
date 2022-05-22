import java.util.*;

class Main {
  public static void main(String[] args) {
    Map<String,String> hMap = new HashMap<String,String>();
    hMap.put("a","1");
    hMap.put("b","2");
    hMap.put("c","3");
    System.out.println(hMap);
    System.out.println(inverse(hMap));

    Map<String,String> tMap = new TreeMap<String,String>();
    tMap.put("uno","one");
    tMap.put("dos","two");
    tMap.put("tres","three");
    tMap.put("quatro","four");
    System.out.println(tMap);
    System.out.println(inverse(tMap));

    tMap.clear(); //reuse TreeMap
    tMap.put("phone","apple");
    tMap.put("pencil","ticonderoga");
    tMap.put("notebook","mead");
    tMap.put("computer","apple");
    System.out.println(tMap);
    System.out.println(inverse(tMap));
  }

public static Map<String, String> inverse(Map<String, String> map)
{
  Map<String, String> when = new HashMap<String, String>();
  for(Map.Entry<String, String> entry : map.entrySet())
  {
    if(when.containsKey(entry.getValue()))
    {
      when.put(entry.getValue(), null);
    }
    else
    {
      when.put(entry.getValue(), entry.getKey());
    }
  }
  return when;
}

}

