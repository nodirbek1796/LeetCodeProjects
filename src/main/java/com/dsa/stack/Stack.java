package com.dsa.stack;

import java.util.Arrays;

public class Stack {

    private int items[];
    private int count = 0;

    public Stack(int n) {
        this.items = new int[n];
    }

    public void push(int item){
        if(count == items.length)
            throw new StackOverflowError();
        items[count++] = item;
    }

    public int peek(){
        if (count == 0)
            throw new IllegalStateException();
        return items[count - 1];
    }

    public int pop(){
        if(count == 0)
            throw new StackOverflowError();
        return items[--count];
    }

    public String toString(){
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}
