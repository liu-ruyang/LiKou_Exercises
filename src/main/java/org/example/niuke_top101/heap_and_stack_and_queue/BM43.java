package org.example.niuke_top101.heap_and_stack_and_queue;

import java.util.LinkedList;

public class BM43 {
    LinkedList<Integer> stack1 = new LinkedList();
    LinkedList<Integer> stack2 = new LinkedList();

    public static void main(String[] args) {
        BM43 bm43 = new BM43();
        bm43.push(-1);
        bm43.push(2);
        bm43.min();
        bm43.top();
        bm43.pop();
        bm43.push(1);
        bm43.top();
        bm43.min();
    }

    public void push(int node) {
        if (stack1.isEmpty()) {
            stack2.push(node);
            stack1.push(node);
        } else {
            stack1.push(node);
            stack2.push(Math.min(stack2.peek(), node));
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
