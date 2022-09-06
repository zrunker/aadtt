package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 剑指 Offer 05. 替换空格
 * @author: zoufengli01
 * @create: 2022/8/18 15:23
 **/
public class Solution_89 {

    public String replaceSpace(String s) {
        String t = " ";
        if (s == null || "".equals(s) || !s.contains(t)) return s;
        for (int i = -1; (i = s.indexOf(t, i + 1)) >= 0; ) {
            s = s.substring(0, i) + "%20" + s.substring(i + 1);
        }
        return s;
    }

    public static void main(String[] args) {
        Solution_89 solution_89 = new Solution_89();
        System.out.println(solution_89.replaceSpace("We are happy."));
    }

}
