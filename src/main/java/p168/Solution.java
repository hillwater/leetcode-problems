package p168;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();

        while (n > 0) {
            int left = n % 26;
            n = n / 26;

            if (left > 0) {
                builder.append((char)('A' + left - 1));
            } else {
                builder.append('Z');
                n--;
            }
        }
        return builder.reverse().toString();
    }

    @Test
    public void test() {
        assertThat(convertToTitle(1), is("A"));
        assertThat(convertToTitle(2), is("B"));
        assertThat(convertToTitle(3), is("C"));
        assertThat(convertToTitle(26), is("Z"));
        assertThat(convertToTitle(27), is("AA"));
        assertThat(convertToTitle(28), is("AB"));
    }
}
