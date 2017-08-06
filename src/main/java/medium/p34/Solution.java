package medium.p34;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int rangeLeft = -1;
        int rangeRight = -1;

        if(nums.length == 0) {
            return new int[] { rangeLeft, rangeRight };
        }


        //
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (target == nums[left]) {
            rangeLeft = left;
        }

        //
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (target == nums[left]) {
            rangeRight = left;
        }

        return new int[] { rangeLeft, rangeRight };
    }

    @Test
    public void test() {
        assertThat(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8), equalTo(new int[] { 3, 4 }));
        assertThat(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6), equalTo(new int[] { -1, -1 }));
    }
}
