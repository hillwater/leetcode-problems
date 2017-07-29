package p83;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (prev == null) {
                prev = current;
            } else if (prev != null && current.val != prev.val) {
                prev.next = current;
                prev = current;
            }

            ListNode tmp = current;
            current = current.next;
            tmp.next = null;
        }

        return head;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode deleteDupList = deleteDuplicates(node1);
        assertThat(deleteDupList.val, is(1));

        deleteDupList = deleteDupList.next;
        assertThat(deleteDupList.val, is(2));

        deleteDupList = deleteDupList.next;
        assertThat(deleteDupList.val, is(3));

        assertThat(deleteDupList.next, nullValue());
    }
}
