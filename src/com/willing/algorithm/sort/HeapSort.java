package com.willing.algorithm.sort;

/**
 * ������
 * 
 *  ˼·��

	1. �����
	2. ȡ�����е����Ԫ�أ������¹����
	3. �ظ��ڶ�����ֱ�����

�ص㣺

	* �ȶ�


���Ż��㣺

	* �ڼ���Parent��Left��Right����ʱ������ʹ��λ���㣬����ٶ�
����ʱ�䣺

	* ��������(nlgn)
	* ƽ����r����(nlgn)
	* �����r����(nlgn) 

 * 
 * @author Willing
 *
 */
public class HeapSort {
	
	public static <T extends Comparable<T>> void sort(T[] arr)
	{
		buildMaxHeap(arr);
		
		int heapSize = arr.length;
		for (int i = arr.length - 1; i >= 1; --i)
		{
			T t = arr[i];
			arr[i] = arr[0];
			arr[0] = t;
			
			heapSize--;
			
			maxHeapify(arr, heapSize, 0);
		}
	}
	
	private static <T extends Comparable<T>> void buildMaxHeap(T[] arr)
	{
		for (int i = arr.length / 2; i >= 0; --i)
		{
			maxHeapify(arr, arr.length, i);
		}
	}
	
	/**
	 * �����ݹ�ͷǵݹ�
	 * @param arr
	 * @param heapSize
	 * @param i
	 */
	private static <T extends Comparable<T>> void maxHeapify(T[] arr, int heapSize, int i)
	{
		// ʹ�õݹ�
//		int left = 2 * i + 1;
//		int right = 2 * i + 2;
//		int largest = i;
//		if (left < heapSize && arr[left].compareTo(arr[i]) > 0)
//		{
//			largest = left;
//		}
//		if (right < heapSize && arr[right].compareTo(arr[largest]) > 0)
//		{
//			largest = right;
//		}
//		
//		if (largest != i)
//		{
//			T t = arr[i];
//			arr[i] = arr[largest];
//			arr[largest] = t;
//			
//			maxHeapify(arr, heapSize, largest);
//		}
		
		// ��ʹ�õݹ�
		int left = 0;
		int right = 0;
		int largest = 0;
		while (i < heapSize)
		{
			left = 2 * i + 1;
			right = 2 * i + 2;
			largest = i;
			
			if (left < heapSize && arr[left].compareTo(arr[i]) > 0)
			{
				largest = left;
			}
			if (right < heapSize && arr[right].compareTo(arr[largest]) > 0)
			{
				largest = right;
			}
			
			if (largest != i)
			{
				T t = arr[i];
				arr[i] = arr[largest];
				arr[largest] = t;
				
				i = largest;
			}
			else
			{
				break;
			}
		}	
		
	}
	
 
 
	
}
