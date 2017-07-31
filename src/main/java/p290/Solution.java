package p290;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in
 * str.
 * 
 * Examples: pattern = "abba", str = "dog cat cat dog" should return true. pattern = "abba", str = "dog cat cat fish"
 * should return false. pattern = "aaaa", str = "dog cat cat dog" should return false. pattern = "abba", str = "dog dog
 * dog dog" should return false. Notes: You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters separated by a single space.
 */
public class Solution {
    private List<List<Integer>> generatePatternList(String pattern) {
        Map<Character, List<Integer>> patternMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!patternMap.containsKey(c)) {
                patternMap.put(c, new ArrayList<>());
            }

            patternMap.get(c).add(i);
        }

        return patternMap.values().stream().sorted((l1, l2) -> {
            if (l1.size() == l2.size()) {
                return l1.get(0) - l2.get(0);
            } else {
                return l1.size() - l2.size();
            }
        }).collect(Collectors.toList());
    }

    private List<List<Integer>> generateStrList(String str) {
        Map<String, List<Integer>> patternMap = new HashMap<>();

        String[] array = str.split(" ");
        for (int i = 0; i < array.length; i++) {
            String c = array[i];
            if (!patternMap.containsKey(c)) {
                patternMap.put(c, new ArrayList<>());
            }

            patternMap.get(c).add(i);
        }

        return patternMap.values().stream().sorted((l1, l2) -> {
            if (l1.size() == l2.size()) {
                return l1.get(0) - l2.get(0);
            } else {
                return l1.size() - l2.size();
            }
        }).collect(Collectors.toList());
    }

    public boolean wordPattern(String pattern, String str) {
        List<List<Integer>> patternList = generatePatternList(pattern);
        List<List<Integer>> strList = generateStrList(str);
        return Objects.equals(patternList, strList);
    }

    @Test
    public void test() {
        assertThat(wordPattern("abba", "dog cat cat dog"), is(true));
        assertThat(wordPattern("abba", "dog cat cat fish"), is(false));
        assertThat(wordPattern("aaaa", "dog cat cat dog"), is(false));
        assertThat(wordPattern("abba", "dog dog dog dog"), is(false));
    }
}
