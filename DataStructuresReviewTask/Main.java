import java.util.*;

class Main 
{
  public static void main(String[] args) 
  {
    ArrayList<Integer> fillArray = new ArrayList<Integer>();

    //Step 1
    int arraySize = ((int)(Math.random() * 100) + 50);
    
    for(int i = 0; i<arraySize; i++)
    {  
      fillArray.add((int)(Math.random() * 100));
    }

    //Step 2
    System.out.println("Step 2: ");
    System.out.println(fillArray);
    System.out.println("ArrayList Size: " + fillArray.size());

    //Step 3
    int size2DArray = (int)Math.sqrt(fillArray.size());

    int[][] array3 = new int[(int)size2DArray][(int)size2DArray];

    for(int a = 0; a<(size2DArray*size2DArray);a++)
    {
      int x;
      int y;
      do
      {
        x = ((int)(Math.random() * size2DArray));
        y = ((int)(Math.random() * size2DArray));
      }while((array3[x][y]!=0));
        
      array3[x][y] = fillArray.get(a);
    }

    //Step 4
    System.out.println("\nStep 4: ");
    System.out.println(Arrays.deepToString(array3));
    System.out.println("2D Array Sizes =>" + " Column: " + array3[0].length + " Row: " + array3.length);

    //Step 5
    Stack<Integer> stack1 = new Stack<Integer>();

    for(int b=0; b<array3[0].length; b++) 
    {
      for(int c=0; c<array3.length; c++) 
      {
          stack1.push(array3[c][b]);
      }
    }

    //Step 6
    System.out.println("\nStep 6: ");
    System.out.println(Arrays.toString(stack1.toArray()));
    System.out.println("Stack Size: " + stack1.size());

    //Step 7
    HashSet<Integer> step7 = new HashSet<Integer>();
    for(int d = 0; d<stack1.size();d++)
    {
      step7.add(stack1.pop());    
    }
    
    //Step 8
    System.out.println("\nStep 8: ");
    Iterator itr = step7.iterator();
        
    while (itr.hasNext()) 
    {
      System.out.print(itr.next() + " ");
    }
    System.out.println("\nHash Set Size: " + step7.size());

    //Step 9
    PriorityQueue<Integer> step9 = new PriorityQueue<Integer>();
    Iterator itr2 = step7.iterator();
        
    while (itr2.hasNext()) 
    {
      step9.add((int)itr2.next());
    }

    //Step 10
    System.out.println("\nStep 10: ");
    System.out.println(Arrays.toString(step9.toArray()));
    System.out.println("Priority Queue Size: " + step9.size());

    //Step 11
    TreeMap<Integer, TreeSet<Integer>> tree_map = new TreeMap<Integer, TreeSet<Integer>>();

    System.out.println("");
    Object[] arr10 = step9.toArray();
    for(int e = 0; e<arr10.length;e++)
    {
      System.out.print((int)arr10[e] + " ");    
    }

    
    TreeSet<Integer> valuePair = new TreeSet<Integer>();

    Integer keyPair = 0;
    
    for(int e = 0; e<arr10.length;e++)
    {
      if((int)(arr10[e])%2==0)
      {
        if(keyPair==0 && valuePair.isEmpty()==false)
        {
          valuePair.clear();
        }
        else if(valuePair.isEmpty()==false)
        {
          tree_map.put(keyPair,valuePair);
          System.out.println(valuePair);
          valuePair.clear();
        }
        keyPair = (int)arr10[e];
      }
      if((int)(arr10[e])%2==1)
      {
        valuePair.add((int)arr10[e]);
      }
    }
    
    System.out.println("\nTree Map Size: " + tree_map.size());
    
    //Step 12
    System.out.println("\nStep 12: ");
    System.out.println(tree_map.size());
    for (Map.Entry<Integer, TreeSet<Integer>> entry : tree_map.entrySet()) 
    {
     System.out.println("Key: " + entry.getKey() + "; Value: " + entry.getValue());
    }
  }
}