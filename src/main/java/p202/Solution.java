package p202;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number
 * by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it
 * loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy
 * numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 1^2 + 9^2 = 82 8^2 + 2^2 = 68 6^2 + 8^2 = 100 1^2 + 0^2 + 0^2 = 1
 */
public class Solution {
    public boolean isHappy(int n, Set<Integer> set) {
        if (n == 1) {
            return true;
        }

        if (set.contains(n)) {
            return false;
        }
        set.add(n);

        int next = 0;
        while (n > 0) {
            int tmp = n % 10;
            next += tmp * tmp;
            n /= 10;
        }
        return isHappy(next, set);
    }

    public boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }

    @Test
    public void test() {
        assertThat(isHappy(19), is(true));
        assertThat(isHappy(4), is(false));
    }
}
