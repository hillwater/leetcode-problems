package easy.p136;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
/**
 * Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int value : nums) {
            result ^= value;
        }

        return result;
    }

    @Test
    public void test() {
        assertThat(singleNumber(new int[]{1}), is(1));
        assertThat(singleNumber(new int[]{1,2,3,4,3,2,1}), is(4));
    }
}
