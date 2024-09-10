package org.example.interview150.array_and_string;

public class Question88 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        new Question88().merge(a, 3, b, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];

        int i = 0, j = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                sorted[i + j] = nums1[i];
                i++;
            } else {
                sorted[i + j] = nums2[j];
                j++;
            }
        }

        while (i < m) {
            sorted[i + n] = nums1[i];
            i++;
        }
        while (j < n) {
            sorted[j + m] = nums1[j];
            j++;
        }

        System.arraycopy(sorted, 0, nums1, 0, sorted.length);
    }
}
