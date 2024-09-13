package org.example.interview150.array_and_string;

public class Question134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] arrivedStatus = new int[gas.length];

        arrivedStatus[0] = 0;
        int minArrivedStatus = 0;
        int minIndex = 0;

        for (int i = 1; i < cost.length; i++) {
            arrivedStatus[i] = arrivedStatus[i - 1] + gas[i - 1] - cost[i - 1];
            if (arrivedStatus[i] < minArrivedStatus) {
                minArrivedStatus = arrivedStatus[i];
                minIndex = i;
            }
        }

        if (arrivedStatus[gas.length - 1] + gas[gas.length - 1] - cost[cost.length - 1] < 0) {
            return -1;
        }
        return minIndex;
    }
}
