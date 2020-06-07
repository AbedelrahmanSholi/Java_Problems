/**
 * This class will get the max and min elements of the array along with its index.
 * Also if the element is duplicated will get all the occurrence indices.
 */
package com.sholi.abedelrahman;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SAQERpc
 *
 */
public class Main {

	/**
	 * @param args
	 */
	static int[] array = {13, 11, 45, 32, 89, 21 ,13, 11, 45, 32, 89, 21, 13, 11, 45, 32, 89, 21, 13, 11, 45, 32, 89, 21, 13, 11, 45, 32, 89, 21, 13, 11, 45, 32, 89, 21};
	public static void main(String[] args) {
		
		int min=Main.array[0];
		int max=Main.array[0];
		List<Integer> maxIntIndices = new ArrayList<>();
		List<Integer> minIntIndices = new ArrayList<>();
		
		for(int index=0; index < Main.array.length; index++ ) {

			if(Main.array[index] < min) {
				minIntIndices.clear();
				min = Main.array[index];
				minIntIndices.add(index);
			}else if(Main.array[index] == min) {
				minIntIndices.add(index);
			} else if(Main.array[index] > max) {
				maxIntIndices.clear();
				max = Main.array[index];
				maxIntIndices.add(index);
			}else if(Main.array[index] == max) {
				maxIntIndices.add(index);
			} 
		}
		
		System.out.println(min +"->"+max);
		System.out.println(minIntIndices+"->"+maxIntIndices);

	}

}
