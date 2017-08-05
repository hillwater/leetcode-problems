package easy.p28;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Solution {

    /**
     * It's the KMP algorithms
     * 
     * @param needle
     * @return
     */
    public int[] calcOverlapArray(String needle) {
        int[] overlap = new int[needle.length() + 1];
        overlap[0] = -1;
        for (int i = 0; i < needle.length(); i++) {
            overlap[i + 1] = overlap[i] + 1;
            while (overlap[i + 1] > 0 && needle.charAt(i) != needle.charAt(overlap[i + 1] - 1)) {
                overlap[i + 1] = overlap[overlap[i + 1] - 1] + 1;
            }
        }
        return overlap;
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int[] overlapArray = calcOverlapArray(needle);

        int i = 0;

        while (i < haystack.length()) {
            int j;

            for (j = 0; j < needle.length()
                    && i + j < haystack.length()
                    && i + needle.length() - 1 < haystack.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == needle.length()) { // match found
                return i;
            }

            i += Math.max(1, j - overlapArray[j]);
        }

        return -1;
    }

    @Test
    public void test() {
        assertThat(strStr("hello world", "world"), is(6));
        assertThat(strStr("abcdedf", "deda"), is(-1));
        assertThat(strStr("mississippi", "issip"), is(4));
    }
}
