package org.example.review.dp;

public class Question5 {
    public static void main(String[] args) {
        new Question5().longestPalindrome("qbmhukucteihghldwdobtvgwwnhflpceiwhbkmvxavmqxedfndegztlpjptpdowwavemasyrjxxnhldnloyizyxgqlhejsdylvkpdzllrzoywfkcamhljminikvwwvqlerdilrdgzifojjlgeayprejhaequyhcohoeonagsmfrqhfzllobwjhxdxzadwxiglvzwiqyzlnamqqsastxlojpcsleohgtcuzzrvwzqugyimaqtorkafyebrgmrfmczwiexdzcokbqymnzigifbqzvfzjcjuugdmvegnvkgbmdowpacyspszvgdapklrhlhcmwkwwqatfswmxyfnxkepdotnvwndjrcclvewomyniaefhhcqkefkyovqxyswqpnysafnydbiuanqphfhfbfovxuezlovokrsocdqrqfzbqhntjafzfjisexcdlnjbhwrvnyabjbshqsxnaxhvtmqlfgdumtpeqzyuvmbkvmmdtywquydontkugdayjqewcgtyajofmbpdmykqobcxgqivmpzmhhcqiyleqitojrrsknhwepoxawpsxcbtsvagybnghqnlpcxlnshihcjdjxxjjwyplnemojhodksckmqdvnzewhzzuswzctnlyvyttuhlreynuternbqonlsfuchxtsyhqlvifcxerzqepthwqrsftaquzuxwcmjjulvjrkatlfqshpyjsbaqwawgpabkkjrtchqmriykbdsxwnkpaktrvmxjtfhwpzmieuqevlodtroiulzgbocrtiuvpywtcxvajkpfmaqckgrcmofkxynjxgvxqvkmhdbvumdaprijkjxxvpqnxakiavuwnifvyfolwlekptxbnctjijppickuqhguvtoqfgepcufbiysfljgmfepwyaxusvnsratn");
    }

    /**
     * 本题采用自左下角向右上角遍历顺序（编写稍微麻烦）
     * 等效于：从下到上，从左到右遍历（原因是，二者都是 每个单元 依赖于 左、左下、下 三个单元）
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        String res = s.substring(0, 1);

        char[] ss = s.toCharArray();

        for (int j = 1; j < dp.length; j++) {
            for (int i = 0; i < dp.length; i++) {
                if (i + j < dp.length) {
                    if (i + 1 == i + j && ss[i] == ss[i + j]) {
                        dp[i][i + j] = true;
                    } else if (dp[i + 1][i + j - 1] && ss[i] == ss[i + j]) {
                        dp[i][i + j] = true;
                    }
                    if (dp[i][i + j]) {
                        res = res.length() >= j + 1 ? res : s.substring(i, i + j + 1);
                    }
                }
            }
        }
        return res;
    }
}
