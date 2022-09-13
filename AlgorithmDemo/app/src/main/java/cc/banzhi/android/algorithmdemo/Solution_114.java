package cc.banzhi.android.algorithmdemo;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 200. 岛屿数量
 * @author: zoufengli01
 * @create: 2022/9/7 10:26
 **/
public class Solution_114 {

    public int numIslands(int[][] grid) {
        if (grid == null || grid.length <= 0) return 0;
        int islandsNum = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = grid[i][j];
                if (val == 1) {
                    islandsNum++;
                    grid[i][j] = 0;

                    dfs(i, j, grid);
                }
            }
        }
        return islandsNum;
    }

    private void dfs(int i, int j, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // 右
        int right = i + 1;
        if (right < rows) {
            if (grid[right][j] == 1) {
                grid[right][j] = 0;

                dfs(right, j, grid);
            }
        }
        // 下
        int bottom = j + 1;
        if (bottom < cols) {
            if (grid[i][bottom] == 1) {
                grid[i][bottom] = 0;

                dfs(i, bottom, grid);
            }
        }
        // 上
        int top = j - 1;
        if (top >= 0) {
            if (grid[i][top] == 1) {
                grid[i][top] = 0;

                dfs(i, top, grid);
            }
        }
        // 左
        int left = i - 1;
        if (left >= 0) {
            if (grid[left][j] == 1) {
                grid[left][j] = 0;

                dfs(left, j, grid);
            }
        }
    }

    public static void main(String[] args) {
        Solution_114 solution_114 = new Solution_114();
        System.out.println(solution_114.numIslands(new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        }));
    }
}
