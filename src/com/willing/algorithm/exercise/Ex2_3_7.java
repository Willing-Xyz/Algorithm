package com.willing.algorithm.exercise;

import java.util.Arrays;

/**
 * 
 * @author Willing
 *
 */
public class Ex2_3_7 {

	public static void main(String[] args) {
		
		int[] ints = new int[]{3, 5, 2, 4, 9, 7, 0};
		
		boolean has = hasSum(ints, 9);
		System.out.println(has);
	}
	
	private static boolean hasSum(int[] arr, int x)
	{
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length / 2; ++i)
		{
			int index = Arrays.binarySearch(arr, x - arr[i]);
			
			if (index >= 0)
			{
				return true;
			}
		}
		return false;
	}
}
