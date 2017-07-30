package p108;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST(Binary Search Tree).
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    @Test
    public void test() {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };

        TreeNode root = sortedArrayToBST(nums);

        assertThat(root.val, is(4));
        assertThat(root.left.val, is(2));
        assertThat(root.left.left.val, is(1));
        assertThat(root.left.right.val, is(3));
        assertThat(root.right.left.val, is(5));
        assertThat(root.right.right.val, is(7));
        assertThat(root.right.right.right.val, is(8));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
