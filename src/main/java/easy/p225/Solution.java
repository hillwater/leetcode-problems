package easy.p225;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

/**
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class Solution {
    public static class MyStack {
        Queue<Integer> mainQueue = new ArrayDeque<>();
        Queue<Integer> secondQueue = new ArrayDeque<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            while (!mainQueue.isEmpty()) {
                secondQueue.offer(mainQueue.poll());
            }

            mainQueue.offer(x);
            while (!secondQueue.isEmpty()) {
                mainQueue.offer(secondQueue.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return mainQueue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return mainQueue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return mainQueue.isEmpty();
        }
    }


    @Test
    public void test() {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        assertThat(stack.top(), is(2));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
        assertThat(stack.empty(), is(true));

    }
}
