package cc.banzhi.android.algorithmdemo;

import java.util.Stack;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 20. 有效的括号
 * @author: zoufengli01
 * @create: 2022/8/13 18:08
 **/
public class Solution_61 {

    public boolean isValid(String s) {
        if (null == s || "".equals(s)) return false;
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for (char c : chs) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (
                    (c == ')' && stack.pop() != '(') ||
                    (c == '}' && stack.pop() != '{') ||
                    (c == ']' && stack.pop() != '[')
            ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_61 solution_61 = new Solution_61();
        System.out.println(solution_61.isValid("()"));
    }
}
