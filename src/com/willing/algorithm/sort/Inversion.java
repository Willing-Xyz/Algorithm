package com.willing.algorithm.sort;

/**
 * º∆À„ƒÊ–Ú∂‘
 * @author Willing
 *
 */
public class Inversion {
	
	public static <T extends Comparable<T>> long inversion(T[] arr)
	{
		return inversionSub(arr, 0, arr.length - 1);
	}
	
	protected static <T extends Comparable<T>> long inversionSub(T[] arr, int p, int r)
	{
		if (p < r)
		{
			int q = (p + r) / 2;
			
			return inversionSub(arr, p, q) + inversionSub(arr, q + 1, r) + merge(arr, p, q, r);
		}
		return 0;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T extends Comparable<T>> long merge(T[] arr, int p, int q, int r)
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
		int v = 0;
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
				v = v + (q - p + 1) - i; 
			}
		}

		while (n1-- > 0)
		{
//			v = v + (r - q);
			arr[k++] = (T) left[i++];
			
		}
		while (n2-- > 0)
		{
			arr[k++] = (T) right[j++];
		}
		
		return v;
		
	}
	
 
	
}
