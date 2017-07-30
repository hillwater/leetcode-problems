package p171;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 */
public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }

        return result;
    }

    @Test
    public void test() {
        assertThat(titleToNumber("A"), is(1));
        assertThat(titleToNumber("B"), is(2));
        assertThat(titleToNumber("C"), is(3));
        assertThat(titleToNumber("Z"), is(26));
        assertThat(titleToNumber("AA"), is(27));
        assertThat(titleToNumber("AB"), is(28));
    }
}