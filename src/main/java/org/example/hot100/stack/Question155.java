package org.example.hot100.stack;

import java.util.LinkedList;

public class Question155 {
    class MinStack {
        public LinkedList<Integer> stack1;
        public LinkedList<Integer> stack2;

        public MinStack() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void push(int val) {
            stack1.push(val);
            if (stack2.isEmpty()) {
                stack2.push(val);
            } else {
                stack2.push(Math.min(stack2.peek(), val));
            }
        }

        public void pop() {
            stack2.pop();
            stack1.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }
}
