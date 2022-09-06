package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 22. 括号生成
 * @author: zoufengli01
 * @create: 2022/7/26 10:07
 **/
public class Solution_4 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, "", res);
        return res;
    }

    // 理解成二叉树，每个节点不是左括号就是右括号，DFS遍历，前序遍历
    private void dfs(int nL, int nR, String parenthesis, List<String> res) {
        // nL 和 nR 分别代表左右括号剩余的数量
        if (nL < 0 || nR < 0) {
            return;
        }
        if (nL == 0 && nR == 0) {
            res.add(parenthesis);
            return;
        }
        dfs(nL - 1, nR, parenthesis + "(", res);
        // 有效括号条件
        if (nL >= nR) {
            return;
        }
        dfs(nL, nR - 1, parenthesis + ")", res);
    }

    public static void main(String[] args) {
        Solution_4 solution_4 = new Solution_4();
        List<String> list = solution_4.generateParenthesis(10);

        for (String item : list) {
            System.out.println(item);
        }
    }
}
