package org.example.interview150.array_and_string;

import java.util.ArrayList;
import java.util.List;

public class Question68 {
    public static void main(String[] args) {
        String[] words = {"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};
        new Question68().fullJustify(words, 16);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < words.length; ) {
            if (list.size() == 0 && words[i].length() <= maxWidth || count + words[i].length() + 1 <= maxWidth) {
                count += words[i].length() + 1; // +1是单词前面的空格
                if (list.size() == 0) {
                    count--;
                }
                list.add(words[i]);
                i++;
            } else {
                concat(result, list, maxWidth);
                list = new ArrayList<>();
                count = 0;
            }
        }

        // 最后一行是左对齐，不是两端对齐了
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i)).append(" ");
        }
        if (builder.length() > maxWidth) {
            builder.delete(maxWidth, builder.length());
        } else if (builder.length() < maxWidth) {
            builder.append(" ".repeat(maxWidth - builder.length()));
        }
        result.add(builder.toString());

        return result;
    }

    public void concat(List<String> result, ArrayList<String> list, int maxWidth) {
        for (String string : list) {
            maxWidth -= string.length();
        }
        if (list.size() > 1) {
            // 不止一个单词，中间空格需要计算
            int num1 = maxWidth / (list.size() - 1);
            int num2 = maxWidth % (list.size() - 1);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    builder.append(list.get(0));
                } else {    // 前num2个空格处的空格数应该是 num1+1 个
                    if (num2 > 0) {
                        builder.append(" ".repeat(num1)).append(" ").append(list.get(i));
                        num2--;
                    } else {
                        builder.append(" ".repeat(num1)).append(list.get(i));
                    }
                }
            }
            result.add(builder.toString());

        } else {
            // 只有一个单词
            result.add(list.get(0) + " ".repeat(maxWidth));
        }
    }
}
