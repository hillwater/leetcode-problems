package medium.p2;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;

        ListNode head = null;

        ListNode prev = null;

        while (l1 != null && l2 != null) {

            int sum = flag + l1.val + l2.val;

            if (sum >= 10) {
                flag = 1;
                sum -= 10;
            } else {
                flag = 0;
            }

            ListNode node = new ListNode(sum);

            if (prev != null) {
                prev.next = node;
            }

            prev = node;

            if (head == null) {
                head = node;
            }

            l1 = l1.next;
            l2 = l2.next;

        }

        while (l1 != null) {

            int sum = flag + l1.val;

            if (sum >= 10) {
                flag = 1;
                sum -= 10;
            } else {
                flag = 0;
            }

            ListNode node = new ListNode(sum);

            if (prev != null) {
                prev.next = node;
            }

            prev = node;

            if (head == null) {
                head = node;
            }

            l1 = l1.next;
        }


        while (l2 != null) {

            int sum = flag + l2.val;

            if (sum >= 10) {
                flag = 1;
                sum -= 10;
            } else {
                flag = 0;
            }

            ListNode node = new ListNode(sum);

            if (prev != null) {
                prev.next = node;
            }

            prev = node;

            if (head == null) {
                head = node;
            }

            l2 = l2.next;
        }


        if(flag>0) {
            ListNode node = new ListNode(flag);

            if (prev != null) {
                prev.next = node;
            }

            prev = node;

            if (head == null) {
                head = node;
            }
        }


        return head;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;

        ListNode head = addTwoNumbers(node1, node4);
        assertThat(head.val, is(7));

        head = head.next;
        assertThat(head.val, is(0));

        head = head.next;
        assertThat(head.val, is(8));

        head = head.next;
        assertThat(head, nullValue());
    }

}
