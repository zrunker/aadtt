package cc.banzhi.android.algorithmdemo;

import java.util.Stack;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 150. 逆波兰表达式求值
 * @author: zoufengli01
 * @create: 2022/8/13 19:18
 **/
public class Solution_62 {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length <= 0) return Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";
        for (String item : tokens) {
            // +、-、*、/
            if (!operators.contains(item)) {
                stack.push(Integer.valueOf(item));
                continue;
            }
            int a = stack.pop();
            int b = stack.pop();
            switch (item) {
                case "+":
                    stack.push(b + a);
                    break;
                case "-":
                    stack.push(b - a);
                    break;
                case "*":
                    stack.push(b * a);
                    break;
                case "/":
                    stack.push(b / a);
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution_62 solution_62 = new Solution_62();
        System.out.println(solution_62.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

}
