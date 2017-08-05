package easy.p268;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * For example, Given nums = [0, 1, 3] return 2.
 * 
 * Note: Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space
 * complexity?
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;

        for (int value : nums) {
            sum -= value;
        }

        return sum;
    }

    @Test
    public void test() {
        assertThat(missingNumber(new int[] { 0, 1, 3 }), is(2));
        assertThat(missingNumber(new int[] { 3, 0, 1, 5, 6, 4 }), is(2));
    }
}
