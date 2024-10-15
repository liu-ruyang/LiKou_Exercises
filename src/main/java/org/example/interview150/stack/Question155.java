package org.example.interview150.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Question155 {
    public static void main(String[] args) {
        // MinStack stack = new MinStack();
        // stack.push(0);
        // stack.push(1);
        // stack.push(0);
        // stack.getMin();
        // stack.pop();
        // stack.getMin();
    }

}

class MinStack {

    Deque deque;
    List list;

    public MinStack() {
        deque = new LinkedList();
        list = new ArrayList();
    }

    public void push(int val) {
        deque.push(val);
        for (int i = 0; i < list.size(); i++) {
            if ((int) list.get(i) >= val) {
                list.add(i, val);
                break;
            } else if (i == list.size() - 1 && (int) list.get(i) < val) {
                list.add(val);
                break;
            }
        }
        if (list.size() == 0) {
            list.add(val);
        }
    }

    public void pop() {
        int num = (int) deque.pop();
        for (int i = 0; i < list.size(); i++) {
            if ((int) list.get(i) == num) {
                list.remove(i);
                break;
            }
        }
    }

    public int top() {
        return (int) deque.peek();
    }

    public int getMin() {
        return (int) list.get(0);
    }
}