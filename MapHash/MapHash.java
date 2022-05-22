/*

NOTE:  This MapHash does not support null keys
This is a shortcut, so a null value at a key in the
key Object[] represents the absence of that key

Methods:
- put (K key, V value) returns previous value (or null)
- get (k key) returns value
- containsKey(K key) returns boolean if key is present (not null)
- keySet() returns a Set<K> based on all keys (not null)
- getSize() returns current size of the map
- remove(K key) removes key and value and returns value V


*/
import java.util.*;  // No using maps, but you can make a keySet

public class MapHash<K,V>{

  public static final int DEFAULT_MAP_SIZE =  13000000;
  private int mapSize;
  private Object[] keys, vals;
  private int size;

  public MapHash(int capacity)
  {
    mapSize = capacity;
    keys = new Object[mapSize]; //Parallel Arrays based on
    vals = new Object[mapSize]; // hash index
  }

  public MapHash(){ // Set to default value
    this(DEFAULT_MAP_SIZE);
  }

  private int hash(K s){ // This is used to keep index values in range
    return Math.abs(s.hashCode()%mapSize);
  }

  public V put(K key,V value)
  {
	  int index = hash(key);
	  V returnValue = null;
	  if(keys[hash(key)]==null)
	  {
		//If it doesn't exist
		keys[index] = key;
	  	vals[index] = value;
	  	size++;
	  }
	  else
	  {
		//If it does exist
		returnValue = (V)vals[hash(key)];
		keys[index] = key;
	  	vals[index] = value;
	  }
	  return returnValue;
	  //Add size if its adding new key
	  //If key exists it'll overwrite value
	  //If doesn't exist it'll create new pair
	  //Return previous value
  }

  public V get(K key)
  {
	//Needs to cast; uses (V)
	return (V)vals[hash(key)];
  }

  public boolean containsKey(K key)
  {
	 boolean returnValue = false;
	 if(!(keys[hash(key)]==null))
	 {
		 returnValue = true;
	 }
	 return returnValue;
  }

  public Set<K> keySet()
  {
	Set<K> returnSet = new HashSet<K>();
	for(int i = 0; i<keys.length;i++)
	{
		if(keys[i]!=null)
		{
			returnSet.add((K)keys[i]);
		}
	}
	return returnSet;
  }

  public int size()
  {
	  return size;
  }

  public V remove(K key)
  {
	  int index = hash(key);
	  V returnValue = (V)vals[index];
	  keys[index] = null;
	  vals[index] = null;
	  size--;
	  return returnValue;
  }



	//For unit testing
	public static void main(String[]args)
	{
		//Test Code
		MapHash<String,String> map = new MapHash<String,String>();
		map.put("Bachman Turner","Overdrive");
		map.put("Mad","Hatter");
		map.put("I love rock and roll","So put another dime in the jukebox baby");
		System.out.println(map.get("Bachman Turner"));
		System.out.println(map.get("Mad"));
		System.out.println(map.get("I love rock and roll"));

		System.out.println("\n Key Set:");
		for (String s: map.keySet())
		  System.out.println(s);

		MapHash<Character,Integer> frq = new MapHash<Character,Integer>();
		String s = "This is a sentence, how many of each character does it have?";
		for (int i = 0; i < s.length(); i++){
		  Character c = s.charAt(i);
		  if (frq.containsKey(c)){
			frq.put(c,frq.get(c)+1);
		  }
		  else
			frq.put(c,1);
		}

		// Print Frequency Table
		System.out.println("Original Freq Table, size = "+frq.size());
		for (Character c: frq.keySet())
		  System.out.println(c+" -> "+frq.get(c));

		// Remove Spaces and keys that occur exactly 3 times
		frq.remove(' ');

		for (Character c: frq.keySet())
		  if (frq.get(c) == 3)
			  frq.remove(c);

		System.out.println("\nAdjusted Freq Table, size = "+frq.size());
		for (Character c: frq.keySet())
		  System.out.println(c+" -> "+frq.get(c));
	}

}