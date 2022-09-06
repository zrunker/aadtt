package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 1371. 每个元音包含偶数次的最长子字符串
 * @author: zoufengli01
 * @create: 2022/8/14 12:13
 **/
public class Solution_65 {

    public int findTheLongestSubstring(String s) {
        if (null == s || "".equals(s)) return 0;
        int maxLen = 0;
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                String item = s.substring(j, i);
                if (evenNum(item)) {
                    maxLen = Math.max(i - j, maxLen);
                }
            }
        }
        return maxLen;
    }

    private boolean evenNum(String s) {
        // aeiou
        int[] counts = new int[5];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a':
                    counts[0] += 1;
                    break;
                case 'e':
                    counts[1] += 1;
                    break;
                case 'i':
                    counts[2] += 1;
                    break;
                case 'o':
                    counts[3] += 1;
                    break;
                case 'u':
                    counts[4] += 1;
                    break;
            }
        }

        for (int count : counts) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_65 solution_65 = new Solution_65();
        System.out.println(solution_65.findTheLongestSubstring("eleetminicoworoep"));
    }
}
