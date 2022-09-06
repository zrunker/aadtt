package cc.banzhi.android.algorithmdemo;

import java.util.Stack;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 155. 最小栈
 * @author: zoufengli01
 * @create: 2022/8/11 15:53
 **/
class MinStack {
    private final Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        min = Math.min(min, val);
    }

    public int pop() {
        int res = stack.pop();

        min = Integer.MAX_VALUE;
        for (int item : stack) {
            min = Math.min(min, item);
        }

        return res;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

