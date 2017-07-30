package p155;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Stack;

import org.junit.Test;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of the stack. top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class Solution {
    static class MinStack {
        private Stack<Integer> minStack = new Stack<>();
        private Stack<Integer> mainStack = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            mainStack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else if (minStack.peek() >= x) {
                minStack.push(x);
            }
        }

        public void pop() {
            int x = mainStack.pop();
            if (x == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return mainStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    @Test
    public void test() {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        assertThat(stack.top(), is(2));
        assertThat(stack.getMin(), is(1));
        stack.pop();
        stack.push(3);
        stack.push(0);
        assertThat(stack.getMin(), is(0));
        stack.pop();
        assertThat(stack.getMin(), is(1));
    }
}
