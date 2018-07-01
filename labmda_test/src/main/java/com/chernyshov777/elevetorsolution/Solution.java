package com.chernyshov777.elevetorsolution;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {40, 40, 100, 80, 20};
        int[] B = {3, 3, 2, 2, 3};
        int solution1 = solution.solution(A, B, 3, 5, 200);
        System.out.println(solution1);
    }

    /**
     * Возвращает число остановок лифта.
     *
     * @param A массив, содержащий веса людей
     * @param B массив, содержащий целевые этажи
     * @param M максимальный этаж
     * @param X максимальное число пассажиров в лифте
     * @param Y максимальный вес пассажиров в лифте
     * @return число остановок лифта с учетом ограничей по месту и весу, люди набраются на 0 этаже и едут вверх,
     *          лифт возвращается вниз только, когда высадил всех людей
     */
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        int deliveredPeople = 0;
        int stops = 0;
        while (deliveredPeople < A.length) {
            int currentWeight = 0;
            int currentNumbersOfPeople = 0;
            Set<Integer> floors = new HashSet<>(M);
            while (deliveredPeople < A.length && currentWeight + A[deliveredPeople] <= Y && currentNumbersOfPeople < X) {
                currentWeight += A[deliveredPeople];
                currentNumbersOfPeople++;
                floors.add(B[deliveredPeople]);
                deliveredPeople++;
            }
            stops += floors.size() + 1;
        }
        return stops;
    }
}
