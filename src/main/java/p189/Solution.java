package p189;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class Solution {
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 0);
        assertThat(nums, equalTo(new int[]{1, 2, 3, 4, 5, 6, 7}));

        rotate(nums, 3);
        assertThat(nums, equalTo(new int[]{5, 6, 7, 1, 2, 3, 4}));

        rotate(nums, 100);
        assertThat(nums, equalTo(new int[]{3, 4, 5, 6, 7, 1, 2}));
    }
}