package p88;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
 * from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int index = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[index--] = nums2[j--];
            } else {
                nums1[index--] = nums1[i--];
            }
        }

        while (i >= 0) {
            nums1[index--] = nums1[i--];
        }

        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }

    @Test
    public void test() {
        int m = 3;
        int n = 4;
        int[] nums1 = new int[m + n];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 5;
        int[] nums2 = new int[] { 2, 4, 6, 8 };

        merge(nums1, m, nums2, n);
        assertThat(nums1, equalTo(new int[] { 1, 2, 3, 4, 5, 6, 8 }));
    }
}
