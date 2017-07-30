package p160;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 * A: a1 → a2 ↘ c1 → c2 → c3 ↗ B: b1 → b2 → b3 begin to intersect at node c1.
 * 
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null. The linked lists must retain their original
 * structure after the function returns. You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int reverse(ListNode head) {
        int count = 0;

        ListNode newHead = null;
        ListNode tmp;
        ListNode current = head;

        while (current != null) {
            tmp = current.next;
            current.next = newHead;
            newHead = current;
            current = tmp;
            count++;
        }

        return count - 1;
    }

    public ListNode getTail(ListNode head) {
        ListNode result = head;

        while (result.next != null) {
            result = result.next;
        }

        return result;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tail = getTail(headA);
        if (getTail(headB) != tail) {
            return null;
        }

        int len1 = reverse(headA);
        int len2 = reverse(headB);
        int len3 = reverse(tail);

        int lenA = (len1 + len2 - len3) / 2;

        ListNode result = headA;
        for (int i = 0; i < lenA; i++) {
            result = result.next;
        }

        return result;
    }

    @Test
    public void test() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        ListNode c3 = new ListNode(8);

        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        assertThat(getIntersectionNode(a1, b1).val, is(6));
        assertThat(a1.next.val, is(2));
        assertThat(a2.next.val, is(6));
        assertThat(b1.next.val, is(4));
        assertThat(b2.next.val, is(5));
        assertThat(b3.next.val, is(6));
        assertThat(c1.next.val, is(7));
    }
}
