import java.util.Scanner;
import java.util.ArrayList;

/**
 * The Class PrimeAndDivisor.
 * 
 * @author Abedelrahman Sholi
 * 
 *         In mathematics, A prime number (or a prime) is a natural number
 *         greater than 1 that is not a product of two smaller natural numbers.
 *         A natural number greater than 1 that is not prime is called a
 *         composite number. For example, 5 is prime because the only ways of
 *         writing it as a product, 1 × 5 or 5 × 1, involve 5 itself. However, 4
 *         is composite because it is a product (2 × 2) in which both numbers
 *         are smaller than 4.
 * 
 *         A divisor of an integer n, also called a factor of n, is an integer m
 *         that may be multiplied by some integer to produce n. In this case,
 *         one also says that n is a multiple of m. An integer n is divisible by
 *         another integer m if m is a divisor of n; this implies dividing n by
 *         m leaves no remainder.
 */

public class PrimeAndDivisor {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int number;
		String exit;
		boolean isPrime;
		ArrayList<Integer> divisorOfNotPrime = new ArrayList<>();

		System.out.println("Check If the numebr is prime.");

		while (true) {
			System.out.println("Insert an integer thats bigger than 1.");
			number = input.nextInt();

			// We need another input.nextLine(); to consume the next line.
			// The problem is that nextInt() does not consume the '\n', so the next call to
			// nextLine() consumes it and then it's waiting to read the input for y.
			// You need to consume the '\n' before calling nextLine().
			// (actually a better way would be to call directly nextLine() after nextInt()).
			input.nextLine();

			if (number <= 1)
				System.out.println("Number :" + number + " is not allowed.");
			else {
				isPrime = PrimeAndDivisor.isPrime(number);
				System.out.println(number + " is a prime number? " + isPrime);
				if (!isPrime) {
					System.out.println("The number " + number + " is dividable by:");
					divisorOfNotPrime = PrimeAndDivisor.getDivisor(number);
					for (int index = 0; index < divisorOfNotPrime.size(); index++) {
						System.out.print(divisorOfNotPrime.get(index) + "\t");
					}
					System.out.println();

				}
			}

			divisorOfNotPrime.clear();
			System.out.println("\nCountinue... ?[Y/N]");
			exit = input.nextLine().trim().toUpperCase();
			if (exit.equals("N") || exit.equals("NO"))
				break;
		}

		input.close();
		System.out.println("Thank you for using my tool");
	}

	/**
	 * Checks if a given number is prime
	 *
	 * @param number the number
	 * @return true, if is prime
	 */
	static boolean isPrime(int number) {
		if (number <= 1)
			throw new IllegalArgumentException();
		for (int counter = 2; counter <= number/2; counter++) {
			if (number % counter == 0)
				return false;
		}
		return true;
	}

	/**
	 * Gets the divisor of a given number.
	 *
	 * @param number the number
	 * @return the divisor
	 */
	static ArrayList<Integer> getDivisor(int number) {
		ArrayList<Integer> divisor = new ArrayList<>();
		divisor.add(1);

		for (int counter = 2; counter < number; counter++) {
			if (number % counter == 0)
				divisor.add(counter);
		}
		divisor.add(number);
		return divisor;
	}
}