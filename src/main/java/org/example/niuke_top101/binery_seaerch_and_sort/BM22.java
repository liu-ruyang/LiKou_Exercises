package org.example.niuke_top101.binery_seaerch_and_sort;

public class BM22 {
    public static void main(String[] args) {
        new BM22().compare("1.1", "2.1");
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 比较版本号
     *
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public int compare(String version1, String version2) {
        // write code here
        String[] nums1 = version1.split("\\."); // "." 在正则中是特殊符号，需要使用双斜杠 \\ 转义，表示字面意义上的点 .
        String[] nums2 = version2.split("\\.");

        for (int i = 0; i < nums1.length; i++) {
            if (i >= nums2.length) return 1;
            int num1 = Integer.valueOf(nums1[i]);
            int num2 = Integer.valueOf(nums2[i]);
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
        }
        for (int i = nums1.length; i < nums2.length; i++) {
            if (Integer.valueOf(nums2[i]) != 0) return -1;
        }
        return 0;

    }
}
