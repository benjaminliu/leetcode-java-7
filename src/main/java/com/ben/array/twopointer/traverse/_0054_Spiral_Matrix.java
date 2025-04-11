package com.ben.array.twopointer.traverse;

import com.ben.common.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _0054_Spiral_Matrix {
    public static void main(String[] args) {
        int[][] matric = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        PrintUtil.printList(new Solution().spiralOrder(matric));
    }

    static
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int r = matrix.length;
            int c = matrix[0].length;
            int length = r * c;

            List<Integer> res = new ArrayList<>(length);

            //0 to right
            //1 to bottom
            //2 to left
            //3 to top
            int direction = 0;

            int right = c - 1;
            int bottom = r - 1;
            int left = 0;
            int top = 0;

            int i = 0;
            int j = 0;
            while (res.size() != length) {
                switch (direction) {
                    //To right
                    case 0:
                        while (j <= right) {
                            res.add(matrix[i][j]);
                            j++;
                        }
                        i++;
                        j--;
                        top++;
                        break;
                    //To bottom
                    case 1:
                        while (i <= bottom) {
                            res.add(matrix[i][j]);
                            i++;
                        }
                        i--;
                        j--;
                        right--;
                        break;
                    //To left
                    case 2:
                        while (j >= left) {
                            res.add(matrix[i][j]);
                            j--;
                        }
                        i--;
                        j++;
                        bottom--;
                        break;
                    //To top
                    default:
                        while (i >= top) {
                            res.add(matrix[i][j]);
                            i--;
                        }
                        j++;
                        i++;
                        left++;
                        break;
                }
                //Change direction
                direction = (direction + 1) % 4;
            }
            return res;
        }
    }
}
