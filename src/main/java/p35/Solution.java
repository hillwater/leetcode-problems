package p35;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4 [1,3,5,6], 0 → 0
 * 
 * 
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right-left)/2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }

        if (target < nums[left]) {
            return left;
        }

        if (target > nums[right]) {
            return right + 1;
        }

        return left;
    }

    @Test
    public void test() {
        assertThat(searchInsert(new int[] { 1, 3, 5, 6 }, 5), is(2));
        assertThat(searchInsert(new int[] { 1, 3, 5, 6 }, 2), is(1));
        assertThat(searchInsert(new int[] { 1, 3, 5, 6 }, 7), is(4));
        assertThat(searchInsert(new int[] { 1, 3, 5, 6 }, 0), is(0));
    }
}
