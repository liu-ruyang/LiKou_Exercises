package org.example.niuke_top101.string;

public class BM85 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 验证IP地址
     *
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public String solve(String IP) {
        // write code here
        if (!(IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.' ||
                IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':')) {
            if (IP.contains(".") && judgeIPv4(IP.split("\\."))) {
                // 注意，按照“.”分割时候要写成正则表达式格式
                return "IPv4";
            } else if (IP.contains(":") && judgeIPv6(IP.split(":"))) {
                return "IPv6";
            }
        }

        return "Neither";
    }

    public boolean judgeIPv4(String[] str) {
        if (str.length != 4) return false;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                if (str[i].charAt(j) < '0' || str[i].charAt(j) > '9') return false;
            }
            int val = Integer.valueOf(str[i]);
            if (val < 0 || val > 255) return false;
            // 不能直接使用返回的double类型，因为int类型和double类型计算的时候会自动转换为double类型
            int pow = (int) Math.pow(10, str[i].length() - 1);
            if (str[i].length() > 1 && val / pow == 0)
                return false;
        }
        return true;
    }


    public boolean judgeIPv6(String[] str) {
        if (str.length != 8) return false;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                if (!(str[i].charAt(j) >= '0' && str[i].charAt(j) <= '9' ||
                        str[i].charAt(j) >= 'a' && str[i].charAt(j) <= 'f' ||
                        str[i].charAt(j) >= 'A' && str[i].charAt(j) <= 'F')) return false;
            }
            if (str[i].equals("")) return false;
            if (str[i].length() > 4) return false;
            // if (str.length > 1 && str[0].equals("0") && str[1].equals("0")) return false;
        }

        return true;
    }
}
