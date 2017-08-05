package easy.p303;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3 Note: You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class Solution {
    static class NumArray {
        private int[] partialSumArray;

        public NumArray(int[] nums) {
            if (nums.length == 0) {
                return;
            }

            partialSumArray = new int[nums.length];

            partialSumArray[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                partialSumArray[i] = partialSumArray[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (i > 0) {
                return partialSumArray[j] - partialSumArray[i - 1];
            } else {
                return partialSumArray[j];
            }
        }
    }

    @Test
    public void test() {
        int[] nums = new int[] { -2, 0, 3, -5, 2, -1 };

        NumArray numArray = new NumArray(nums);

        assertThat(numArray.sumRange(0, 2), is(1));
        assertThat(numArray.sumRange(2, 5), is(-1));
        assertThat(numArray.sumRange(0, 5), is(-3));
    }
}
