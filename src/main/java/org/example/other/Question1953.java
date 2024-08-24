package org.example.other;

public class Question1953 {
    public long numberOfWeeks(int[] milestones) {
        int maxTime = Integer.MIN_VALUE;
        long sum = 0;
        for (int milestone : milestones) {
            maxTime = maxTime >= milestone ? maxTime : milestone;
            sum += milestone;
        }
        long rest = sum - maxTime;
        return (rest + 1 >= maxTime) ? sum : (2L * rest + 1);
    }
}
