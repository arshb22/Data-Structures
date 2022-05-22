public class ListNode2<E>{

  private static int id_Gen = 0;

  private int id;
  private E value;
  private ListNode<E> prev;
  private ListNode<E> next;

  public ListNode2(){
    value = null;
  }

  public ListNode2(E val){
    value = val;
    id = id_Gen++;
    prev = null;
    next = null;
  }

  public E getValue() { return value;}

  public ListNode<E> getPrevious() { return prev;}

  public ListNode<E> setPrevious(ListNode<E> val) { 
    ListNode<E> orig = prev;
    prev = val;
    return orig;
  }

  public ListNode<E> getNext() { return next;}

  public ListNode<E> setNext(ListNode<E>  val) { 
    ListNode<E> orig = next;
    next = val;
    return orig;
    
  }

  public String toString(){
    String s = "";
    if (prev != null)
      s+= "<pr="+prev.getValue();
    s+= ", "+this.getValue();
    if (next != null)
     s+= ", n="+next.getValue()+">";
    return s;
  }

  

  public boolean hasPrevious(){
    return (prev != null);
  }

  public boolean hasNext(){
    return (next != null);
  }


}