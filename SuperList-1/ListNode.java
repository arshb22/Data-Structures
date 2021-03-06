public class ListNode<E>
{
	private E value;
	private ListNode<E> next, prev;

	public ListNode(E value)
	{
		this.value = value;
		next = null;
		prev = null;
	}//constructor

	public E getValue() { return value; }
	public void setValue(E val) { value = val; }

	public ListNode<E> getNext() { return next; }//getNext
	public ListNode<E> getPrev() { return prev; }//getPrev

	public void setNext(ListNode<E> newNext)
	{
		next = newNext;
	}//setNext
	public void setPrev(ListNode<E> newPrev)
	{
		prev = newPrev;
	}//setPrev

	public boolean hasNext()
	{
		return (next != null);
	}//hasNext
	public boolean hasPrev()
	{
		return (prev != null);
	}//hasPrev

	public String toString()
	{
		String prevValue = "", nextValue = "";
		if (prev == null)
			prevValue = "root has no prev";
		else prevValue = prev.getValue() + "";
		if (next == null)
			nextValue = "end has no next";
		else nextValue = next.getValue() + "";

		return "Prev: " + prevValue + "\nNext: " + nextValue + "\nValue: " + value;
	}
}//ListNode<E>