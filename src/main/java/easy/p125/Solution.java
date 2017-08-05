package easy.p125;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Valid Palindrome Given a string, determine if it is a palindrome, considering only alphanumeric characters and
 * ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c>='0' && c<='9') {
                builder.append(s.charAt(i));
            }
        }

        s = builder.toString();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertThat(isPalindrome("A man, a plan, a canal: Panama"), is(true));
        assertThat(isPalindrome("race a car"), is(false));
    }
}
