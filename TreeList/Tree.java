import java.util.*;
public class Tree<E extends Comparable<E>>
{
	class TreeNode<E>
	{
	public static void main(String[] args)
	{

	}
    
		private E value;
		private TreeNode<E> left, right;

		public TreeNode(E value)
		{
			this.value = value;
			left = null;
			right = null;
		}

		public E getValue() 
    { 
      return value; 
    }
		public TreeNode<E> getLeft() 
    { 
      return left; 
    }
		public TreeNode<E> getRight() 
    { 
      return right; 
    }
    
		public E setValue(E value)
		{
			E temp = this.value;
			this.value = value;
			return temp;
		}

		public TreeNode<E> setLeft(TreeNode<E> left)
		{
			TreeNode<E> temp = this.left;
			this.left = left;
			return temp;
		}

		public TreeNode<E> setRight(TreeNode<E> right)
		{
			TreeNode<E> temp = this.right;
			this.right = right;
			return temp;
		}

		public String toString()
		{
			return value.toString();
		}

	}

	TreeNode<E> root;
	int size;

	public Tree()
	{
		root = null;
		size = 0;
	}

	public Tree(E value)
	{
			root = new TreeNode<E>(value);
			size = 1;
	}

	public TreeNode<E> getRoot() 
  {
    return root; 
  }
	public int size() 
  {
    return size; 
  }

	public void add(E value)
	{
		root = addRecur(root, value);
	}

	private TreeNode<E> addRecur(TreeNode<E> node, E value)
	{
		if (node == null)
		{
			size++;
			return new TreeNode<E>(value);
		}
		else if (value.compareTo(node.getValue()) < 0)
			node.left = addRecur(node.getLeft(), value);
		else if (value.compareTo(node.getValue()) > 0)
			node.right = addRecur(node.getRight(), value);

		return node;
	}

	public void traverseInOrder()
	{
		traverseInOrder(root);
	}

	private void traverseInOrder(TreeNode<E> node)
	{
		if (node != null)
		{
			traverseInOrder(node.getLeft());
			System.out.println(node.getValue());
			traverseInOrder(node.getRight());
		}
	}

	public void traversePreOrder()
	{
		traversePreOrder(root);
	}

	private void traversePreOrder(TreeNode<E> node)
	{
		if (node != null)
		{
			System.out.println(node.getValue());
			traversePreOrder(node.getLeft());
			traversePreOrder(node.getRight());
		}
	}

	public void traversePostOrder()
	{
		traversePostOrder(root);
	}

	private void traversePostOrder(TreeNode<E> node)
	{
		if (node != null)
		{
			traversePostOrder(node.getLeft());
			traversePostOrder(node.getRight());
			System.out.println(node.getValue());
		}
	}

	public ArrayList<E> toArrayList()
	{
		ArrayList<E> list = new ArrayList<E>();
		toArrayList(root, list);
		return list;
	}

	private void toArrayList(TreeNode<E> node, ArrayList<E> list)
	{
		if (node != null)
		{
			toArrayList(node.getLeft(), list);
			list.add(node.getValue());
			toArrayList(node.getRight(), list);
		}
	}

	public boolean contains(E value)
	{
		return contains(root, value);
	}

	private boolean contains(TreeNode<E> node, E value)
	{
		if (node == null)
			return false;
		if (node.getValue().equals(value))
			return true;
		if (value.compareTo(node.getValue()) < 0)
			return contains(node.getLeft(), value);
		return contains(node.getRight(), value);
	}

	public E minValue()
	{
		return minValue(root);
	}

	private E minValue(TreeNode<E> node)
	{
		if (node.getLeft() == null)
			return node.getValue();
		return minValue(node.getLeft());
	}

	public E maxValue()
	{
		return maxValue(root);
	}

	private E maxValue(TreeNode<E> node)
	{
		if (node.getRight() == null)
			return node.getValue();
		return maxValue(node.getRight());
	}

	public void remove(E value)
	{
		if (root == null)
			return;
		if (contains(root, value))
		{
			if (root.getLeft() == null && root.getRight() == null)
			{
				root = null;
				size = 0;
				return;
			}

			size--;
			root = remove(root, value);
		}
	}

	private TreeNode<E> remove(TreeNode<E> node, E value)
	{
		if (node == null)
			return null;
		if (value.compareTo(node.getValue()) < 0)
			node.setLeft(remove(node.getLeft(), value));
		else if (value.compareTo(node.getValue()) > 0)
			node.setRight(remove(node.getRight(), value));
		else {
			if (node.getLeft() == null && node.getRight() == null)
				node = null;
			else if (node.getLeft() == null)
				return node.getRight();
			else if (node.getRight() == null)
				return node.getLeft();
			else {
				E minRight = minValue(node.getRight());
				node.setValue(minRight);
				node.setRight(remove(node.getRight(), minRight));
			}
		}

		return node;
	}

	public void rotateRight()
	{
		TreeNode<E> temp = root.getLeft();
		root.setLeft(temp.getRight());
		temp.setRight(root);
		root = temp;
	}

	public void rotateLeft()
	{
		TreeNode<E> temp = root.getRight();
		root.setRight(temp.getLeft());
		temp.setLeft(root);
		root = temp;
	}

	public void print()
	{
		if (root == null)
			System.out.print("Empty Tree");
		print(root,0,"");
		System.out.println();
	}
	
	private void print(TreeNode<E> curr, int depth, String s)
	{
		if (curr == null)
			return; 
		
		for (int i=1; i<=depth-1; i++)
		{ 
			System.out.print("|\t");
		}

		if (depth == 0)
			System.out.println("["+curr.value+"] <- root (L___ left, R___ right)");
	

		if (depth > 0)
		{
			System.out.print(s);
			System.out.println(curr.value); 
		}
		
		print(curr.left, depth + 1,"L___");
		print(curr.right,depth + 1,"R___");
	}

	public int NodeCount()
	{
		return NodeCount(root);
	}

	private int NodeCount(TreeNode<E> node)
	{
		if (node == null)
			return 0;
		return NodeCount(node.left) + NodeCount(node.right) + 1;
	}
	

}