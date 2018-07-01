package com.chernysvov777;

import java.util.Arrays;

public class BubbleSort implements Sorting {
    @Override
    public int[] sort(int[] arrayToSort) {
        int[] sortedArray = Arrays.copyOf(arrayToSort, arrayToSort.length);
        for (int j = 0; j < sortedArray.length - 1; j++) {
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                }
            }
        }

        return sortedArray;
    }
}
