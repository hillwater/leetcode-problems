package easy.p198;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
 * money you can rob tonight without alerting the police.
 */
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int[] f = new int[nums.length + 1];
        f[0] = 0;
        f[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            f[i + 1] = Math.max(f[i], f[i - 1] + nums[i]);
        }

        return f[f.length - 1];
    }

    @Test
    public void test() {
        assertThat(rob(new int[] { 1, 2, 3, 4, 5, 6 }), is(12));
        assertThat(rob(new int[] { 1, 3, 5, 2, 4, 6 }), is(12));
        assertThat(rob(new int[] { 3, 1, 5, 6, 4, 2 }), is(12));
    }
}
