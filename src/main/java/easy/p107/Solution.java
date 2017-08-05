package easy.p107;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level
 * by level from leaf to root).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7], 3 / \ 9 20 / \ 15 7 return its bottom-up level order
 * traversal as: [ [15,7], [9,20], [3] ]
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<TreeNode>> levelOrderNodeList = new ArrayList<>();
        List<TreeNode> currentLevelList = Arrays.asList(root);

        while (!currentLevelList.isEmpty()) {
            levelOrderNodeList.add(currentLevelList);

            List<TreeNode> nextLevelList = new ArrayList<>();

            for (TreeNode node : currentLevelList) {
                if (node.left != null) {
                    nextLevelList.add(node.left);
                }

                if (node.right != null) {
                    nextLevelList.add(node.right);
                }
            }

            currentLevelList = nextLevelList;
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = levelOrderNodeList.size() - 1; i >= 0; i--) {
            result.add(levelOrderNodeList.get(i).stream().map(node -> node.val).collect(Collectors.toList()));
        }

        return result;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;

        List<List<Integer>> list = Lists.newArrayList(
                Lists.newArrayList(15, 7).subList(0, 2),
                Lists.newArrayList(9, 20),
                Lists.newArrayList(3));

        assertThat(levelOrderBottom(node1), equalTo(list));
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
