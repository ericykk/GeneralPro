package com.eric.general.algorithm;

import java.util.Stack;

/**
 * 描述: 包含min函数的栈
 *
 * @author eric
 * @create 2018-06-01 下午2:57
 */
public class MinStack {
    private Stack<Integer> valueStack = new Stack<>();
    private Stack<Integer> minValueStack = new Stack<>();


    public void push(int value) {
        valueStack.push(value);
        if (minValueStack.isEmpty()) {
            minValueStack.push(value);
        } else {
            if (minValueStack.peek() > value) {
                minValueStack.push(value);
            } else {
                minValueStack.push(minValueStack.peek());
            }
        }
    }

    public void pop() {
        if (valueStack.size() > 0 && minValueStack.size() > 0) {
            valueStack.pop();
            minValueStack.pop();
        }
    }


    public Integer min() {
        if (valueStack.size() > 0 && minValueStack.size() > 0) {
            return minValueStack.peek();
        } else {
            return null;
        }
    }
}
