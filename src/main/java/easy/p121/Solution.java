package easy.p121;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Best Time to Buy and Sell Stock Say you have an array for which the ith element is the price of a given stock on day
 * i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design
 * an algorithm to find the maximum profit.
 * 
 * Example 1: Input: [7, 1, 5, 3, 6, 4] Output: 5
 * 
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price) Example 2: Input: [7,
 * 6, 4, 3, 1] Output: 0
 * 
 * In this case, no transaction is done, i.e. max profit = 0.
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
        return max;
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int[] nums = new int[prices.length - 1];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prices[i + 1] - prices[i];
        }

        return maxSubArray(nums);
    }

    @Test
    public void test() {
        assertThat(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }), is(5));
        assertThat(maxProfit(new int[] { 7, 6, 4, 3, 1 }), is(0));
    }
}
