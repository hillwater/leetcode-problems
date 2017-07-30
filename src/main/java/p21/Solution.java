package p21;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        ListNode prev = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current = l1;
                l1 = l1.next;
            } else {
                current = l2;
                l2 = l2.next;
            }

            if (prev != null) {
                prev.next = current;
            }
            prev = current;

            current.next = null;
            if (head == null) {
                head = current;
            }
        }

        if (l1 != null) {
            current = l1;
        }

        if (l2 != null) {
            current = l2;
        }

        if (prev != null) {
            prev.next = current;
        }

        if (head == null) {
            head = current;
        }

        return head;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;

        ListNode mergedList = mergeTwoLists(node1, node2);
        assertThat(mergedList.val, is(1));

        mergedList = mergedList.next;
        assertThat(mergedList.val, is(2));

        mergedList = mergedList.next;
        assertThat(mergedList.val, is(3));

        mergedList = mergedList.next;
        assertThat(mergedList.val, is(4));

        mergedList = mergedList.next;
        assertThat(mergedList.val, is(5));

        mergedList = mergedList.next;
        assertThat(mergedList.val, is(6));

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
