package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 866. 回文素数
 * @author: zoufengli01
 * @create: 2022/8/19 16:53
 **/
public class Solution_98 {

    public int primePalindrome(int n) {
        while (true) {
            if (isPrime(n) && reverse(n)) {
                return n;
            }
            n++;
        }
    }

    // 判断素数
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 判断回文
    private boolean reverse(int num) {
        String str = num + "";
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
        Solution_98 solution_98 = new Solution_98();
        System.out.println(solution_98.primePalindrome(6));
    }

}
