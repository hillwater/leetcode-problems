package easy.p70;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 */
public class Solution {
    /**
     * f(n) = f(n-1) + f(n-2) f(0) = 1 f(1) = 1
     * 
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int tmp = b;
            b += a;
            a = tmp;
        }

        return b;
    }

    @Test
    public void test() {
        assertThat(climbStairs(0), is(1));
        assertThat(climbStairs(1), is(1));
        assertThat(climbStairs(2), is(2));
        assertThat(climbStairs(3), is(3));
        assertThat(climbStairs(4), is(5));
        assertThat(climbStairs(5), is(8));
    }
}
