package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 51. N 皇后
 * @author: zoufengli01
 * @create: 2022/7/29 20:29
 **/
public class Solution_14 {
    private final List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] strs = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                strs[i][j] = ".";
            }
        }
        backTrace(0, strs);
        return res;
    }

    private void backTrace(int row, String[][] strs) {
        int n = strs.length;
        if (row == n) {
            ArrayList<String> list = new ArrayList<>();
            for (String[] item : strs) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(item[j]);
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!valid(col, row, strs)) {
                continue;
            }
            strs[row][col] = "Q";
            backTrace(row + 1, strs);
            strs[row][col] = ".";
        }
    }

    private boolean valid(int col, int row, String[][] strs) {
        int n = strs.length;
        // 判断行列
        for (int i = 0; i < n; i++) {
            if ("Q".equals(strs[row][i]) || "Q".equals(strs[i][col])) {
                return false;
            }
        }
        // 判断斜线
        for (int i = 0; i < n; i++) {// 行
            for (int j = 0; j < n; j++) {// 列
                if (Math.abs(i - row) == Math.abs(j - col)) {
                    if ("Q".equals(strs[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_14 solution_14 = new Solution_14();
        System.out.println(solution_14.solveNQueens(8));
    }
}
