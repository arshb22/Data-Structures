import java.io.*;
import java.lang.*;
import java.util.*;

public class StackAssignmentPart2{
	public StackAssignmentPart2(){
		Stack<Character> stack = new Stack<Character>();

		String input = "whendit";

		for(int i = 0; i<input.length(); i++)
		{
			stack.push(input.charAt(i));
		}


		while(!(stack.isEmpty()))
		{
			System.out.print(stack.pop());
		}

		System.out.println("\nwhendit");
		System.out.println();
	}

	public static void main(String[]args) {
		StackAssignmentPart2 revereString = new StackAssignmentPart2();
	}
}