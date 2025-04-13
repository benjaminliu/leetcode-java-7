package com.ben.array.diffarray;

import com.ben.common.PrintUtil;

public class _0370_m_Range_Addition {


//    Assume you have an array of length n initialized with all 0's and are given k update operations.
//
//    Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
//
//    Return the modified array after all k operations were executed.
//
//    Example:
//
//    Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
//    Output: [-2,0,3,5,3]
//    Explanation:
//
//    Initial state:
//            [0,0,0,0,0]
//
//    After applying operation [1,3,2]:
//            [0,2,2,2,0]
//
//    After applying operation [2,4,3]:
//            [0,2,5,5,3]
//
//    After applying operation [0,2,-2]:
//            [-2,0,3,5,3]


//    Example 2:
//
//    Input: length = 10, updates = [[2,4,6],[5,6,8],[1,9,-4]]
//    Output: [0,-4,2,2,2,4,4,-4,-4,-4]

    public static void main(String[] args) {
        Solution solution = new Solution();
//
//        int length = 5;
//        int[][] updates = new int[][]{
//                {1, 3, 2},
//                {2, 4, 3},
//                {0, 2, -2}
//        };

        int length = 10;
        int[][] updates = new int[][]{
                {2, 4, 6},
                {5, 6, 8},
                {1, 9, -4}
        };


        PrintUtil.printArray(solution.getModifiedArray(length, updates));
    }

    static
    class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            DifferenceArray differenceArray = new DifferenceArray(length);

            for (int[] update : updates) {
                differenceArray.update(update[0], update[1], update[2]);
            }

            return differenceArray.generateNormalArray();
        }

        public class DifferenceArray {
            private int[] array;

            public DifferenceArray(int length) {
                array = new int[length];
            }

            public void update(int startIdx, int endIdx, int inc) {
                array[startIdx] += inc;
                if (endIdx + 1 < array.length) {
                    array[endIdx + 1] -= inc;
                }
            }

            public int[] generateNormalArray() {
                for (int i = 1; i < array.length; i++) {
                    array[i] = array[i] + array[i - 1];
                }

                return array;
            }
        }
    }
}
