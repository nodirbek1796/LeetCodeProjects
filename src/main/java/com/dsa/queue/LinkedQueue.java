package com.dsa.queue;

public class LinkedQueue {
    private static class Node{
        private final int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    public LinkedQueue(){
        first = null;
        last = null;
    }

    public void enqueue(int item){
        Node node = new Node(item);
        if (isEmpty()){
            first = node;
        }else {
            last.next = node;
        }
        last = node;
        size++;
    }

    public int dequeue(){
        if (isEmpty())
            return  - 1;
        Node second;
        if (first == last){
            second = first;
            first = null;
            last = null;
        }
        else {
            second = first.next;
            first.next = null;
            first = second;
        }
        size--;
        return second.value;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return first == null && last == null;
    }

    public void print(){
        Node current = first;
        while (current != null){
            System.out.println(current.value + " ");
            current = current.next;
        }
    }
}
