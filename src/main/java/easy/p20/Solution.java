package easy.p20;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Stack;

import org.junit.Test;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
 * valid. The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            switch (current) {
            case '(':
            case '[':
            case '{':
                stack.push(current);
                break;
            case ')':
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
                break;
            case ']':
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
                break;
            case '}':
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
                break;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        assertThat(isValid("()"), is(true));
        assertThat(isValid("()[]{}"), is(true));
        assertThat(isValid("(]"), is(false));
        assertThat(isValid("([)]"), is(false));
    }
}
