package org.example.greedy_question;

public class Question134 {

    public static void main(String[] args) {
        int[] a = {2, 3, 4};
        int[] b = {3, 4, 3};
        int result = new Question134().canCompleteCircuit(a, b);
        System.out.println(result);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int startIndex = 0;
        int rest = 0;

        int totalrest = 0;

        for (int i = 0; i < gas.length; i++) {
            rest = rest + gas[i] - cost[i];
            totalrest = totalrest + gas[i] - cost[i];
            if (rest < 0) {
                rest = 0;
                startIndex = i + 1;
            }
        }

        return startIndex >= gas.length || totalrest < 0 ? -1 : startIndex;

    }
}
