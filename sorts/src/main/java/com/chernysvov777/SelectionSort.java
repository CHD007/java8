package com.chernysvov777;

import java.util.Arrays;

public class SelectionSort implements Sorting {
    @Override
    public int[] sort(int[] arrayToSort) {
        int[] sortedArray = Arrays.copyOf(arrayToSort, arrayToSort.length);
        for (int min = 0; min < sortedArray.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] < sortedArray[least]) {
                    least = j;
                }
            }
            int tmp = sortedArray[min];
            sortedArray[min] = sortedArray[least];
            sortedArray[least] = tmp;
        }
        return sortedArray;
    }
}
