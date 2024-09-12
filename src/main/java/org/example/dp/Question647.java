package org.example.dp;

public class Question647 {
    public int countSubstrings(String s) {

        Boolean[][] dp = new Boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = false;
            }
        }

        int result = 0;

        // 如果这矩阵是从上到下，从左到右遍历，那么会用到没有计算过的dp[i + 1][j - 1]，也就是根据不确定是不是回文的区间[i+1,j-1]，来判断了[i,j]是不是回文，那结果一定是不对的。
        // 所以一定要从下到上，从左到右遍历，这样保证dp[i + 1][j - 1]都是经过计算的。
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // 当s[i]与s[j]不相等，那没啥好说的了，dp[i][j]一定是false。
                    // 当s[i]与s[j]相等时，这就复杂一些了，有如下三种情况
                    //      情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
                    //      情况二：下标i 与 j相差为1，例如aa，也是回文子串
                    //      情况三：下标：i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，我们看i到j区间是不是回文子串就看aba是不是回文就可以了，那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看dp[i + 1][j - 1]是否为true。
                    if (i == j || j - i == 1) {
                        dp[i][j] = true;
                        // result ++;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        result++;
                    }
                }

            }

        }

        return result;

    }
}
