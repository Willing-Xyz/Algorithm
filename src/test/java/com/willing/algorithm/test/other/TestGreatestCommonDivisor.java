package com.willing.algorithm.test.other;

import com.willing.algorithm.other.GreatestCommonDivisor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGreatestCommonDivisor {
    @Test
    public void test()
    {
        int actual = GreatestCommonDivisor.compute(99, 66);
        assertEquals(33, actual);

        actual = GreatestCommonDivisor.compute(0, 66);
        assertEquals(66, actual);

        actual = GreatestCommonDivisor.compute(66, 0);
        assertEquals(66, actual);
    }
}
