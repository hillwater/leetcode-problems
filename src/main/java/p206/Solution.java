package p206;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Reverse a singly linked list.
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode tmp;
        ListNode current = head;

        while (current != null) {
            tmp = current.next;
            current.next = newHead;
            newHead = current;
            current = tmp;
        }

        return newHead;
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

        ListNode head = reverseList(node1);
        assertThat(head.val, is(4));

        head = head.next;
        assertThat(head.val, is(3));

        head = head.next;
        assertThat(head.val, is(2));

        head = head.next;
        assertThat(head.val, is(1));

        head = head.next;
        assertThat(head, nullValue());
    }
}
