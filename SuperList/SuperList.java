public class SuperList<E>{
  private ListNode<E> root;
  private ListNode<E> end;
  int size;

  public SuperList(){
    root = end = null;
    size = 0;
  }
  public SuperList(E val){
    root = end = new ListNode<E>(val);
    size = 1;
  }

  public void add (E val){
    ListNode<E> newNode = new ListNode<E>(val);
    
    if (size == 0){// If first thing in list, just add
      root = end = newNode;
      size++;
      return;
    }

    ListNode<E> oldEnd = end;
    if (oldEnd != null)
      oldEnd.setNext(newNode);
    end = newNode;
    //end.setNext(this.end = new ListNode<E>(val));
    this.end.setPrevious(oldEnd);
    size++;
    //System.out.println("RT-->"+root);
    //System.out.println("OE-->"+oldEnd);
    //System.out.println("E-->"+end);

  }
   public void add (int i, E val){

    if (i > size || i < 0)
      throw new ArrayIndexOutOfBoundsException();

    ListNode<E> newNode = new ListNode<E>(val);

    if (size == 0){
      root = end = newNode;
      size++;
      return;
    }
    
    ListNode<E> current = root;
    ListNode<E> newNext = null;
    
    for (int j = 0 ; j < i-1; j++){ // advance to one before insert
      if (current != null)
        current = current.getNext();
    }
    if (size > 1 && i >0 && (current != null)){
        newNext = current.getNext();
        current.setNext(newNode);
        newNode.setPrevious(current);
        newNode.setNext(newNext);
        
    }

    if (i == 0){     
      root = newNode;     
      root.setNext(current);
      if (current != null)
        current.setPrevious(root);

    }
    if (size == 1 && i == 1)
      end = newNode;

    while (current != null && current.hasNext()){
      ListNode<E> last = current;
      current = current.getNext();
      last.setNext(current);
      current.setPrevious(last);
    }
    end = current;
    size++;
  }

  public void push(E val){
    add(val);
  }

  public E pop(){
    if (size == 0)
      return null;
    E val = end.getValue();
    end = end.getPrevious();
    if (end != null)
      end.setNext(null);
    size--;
    return val;

  }

  public E poll(){
    if (size == 0)
      return null;
    E val = root.getValue();
    root = root.getNext();
    //System.out.println("root = "+root);
    if (end != null)
      end.setPrevious(null);
    size--;
    return val;

  }

  public E stackPeek(){
    return end.getValue();
  }

  public E queuePeek(){
    return root.getValue();
  }

  public boolean isEmpty(){
    return (size == 0);
  }

  public E get(int i ){
    ListNode<E> current = root;
    for (int j = 0 ; j < i; j++){ // advance to one before insert
       if (current != null)
        current = current.getNext();
    }
    if (current != null)
      return current.getValue();
    return null;
  }

  public E remove(int i ){
    if (i>= size)
      throw new ArrayIndexOutOfBoundsException();
    if (size > 1 && i == (size-1)){
      E val = end.getValue();
      end = end.getPrevious();
      end.setNext(null);
      size--;
      return val;
    }
    ListNode<E> current = root;
    for (int j = 0 ; j < i; j++){ // advance to one before removal
       if (current != null)
          current = current.getNext();
    }
    E val = null;
    ListNode<E> prev  = null;
    ListNode<E> next  = null;
    if (current != null){
      val = current.getValue();
      prev  = current.getPrevious();
      next  = current.getNext();
    }
    if (prev != null)
      prev.setNext(next);
    if (next != null)
     next.setPrevious(prev);
    if (i == 0 && size > 0)
      root = current.getNext();

    size--;
    return val;

  }

  public boolean contains (E val){
    ListNode<E> current = root;
    for (int j = 0 ; j < size; j++){
        if (current.getValue().equals(val))
          return true;
       current = current.getNext();

    }
    return false;
  }



  public String toString(){
    if (root == null)
      return "[]";
    String s = "[";
    ListNode<E> current = root;
    while (current.hasNext()){
      s+= current.getValue()+", "; 
      current = current.getNext();
    }
    s+= end.getValue()+"]";
    return s;
  }

 

  public int size(){ return size;}

 class ListNode<E>{
  private E value;
  private ListNode<E> prev;
  private ListNode<E> next;

  public ListNode(){
    value = null;
  }

  public ListNode(E val){
    value = val;
    prev = null;
    next = null;
  }

  public E getValue() { return value;}

  public ListNode getPrevious() { return prev;}

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

}