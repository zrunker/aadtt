package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 9. 回文数
 * @author: zoufengli01
 * @create: 2022/7/28 23:28
 **/
public class Solution_10 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String strX = x + "";
        int left = 0, right = strX.length() - 1;
        while (left < right && strX.charAt(left) == strX.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }

    public static void main(String[] args) {
        Solution_10 solution_10 = new Solution_10();
        System.out.println(solution_10.isPalindrome(121));
    }
}
