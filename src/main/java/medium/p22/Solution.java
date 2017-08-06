package medium.p22;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        return null;
    }

    @Test
    public void test() {
        assertThat(generateParenthesis(3), equalTo(Lists.newArrayList(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()")));
    }
}
