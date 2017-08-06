package medium.p29;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        long dividendLong = (long)dividend;
        long divisorLong = (long) divisor;

        dividendLong = Math.abs(dividendLong);
        divisorLong = Math.abs(divisorLong);


        int count = 0;

        while (dividendLong >= divisorLong) {
            dividendLong -= divisorLong;
            count++;
        }

        return flag ? count : -count;
    }

    @Test
    public void test() {
//        assertThat(divide(10, 2), is(5));
//        assertThat(divide(100, 3), is(33));
//        assertThat(divide(-1,-1), is(1));
        assertThat(divide(-2147483648, -1), is(2147483647));
    }
}
