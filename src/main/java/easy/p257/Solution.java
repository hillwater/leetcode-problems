package easy.p257;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p/>
 * For example, given the following binary tree:
 * <p/>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p/>
 * ["1->2->5", "1->3"]
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

    private void binaryTreePaths(TreeNode root, List<String> result, String parent) {
        if (root.left != null) {
            binaryTreePaths(root.left, result, parent + "->" + root.val);
        }

        if (root.right != null) {
            binaryTreePaths(root.right, result, parent + "->" + root.val);
        }

        if (root.left == null && root.right == null) {
            String tmp = parent + "->" + root.val;
            result.add(tmp.substring(2, tmp.length()));
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        List<String> result = new ArrayList<>();

        binaryTreePaths(root, result, "");

        return result;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        assertThat(binaryTreePaths(node1), equalTo(Lists.newArrayList("1->2->5", "1->3")));
    }
}
