package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 14. 最长公共前缀
 * @author: zoufengli01
 * @create: 2022/7/28 22:52
 **/
public class Solution_9 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String item = strs[i];
            int j = 0;
            while (j < item.length() && j < prefix.length() && item.charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

    public static void main(String[] args) {
        Solution_9 solution_9 = new Solution_9();
        System.out.println(
                solution_9.longestCommonPrefix(new String[]{"flower", "flow", "flight"})
        );
    }
}
