package p7;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * click to show spoilers.
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class Solution {
    public int reverse(int x) {
        int flag;
        if(x == 0) {
            return 0;
        } else if(x > 0) {
            flag = 1;
        } else {
            flag = -1;
            x = -x;
        }

        long result = 0;
        while(x > 0) {
            result = result * 10 + x%10;
            x = x/10;
        }

        if(result>=Integer.MAX_VALUE) {
            return 0;
        }

        return flag * (int)result;
    }


    @Test
    public void testReverse() {
        assertThat(reverse(123), is(321));
        assertThat(reverse(-123), is(-321));
        assertThat(reverse(1534236469), is(0));
    }
}
