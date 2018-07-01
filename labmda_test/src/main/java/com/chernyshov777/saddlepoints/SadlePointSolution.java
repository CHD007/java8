package com.chernyshov777.saddlepoints;

public class SadlePointSolution {

    public static void main(String[] args) {
        SadlePointSolution sadlePointSolution = new SadlePointSolution();
        int[][] A = new int[4][4];
        A[0][0] = 0;
        A[0][1] = 1;
        A[0][2] = 9;
        A[0][3] = 3;

        A[1][0] = 7;
        A[1][1] = 5;
        A[1][2] = 8;
        A[1][3] = 3;

        A[2][0] = 9;
        A[2][1] = 2;
        A[2][2] = 9;
        A[2][3] = 4;

        A[3][0] = 4;
        A[3][1] = 6;
        A[3][2] = 7;
        A[3][3] = 1;
        int solution = sadlePointSolution.solution(A);
        System.out.println(solution);
    }

    public int solution(int[][] A) {
        int saddlePointNumbers = 0;
        for (int P = 1; P < A.length - 1; P++) {
            for (int Q = 1; Q < A[0].length - 1; Q++) {
                if ((A[P][Q] < A[P][Q-1] && A[P][Q] < A[P][Q+1] && A[P][Q] > A[P-1][Q] && A[P][Q] > A[P+1][Q])
                        || (A[P][Q] > A[P][Q-1] && A[P][Q] > A[P][Q+1] && A[P][Q] < A[P-1][Q]) && A[P][Q] < A[P+1][Q]) {
                    saddlePointNumbers++;
                }
            }
        }
        return saddlePointNumbers;
    }
}
