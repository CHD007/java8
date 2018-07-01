package com.chernysvov777;

import java.util.Arrays;

public class SortsMain {
    public static void main(String[] args) {
        IntGenerator intGenerator = new IntGenerator();
        int[] ints = intGenerator.randomInts(10000);

        printArray(ints);


        System.out.println("bubble sort time: " + sort(new BubbleSort(), ints));
        System.out.println("selection sort time: " + sort(new SelectionSort(), ints));
        System.out.println("merge sort time: " + sort(new MergeSort(), ints));

    }

    private static void printArray(int[] a) {
        System.out.println("An array: ");
        Arrays.stream(a)
                .forEach(System.out::println);
    }

    private static long sort(Sorting sorting, int[] array) {
        long before = System.nanoTime();
        sorting.sort(array);
        long after = System.nanoTime();
        return after - before;
    }
}
