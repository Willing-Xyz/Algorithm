package com.willing.algorithm.sort;

/**
 * 思路：

	1. 把序列划分为两部分
	2. 分别对其进行递归排序
	3. 最后，把这两部分合并到一起

特点：

	* 稳定
	* 不是原址排序


可优化点：

	* 可以选择是否使用哨兵
	* 对小数组使用插入排序或其他更合适的算法

运行时间：

	* 最坏情况：θ(nlgn)
	* 平均情況：θ(nlgn)
	* 最好情況：θ(nlgn) 

 * @author Willing
 *
 */
public class MergeSort {

	public static <T extends Comparable<? super T>> void sort(T[] arr)
	{
		sortSub(arr, 0, arr.length - 1);
	}
	
	protected static <T extends Comparable<? super T>> void sortSub(T[] arr, int p, int r)
	{
		if (p < r)
		{
			int q = (p + r) / 2;
			sortSub(arr, p, q);
			sortSub(arr, q + 1, r);
			merge(arr, p, q, r);
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
