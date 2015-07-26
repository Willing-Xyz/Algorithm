package com.willing.algorithm.datastructure;

import java.lang.reflect.Array;

public class MaxPriorityQueue<T extends Comparable<T>> {
	
	T[] queue;
	
	int pos;
	 
	@SuppressWarnings("unchecked")
	public MaxPriorityQueue(Class<T> clazz, int size)
	{
		queue = (T[])Array.newInstance(clazz, size);
		pos = -1;
	}
	
	public T max()
	{
		if (pos >= 0)
		{
			return queue[0];
		}
		else
		{
			return null;
		}
	}
	
	public T extractMax()
	{
		T max = null;
		
		if (pos >= 0)
		{
			max = queue[0];
			
			queue[0] = queue[pos--];
			
			maxHeapify(0);
		}
		
		return max;
	}
	
	public void increaseKey(int i, T key)
	{
		if (key.compareTo(queue[i]) < 0)
		{
			throw new IllegalArgumentException("ֻ�����Ӽ�ֵ");
		}
		
		queue[i] = key;
		
		while (i >= 0 && queue[(i - 1) / 2].compareTo(queue[i]) < 0)
		{
			T tmp = queue[(i - 1) / 2];
			queue[(i - 1) / 2] = queue[i];
			queue[i] = tmp;
			
			i = (i - 1) / 2;
		}
	}
	
	
	public void insert(T t)
	{
		++pos;
		queue[pos] = t;
		
		int i = pos;
		
		while (i >= 0 && queue[(i - 1) / 2].compareTo(queue[i]) < 0)
		{
			T tmp = queue[(i - 1) / 2];
			queue[(i - 1) / 2] = queue[i];
			queue[i] = tmp;
			
			i = (i - 1) / 2;		
		}
	}
	
 
	
	
 
	
	/**
	 * �����ݹ�ͷǵݹ�
	 * @param arr
	 * @param heapSize
	 * @param i
	 */
	private  void maxHeapify(int i)
	{
		T[] arr = queue;
		int heapSize = pos;
		
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
