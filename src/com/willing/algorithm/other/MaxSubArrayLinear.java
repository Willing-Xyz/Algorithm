package com.willing.algorithm.other;

public class MaxSubArrayLinear {

	public static Result maxSubArray(int[] arr)
	{
		int sum = 0;
		int finalSum = 0;
		int begin = 0;
		int end = 0;
		for (int i = 0; i < arr.length - 1; ++i)
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
