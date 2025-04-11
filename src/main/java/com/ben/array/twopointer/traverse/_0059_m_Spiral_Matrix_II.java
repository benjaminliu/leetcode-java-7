package com.ben.array.twopointer.traverse;

import com.ben.common.PrintUtil;

public class _0059_m_Spiral_Matrix_II {

    public static void main(String[] args) {
        PrintUtil.printArrayOfArray(new Solution().generateMatrix(4));
    }

    static
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];

            int top = 0;
            int left = 0;
            int right = n - 1;
            int bottom = right;

            int direction = 0;
            int i = 0;
            int j = 0;

            int totalCount = n * n;
            int count = 1;

            while (count < totalCount) {
                switch (direction) {
                    //to right
                    case 0:
                        while (j <= right) {
                            matrix[i][j] = count;
                            count++;
                            j++;
                        }
                        i++;
                        j--;
                        top++;
                        break;
                    //to bottom
                    case 1:
                        while (i <= bottom) {
                            matrix[i][j] = count;
                            count++;
                            i++;
                        }
                        i--;
                        j--;
                        right--;
                        break;
                    //to left
                    case 2:
                        while (j >= left) {
                            matrix[i][j] = count;
                            count++;
                            j--;
                        }
                        i--;
                        j++;
                        bottom--;
                        break;
                    //to top
                    default:
                        while (i >= top) {
                            matrix[i][j] = count;
                            count++;
                            i--;
                        }
                        i++;
                        j++;
                        left++;
                        break;
                }
                //change direction
                direction = (direction + 1) % 4;
            }

            matrix[i][j] = count;

            return matrix;
        }
    }
}
