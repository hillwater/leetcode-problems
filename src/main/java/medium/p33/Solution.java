package medium.p33;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class Solution {
    public int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length-1;
//
//        while (left<right){
//            int mid = left+(right-left)/2;
//
//            if(nums[mid] == target){
//                return mid;
//            }else if(target > nums[mid] && nums[left]<nums[mid]) {
//                left = mid + 1;
//            } else if(target > nums[mid] && nums[left]>nums[mid]) {
//
//            } else if(target < nums[mid] && nums[left] < nums[mid]) {
//
//            } else {
//
//            }
//
//        }
//
//        if(nums[left] == target) {
//            return left;
//        }else {
//            return -1;
//        }

        return -1;
    }

    @Test
    public void test() {
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6), is(2));
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 8), is(-1));
    }
}
