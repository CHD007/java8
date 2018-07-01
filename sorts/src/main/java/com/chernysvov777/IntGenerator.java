package com.chernysvov777;

import java.util.Random;

public class IntGenerator {
    public int[] randomInts(int size) {
        int[] ints = new int[size];

        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            ints[i] = rand.nextInt();
        }

        return ints;
    }
}
