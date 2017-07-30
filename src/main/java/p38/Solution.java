package p38;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 
 * 1. 1 2. 11 3. 21 4. 1211 5. 111221 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read off
 * as "one 2, then one 1" or 1211. Given an integer n, generate the nth term of the count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * Example 1:
 * 
 * Input: 1 Output: "1" Example 2:
 * 
 * Input: 4 Output: "1211"
 */
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String previous = countAndSay(n - 1);

        StringBuilder builder = new StringBuilder();

        int count = 1;
        char currentChar = previous.charAt(0);

        for (int i = 1; i < previous.length(); i++) {
            if (previous.charAt(i) == currentChar) {
                count++;
            } else {
                builder.append(count);
                builder.append(currentChar);

                currentChar = previous.charAt(i);
                count = 1;
            }
        }

        builder.append(count);
        builder.append(currentChar);

        return builder.toString();
    }

    @Test
    public void test() {
        assertThat(countAndSay(1), is("1"));
        assertThat(countAndSay(2), is("11"));
        assertThat(countAndSay(3), is("21"));
        assertThat(countAndSay(4), is("1211"));
        assertThat(countAndSay(5), is("111221"));
        assertThat(countAndSay(6), is("312211"));
    }
}
