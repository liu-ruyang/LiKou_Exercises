package org.example.interview150.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Question71 {

    public static void main(String[] args) {
        // new Question71().simplifyPath("/home/user/Documents/../Pictures");
        // new Question71().simplifyPath("/.../a/../b/c/../d/./");
        new Question71().simplifyPath("/a//b..");
    }

    public String simplifyPath(String path) {
        path = path + "/";
        StringBuffer res = new StringBuffer();
        Deque deque = new LinkedList<>();

        for (int i = 0; i < path.toCharArray().length; i++) {
            // if (path.charAt(i) == '.') {
            //
            // } else
            if (path.charAt(i) == '/') {
                // 去除重复的'/'
                if (!deque.isEmpty() && (Character) deque.peek() == '/') {
                    deque.pop();
                }
                if (!deque.isEmpty() && (Character) deque.peek() == '/') {
                    deque.pop();
                }
                int count = 0;
                if (!deque.isEmpty() && (Character) deque.peek() == '.') {
                    count = 1;
                    deque.pop();
                    if (!deque.isEmpty() && (Character) deque.peek() == '.') {
                        count++;
                        deque.pop();
                    }
                    if (!deque.isEmpty() && (Character) deque.peek() == '.') {
                        count++;
                    }
                }
                if (count == 1 && !deque.isEmpty() && (Character) deque.peek() == '/') { // 当前路径
                    deque.pop();
                } else if (count == 1 && !deque.isEmpty() && (Character) deque.peek() != '/') { // 当前路径
                    deque.push('.');
                } else if (count == 2 && !deque.isEmpty() && ((Character) deque.peek() == '/' || i == path.length() - 1)) {    // 上一级路径
                    deque.pop();
                    boolean flag = false;
                    while (!deque.isEmpty() && !flag) {
                        Character pop = (Character) deque.pop();
                        if (pop == '/') {
                            // deque.pop();
                            flag = true;
                        }
                    }
                } else if (count == 2 && !deque.isEmpty() && ((Character) deque.peek() != '/' || i == path.length() - 1)) {    // 恢复'.'
                    deque.push('.');
                    deque.push('.');
                } else if (count == 3) {    // 普通文件或目录
                    deque.push('.');
                    deque.push('.');
                }
                if (i != path.length() - 1) {
                    deque.push('/');
                }
                // continue;
            } else {
                deque.push(path.charAt(i));
            }

        }

        deque.forEach(ch -> res.append(ch));
        String result = res.reverse().toString();
        return result.equals("") ? "/" : result;
    }
}
