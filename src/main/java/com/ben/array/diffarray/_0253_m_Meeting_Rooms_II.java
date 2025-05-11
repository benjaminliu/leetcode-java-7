package com.ben.array.diffarray;

import com.ben.common.PrintUtil;

public class _0253_m_Meeting_Rooms_II {


    public static void main(String[] args) {
//        int[][] intervals = new int[][]{
//                {0, 30},
//                {5, 10},
//                {15, 20}
//        };

        int[][] intervals = new int[][]{
                {7, 10},
                {2, 4}
        };


        PrintUtil.printLn(new Solution().minMeetingRooms(intervals));
    }

    static class Solution {
        public int minMeetingRooms(int[][] intervals) {
            int length = 0;

            for (int[] interval : intervals) {
                if (interval[1] > length) {
                    length = interval[1];
                }
            }

            DifferenceArray differenceArray = new DifferenceArray(length);

            for (int[] interval : intervals) {
                differenceArray.update(interval[0], interval[1], 1);
            }

            int[] normalArray = differenceArray.generateNormalArray();

            int max = 0;
            for (int i : normalArray) {
                max = Math.max(max, i);
            }

            return max;
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
