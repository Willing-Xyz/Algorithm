package com.willing.algorithm.sort;

/**
 * ð������(���ʵȼ���ѡ�����򣬼�ÿ��ѡ��һ����Сֵ)
 * @author Willing
 *
 */
public class BubbleSort {

	public static <T extends Comparable<T>> void sort(T[] arr)
	{
		for (int i = 0; i < arr.length - 1; ++i)
		{
			for (int j = arr.length; j > i; --j)
			{
				if (arr[j].compareTo(arr[j - 1]) < 0)
				{
					exch(arr, j, j - 1);
				}
				// �ڴ˴���arr[j]��arr[j] - arr[a.length]�е���Сֵ
			}
		}
	}
	
	private static <T extends Comparable<T>> void exch(T[] arr, int a, int b)
	{
		T t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
}
