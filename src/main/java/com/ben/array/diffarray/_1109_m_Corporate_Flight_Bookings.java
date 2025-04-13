package com.ben.array.diffarray;

public class _1109_m_Corporate_Flight_Bookings {
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            DifferenceArray differenceArray = new DifferenceArray(n);
            for (int[] booking : bookings) {
                differenceArray.update(booking[0] - 1, booking[1] - 1, booking[2]);
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
