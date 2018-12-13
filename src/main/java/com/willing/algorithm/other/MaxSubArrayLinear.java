package com.willing.algorithm.other;

/**
 * 最大子数组的线性时间的实现
 * 
 * 思路：
 * 	1. 首先，起始点从头开始
 * 	2. 它会一直从头往后求和，直到求到的和小于0，才会更改起始点。因为如果不小于0，它是正值，当然要加起来
 * 	3. 一旦求到的和小于了0，则下一个位置设为起始点
 * 	4. 如果新求到的和大于之前的和，则此点设为终止点
 * 	5. 回到第二步，重复。
 * 
 * @author Willing
 *
 */
public class MaxSubArrayLinear {

	public static Result maxSubArray(int[] arr)
	{
		int sum = 0;
		int finalSum = 0;
		int begin = 0;
		int end = 0;
		for (int i = 0; i < arr.length; ++i)
		{
			sum += arr[i];
			if (sum < 0)
			{
				sum = 0;
				begin = i + 1;
			}
			else if (sum > finalSum)
			{
				finalSum = sum;
				end = i;
			}
		}
		
		return new Result(finalSum, begin, end);
	}
}
