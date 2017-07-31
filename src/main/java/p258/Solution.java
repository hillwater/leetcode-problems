package p258;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 */
public class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }

        int result = num % 9;
        if (result == 0) {
            return 9;
        } else {
            return result;
        }
    }

    @Test
    public void test() {
        assertThat(addDigits(0), is(0));
        assertThat(addDigits(18), is(9));
        assertThat(addDigits(38), is(2));
    }
}
