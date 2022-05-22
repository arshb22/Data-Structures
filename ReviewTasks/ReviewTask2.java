import java.util.Scanner;
import java.math.BigInteger;

public class ReviewTask2{
	public static void main(String[]Args){
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter numbers term");
		String input = scanner1.nextLine();

		String[] numbers = input.split(" ");
		int one = Integer.parseInt(numbers[0]);
		int two = Integer.parseInt(numbers[1]);

		int sumFactorOne = 0;
		int sumFactorTwo = 0;


		System.out.print("Factors of " + one + " are ");
		for (int i = 1; i < one; i++) {
		      if (one % i == 0) {
		        sumFactorOne+=i;
		        System.out.print(i + ", ");
		      }
    	}
    	System.out.print("Sum is " + sumFactorOne + "\n");

		System.out.print("Factors of " + two + " are ");
    	for (int i = 1; i < two; i++) {
			if (two % i == 0) {
				sumFactorTwo+=i;
				System.out.print(i + ", ");
			}
    	}
    	System.out.print("Sum is " + sumFactorTwo + "\n");

		if(sumFactorOne == two && sumFactorTwo == one)
		{
			System.out.println("The numbers " + one + " and " + two + " are amicable");
		}
		else
		{
			System.out.println("The numbers " + one + " and " + two + " are not amicable");
		}
	}
}
