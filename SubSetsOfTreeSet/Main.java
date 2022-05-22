import java.util.*;

class Main {
  public static void main(String[] args) {
    TreeSet<Integer> ts = new TreeSet<Integer>();
    for (int i = 0; i < 30; i++)
      ts.add((int)(Math.random()*100+1));

    
    // Create a subset of all elements >= 80
    TreeSet<Integer> tail = (TreeSet<Integer>)ts.tailSet(80);

    // Print the new Set
    for (int i : tail)
      System.out.print(i+" ");
    System.out.println();

   

    String randomText = "Savings her pleased are several started females met. Short her not among being any. Thing of judge fruit charm views do. Miles mr an forty along as he. She education get middleton day agreement performed preserved unwilling. Do however as pleased offence outward beloved by present. By outward neither he so covered amiable greater. Juvenile proposal betrayed he an informed weddings followed. Precaution day see imprudence sympathize principles. At full leaf give quit to in they up";

    String okay = "";

    for (int i = 0; i < randomText.length(); i++) 
    {
        if(!(randomText.charAt(i) == '.'))
        {
          okay += randomText.charAt(i);
        }
    }
    okay = okay.toLowerCase();

    TreeSet<String> tree = new TreeSet<String>();

    String[] arr = okay.split(" "); 

    for (String ss : arr) 
    {
      tree.add(ss);
    }  

    TreeSet<String> sub_set = new TreeSet<String>();
  
   
    sub_set = (TreeSet<String>)tree.subSet("leaf", "pleased");


  Iterator iterate;
  iterate = sub_set.iterator();

  while (iterate.hasNext()) 
  {
    System.out.print(iterate.next() + " ");
  }
    
    /* Task:  Convert the randomText string to all lowercase and 
    remove punctuation.  Then, add all the words to a TreeSet of Strings.  Finally, use a subSet to print out the words "leaf" and "pleased" along with all the words in between them (in natural order).
    See subset documentation:
    https://docs.oracle.com/javase/7/docs/api/java/util/TreeSet.html
    */
   


  
  }
}