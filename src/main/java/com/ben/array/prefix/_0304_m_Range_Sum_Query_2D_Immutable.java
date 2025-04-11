package com.ben.array.prefix;

public class _0304_m_Range_Sum_Query_2D_Immutable {
    class NumMatrix {

        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int r = matrix.length;
            int c = matrix[0].length;
            preSum = new int[r + 1][c + 1];

            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
        }
    }
}
