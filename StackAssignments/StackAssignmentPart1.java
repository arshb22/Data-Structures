import java.io.*;
import java.lang.*;
import java.util.*;

public class StackAssignmentPart1{
	public StackAssignmentPart1(){
		Stack<Integer> stack = new Stack<Integer>();

		int num = 9;

		System.out.print("The number "+num+" in binary is: ");

		while(num > 0)
		{
			int mod = num % 2;
			stack.push(mod);
			num /= 2;
		}

		while(!(stack.isEmpty()))
			System.out.print(stack.pop());

		System.out.println();

	}

	public static void main(String[]args) {
		StackAssignmentPart1 converter = new StackAssignmentPart1();
	}
}