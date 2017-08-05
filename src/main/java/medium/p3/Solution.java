package medium.p3;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Longest Substring Without Repeating Characters Given a string, find the length of the longest substring without
 * repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int len = 0;
        int begin = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                int k = map.get(c);
                len = i - k;

                for (int j = begin; j < k; j++) {
                    map.remove(s.charAt(j));
                }

                begin = k + 1;
            } else {
                len++;

                if (len > max) {
                    max = len;
                }
            }

            map.put(c, i);
        }

        return max;
    }

    @Test
    public void test() {
        assertThat(lengthOfLongestSubstring("abcabcbb"), is(3));
        assertThat(lengthOfLongestSubstring("bbbbb"), is(1));
        assertThat(lengthOfLongestSubstring("pwwkew"), is(3));
        assertThat(lengthOfLongestSubstring("dvdf"), is(3));
        assertThat(lengthOfLongestSubstring("tmmzuxt"), is(5));
    }
}
