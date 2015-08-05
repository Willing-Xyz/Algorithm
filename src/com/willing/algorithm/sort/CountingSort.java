package com.willing.algorithm.sort;

/**
 * ˼·��

	1. ��ÿһ��Ԫ�أ�ȷ��С������Ԫ�ظ���
	2. Ȼ��ֱ�ӰѸ�Ԫ�طŵ���Ӧ��λ����

�ص㣺

	* �ȶ�
	* ����ԭַ����


���Ż��㣺

	* 

����ʱ�䣺   ��(n + k) k��ʾ��ֵ�ķ�Χ

 * @author Willing
 *
 */
public class CountingSort {

	public static int[] sort(int[] arr, int max)
	{
		int[] c = new int[max];
		int[] b = new int[arr.length];
		
		
		for (int i = 0; i < c.length; ++i)
		{
			c[i] = 0;
		}
		
		for (int i = 0; i < arr.length; ++i)
		{
			c[arr[i]]++;
		}
		for (int i = 1; i < c.length; ++i)
		{
			c[i] += c[i - 1];
		}
		for (int i = arr.length - 1; i >= 0; --i)
		{
			b[c[arr[i]] - 1] = arr[i];
			--c[arr[i]];
		}
		
		return b;
	}
}
