package com.dsa.stack;

public class Main {
    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks(20);
        twoStacks.pushOne(15);
        twoStacks.pushOne(46);
        twoStacks.pushOne(16);
        twoStacks.pushOne(20);

        twoStacks.pushTwo(78);
        twoStacks.pushTwo(100);
        twoStacks.pushTwo(49);
        twoStacks.pushTwo(46);
        System.out.println(twoStacks);
    }
}
