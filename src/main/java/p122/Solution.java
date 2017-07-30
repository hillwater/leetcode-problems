package p122;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Best Time to Buy and Sell Stock II Say you have an array for which the ith element is the price of a given stock on
 * day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
 * sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int[] nums = new int[prices.length - 1];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prices[i + 1] - prices[i];
        }

        int max = 0;
        for (int value : nums) {
            if (value > 0) {
                max += value;
            }
        }

        return max;
    }

    @Test
    public void test() {
        assertThat(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }), is(7));
        assertThat(maxProfit(new int[] { 7, 6, 4, 3, 1 }), is(0));
    }
}
