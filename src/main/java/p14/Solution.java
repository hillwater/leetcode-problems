package p14;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int index = 0;
        String firstStr = strs[0];

        for (; index < firstStr.length(); index++) {
            boolean flag = true;

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= index || strs[j].charAt(index) != firstStr.charAt(index)) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                break;
            }
        }

        return firstStr.substring(0, index);
    }

    @Test
    public void test() {
        assertThat(longestCommonPrefix(new String[] { "aaaabb", "aaa", "aaaabcd" }), is("aaa"));
    }
}
