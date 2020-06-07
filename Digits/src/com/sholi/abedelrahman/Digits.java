/**
 * This class is able to get all the digits of any number in case its positive and its type is one of the following:
 * 	Integer.
 * 	Long.
 * 	BigInteger.
 * 	Double.
 * 
 * Also will provide you with the place value of each digit.
 */
package com.sholi.abedelrahman;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The Class Digits.
 *
 * @author Abedelrahman Sholi
 */
public class Digits {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String number = Digits.readLongConsole();
		
		LinkedList<Integer> naturalStack = null;
		LinkedList<Integer> fractionsStack = null;
		
		Boolean isInteger = Digits.isParsableAsInteger(number);
		Boolean isLong = Digits.isParsableAsLong(number);
		Boolean isBigInteger = Digits.isParsableAsBigInteger(number);
		Boolean isDouble = Digits.isParsableAsDouble(number);
		
		System.out.println("Your input is:"+number);
		System.out.println("Can be converted into:");
		System.out.println("Integer\tLong\tBigInteger\tDouble");
		System.out.println(isInteger + "\t" + isLong + "\t" + isBigInteger + "\t\t" + isDouble+"\n\r");
		

		
		if( (!isInteger && !isLong && !isBigInteger && !isDouble) || number.startsWith("-")) {
			System.out.println("Your inserted number type should be one of int, long, BigInteger or double , and should be positive");
			return;
		}
		
		if (!number.contains(".")) {
			naturalStack = Digits.getDigits(new BigInteger(number));
		}else {
			String[] partsOfDouble = number.split(Pattern.quote("."));
			naturalStack = Digits.getDigits(new BigInteger(partsOfDouble[0]));
			fractionsStack = Digits.getDigits(new BigInteger(partsOfDouble[1]));			
		}
		
		Digits.display(naturalStack,fractionsStack);
		
	}

	static String readLongConsole() {
		String number;
		Scanner input = new Scanner(System.in);
		System.out.println("Insert an number.");
		number = input.nextLine();
		input.close();
		return number;
	}
	
	static boolean isParsableAsInteger(String number) {
	    try {
	        Integer.valueOf(number);
	        return true;
	    } catch (NumberFormatException numberFormatException) {
	        return false;
	    }
	}

	static boolean isParsableAsLong(String number) {
	    try {
	        Long.valueOf(number);
	        return true;
	    } catch (NumberFormatException numberFormatException) {
	        return false;
	    }
	}
	
	static boolean isParsableAsBigInteger(String number) {
	    try {
	    	new BigInteger(number); 
	        return true;
	    } catch (NumberFormatException numberFormatException) {
	        return false;
	    }
	}
	
	static boolean isParsableAsDouble(String number) {
	    try {
	        Double.valueOf(number);
	        return true;
	    } catch (NumberFormatException numberFormatException) {
	        return false;
	    }
	}

	static LinkedList<Integer> getDigits(BigInteger number) {
		LinkedList<Integer> stack = new LinkedList<>();
		BigInteger theTen = new BigInteger("10");
		BigInteger theZero = new BigInteger("0");
		while(!number.equals(theZero)) {
			stack.push(number.mod(theTen).intValue());
			number = number.divide(theTen);
		}
		
		return stack;
	}

	static void display(LinkedList<Integer> naturalStack , LinkedList<Integer> fractionsStack) {
		
		System.out.println("Digit" + "\t\t\t\t\t->\t\t\t\t\t" + "Corresponding Value" );
		for(int index=0; index < naturalStack.size() ; index++) {
			BigInteger digitValue = BigDecimal.valueOf(Math.pow(10, naturalStack.size() - index - 1)).toBigInteger();
			System.out.println(naturalStack.get(index) + "\t\t\t\t\t->\t\t\t\t\t" + digitValue );
		}
		
		if(fractionsStack != null) {
			for(int index=0; index < fractionsStack.size() ; index++) {
				BigDecimal digitValue = BigDecimal.valueOf(1/Math.pow(10, index + 1));
				System.out.println(fractionsStack.get(index) + "\t\t\t\t\t->\t\t\t\t\t" + digitValue.toPlainString() );
			}
		}
	}

}
