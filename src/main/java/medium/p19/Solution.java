package medium.p19;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        node = head;
        ListNode prev = null;
        int index = 0;
        while (index < count - n) {
            index++;
            prev = node;
            node = node.next;
        }

        if (prev == null) {
            head = node.next;
        } else {
            prev.next = node.next;
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

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = removeNthFromEnd(node1, 2);
        assertThat(head.val, is(1));

        head = head.next;
        assertThat(head.val, is(2));

        head = head.next;
        assertThat(head.val, is(3));

        head = head.next;
        assertThat(head.val, is(5));

        head = head.next;
        assertThat(head, nullValue());
    }
}
