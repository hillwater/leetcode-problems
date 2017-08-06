package medium.p5;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer. Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 */
public class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int len;
        String result = "";

        // odd
        for (int center = 0; center < s.length(); center++) {
            for (len = 1; center - len >= 0 && center + len < s.length(); len++) {
                if (s.charAt(center - len) != s.charAt(center + len)) {
                    break;
                }
            }

            if (max < (len - 1) * 2 + 1) {
                max = (len - 1) * 2 + 1;
                result = s.substring(center - len + 1, center + len);
            }
        }

        // even
        for (int center = 0; center < s.length(); center++) {
            for (len = 1; center - len + 1 >= 0 && center + len < s.length(); len++) {
                if (s.charAt(center - len + 1) != s.charAt(center + len)) {
                    break;
                }
            }

            if (max < (len - 1) * 2) {
                max = (len - 1) * 2;
                result = s.substring(center - len + 2, center + len);
            }
        }

        return result;
    }

    @Test
    public void test() {
        assertThat(longestPalindrome("babad"), is("bab"));
        assertThat(longestPalindrome("cbbd"), is("bb"));
    }
}
