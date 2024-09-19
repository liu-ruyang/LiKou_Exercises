package org.example.greedy_question;

import java.util.Arrays;

public class Question406 {
    public int[][] reconstructQueue(int[][] people) {
        int[][] queue = new int[people.length][2];

        // 先排序people，身高降序，数量升序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];   // 降序
            }
            return o1[1] - o2[1]; // 升序
        });

        queue[0][0] = people[0][0];
        queue[0][1] = people[0][1];

        for (int i = 1; i < people.length; i++) {
            int index = i;

            queue[index][0] = people[i][0];
            queue[index][1] = people[i][1];

            while (index > people[i][1]) {
                int a = queue[index][0];
                int b = queue[index][1];

                queue[index][0] = queue[index - 1][0];
                queue[index][1] = queue[index - 1][1];

                queue[index - 1][0] = a;
                queue[index - 1][1] = b;
                index--;
            }
        }

        return queue;
    }

}
