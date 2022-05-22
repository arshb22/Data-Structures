import java.util.*;

class Main {
  public static void main(String[] args) {
    Map<Integer,Integer> hMap = new HashMap<Integer,Integer>();
    hMap.put(null,null);
    System.out.println(hMap);
    hMap.put(null,2);
    System.out.println(hMap);
    hMap.put(2,null);
    System.out.println(hMap);
    hMap.put(3,null);
    System.out.println(hMap.get(hMap.get(3)));


    // Will the same work with a Tree Map?   where are the differences?
    Map<Integer,Integer> tMap = new TreeMap<Integer,Integer>();
    tMap.put(null,null);
    System.out.println(tMap);
    tMap.put(null,2);
    System.out.println(tMap);
    tMap.put(2,null);
    System.out.println(tMap);
    tMap.put(3,null);
    System.out.println(tMap.get(tMap.get(3)));




  }
}