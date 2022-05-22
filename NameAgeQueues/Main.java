import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Main {
  public static void main(String[] args) {
    String[] names = {"Sal","Dev","Tanika","Krish","Tom","Lisa","Neva"};
    Queue<Person> q = new LinkedList<Person>();
    Queue<Person> pq = new PriorityQueue<Person>();
    for (int i = 0; i < 15; i++){
      Person p = new Person(names[(int)(Math.random()*names.length)], (int)(Math.random()*80+5));
      q.add(p);
      pq.add(p);

    }

    System.out.println("\n Original Queue");
    while (!q.isEmpty())
      System.out.println(q.poll());

    System.out.println("\n Priority Queue");
    while (!pq.isEmpty())
      System.out.println(pq.poll());

    

  }
}