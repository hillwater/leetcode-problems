package p172;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.
 */
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;

        while(n>0){
            n /= 5;
            count += n;
        }
        return count;
    }

    @Test
    public void test() {
        assertThat(trailingZeroes(1), is(0));
        assertThat(trailingZeroes(4), is(0));
        assertThat(trailingZeroes(5), is(1));
        assertThat(trailingZeroes(10), is(2));
        assertThat(trailingZeroes(25), is(6));
    }
}
