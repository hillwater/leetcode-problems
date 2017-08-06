package medium.p24;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be
 * changed.
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            int tmp = current.val;

            current.val = current.next.val;
            current.next.val = tmp;

            current = current.next.next;
        }

        return head;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head = swapPairs(node1);
        assertThat(head.val, is(2));

        head = head.next;
        assertThat(head.val, is(1));

        head = head.next;
        assertThat(head.val, is(4));

        head = head.next;
        assertThat(head.val, is(3));

        head = head.next;
        assertThat(head, nullValue());
    }
}
