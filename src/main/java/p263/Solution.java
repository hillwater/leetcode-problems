package p263;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is
 * not ugly since it includes another prime factor 7.
 * 
 * Note that 1 is typically treated as an ugly number.
 */
public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }

            if (num % 3 == 0) {
                num /= 3;
                continue;
            }

            if (num % 5 == 0) {
                num /= 5;
                continue;
            }

            return false;
        }

        return true;
    }

    @Test
    public void test() {
        assertThat(isUgly(14), is(false));
        assertThat(isUgly(6), is(true));
        assertThat(isUgly(-2147483648), is(false));
    }
}
