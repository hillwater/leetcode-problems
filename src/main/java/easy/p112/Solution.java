package easy.p112;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along
 * the path equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22, 5 / \ 4 8 / / \ 11 13 4 / \ \ 7 2 1 return true, as there
 * exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return (root.left != null && hasPathSum(root.left, sum - root.val))
                || (root.right != null && hasPathSum(root.right, sum - root.val));
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.right = node9;

        assertThat(hasPathSum(node1, 22), is(true));
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
