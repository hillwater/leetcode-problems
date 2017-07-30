package p203;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = null;
        ListNode prev = null;
        ListNode current = head;
        ListNode tmp;

        while (current != null) {
            tmp = current.next;

            if (current.val != val) {
                if (prev != null) {
                    prev.next = current;
                }

                prev = current;
                current.next = null;

                if (newHead == null) {
                    newHead = current;
                }
            }

            current = tmp;
        }

        return newHead;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode head = removeElements(node1, 6);
        assertThat(head.val, is(1));

        head = head.next;
        assertThat(head.val, is(2));

        head = head.next;
        assertThat(head.val, is(3));

        head = head.next;
        assertThat(head.val, is(4));

        head = head.next;
        assertThat(head.val, is(5));

        head = head.next;
        assertThat(head, nullValue());
    }
}
