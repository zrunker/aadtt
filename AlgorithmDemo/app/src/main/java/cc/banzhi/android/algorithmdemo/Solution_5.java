package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 168. Excel表列名称
 * @author: zoufengli01
 * @create: 2022/7/27 10:28
 **/
public class Solution_5 {

    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) ((columnNumber % 26) + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution_5 solution_5 = new Solution_5();
        System.out.println(solution_5.convertToTitle(51));
    }
}
