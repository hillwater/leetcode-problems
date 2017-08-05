package easy.p205;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No
 * two characters may map to the same character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note: You may assume both s and t have the same length.
 */
public class Solution {

    private List<List<Integer>> generateList(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }

            map.get(c).add(i);
        }

        return map.values().stream().sorted((l1, l2) -> {
            if (l1.size() != l2.size()) {
                return l1.size() - l2.size();
            } else {
                return l1.get(0) - l2.get(0);
            }
        }).collect(Collectors.toList());
    }

    public boolean isIsomorphic(String s, String t) {
        List<List<Integer>> listS = generateList(s);
        List<List<Integer>> listT = generateList(t);

        return Objects.equals(listS, listT);
    }

    @Test
    public void test() {
        assertThat(isIsomorphic("egg", "add"), is(true));
        assertThat(isIsomorphic("foo", "bar"), is(false));
        assertThat(isIsomorphic("paper", "title"), is(true));
    }
}
