package easy.p242;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car", return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, 1 + map.get(c));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }

            int count = map.get(c);
            if (count == 1) {
                map.remove(c);
            } else {
                map.put(c, count - 1);
            }
        }

        return true;
    }

    @Test
    public void test() {
        assertThat(isAnagram("anagram", "nagaram"), is(true));
        assertThat(isAnagram("rat", "car"), is(false));
    }
}
