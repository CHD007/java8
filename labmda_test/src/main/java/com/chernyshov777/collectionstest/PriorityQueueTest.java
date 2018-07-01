package com.chernyshov777.collectionstest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Apple a = new Apple("a");
        Apple b = new Apple("b");
        PriorityQueue<Apple> apples = new PriorityQueue<>(Comparator.comparing(Apple::getName));
        apples.add(b);
        apples.add(a);
        System.out.println(apples);
    }
}
