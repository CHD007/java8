package com.chernysvov777;

import java.util.Arrays;

/**
 * In quick sort we pick a random element and partition the array,
 * such that all numbers that are less than the partitioning element
 * come before all elements that are greater than it.
 *
 * If we repeatedly partition the array (and its sub-arrays) around
 * an element, the array will eventually become sorted.
 *
 * Quick sort | Runtime: O(n log(n)) average, O(n^2) worst case. Memory: O(log(n))
 */
public class QuickSort implements Sorting {
    @Override
    public int[] sort(int[] arrayToSort) {
        int[] sortedArray = Arrays.copyOf(arrayToSort, arrayToSort.length);

        quickSort(sortedArray, 0, sortedArray.length - 1);

        return sortedArray;
    }

    private void quickSort(int[] array, int left, int right) {
        int index = partition(array, left, right);
        if (left < index - 1) { // sort left side
            quickSort(array, left, index - 1);
        }
        if (index < right) { // sort right side
            quickSort(array, index, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2]; // Pick pivot point

        while (left <= right) {
            // find element on left that should be on right
            while (array[left] < pivot) left++;

            while (array[right] > pivot) right--;

            if (left <= right) {
                swap(array, left, right); // swap elements
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
    }
}
