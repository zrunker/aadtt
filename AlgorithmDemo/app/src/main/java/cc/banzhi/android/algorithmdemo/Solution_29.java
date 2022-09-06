package cc.banzhi.android.algorithmdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 89. 格雷编码
 * @author: zoufengli01
 * @create: 2022/8/5 23:21
 **/
public class Solution_29 {

    // 格雷码生成公式：G(i) = i ^ (i >> 1)
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_29 solution_29 = new Solution_29();
        System.out.println(solution_29.grayCode(2));
    }
}
