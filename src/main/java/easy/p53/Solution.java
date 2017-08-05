package easy.p53;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum < 0) {
                sum = 0;
            }

            if (sum > max) {
                max = sum;
            }
        }

        if (max == 0) {
            max = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        assertThat(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }), is(6));
        assertThat(maxSubArray(new int[] { -1, -2, -3, -4, -5 }), is(-1));
    }
}
