package com.willing.algorithm.sort;
import java.util.Arrays;


public class MergeSort {

	public static <T extends Comparable<T>> void sort(T[] arr)
	{
		sort_sub(arr, 0, arr.length - 1);
	}
	
	private static <T extends Comparable<T>> void sort_sub(T[] arr, int p, int r)
	{
		if (p < r)
		{
			int q = (p + r) / 2;
			sort_sub(arr, p, q);
			sort_sub(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T extends Comparable<T>> void merge(T[] arr, int p, int q, int r)
	{
		int n1 = q - p + 1;
		int n2 = r - q;
		
		
		Comparable[] left = new Comparable[n1];
		Comparable[] right = new Comparable[n2];
		
		for (int i = p; i <= q; ++i)
		{
			left[i - p] = arr[i];
		}
		for (int i = q + 1; i <= r; ++i)
		{
			right[i - q - 1] = arr[i];
		}
		
		int i = 0;
		int j = 0;
		int k = p;
		while (n1 > 0 && n2 > 0)
		{
			if (left[i].compareTo(right[j]) <= 0)
			{
				arr[k++] = (T) left[i++];
				n1--;
			}
			else 
			{
				arr[k++] = (T) right[j++];
				n2--;
			}
		}

		while (n1-- > 0)
		{
			arr[k++] = (T) left[i++];
		}
		while (n2-- > 0)
		{
			arr[k++] = (T) right[j++];
		}
		
	}
	
	public static void main(String[] args) {
		
		Integer[] ints = new Integer[]{2, 1, 3, 5, 4};
		sort(ints);
		
		System.out.println(Arrays.deepToString(ints));
	}
	
}
