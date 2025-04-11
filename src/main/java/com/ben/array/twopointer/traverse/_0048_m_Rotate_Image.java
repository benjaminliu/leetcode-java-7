package com.ben.array.twopointer.traverse;

import com.ben.common.PrintUtil;

public class _0048_m_Rotate_Image {

    public static void main(String[] args) {
        int[][] matric = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        new Solution().rotate(matric);

        PrintUtil.printArrayOfArray(matric);
    }

    static
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;

            //reverse each column
            for (int c = 0; c < n; c++) {
                int left = 0;
                int right = n - 1;

                while (left < right) {
                    int tmp = matrix[left][c];
                    matrix[left][c] = matrix[right][c];
                    matrix[right][c] = tmp;
                    left++;
                    right--;
                }
            }

            //reverse each diagonal
            for (int i = 1; i < n; i++) {
                int x = i - 1;
                int y = i - 1;

                while (x >= 0) {
                    int tmp = matrix[x][i];
                    matrix[x][i] = matrix[i][y];
                    matrix[i][y] = tmp;
                    x--;
                    y--;
                }
            }
        }
    }
}
