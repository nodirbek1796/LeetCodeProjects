package com.dsa.queue;

import java.util.Arrays;

public class PriorityQueue {
    private final int [] items;
    private int front;
    private int rear;

    public PriorityQueue(int n){
        items = new int[n];
    }

    public void enqueue(int item){
        if(rear == items.length)
            throw new StackOverflowError();
        if (rear == 0)
            items[rear++] = item;
        else {
            int index, temp;
            boolean isSmall = true;
            for (int i = 0; i < items.length && isSmall; i++) {
                if (items[i] < item) {
                    temp = items[i];
                    items[i] = item;
                    items[++i] = temp;
                    isSmall = false;
                }
            }
            if (isSmall)
                return;
        }
    }

    public int dequeue(){
        var item = items[front];
        items[front] = 0;
        front++;
        return item;
    }

    public void print(){
        System.out.println(Arrays.toString(items));
    }
}
