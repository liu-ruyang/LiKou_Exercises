package org.example.interview150.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Question20 {
    public static void main(String[] args) {
        new Question20().isValid("([])");
    }

    public boolean isValid(String s) {
        Deque list = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            if (list.isEmpty()) {
                list.push(s.charAt(i));
            } else {
                char c = s.charAt(i);
                switch (c) {
                    case '(': {
                        list.push(c);
                        break;
                    }
                    case '[': {
                        list.push(c);
                        break;
                    }
                    case '{': {
                        list.push(c);
                        break;
                    }
                    case ')': {
                        if (!list.isEmpty() && (Character) list.peek() == '(') {
                            list.pop();
                        } else {
                            return false;
                        }
                        break;
                    }
                    case ']': {
                        if (!list.isEmpty() && (Character) list.peek() == '[') {
                            list.pop();

                        } else {
                            return false;
                        }
                        break;

                    }
                    case '}': {
                        if (!list.isEmpty() && (Character) list.peek() == '{') {
                            list.pop();

                        } else {
                            return false;
                        }
                        break;
                        
                    }
                }
            }
            i++;
        }

        return list.isEmpty();

    }
}
