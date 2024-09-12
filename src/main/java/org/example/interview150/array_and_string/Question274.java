package org.example.interview150.array_and_string;

public class Question274 {
    public static void main(String[] args) {
        int[] a = {3, 0, 6, 1, 5};
        new Question274().hIndex(a);
    }

    // 归并排序算法
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 分割数组为两个子数组
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            // 合并两个子数组
            merge(array, left, mid, right);
        }
    }

    // 合并两个子数组
    public static void merge(int[] array, int left, int mid, int right) {
        // 计算两个子数组的长度
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 创建临时数组
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // 将数据复制到临时数组
        System.arraycopy(array, left, leftArray, 0, n1);
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // 合并临时数组并将结果存回原始数组
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 复制剩余的元素（如果有）
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public int hIndex(int[] citations) {
        // 使用归并排序算法对数组进行排序
        mergeSort(citations, 0, citations.length - 1);

        int left = 0, right = citations.length - 1;
        while (left < right) {
            int temp = citations[left];
            citations[left] = citations[right];
            citations[right] = temp;
            left++;
            right--;
        }

        // for (int i = 0; i < citations.length; i++) {
        //     if (citations[i] > 0 && citations[i] - 1 < citations.length && citations[citations[i] - 1] >= citations[i]) {
        //         return citations[i];
        //     }
        // }
        // return 0;

        int result = citations[0];
        while (result >= 1) {
            if (result <= citations.length && citations[result - 1] >= result) {
                return result;
            }
            result--;
        }

        return result;
    }
}
