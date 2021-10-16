package com.dsa.stack;

import java.util.Arrays;

public class TwoStacks {
    private final int[] items;
    private int count1 , count2 ;

    public TwoStacks(int n) {
        this.items = new int[n];
        count2 = n / 2;
    }

    public void pushOne(int item){
        if(count1 == items.length / 2)
            throw new StackOverflowError();
        items[count1++] = item;
    }

    public void pushTwo(int item){
        if (count2 == items.length - 1)
            throw new StackOverflowError();
        items[count2++] = item;
    }

    public int popOne(){
        if(count1 == 0)
            throw new StackOverflowError();
        return items[--count1];
    }

    public int popTwo(){
        if (count2 == items.length / 2)
            throw new StackOverflowError();
        return items[--count2];
    }

    public int peekOne(){
        if (count1 == 0)
            throw new IllegalArgumentException();
        return items[count1 - 1];
    }

    public int peekTwo(){
        if (count2 == items.length / 2)
            throw new IllegalArgumentException();
        return items[count2 - 1];
    }

    public String toString(){
        var content = Arrays.copyOfRange(items, 0, count2);
        return Arrays.toString(content);
    }
}
