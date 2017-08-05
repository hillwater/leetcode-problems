package easy.p67;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * 
 */
public class Solution {
    public String addBinary(String a, String b) {
        int flag = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder builder = new StringBuilder();

        while (i >= 0 && j >= 0) {
            int sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + flag;
            i--;
            j--;
            if (sum < 2) {
                builder.append(sum);
                flag = 0;
            } else {
                builder.append(sum - 2);
                flag = 1;
            }
        }

        while (i >= 0) {
            int sum = (a.charAt(i) - '0') + flag;
            i--;
            if (sum < 2) {
                builder.append(sum);
                flag = 0;
            } else {
                builder.append(sum - 2);
                flag = 1;
            }
        }

        while (j >= 0) {
            int sum = (b.charAt(j) - '0') + flag;
            j--;
            if (sum < 2) {
                builder.append(sum);
                flag = 0;
            } else {
                builder.append(sum - 2);
                flag = 1;
            }
        }

        if (flag > 0) {
            builder.append(1);
        }

        return builder.reverse().toString();
    }

    @Test
    public void test() {
        assertThat(addBinary("11", "1"), is("100"));
        assertThat(addBinary("101", "10001"), is("10110"));
        assertThat(addBinary("1111", "1111"), is("11110"));
    }
}
