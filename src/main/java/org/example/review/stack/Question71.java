package org.example.review.stack;

import java.util.LinkedList;

public class Question71 {
    public static void main(String[] args) {
        // new Question71().simplifyPath("/home/");
        // new Question71().simplifyPath("/home/user/Documents/../Pictures");
        // new Question71().simplifyPath("/../");
        new Question71().simplifyPath("/.../a/../b/c/../d/./");
    }

    // 逐字符处理
    public String simplifyPath(String path) {
        char[] chars = path.toCharArray();

        LinkedList<String> stack = new LinkedList<>();

        // 1.提取有效路径
        for (int i = 0; i < chars.length; ) {
            StringBuffer buffer = new StringBuffer();
            // 处理斜杠
            while (i < chars.length && chars[i] == '/') i++;
            // 处理非斜杠字符
            while (i < chars.length && chars[i] != '/') {
                buffer.append(chars[i]);
                i++;
            }
            // 处理每个得到的字符串
            if (buffer.toString().equals("..")) {
                // 切换到上一级目录
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!buffer.toString().equals(".")) {
                // 是有效文件夹或文件名（不是当前目录本身）
                stack.push(buffer.toString());
            }
        }

        // 2.拼接路径
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (!pop.equals(""))
                res.insert(0, "/" + pop);
        }

        if (res.toString().equals("")) {
            res.append("/");
        }

        return res.toString();
    }
}
