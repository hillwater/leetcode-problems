package p9;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        long x2 = x;

        long result = 0;
        while (x2 > 0) {
            result = result * 10 + x2 % 10;
            x2 /= 10;
        }

        return result == x;
    }

    @Test
    public void test() {
        assertThat(isPalindrome(212), is(true));
        assertThat(isPalindrome(231), is(false));
    }
}
