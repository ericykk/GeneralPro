package com.eric.general.algorithm;

import java.util.Stack;

/**
 * 描述:
 * 用两个栈实现队列
 *
 * @author eric
 * @create 2018-05-24 下午6:06
 */
public class QueueAndStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;


    public void appendTail(Integer value) {
        stack1.push(value);
    }

    public Integer deleteHead() throws Exception {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("队列为空！");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
