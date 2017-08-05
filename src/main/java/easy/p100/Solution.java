package easy.p100;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Test
    public void test() {
        TreeNode nodeA1 = new TreeNode(1);
        TreeNode nodeA2 = new TreeNode(2);
        TreeNode nodeA3 = new TreeNode(3);
        TreeNode nodeA4 = new TreeNode(4);

        nodeA1.left = nodeA2;
        nodeA1.right = nodeA3;
        nodeA2.left = nodeA4;

        TreeNode nodeB1 = new TreeNode(1);
        TreeNode nodeB2 = new TreeNode(2);
        TreeNode nodeB3 = new TreeNode(3);
        TreeNode nodeB4 = new TreeNode(4);

        nodeB1.left = nodeB2;
        nodeB1.right = nodeB3;
        nodeB2.left = nodeB4;

        assertThat(isSameTree(nodeA1, nodeB1), is(true));
        assertThat(isSameTree(nodeA2, nodeB2), is(true));
        assertThat(isSameTree(nodeA1, nodeB2), is(false));
        assertThat(isSameTree(nodeA4, nodeB4), is(true));
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
