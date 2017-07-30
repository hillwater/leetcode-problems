package p169;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2
 * ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int result = nums[0];
        for (int value : nums) {
            if (value == result) {
                count++;
            } else if (count > 1) {
                count--;
            } else {
                result = value;
            }
        }

        return result;
    }

    @Test
    public void test() {
        assertThat(majorityElement(new int[] { 6, 5, 5 }), is(5));
        assertThat(majorityElement(new int[] { 1, 2, 2, 4, 2, 2, 6 }), is(2));
        assertThat(majorityElement(new int[] { 2, 2, 2, 2, 1, 1, 1 }), is(2));
    }
}
