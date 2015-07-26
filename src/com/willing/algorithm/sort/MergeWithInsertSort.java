package com.willing.algorithm.sort;

/**
 * 在归并排序中对小数组采用插入排序
 * @author Willing
 *
 */
public class MergeWithInsertSort extends MergeSort{
	private static int K = 4;

	public static <T extends Comparable<? super T>> void sort(T[] arr)
	{
		sortSub(arr, 0, arr.length - 1);
	}
	
	protected static <T extends Comparable<? super T>> void sortSub(T[] arr, int p, int r)
	{
		if ((r - p) > K)
		{
			int q = (p + r) / 2;
			sortSub(arr, p, q);
			sortSub(arr, q + 1, r);
			merge(arr, p, q, r);
		}
		else
		{
			for (int i = p; i <= r; ++i)
			{
				T key = arr[i];
				int j;
				for (j = i - 1; j >= 0; --j)
				{
					arr[j + 1] = arr[j];
					if (key.compareTo(arr[j]) >= 0)
					{
						break;
					}
				}
				arr[j + 1] = key;
			}
			
			 
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T extends Comparable<? super T>> void merge(T[] arr, int p, int q, int r)
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
	
 
 
	
}
