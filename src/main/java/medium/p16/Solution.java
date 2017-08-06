package medium.p16;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int result = target;

        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int tmp = nums[j] + nums[k];
                if (tmp == sum) {
                    return target;
                } else if (tmp > sum) {
                    k--;
                } else {
                    j++;
                }

                if (Math.abs(tmp - sum) < min) {
                    min = Math.abs(tmp - sum);
                    result = tmp + nums[i];
                }
            }

        }

        return result;

    }

    @Test
    public void test() {
        assertThat(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1), is(2));
    }
}
