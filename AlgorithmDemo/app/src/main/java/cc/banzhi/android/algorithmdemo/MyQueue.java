package cc.banzhi.android.algorithmdemo;

import java.util.Stack;

/**
 * @program: AlgorithmDemo
 * @description: 力扣 232. 用栈实现队列
 * @author: zoufengli01
 * @create: 2022/8/13 18:24
 **/
public class MyQueue {
    private final Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> inStack = new Stack<>();
        while (!stack.isEmpty()) {
            inStack.push(stack.pop());
        }
        inStack.push(x);
        while (!inStack.isEmpty()) {
            stack.push(inStack.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
