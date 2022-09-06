package cc.banzhi.android.algorithmdemo;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 36. 有效的数独
 * @author: zoufengli01
 * @create: 2022/8/1 09:42
 **/
public class Solution_22 {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length <= 0) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if ('.' != c) {
                    if (!set.add(c + " in row " + i) ||
                            !set.add(c + " in col " + j) ||
                            !set.add(c + " in small " + i / 3 + '-' + j / 3))
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_22 solution_22 = new Solution_22();
        System.out.println(solution_22.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }
}
