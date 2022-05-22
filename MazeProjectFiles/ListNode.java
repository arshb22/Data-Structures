import java.io.*;

public class ListNode<E>
{
	private E value;
	private ListNode<E> previous;
	private ListNode<E> next;

	public ListNode(E initValue)
	{
		value = initValue;
	}

	public E getValue()
	{
		return value;
	}

	public void setPrevious(ListNode<E> a)
	{
		previous = a;
	}

	public void setNext(ListNode<E> b)
	{
		next = b;
	}

	public ListNode<E> getPrevious()
	{
		return previous;
	}

	public ListNode<E> getNext()
	{
			return next;
	}

	public boolean hasNext()
	{
		if(next==null)
			return false;
		return true;
	}

	public boolean hasPrevious()
	{
		if(previous==null)
			return false;
		return true;
	}
}