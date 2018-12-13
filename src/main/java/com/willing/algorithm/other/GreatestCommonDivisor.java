package com.willing.algorithm.other;

/**
 * 最大公约数
 * 《算法（第四版）》 p1
 */
public class GreatestCommonDivisor {
    public static int compute(int p, int q)
    {
        if (q == 0)
            return p;
        int r = p % q;
        return compute(q, r);
    }
}
