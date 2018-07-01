package com.chernysvov777;

import java.util.Arrays;

public class MergeSort implements Sorting {
    @Override
    public int[] sort(int[] arrayToSort) {
        int[] sortedArray = Arrays.copyOf(arrayToSort, arrayToSort.length);
        int[] helper = new int[sortedArray.length];

        mergeSort(sortedArray, helper, 0, helper.length - 1);

        return sortedArray;
    }

    /**
     * @param array     массив для сортировки
     * @param helper    вспомогательный массив, в котором хранится будующий отсортированный массив
     * @param low       индекс начала подмассива
     * @param high      индекс конца подмассива
     */
    private void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, helper, low, middle);          // merge left side
            mergeSort(array, helper, middle + 1, high); // merge right side
            merge(array, helper, low, middle, high);
        }
    }

    /**
     * @param array     массив для сортировки
     * @param helper    вспомогательный массив, в котором хранится будующий отсортированный массив
     * @param low       индекс начала подмассива
     * @param middle    индекс середины подмоссива
     * @param high      индекс конца подмассива
     */
    private void merge(int[] array, int[] helper, int low, int middle, int high) {
        /*Copy both halves into a helper array*/
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }


        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /*Iterate through helper array. Compare left and right half, copying back
        * the smaller element from the two halves int the original array*/
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        /*Copy the rest of the left side of the array into the target array*/
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }
}
