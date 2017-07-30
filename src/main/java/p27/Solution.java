package p27;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length. Do not allocate
 * extra space for another array, you must do this in place with constant memory. The order of elements can be changed.
 * It doesn't matter what you leave beyond the new length.
 *
 * Example: Given input array nums = [3,2,2,3], val = 3 Your function should return length = 2, with the first two
 * elements of nums being 2.
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }

    @Test
    public void test() {
        int[] nums = new int[] { 3, 2, 2, 3 };
        int length = removeElement(nums, 3);
        assertThat(length, is(2));
        assertThat(nums[0], is(2));
        assertThat(nums[1], is(2));
    }
}
