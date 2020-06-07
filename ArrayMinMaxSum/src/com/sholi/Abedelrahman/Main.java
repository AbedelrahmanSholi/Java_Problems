/**
 * This class will do insertion sort to sort the array in descending order and then find the max and min sum of its element.
 * Another way to solve this would be by finding the max and min element of the array and then loop to get the sum of min and max.
 * 
 * Example:
 * Input: a[] = {13, 11, 45, 32, 89, 21}
 * Output: 122 200
 */
package com.sholi.Abedelrahman;

/**
 * @author Abedelrahman Sholi
 *
 */
public class Main {

	/**
	 * @param args
	 */
	static int array[] = {13, 11, 45, 32, 89, 21};
	public static void main(String[] args) {
		// First Solution.
		System.out.println("First Solution.");
		Main.insertionSort();
		for (int element : Main.array) {
			System.out.println(element);
		}
		System.out.println(minSum());
		System.out.println(maxSum());
		
		// Second Solution.
		System.out.println("Second Solution.");
		int min=Main.array[0];
		int max=min;
		int sum=0;
		for(int index=0; index<Main.array.length; index++) {
			if(Main.array[index]<min) {
				min = Main.array[index];
			}else if(Main.array[index]>max) {
				max = Main.array[index];
			}
			
			sum+=Main.array[index];
			
		}
		
		int minSum = sum - max;
		int maxSum = sum - min;
		
		System.out.println(minSum);
		System.out.println(maxSum);
	}
	
	static void getMinMaxSum() {
		
	}
	
	static void insertionSort() {
		for (int index = 1; index < Main.array.length; ++index) {
			int key = Main.array[index];
			int swapIndex = index - 1;

			/*
			 * Move elements of array[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (swapIndex >= 0 && Main.array[swapIndex] > key) {
				Main.array[swapIndex + 1] = Main.array[swapIndex];
				swapIndex = swapIndex - 1;
			}
			Main.array[swapIndex + 1] = key;
		}
	}
	
	static int minSum() {
		int sum = 0;
		for(int index=0; index < Main.array.length - 1; index++) {
			sum+= array[index];
		}
		return sum;
	}
	
	static int maxSum() {
		int sum = 0;
		for(int index=1; index < Main.array.length; index++) {
			sum+= array[index];
		}
		return sum;
	}
}
