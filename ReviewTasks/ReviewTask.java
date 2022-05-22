import java.util.Scanner;
import java.math.BigInteger;

public class ReviewTask{
	public static void main(String[]Args){
		//System.out.println("Hello World");

		// Did He Just Steal An Idea?!
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter nth term");
		String nthTerm = scanner1.nextLine();

		//System.out.println(nthTerm);

		BigInteger first = BigInteger.valueOf(2);
		BigInteger second = BigInteger.valueOf(1);
		BigInteger three = null;

		int x = Integer.parseInt(nthTerm) + 1;

		if(x==1)
		{
			System.out.print()
		}



		for(int i = 0; i<=x-3;i++)
		{
			three = first.add(second);
			first = second;
			second = three;
		}
			System.out.println(three);


		//Can't My Numbers Just Get Along
	}
}
