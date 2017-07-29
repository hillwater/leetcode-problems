package p69;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 */
public class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        while (left < right) {
            int mid = left + (right - left) / 2;

            int tmp = mid == 0 ? Integer.MAX_VALUE : x / mid;
            if (tmp < mid) {
                right = mid;
            } else if (tmp > mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        int tmp = left == 0 ? Integer.MAX_VALUE : x / left;

        if (left > tmp) {
            return left - 1;
        } else {
            return left;
        }
    }

    @Test
    public void test() {
        assertThat(mySqrt(0), is(0));
        assertThat(mySqrt(2), is(1));
        assertThat(mySqrt(4), is(2));
        assertThat(mySqrt(100), is(10));
        assertThat(mySqrt(2147395599), is(46339));
    }
}
