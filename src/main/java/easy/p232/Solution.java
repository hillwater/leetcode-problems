package easy.p232;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Stack;

import org.junit.Test;

/**
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. pop() -- Removes the element from in front of queue. peek() -- Get
 * the front element. empty() -- Return whether the queue is empty. Notes: You must use only standard operations of a
 * stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid. Depending on your
 * language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended
 * queue), as long as you use only standard operations of a stack. You may assume that all operations are valid (for
 * example, no pop or peek operations will be called on an empty queue).
 */
public class Solution {
    static class MyQueue {
        private Stack<Integer> mainStack = new Stack<>();
        private Stack<Integer> secondStack = new Stack<>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!mainStack.empty()) {
                secondStack.push(mainStack.pop());
            }

            mainStack.push(x);

            while (!secondStack.empty()) {
                mainStack.push(secondStack.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return mainStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return mainStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return mainStack.empty();
        }
    }

    @Test
    public void test() {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);

        assertThat(queue.peek(), is(1));
        assertThat(queue.pop(), is(1));
        queue.pop();
        assertThat(queue.empty(), is(true));
    }
}
