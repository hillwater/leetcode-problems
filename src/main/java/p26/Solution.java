package p26;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new
 * length. Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example, Given input array nums = [1,1,2], Your function should return length = 2, with the first two elements of
 * nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }

    @Test
    public void test() {
        int[] nums = new int[] { 1, 1, 2, 2, 3, 4, 4, 4 };
        int count = removeDuplicates(nums);

        assertThat(count, is(4));
        assertThat(nums[0], is(1));
        assertThat(nums[1], is(2));
        assertThat(nums[2], is(3));
        assertThat(nums[3], is(4));
    }
}
