import java.util.*;

class Main 
{
  public static void main(String[] args) 
  {
    String sentence = "The quick brown fox jumps over the lazy dog.";
    sentence = sentence.replaceAll("[^a-zA-Z]+", "");
        
    TreeSet<Character> az = new TreeSet<Character>();
 
    for(int i = 0; i< sentence.length(); i++)
    {
      az.add(Character.toLowerCase(sentence.charAt(i)));
      System.out.println(Character.toLowerCase(sentence.charAt(i)));
    }
  }
}