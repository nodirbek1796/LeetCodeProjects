package com.dsa.queue;

import java.util.Arrays;
import java.util.Stack;

public class StackQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack1 = new Stack<>();

    public void enqueue(int item){
        stack.push(item);
    }

    public int dequeue(){
        if (stack.isEmpty())
            return -1;
        int item;
        while (!stack.isEmpty()){
            stack1.push(stack.pop());
        }
        item = stack1.pop();
        while (!stack1.isEmpty()){
            stack.push(stack1.pop());
        }
        return item;
    }

    public void print(){
        System.out.println(Arrays.toString(stack.toArray()));
    }
}
