package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 5. 最长回文子串
 * @author: zoufengli01
 * @create: 2022/8/10 11:31
 **/
public class Solution_54 {

    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        String res = "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                    continue;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return "".equals(res) ? null : res;
    }

    public String longestPalindrome2(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        String res = "";
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                String item = s.substring(j, i);
                if (valid(item) && item.length() > res.length()) {
                    res = item;
                }
            }
        }
        return "".equals(res) ? null : res;
    }

    private boolean valid(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        int left = 0, right = str.length() - 1;
        while (left < right) {
            char l = str.charAt(left);
            char r = str.charAt(right);
            if (l != r) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution_54 solution_54 = new Solution_54();
        System.out.println(solution_54.longestPalindrome("babad"));
    }
}
