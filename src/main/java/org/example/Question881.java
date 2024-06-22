package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Question881 {

    public static void main(String[] args) {
        int[] a = {1, 2};
        new Question881().numRescueBoats(a, 3);
    }

    public int numRescueBoats(int[] people, int limit) {

        List<Integer> list = Arrays.stream(people).boxed().collect(Collectors.toList());    // 将nums数组转换为list
        list.sort(Collections.reverseOrder());

        int left = 0, right = people.length - 1;
        int count = 0;
        while (left <= right) {
            count++;
            if (left == right) {
                break;
            }
            if (list.get(left) + list.get(right) <= limit) {
                left++;
                right--;
            } else
                left++;
        }
        return count;
    }
}
