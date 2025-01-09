package org.example.hot100.stack;

import java.util.LinkedList;

public class Question394 {
    public static void main(String[] args) {
//        new Question394().decodeString("3[a]2[bc]");
        new Question394().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
    }

    /**
     * 需要合并字符串的合并，需要合并数字的合并，需要重复的字符串重复，重复完之后检查是否需要再合并
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {

        StringBuilder res = new StringBuilder();
        LinkedList<String> stack = new LinkedList<>();   // 栈中存放需要重复的数据
        for (int i = 0; i < s.length(); ) {
//            if (stack.isEmpty() && !(s.charAt(i) <= '9' && s.charAt(i) >= '0') && s.charAt(i) != '[') {     // 可以直接加进res中
//                res.append(s.charAt(i));
//                i++;
//            } else {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') { // 遇到数字
                StringBuilder num = new StringBuilder(String.valueOf(s.charAt(i)));
                i++;
                while (i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                    num.append(s.charAt(i));
                    i++;
                }
                stack.push(String.valueOf(num));
            } else if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {  // 遇到字母
                StringBuilder str = new StringBuilder(String.valueOf(s.charAt(i)));
                i++;
                while (i < s.length() && s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                    str.append(s.charAt(i));
                    i++;
                }
                if (!stack.isEmpty() && !stack.peek().equals("[")) {
                    stack.push(stack.pop() + str);
                } else {
                    stack.push(String.valueOf(str));
                }
            } else if (s.charAt(i) == '[') {    // 遇到[符号
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            } else if (s.charAt(i) == ']') {    // 遇到]符号
                String str = stack.pop();
                stack.pop();    // 弹出[符号
                String count = stack.pop(); // 弹出重复次数
                String repeatStr = str.repeat(Integer.parseInt(count));

                if (!stack.isEmpty() && !stack.peek().equals("[")) {
                    stack.push(stack.pop() + repeatStr);
                } else {
                    stack.push(repeatStr);
                }
                i++;
            }

//            }
        }

        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}
