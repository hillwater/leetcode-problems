package easy.p226;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Invert a binary tree.
 <p>
       4
     /   \
    2     7
   / \   / \
  1   3 6   9

  to
       4
     /   \
    7     2
   / \   / \
  9   6 3   1
 </p>
 */
public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode root = invertTree(node1);

        assertThat(root.val, is(4));
        assertThat(root.left.val, is(7));
        assertThat(root.right.val, is(2));
        assertThat(root.left.left.val, is(9));
        assertThat(root.left.right.val, is(6));
        assertThat(root.right.left.val, is(3));
        assertThat(root.right.right.val, is(1));
    }
}
