package com.ben.array.diffarray;

import com.ben.common.PrintUtil;

public class _1094_m_Car_Pooling {

    public static void main(String[] args) {
        int capacity = 3;

        int[][] trips = new int[][]{{2, 1, 5}, {3, 5, 7}};

        PrintUtil.printLn(new Solution().carPooling(trips, capacity));
    }

    static class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int length = 0;

            for (int[] trip : trips) {
                if (trip[2] > length) {
                    length = trip[2];
                }
            }
            length++;

            DifferenceArray differenceArray = new DifferenceArray(length);

            for (int[] trip : trips) {
                //be careful about the end,  the passenger get off car at the end.
                differenceArray.update(trip[1], trip[2] - 1, trip[0]);
            }

            int[] maxPeople = differenceArray.generateNormalArray();

            for (int max : maxPeople) {
                if (max > capacity) {
                    return false;
                }
            }

            return true;
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
